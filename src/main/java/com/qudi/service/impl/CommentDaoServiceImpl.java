package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.Comment;
import com.qudi.bean.CommentPicture;
import com.qudi.bean.Reply;
import com.qudi.dao.CommentDao;
import com.qudi.service.CommentDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("commentService")
public class CommentDaoServiceImpl implements CommentDaoService {

	@Autowired
	private CommentDao commentdao;

	public MessageUtil insertComment(Comment comment, int userId, int commodityId) {
		MessageUtil message = new MessageUtil();
		if (comment != null) {
			// 判断是否添加成功
			if (commentdao.insertComment(comment) > 0) {

				// 判断是否添加图片
				if (comment.getPricture().size() > 0) {
					for (CommentPicture picture : comment.getPricture()) {
						// 添加图片
						if (commentdao.insertPicture(picture) > 0) {
							// 添加图片与评论的关系
							commentdao.insertPicture2Comment(comment.getId(), picture.getId());
						}
						message.setInfo("图片上传失败");
						return message;
					}
				}
				// 添加评论与商品关系
				commentdao.insertComment2Commodity(commodityId, comment.getId());
				// 添加评论与用户关系
				commentdao.insertComment2User(userId, comment.getId());

				message.setInfo("添加成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("添加失败，参数错误");
		return message;
	}

	public MessageUtil updateGiveLike(int giveLike, int id) {
		MessageUtil message = new MessageUtil();
		if (giveLike > 0 && id > 0) {
			// 判断是否修改成功
			if (commentdao.updateGiveLike(giveLike, id) > 0) {
				message.setInfo("评论成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("查询失败，参数错误");
		return message;
	}

	public MessageUtil selectCommentList(int commodityId) {
		MessageUtil message = new MessageUtil();
		if (commodityId > 0) {
			// 根据商品id查询评论id
			List<Integer> idList = commentdao.selectCommentId(commodityId);
			if (idList.size() > 0) {
				// 根据评论id查询评论
				List<Comment> commentList = commentdao.selectCommentList(idList);
				if (commentList.size() > 0) {
					for (Comment co : commentList) {
						// 查询图片id
						List<Integer> idLists = commentdao.selectPictureId(co.getId());
						if (idLists.size() > 0) {
							// 查询图片
							List<CommentPicture> pricture = commentdao.selectPicture(idLists);
							co.setPricture(pricture);
						}
					}
					message.setInfo("查询成功");
					message.setResult(Result.SUCCEED);
					message.setObject(commentList);
					return message;
				}
			}
			message.setInfo("暂无评论");
			return message;
		}
		message.setInfo("查询失败，参数错误");
		return message;
	}

	public MessageUtil selectComment(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// 根据评论id查询评论
			Comment comment = commentdao.selectComment(id);
			if (comment != null) {
				// 查询图片id
				List<Integer> idList = commentdao.selectPictureId(comment.getId());
				if (idList.size() > 0) {
					// 查询图片
					List<CommentPicture> pricture = commentdao.selectPicture(idList);
					comment.setPricture(pricture);
				}
				message.setInfo("查询成功");
				message.setResult(Result.SUCCEED);
				message.setObject(comment);
				return message;
			}
		}
		message.setInfo("查询失败，参数错误");
		return message;
	}

	public MessageUtil userCommentList(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// 根据评论id查询评论
			List<Integer> idList = commentdao.selectUserCommentId(userId);
			if (idList.size() > 0) {
				// 根据评论id查询评论
				List<Comment> commentList = commentdao.selectCommentList(idList);
				if (commentList.size() > 0) {
					for (Comment co : commentList) {
						// 查询图片id
						List<Integer> idLists = commentdao.selectPictureId(co.getId());
						if (idLists.size() > 0) {
							// 查询图片
							List<CommentPicture> pricture = commentdao.selectPicture(idLists);
							co.setPricture(pricture);
						}
					}
					message.setInfo("查询成功");
					message.setResult(Result.SUCCEED);
					message.setObject(commentList);
					return message;
				}
			}
			message.setInfo("暂无评论");
			return message;
		}
		message.setInfo("查询失败，参数错误");
		return message;
	}

	public MessageUtil insertReply(Reply reply, int userId, int commentId) {
		MessageUtil message = new MessageUtil();
		if (reply != null) {
			// 判断是否添加成功
			if (commentdao.insertReply(reply) > 0) {
				// 添加回复与用户关系
				commentdao.insertUser2Reply(reply.getId(), userId);
				// 添加回复与评论关系
				commentdao.insertComment2Reply(commentId, reply.getId());
				message.setInfo("回复成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("回复失败，参数错误");
		return message;
	}

	public MessageUtil selectReply(int commentId) {
		MessageUtil message = new MessageUtil();
		if (commentId > 0) {
			// 查询回复id
			List<Integer> idList = commentdao.selectReplyId(commentId);
			if (idList.size() > 0) {
				// 查询回复
				List<Reply> replyList = commentdao.selectReply(idList);
				if (replyList.size() > 0) {
					message.setInfo("查询成功");
					message.setResult(Result.SUCCEED);
					message.setObject(replyList);
					return message;
				}
			}
			message.setInfo("暂无回复");
			return message;
		}
		message.setInfo("查询失败，参数错误");
		return message;
	}

}
