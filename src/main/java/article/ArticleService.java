package article;

import java.util.List;

import regist.MemberBean;

public class ArticleService {
	
	ArticleDao aDao = null;
	
	public ArticleService() {
		aDao = new ArticleDao();
	}	
	
	public void save(ArticleBean articleBean) {
		aDao.save(articleBean);
	}
	
	public ArticleBean findById(Integer articleId) {
		return aDao.findById(articleId);
	}
	
	
	public void deleteById(Integer articleId) {
		aDao.deleteById(articleId);
	}
	
	public void updateById(ArticleBean articleBean) {
		aDao.updateById(articleBean);
	}
	
	public List<ArticleBean> findByAuthor(Integer authorId){
		return aDao.findByAuthor(authorId);
	}
	
	public List<ArticleBean> findAll(){
		return aDao.findAll();
	}
	
	public MemberBean findBeanByMemberId(String memberId) {
		return aDao.findBeanByMemberId(memberId);
	}
	
	public MemberBean findBeanByName(String name) {
		return aDao.findBeanByName(name);
	}
	
	public List<ArticleBean> fuzzyQueryBeanByName(String name){
		return aDao.fuzzyQueryBeanByName(name);
	}
	
	public MemberBean findMemberBeanByAuthorId(Integer authorId) {
		return aDao.findMemberBeanByAuthorId(authorId);
	}
	
	public boolean isExistBytitle(String title) {
		return aDao.isExistBytitle(title);
	}
}
