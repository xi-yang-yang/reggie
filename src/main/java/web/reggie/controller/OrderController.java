package web.reggie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.reggie.common.R;
import web.reggie.domain.OrderDetail;
import web.reggie.domain.Orders;
import web.reggie.service.OrderDetailService;
import web.reggie.service.OrderService;

/**
 * 订单
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 用户下单
     *
     * @param orders
     * @return
     */
    @PostMapping("/submit")

    public R<String> submit(@RequestBody Orders orders) {
        log.info("订单数据：{}", orders);
        orderService.submit(orders);
        return R.success("下单成功");
    }

    @GetMapping("/page")
    public R<Page> page(Integer page, Integer pageSize) {
        Page<OrderDetail> page1 = new Page<>(page, pageSize);
        Page<OrderDetail> page2 = orderDetailService.page(page1, null);
        return R.success(page2);

    }
}