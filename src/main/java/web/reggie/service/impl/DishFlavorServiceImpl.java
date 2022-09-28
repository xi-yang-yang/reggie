package web.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import web.reggie.domain.DishFlavor;
import web.reggie.service.DishFlavorService;
import web.reggie.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

/**
* @author andy
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
* @createDate 2022-06-24 17:32:45
*/
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
    implements DishFlavorService{

}




