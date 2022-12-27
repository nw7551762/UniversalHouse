package forum.model;

import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import member.model.Member;
import utils.HibernateUtil;

public class ArticleDao {

	private SessionFactory factory;

	public ArticleDao() {
	}

	public Article save(Article article) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			Article savedArticle = new Article();

			savedArticle.setAuthorId(article.getAuthorId());
			savedArticle.setUpdateTime(article.getUpdateTime());
			savedArticle.setTopicName(article.getTopicName());
			savedArticle.setTitle(article.getTitle());
			savedArticle.setContent(article.getContent());
			savedArticle.setLike(article.getLike());
			savedArticle.setDislike(article.getDislike());
			savedArticle.setStatus(article.getStatus());

			session.save(savedArticle);
			
			session.getTransaction().commit();
			return savedArticle;

		} catch (NoResultException | NonUniqueResultException e) {
			session.getTransaction().rollback();
			e.getStackTrace();
			return null;
		}

	}

	public Article findByArticleId(Integer articleId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {
			Article article = session.get(Article.class, articleId);
			session.getTransaction().commit();
			return article;

		} catch (Exception e) {

			session.getTransaction().rollback();
			e.printStackTrace();
			return null;

		}
	}

	public List<Article> findAll() {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			List<Article> result = session.createQuery("FROM Article", Article.class).getResultList();
			session.getTransaction().commit();
			return result;

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();
			return null;

		}
	}

	public List<Article> findPublic() {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			List<Article> result = session.createQuery("FROM Article WHERE status = 'public'", Article.class)
					.getResultList();
			session.getTransaction().commit();
			return result;

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();
			return null;

		}
	}

	public Article updateById(Article article) {
		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			Article result = session.get(Article.class, article.getArticleId());

			if (result != null) {
				result.setUpdateTime(article.getUpdateTime());
				result.setTopicName(article.getTopicName());
				result.setTitle(article.getTitle());
				result.setContent(article.getContent());
				result.setStatus(article.getStatus());
				result.setLike(article.getLike());
				result.setDislike(article.getDislike());

				session.update(result);
				session.getTransaction().commit();
			}

			return article;

		} catch (Exception e) {

			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	public Article findByTitle(String title) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			String hql = "FROM Article WHERE title = :t";
			Article article = session.createQuery(hql, Article.class).setParameter("t", title).getSingleResult();

			session.getTransaction().commit();
			return article;

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			return null;
		}
	}

	public boolean deleteByArticleId(Integer articleId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {
			Article article = session.get(Article.class, articleId);
			session.delete(article);

			session.getTransaction().commit();
			return true;

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();
			return false;

		}
	}

	public List<Article> findAllByMemberId(String memberId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {
			String hql = "FROM Article WHERE memberId_fk = :m";
			List<Article> articleList = session.createQuery(hql, Article.class).setParameter("m", memberId)
					.getResultList();
			session.getTransaction().commit();
			return articleList;

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	public Member findMemberByMemberId(String authorId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			String hql = "FROM Member WHERE memberId = :a";
			Member member = session.createQuery(hql, Member.class).setParameter("a", authorId).getSingleResult();
			session.getTransaction().commit();
			return member;

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			return null;

		}

	}

	public Member findMemberByName(String name) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			String hql = "FROM Member WHERE name LIKE :name";
			Member result = session.createQuery(hql, Member.class).setParameter("name","%" + name + "%").getSingleResult();
			session.getTransaction().commit();
			return result;

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			return null;
		}
	}

}
