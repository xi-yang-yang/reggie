package web.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.reggie.domain.AddressBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author andy
 * @description 针对表【address_book(地址管理)】的数据库操作Mapper
 * @createDate 2022-06-25 11:18:48
 * @Entity web.reggie.domain.AddressBook
 */

public interface AddressBookMapper extends BaseMapper<AddressBook> {

}




