package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.Comment;
import com.qudi.bean.CommentPicture;
import com.qudi.bean.Reply;

public interface CommentDao {

	int insertComment(Comment comment);

	int insertPicture(CommentPicture picture);

	int insertComment2Commodity(@Param("commodityId") int commodityId, @Param("commentId") int commentId);

	int updateGiveLike(@Param("giveLike") int giveLike, @Param("id") int id);

	int insertComment2User(@Param("userId") int userId, @Param("commentId") int commentId);

	int insertPicture2Comment(@Param("commentId") int commentId, @Param("pictureId") int pictureId);

	Comment selectComment(@Param("id") int id);

	List<Comment> selectCommentList(List<Integer> idList);

	List<Integer> selectCommentId(@Param("commodityId") int commodityId);

	List<Integer> selectUserCommentId(@Param("userId") int userId);

	List<CommentPicture> selectPicture(List<Integer> idList);

	List<Integer> selectPictureId(@Param("commentId") int commentId);

	int insertReply(Reply reply);

	int insertUser2Reply(@Param("replyId") int replyId, @Param("userId") int userId);

	int insertComment2Reply(@Param("commentId") int commentId, @Param("replyId") int replyId);

	List<Reply> selectReply(List<Integer> idList);

	List<Integer> selectReplyId(@Param("commentId") int commentId);

}
