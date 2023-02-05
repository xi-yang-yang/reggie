package web.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import web.reggie.domain.Admin;
import web.reggie.service.AdminService;
import web.reggie.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author andy
* @description 针对表【admin(员工信息)】的数据库操作Service实现
* @createDate 2022-10-12 09:45:01
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




