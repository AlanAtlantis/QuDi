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
			// �ж��Ƿ���ӳɹ�
			if (commentdao.insertComment(comment) > 0) {

				// �ж��Ƿ����ͼƬ
				if (comment.getPricture().size() > 0) {
					for (CommentPicture picture : comment.getPricture()) {
						// ���ͼƬ
						if (commentdao.insertPicture(picture) > 0) {
							// ���ͼƬ�����۵Ĺ�ϵ
							commentdao.insertPicture2Comment(comment.getId(), picture.getId());
						}
						message.setInfo("ͼƬ�ϴ�ʧ��");
						return message;
					}
				}
				// �����������Ʒ��ϵ
				commentdao.insertComment2Commodity(commodityId, comment.getId());
				// ����������û���ϵ
				commentdao.insertComment2User(userId, comment.getId());

				message.setInfo("��ӳɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("���ʧ�ܣ���������");
		return message;
	}

	public MessageUtil updateGiveLike(int giveLike, int id) {
		MessageUtil message = new MessageUtil();
		if (giveLike > 0 && id > 0) {
			// �ж��Ƿ��޸ĳɹ�
			if (commentdao.updateGiveLike(giveLike, id) > 0) {
				message.setInfo("���۳ɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("��ѯʧ�ܣ���������");
		return message;
	}

	public MessageUtil selectCommentList(int commodityId) {
		MessageUtil message = new MessageUtil();
		if (commodityId > 0) {
			// ������Ʒid��ѯ����id
			List<Integer> idList = commentdao.selectCommentId(commodityId);
			if (idList.size() > 0) {
				// ��������id��ѯ����
				List<Comment> commentList = commentdao.selectCommentList(idList);
				if (commentList.size() > 0) {
					for (Comment co : commentList) {
						// ��ѯͼƬid
						List<Integer> idLists = commentdao.selectPictureId(co.getId());
						if (idLists.size() > 0) {
							// ��ѯͼƬ
							List<CommentPicture> pricture = commentdao.selectPicture(idLists);
							co.setPricture(pricture);
						}
					}
					message.setInfo("��ѯ�ɹ�");
					message.setResult(Result.SUCCEED);
					message.setObject(commentList);
					return message;
				}
			}
			message.setInfo("��������");
			return message;
		}
		message.setInfo("��ѯʧ�ܣ���������");
		return message;
	}

	public MessageUtil selectComment(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// ��������id��ѯ����
			Comment comment = commentdao.selectComment(id);
			if (comment != null) {
				// ��ѯͼƬid
				List<Integer> idList = commentdao.selectPictureId(comment.getId());
				if (idList.size() > 0) {
					// ��ѯͼƬ
					List<CommentPicture> pricture = commentdao.selectPicture(idList);
					comment.setPricture(pricture);
				}
				message.setInfo("��ѯ�ɹ�");
				message.setResult(Result.SUCCEED);
				message.setObject(comment);
				return message;
			}
		}
		message.setInfo("��ѯʧ�ܣ���������");
		return message;
	}

	public MessageUtil userCommentList(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// ��������id��ѯ����
			List<Integer> idList = commentdao.selectUserCommentId(userId);
			if (idList.size() > 0) {
				// ��������id��ѯ����
				List<Comment> commentList = commentdao.selectCommentList(idList);
				if (commentList.size() > 0) {
					for (Comment co : commentList) {
						// ��ѯͼƬid
						List<Integer> idLists = commentdao.selectPictureId(co.getId());
						if (idLists.size() > 0) {
							// ��ѯͼƬ
							List<CommentPicture> pricture = commentdao.selectPicture(idLists);
							co.setPricture(pricture);
						}
					}
					message.setInfo("��ѯ�ɹ�");
					message.setResult(Result.SUCCEED);
					message.setObject(commentList);
					return message;
				}
			}
			message.setInfo("��������");
			return message;
		}
		message.setInfo("��ѯʧ�ܣ���������");
		return message;
	}

	public MessageUtil insertReply(Reply reply, int userId, int commentId) {
		MessageUtil message = new MessageUtil();
		if (reply != null) {
			// �ж��Ƿ���ӳɹ�
			if (commentdao.insertReply(reply) > 0) {
				// ��ӻظ����û���ϵ
				commentdao.insertUser2Reply(reply.getId(), userId);
				// ��ӻظ������۹�ϵ
				commentdao.insertComment2Reply(commentId, reply.getId());
				message.setInfo("�ظ��ɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("�ظ�ʧ�ܣ���������");
		return message;
	}

	public MessageUtil selectReply(int commentId) {
		MessageUtil message = new MessageUtil();
		if (commentId > 0) {
			// ��ѯ�ظ�id
			List<Integer> idList = commentdao.selectReplyId(commentId);
			if (idList.size() > 0) {
				// ��ѯ�ظ�
				List<Reply> replyList = commentdao.selectReply(idList);
				if (replyList.size() > 0) {
					message.setInfo("��ѯ�ɹ�");
					message.setResult(Result.SUCCEED);
					message.setObject(replyList);
					return message;
				}
			}
			message.setInfo("���޻ظ�");
			return message;
		}
		message.setInfo("��ѯʧ�ܣ���������");
		return message;
	}

}
