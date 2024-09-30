package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    /**
     * 动态条件查询
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    @Update("update sky_take_out.shopping_cart set number = #{number} where id=#{id}")
    void updateById(ShoppingCart shoppingCart);

    /**
     * 插入购物车数据
     * @param shoppingCart
     */
    @Insert("insert into sky_take_out.shopping_cart(name, image, user_id, dish_id, setmeal_id, dish_flavor, amount, number ,create_time) " +
            "values (#{name},#{image},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{amount},#{number},#{createTime})")
    void insert(ShoppingCart shoppingCart);

    /**
     * 根据userid删除购物车数据
     * @param userId
     */
    @Delete("delete from sky_take_out.shopping_cart where user_id=#{userId}")
    void deleteByUserId(Long userId);


    /**
     * 根据菜品id查询购物车数据
     * @param shoppingCart
     * @return
     */
    @Select("select * from sky_take_out.shopping_cart where user_id=#{userId} and dish_id=#{dishId}")
    ShoppingCart getByUserIdAndDishId(ShoppingCart shoppingCart);

    /**
     * 根据id修改商品数量
     * @param cart
     */
    @Update("update sky_take_out.shopping_cart set number = #{number} where id=#{id}")
    void updateNumberById(ShoppingCart cart);

    /**
     * 根据套餐查询购物车
     * @param shoppingCart
     * @return
     */
    @Select("select * from sky_take_out.shopping_cart where user_id=#{userId} and setmeal_id = #{setmealId}")
    ShoppingCart getByUserIdAndSetmealId(ShoppingCart shoppingCart);

    /**
     * 根据id删除购物车数据
     * @param id
     */
    @Delete("delete from sky_take_out.shopping_cart where id=#{id}")
    void deleteByShoppingId(Long id);

    /**
     * 批量插入购物车数据
     * @param shoppingCartList
     */
    void insertBatch(List<ShoppingCart> shoppingCartList);
}
