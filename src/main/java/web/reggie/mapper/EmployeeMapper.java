package web.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.reggie.domain.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author andy
 * @description 针对表【employee(员工信息)】的数据库操作Mapper
 * @createDate 2022-06-21 18:22:14
 * @Entity web.reggie.domain.Employee
 */

public interface EmployeeMapper extends BaseMapper<Employee> {

}




