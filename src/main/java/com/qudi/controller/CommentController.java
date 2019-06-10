package com.qudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.bean.Comment;
import com.qudi.bean.Message;
import com.qudi.bean.Reply;
import com.qudi.service.CommentDaoService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentDaoService commentService;

	/**
	 * �������
	 * 
	 * @param comment
	 * @param userId
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value = "/insertComment", method = RequestMethod.GET)
	public @ResponseBody MessageUtil insertComment(@RequestBody Comment comment, @RequestParam("userId") int userId,
			@RequestParam("commodityId") int commodityId) {
		MessageUtil message = commentService.insertComment(comment, userId, commodityId);
		return message;
	}

	/**
	 * ���۵���
	 * 
	 * @param giveLike
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/updateGiveLike", method = RequestMethod.GET)
	public @ResponseBody MessageUtil updateGiveLike(@RequestParam("giveLike") int giveLike,
			@RequestParam("id") int id) {
		MessageUtil message = commentService.updateGiveLike(giveLike, id);
		return message;
	}

	/**
	 * �鿴��Ʒ��������
	 * 
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value = "/selectCommentList", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectCommentList(@RequestParam("commodityId") int commodityId) {
		MessageUtil message = commentService.selectCommentList(commodityId);
		return message;
	}

	/**
	 * �鿴��������
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/selectComment", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectComment(@RequestParam("id") int id) {
		MessageUtil message = commentService.selectComment(id);
		return message;
	}

	/**
	 * �鿴�û���������
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/userCommentList", method = RequestMethod.GET)
	public @ResponseBody MessageUtil userCommentList(@RequestParam("userId") int userId) {
		MessageUtil message = commentService.userCommentList(userId);
		return message;
	}

	/**
	 * �ظ�����
	 * 
	 * @param userId
	 * @param commentId
	 * @param reply
	 * @return
	 */
	@RequestMapping(value = "/insertReply", method = RequestMethod.GET)
	public @ResponseBody MessageUtil insertReply(@RequestParam("userId") int userId,
			@RequestParam("commentId") int commentId, @RequestBody Reply reply) {
		MessageUtil message = commentService.insertReply(reply, userId, commentId);
		return message;
	}

	/**
	 * �鿴���ۻظ�
	 * 
	 * @param commentId
	 * @return
	 */
	@RequestMapping(value = "/selectReply", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectReply(@RequestParam("commentId") int commentId) {
		MessageUtil message = commentService.selectReply(commentId);
		return message;
	}

}
