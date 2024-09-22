package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    List<Long> getSetmealIdByDishIds(List<Long> dishIds);

    /**
     * 批量保存套餐和菜品的关联关系
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 删除套餐菜品关系表中的数据
     * @param setmealId
     */
    @Delete("delete from sky_take_out.setmeal_dish where setmeal_id=#{setmealId}")
    void deleteBySetmealId(Long setmealId);


    /**
     * 根据套餐id查询套餐和菜品的关联关系
     * @param id
     * @return
     */
    @Select("select * from sky_take_out.setmeal_dish where setmeal_id=#{setmealId}")
    List<SetmealDish> getBySetmealId(Long id);
}
