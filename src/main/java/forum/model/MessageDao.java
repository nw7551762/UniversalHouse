package forum.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import member.model.Member;
import utils.HibernateUtil;

public class MessageDao {

	private SessionFactory factory;

	public MessageDao() {}

	public void save(Integer articleId, Message message) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			List<Message> savedList = new ArrayList<Message>();
			Article article = new Article();
			Message savedmessage = new Message();

			savedmessage.setMessageId(message.getMessageId());
			savedmessage.setUpdateTime(message.getUpdateTime());
			savedmessage.setAuthorId(message.getAuthorId());
			savedmessage.setContent(message.getContent());
			savedmessage.setStatus(message.getStatus());
			savedmessage.setLike(message.getLike());
			savedmessage.setDislike(message.getDislike());

			article = session.get(Article.class, articleId);
			savedmessage.setArticle(article);

			savedList.add(savedmessage);
			article.setMessage(savedList);

			session.update(article);
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public List<Message> findAllByArticleId(Integer articleId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			String hql = "FROM Message WHERE articleId_fk = :a";
			List<Message> result = session.createQuery(hql, Message.class).setParameter("a", articleId).getResultList();

			session.getTransaction().commit();
			return result;

		} catch (NoResultException | NonUniqueResultException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	public void deleteByArticleId(Integer articleId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			Message message = session.get(Message.class, articleId);

			session.delete(message);

			session.getTransaction().commit();

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void deleteByMessageId(Integer messageId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {
			Message message = session.get(Message.class, messageId);
			if (message != null) {
				session.delete(message);
			}

			session.getTransaction().commit();

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	public Member findMemberByMemberId(String memberId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {
			String hql = "FROM Member WHERE memberId = :m";
			Member result = session.createQuery(hql, Member.class).setParameter("m", memberId).getSingleResult();

			session.getTransaction().commit();
			return result;

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}

	public Message findByAuthorId(String authorId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			String hql = "FROM Message WHERE authorId = :a";
			Message result = session.createQuery(hql, Message.class).setParameter("a", authorId).getSingleResult();

			session.getTransaction().commit();
			return result;

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	public List<Message> findPublicByArticleId(Integer articleId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {
			
			List<Message> messages = session.createQuery("FROM Message WHERE status = 'public' AND articleId_fk = :a", Message.class)
					.setParameter("a", articleId)
					.getResultList();

			session.getTransaction().commit();
			return messages;

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			return null;

		}
	}
}
