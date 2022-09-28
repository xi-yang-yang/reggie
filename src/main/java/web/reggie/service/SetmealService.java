package web.reggie.service;

import web.reggie.domain.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;
import web.reggie.dto.SetmealDto;

import java.util.List;

/**
* @author andy
* @description 针对表【setmeal(套餐)】的数据库操作Service
* @createDate 2022-06-23 12:03:42
*/
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);

}
