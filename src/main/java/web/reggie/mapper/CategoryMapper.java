package web.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import web.reggie.domain.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author andy
 * @description 针对表【category(菜品及套餐分类)】的数据库操作Mapper
 * @createDate 2022-06-23 11:22:03
 * @Entity web.reggie.domain.Category
 */

public interface CategoryMapper extends BaseMapper<Category> {

}




