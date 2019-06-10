package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qudi.bean.Address;

@Repository
public interface AddressDao {

	Address queryAddress(@Param("id") int id);

	List<Address> queryAddressList(@Param("userId") int userId);

	int insertAddress(Address address);

	int updateAddress(Address address);

	int insertUser2Address(@Param("userId") int userId, @Param("addressId") int addressId);

	int deleteAddress(@Param("id") int id);

	int deleteUser2Address(@Param("addressId") int addressId);

}
