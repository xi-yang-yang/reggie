package web.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import web.reggie.common.R;
import web.reggie.domain.Admin;
import web.reggie.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/employee")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public R<Admin> login(@RequestBody Admin admin, HttpServletRequest request) {
        String password = admin.getPassword();
        String passwordMD5 = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        LambdaQueryWrapper<Admin> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Admin::getUsername, admin.getUsername());
        Admin emp = adminService.getOne(lambdaQueryWrapper);
        if (emp == null) {
            return R.error("登录失败，未注册");
        }
        if (!emp.getPassword().equals(passwordMD5)) {
            return R.error("登陆失败，密码或账号错误");
        }
        if (emp.getStatus() == 0) {
            return R.error("账号已被冻结");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", emp.getId());
            return R.success(emp);
        }

    }

    @PostMapping
    public R<String> save(@RequestBody Admin employee, HttpServletRequest request) {
        String initPassword = "123456";
        String passwordMD5 = DigestUtils.md5DigestAsHex(initPassword.getBytes(StandardCharsets.UTF_8));
        employee.setPassword(passwordMD5);
        adminService.save(employee);
        return R.success("添加成功");
    }

    @GetMapping("/page")

    public R<Page> page(Integer page, Integer pageSize, String name) {
        Page page1 = new Page(page, pageSize);
        LambdaQueryWrapper<Admin> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(name != null, Admin::getName, name);
        lambdaQueryWrapper.orderByAsc(Admin::getUpdateTime);
        Page page2 = adminService.page(page1, lambdaQueryWrapper);
        return R.success(page2);
    }

    @PutMapping
    public R<String> update(@RequestBody Admin employee, HttpServletRequest request) {
        adminService.updateById(employee);
        return R.success("更新成功");
    }

    @GetMapping("/{id}")
    public R<Admin> getResult(@PathVariable("id") Long id) {
        Admin emp = adminService.getById(id);
        return R.success(emp);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return R.success("退出成功");
    }
}
