package web.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.reggie.domain.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author andy
 * @description 针对表【order_detail(订单明细表)】的数据库操作Mapper
 * @createDate 2022-06-25 11:18:58
 * @Entity web.reggie.domain.OrderDetail
 */

public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}




