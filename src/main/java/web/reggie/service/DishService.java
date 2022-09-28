package web.reggie.service;

import web.reggie.domain.Dish;
import com.baomidou.mybatisplus.extension.service.IService;
import web.reggie.domain.DishFlavor;
import web.reggie.dto.DishDto;

/**
 * @author andy
 * @description 针对表【dish(菜品管理)】的数据库操作Service
 * @createDate 2022-06-23 12:03:22
 */
public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);


}
