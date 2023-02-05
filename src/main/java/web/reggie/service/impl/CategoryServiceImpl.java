package web.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import web.reggie.domain.Category;
import web.reggie.domain.Food;
import web.reggie.domain.Setmeal;
import web.reggie.service.CategoryService;
import web.reggie.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import web.reggie.service.FoodService;
import web.reggie.service.SetmealService;

/**
 * @author andy
 * @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
 * @createDate 2022-06-23 11:22:03
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {
    @Autowired
    private FoodService foodService;
    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Food> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //菜品查询
        dishLambdaQueryWrapper.eq(Food::getCategoryId, id);
        //通过菜品分类id来查询菜品
        int count = foodService.count(dishLambdaQueryWrapper);
        if (count > 0) {
            throw new RuntimeException("关联数据了，不能直接删除");

        }
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count1 = setmealService.count(setmealLambdaQueryWrapper);
        if (count1 > 0) {
            throw new RuntimeException("关联数据了，不能直接删除");
        }
        super.removeById(id);


    }
}




