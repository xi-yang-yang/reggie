package web.reggie.service;

import web.reggie.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author andy
 * @description 针对表【category(菜品及套餐分类)】的数据库操作Service
 * @createDate 2022-06-23 11:22:03
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
