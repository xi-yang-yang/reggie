package web.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import web.reggie.domain.AddressBook;
import web.reggie.service.AddressBookService;
import web.reggie.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author andy
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2022-06-25 11:18:48
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
    implements AddressBookService{

}




