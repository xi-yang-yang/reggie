package web.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import web.reggie.domain.Orders;
import web.reggie.service.OrdersService;
import web.reggie.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author andy
* @description 针对表【orders(订单表)】的数据库操作Service实现
* @createDate 2022-06-25 11:19:02
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




