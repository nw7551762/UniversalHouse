package article_message;

import java.sql.SQLException;
import java.util.List;

import regist.MemberBean;


public class MessageService {
	
	MessageDao mDao = null;
	
	public MessageService() {
		mDao = new MessageDao();
	}	
	
	public void saveMessage(MessageBean mb) throws SQLException {
		mDao.saveMessage(mb);
	}
	
	public List<MessageBean> findMessageByArticleId(Integer articleId) {
		return mDao.findMessageByArticleId(articleId);
	}
	
	public void deleteMessageById(Integer articleId) {
		mDao.deleteMessageById(articleId);
	}
	
	public MemberBean findBeanByMemberId(String memberId) {
		return mDao.findBeanByMemberId(memberId);
	}
	
	public MemberBean findBeanByAuthorId(int authorId) {
		return mDao.findBeanByAuthorId(authorId);
		
	}
	
	public void deleteByMessageId(Integer messageId) {
		mDao.deleteByMessageId(messageId);
	}
}
