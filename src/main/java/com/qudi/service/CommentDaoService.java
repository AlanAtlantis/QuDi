package com.qudi.service;

import java.util.List;

import com.qudi.bean.Comment;
import com.qudi.bean.Reply;
import com.qudi.util.MessageUtil;

public interface CommentDaoService {

	/**
	 * �������
	 * 
	 * @param comment
	 * @return
	 */
	MessageUtil insertComment(Comment comment, int userId, int commodityId);

	/**
	 * ����
	 * 
	 * @param giveLike
	 * @param id
	 * @return
	 */
	MessageUtil updateGiveLike(int giveLike, int id);

	/**
	 * �鿴����
	 * 
	 * @param commodityId
	 * @return
	 */
	MessageUtil selectCommentList(int commodityId);

	/**
	 * �鿴��������
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil selectComment(int id);

	/**
	 * �鿴�û�����������
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil userCommentList(int userId);

	/**
	 * ��ӻظ�
	 * 
	 * @param reply
	 * @return
	 */
	MessageUtil insertReply(Reply reply, int userId, int commentId);

	/**
	 * ��ѯ���ۻظ�
	 * 
	 * @param commentId
	 * @return
	 */
	MessageUtil selectReply(int commentId);

}
