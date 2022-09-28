package web.reggie.dto;

import lombok.Data;
import web.reggie.domain.Setmeal;
import web.reggie.domain.SetmealDish;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
