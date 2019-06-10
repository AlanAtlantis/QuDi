package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.Message;

public interface MessageDao {

	int insertMessage(Message message);

	int deleteMessage(@Param("id") int id);

	List<Message> queryMessage(@Param("userId") int userId);

	List<Message> queryHistoryMessage(@Param("userId") int userId);

}
