package web.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import web.reggie.domain.User;
import web.reggie.service.UserService;
import web.reggie.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author andy
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2022-09-01 13:20:33
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




