package com.qudi.dao;

import java.util.List;
import com.qudi.bean.OrderForm;
import com.qudi.bean.Orderdetail;

import org.apache.ibatis.annotations.Param;

public interface OrderFormDao {

	OrderForm queryOrderForm(@Param("id") int id);

	int insertOrderForm(OrderForm order);

	int updateOrderForm(OrderForm order);

	int deleteOrderForm(@Param("id") int id);

	List<OrderForm> queryOrderFormList(@Param("idList") List<Integer> idList);

	List<Integer> queryIdList(@Param("userId") int userId);

	int insertOrderForm2User(@Param("userId") int userId, @Param("orderId") int orderId,
			@Param("addressId") int addressId);

	int updateOrderAddress(@Param("addressId") int addressId, @Param("orderId") int orderId);

	int deleteOrderForm2User(@Param("orderId") int orderId);

	int insertOrderdetail(Orderdetail orderde);

	int deleteOrderdetail(@Param("id") int id);

	List<Orderdetail> queryOrderdetail(@Param("orderId") int orderId);

}
