package com.qudi.service;

import java.util.List;

import com.qudi.bean.Comment;
import com.qudi.bean.Reply;
import com.qudi.util.MessageUtil;

public interface CommentDaoService {

	/**
	 * 添加评论
	 * 
	 * @param comment
	 * @return
	 */
	MessageUtil insertComment(Comment comment, int userId, int commodityId);

	/**
	 * 点赞
	 * 
	 * @param giveLike
	 * @param id
	 * @return
	 */
	MessageUtil updateGiveLike(int giveLike, int id);

	/**
	 * 查看评论
	 * 
	 * @param commodityId
	 * @return
	 */
	MessageUtil selectCommentList(int commodityId);

	/**
	 * 查看单个评论
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil selectComment(int id);

	/**
	 * 查看用户的所有评论
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil userCommentList(int userId);

	/**
	 * 添加回复
	 * 
	 * @param reply
	 * @return
	 */
	MessageUtil insertReply(Reply reply, int userId, int commentId);

	/**
	 * 查询评论回复
	 * 
	 * @param commentId
	 * @return
	 */
	MessageUtil selectReply(int commentId);

}
