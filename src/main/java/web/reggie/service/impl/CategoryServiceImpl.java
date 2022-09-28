package web.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import web.reggie.domain.Category;
import web.reggie.domain.Dish;
import web.reggie.domain.Setmeal;
import web.reggie.service.CategoryService;
import web.reggie.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import web.reggie.service.DishService;
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
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(Long ids) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, ids);
        int count = dishService.count(dishLambdaQueryWrapper);
        if (count > 0) {
            System.out.println("关联数据了，不能直接删除");
        }
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, ids);
        int count1 = setmealService.count(setmealLambdaQueryWrapper);
        if (count1 > 0) {
            System.out.println("关联数据了，不能直接删除");
        }
        super.removeById(ids);


    }
}




