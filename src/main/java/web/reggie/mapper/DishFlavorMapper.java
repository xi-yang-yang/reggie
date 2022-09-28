package web.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.reggie.domain.DishFlavor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author andy
 * @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Mapper
 * @createDate 2022-06-24 17:32:45
 * @Entity web.reggie.domain.DishFlavor
 */

public interface DishFlavorMapper extends BaseMapper<DishFlavor> {

}




