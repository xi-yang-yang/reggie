package web.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import web.reggie.domain.ShoppingCart;
import web.reggie.service.ShoppingCartService;
import web.reggie.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Service;

/**
* @author andy
* @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
* @createDate 2022-06-25 11:19:08
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

}




