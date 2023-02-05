package web.reggie.service;

import web.reggie.domain.Food;
import com.baomidou.mybatisplus.extension.service.IService;
import web.reggie.dto.DishDto;

/**
* @author andy
* @description 针对表【food(菜品管理)】的数据库操作Service
* @createDate 2022-10-12 11:05:48
*/
public interface FoodService extends IService<Food> {
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);

}
