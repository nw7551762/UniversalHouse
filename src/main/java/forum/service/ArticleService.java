package forum.service;

import java.util.List;

import forum.model.Article;
import forum.model.ArticleDao;
import member.model.Member;

public class ArticleService {

	private ArticleDao aDao;

	public ArticleService() {
		this.aDao = new ArticleDao();
	}

	public Article save(Article article) {
		return aDao.save(article);
	}

	public Article findByArticleId(Integer articleId) {
		return aDao.findByArticleId(articleId);
	}

	public void deleteByArticleId(Integer articleId) {
		aDao.deleteByArticleId(articleId);
	}

	public void updateById(Article article) {
		aDao.updateById(article);
	}

	public List<Article> findAllByMemberId(String authorId) {
		return aDao.findAllByMemberId(authorId);
	}

	public List<Article> findAll() {
		return aDao.findAll();
	}

	public List<Article> findPublic() {
		return aDao.findPublic();
	}

	public Article findByTitle(String title) {
		return aDao.findByTitle(title);
	}

	public List<Article> findByName_FQ(String name) {
		
		Member member = aDao.findMemberByName(name);
		if(member==null) {
			return null;
		}
		
		return aDao.findAllByMemberId(member.getMemberId());
	}

	public Member findMemberByMemberId(String authorId) {
		return aDao.findMemberByMemberId(authorId);
	}

	public Member findMemberByName(String name) {
		return aDao.findMemberByName(name);
	}

}
