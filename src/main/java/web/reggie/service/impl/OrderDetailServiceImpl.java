package web.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import web.reggie.domain.OrderDetail;
import web.reggie.service.OrderDetailService;
import web.reggie.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author andy
* @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
* @createDate 2022-06-25 11:18:58
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
    implements OrderDetailService{

}




