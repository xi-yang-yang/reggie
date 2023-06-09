package web.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.reggie.common.R;
import web.reggie.domain.Category;
import web.reggie.domain.Food;
import web.reggie.domain.DishFlavor;
import web.reggie.dto.DishDto;
import web.reggie.service.CategoryService;
import web.reggie.service.DishFlavorService;
import web.reggie.service.FoodService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dish")
@Slf4j
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto) {
        foodService.saveWithFlavor(dishDto);
        return R.success("新增菜品成功");
    }

    @GetMapping("/page")
    public R<Page> page(Integer page, Integer pageSize, String name) {
        Page<Food> pageInfo = new Page<>(page, pageSize);
        Page<DishDto> finalPage = new Page<>();
        LambdaQueryWrapper<Food> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name != null, Food::getName, name);
        lambdaQueryWrapper.orderByDesc(Food::getUpdateTime);
        foodService.page(pageInfo, lambdaQueryWrapper);
        BeanUtils.copyProperties(pageInfo, finalPage, "records");
        List<Food> records = pageInfo.getRecords();
        List<DishDto> dishDtoList = records.stream().map((item) -> {
            Long categoryId = item.getCategoryId();
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item, dishDto);
            Category category = categoryService.getById(categoryId);
            String name1 = category.getName();
            dishDto.setCategoryName(name1);
            return dishDto;

        }).collect(Collectors.toList());
        finalPage.setRecords(dishDtoList);
        return R.success(finalPage);
    }

    @GetMapping("/{id}")
    public R<DishDto> update(@PathVariable("id") Long id) {
        DishDto flavor = foodService.getFlavor(id);
        return R.success(flavor);
    }

    @PutMapping
    public R<String> renewal(@RequestBody DishDto dishDto) {
        foodService.updateWithFlavor(dishDto);
        return R.success("更新成功");

    }

    @GetMapping("/list")
    public R<List<DishDto>> list(Food food) {
        LambdaQueryWrapper<Food> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(food.getCategoryId() != null, Food::getCategoryId, food.getCategoryId());
        lambdaQueryWrapper.orderByAsc(Food::getSort).orderByDesc(Food::getUpdateTime);
        lambdaQueryWrapper.eq(Food::getStatus, 1);
        List<Food> list = foodService.list(lambdaQueryWrapper);
        List<DishDto> dishDtoList = list.stream().map((item) -> {
            DishDto dishDto = new DishDto();
            Long categoryId = item.getCategoryId();
            BeanUtils.copyProperties(item, dishDto);
            Category byId = categoryService.getById(categoryId);
            String name1 = byId.getName();
            dishDto.setCategoryName(name1);
            Long id = item.getId();
            LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(DishFlavor::getDishId, id);
            dishDto.setFlavors(dishFlavorService.list(queryWrapper));
            return dishDto;
        }).collect(Collectors.toList());
        return R.success(dishDtoList);
    }

    @DeleteMapping
    public R<String> deleteFood(Long ids) {
        foodService.removeById(ids);
        return R.success("删除成功");
    }
}
