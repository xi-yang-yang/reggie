package web.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import web.reggie.common.R;
import web.reggie.domain.Employee;
import web.reggie.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(@RequestBody Employee employee, HttpServletRequest request) {
        String password = employee.getPassword();
        String passwordMD5 = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(lambdaQueryWrapper);
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

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return R.success("退出成功");
    }

    @PostMapping
    public R<String> save(@RequestBody Employee employee, HttpServletRequest request) {
        String initPassword = "123456";
        String passwordMD5 = DigestUtils.md5DigestAsHex(initPassword.getBytes(StandardCharsets.UTF_8));
        employee.setPassword(passwordMD5);
        employeeService.save(employee);
        return R.success("添加成功");
    }

    @GetMapping("/page")

    public R<Page> page(Integer page, Integer pageSize, String name) {
        Page page1 = new Page(page, pageSize);
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(name != null, Employee::getName, name);
        lambdaQueryWrapper.orderByAsc(Employee::getUpdateTime);
        Page page2 = employeeService.page(page1, lambdaQueryWrapper);
        return R.success(page2);
    }

    @PutMapping
    public R<String> update(@RequestBody Employee employee, HttpServletRequest request) {
        employeeService.updateById(employee);
        return R.success("更新成功");
    }

    @GetMapping("/{id}")
    public R<Employee> getResult(@PathVariable("id") Long id) {
        Employee emp = employeeService.getById(id);
        return R.success(emp);
    }
}
