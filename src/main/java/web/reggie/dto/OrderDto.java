package web.reggie.dto;

import lombok.Data;
import web.reggie.domain.OrderDetail;
import web.reggie.domain.Orders;

import java.util.List;

@Data
public class OrderDto extends Orders {
    private List<OrderDetail> orderDetails;
}
