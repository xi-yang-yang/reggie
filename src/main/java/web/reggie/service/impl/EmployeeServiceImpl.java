package web.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import web.reggie.domain.Employee;
import web.reggie.service.EmployeeService;
import web.reggie.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

/**
* @author andy
* @description 针对表【employee(员工信息)】的数据库操作Service实现
* @createDate 2022-06-21 18:22:14
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

}




