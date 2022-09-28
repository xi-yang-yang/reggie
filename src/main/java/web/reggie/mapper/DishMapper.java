package web.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.reggie.domain.Dish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author andy
 * @description 针对表【dish(菜品管理)】的数据库操作Mapper
 * @createDate 2022-06-23 12:03:22
 * @Entity web.reggie.domain.Dish
 */

public interface DishMapper extends BaseMapper<Dish> {

}




