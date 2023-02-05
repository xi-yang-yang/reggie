package web.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.reggie.common.R;
import web.reggie.domain.OrderDetail;
import web.reggie.domain.Orders;
import web.reggie.service.OrderDetailService;
import web.reggie.service.OrderService;

/**
 * 订单明细
 */
@Slf4j
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/pages")
    public R<Page> page(Integer page, Integer pageSize, String number) {
        Page page1 = new Page(page, pageSize);
        LambdaQueryWrapper<OrderDetail> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(number != null, OrderDetail::getOrderId, number);
        Page page2 = orderDetailService.page(page1, lambdaQueryWrapper);
        return R.success(page2);
    }

}