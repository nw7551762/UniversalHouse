package forum.service;

import java.util.List;

import forum.model.Message;
import forum.model.MessageDao;
import member.model.Member;

public class MessageService {
	
	MessageDao mDao = null;
	
	public MessageService() {
		mDao = new MessageDao();
	}	
	
	public void save(Integer articleId,Message message){
		mDao.save(articleId,message);
	}
	
	public List<Message> findAllByArticleId(Integer articleId) {
		return mDao.findAllByArticleId(articleId);
	}
	
	public void deleteByArticleId(Integer articleId) {
		mDao.deleteByArticleId(articleId);
	}
	
	public void deleteByMessageId(Integer messageId) {
		mDao.deleteByMessageId(messageId);
	}
	
	public Member findMemberByMemberId(String authorId) {
		return mDao.findMemberByMemberId(authorId);
		
	}
	
	public Message findByAuthorId(String memberId) {
		return mDao.findByAuthorId(memberId);
	}
	
	public List<Message> findPublicByArticleId(Integer articleId){
		return mDao.findPublicByArticleId(articleId);
	}
		
}
