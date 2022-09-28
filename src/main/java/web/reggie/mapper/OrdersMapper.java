package web.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.reggie.domain.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author andy
 * @description 针对表【orders(订单表)】的数据库操作Mapper
 * @createDate 2022-06-25 11:19:02
 * @Entity web.reggie.domain.Orders
 */

public interface OrdersMapper extends BaseMapper<Orders> {

}




