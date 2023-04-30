package web.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.reggie.common.R;
import web.reggie.domain.User;
import web.reggie.service.UserService;
import web.reggie.utils.ValidateCodeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        String phone = user.getPhone();
        if (!StringUtils.isEmpty(phone)) {
            String code = ValidateCodeUtils.generateValidateCode(6).toString();
            log.debug(code);
            session.setAttribute(phone, code);
            return R.success("验证码生成");

        } else {
            return R.error("验证码生成失败");
        }


    }

    //用户登出
    @PostMapping("/loginout")
    public R<String> loginout(HttpServletRequest request) {
        //清理Session中保存的当前用户登录的id
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }


    @PostMapping("/login")
    public R<User> login(@RequestBody Map user, HttpSession session) {
        String phone = user.get("phone").toString();
        String code = user.get("code").toString();
        Object codeInSession = session.getAttribute(phone);
        if (codeInSession != null && code.equals(codeInSession)) {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user01 = userService.getOne(queryWrapper);
            if (user01 == null) {
                user01 = new User();
                user01.setPhone(phone);
                user01.setStatus(1);
                userService.save(user01);
            }
            session.setAttribute("user", user01.getId());
            return R.success(user01);

        }
        return R.error("登录失败");


    }

}
