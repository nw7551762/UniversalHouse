package forum.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import forum.model.Article;
import utils.HibernateUtil;

public class ImgDao {

	private SessionFactory factory;

	public ImgDao() {
	}

	public void save(Integer articleId, List<Img> imgList) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			Article article = new Article();
			List<Img> savedList = new ArrayList<Img>();
			article = session.get(Article.class, articleId);

			for (Img img : imgList) {
				Img savedImg = new Img();
				System.out.println("------------" + img.getImgName() + "------------");
				System.out.println("------------" + img.getImg() + "------------");
				savedImg.setImgName(img.getImgName());
				savedImg.setImg(img.getImg());
				savedImg.setArticle(article);
				savedList.add(savedImg);
			}

			article.setImg(savedList);
			session.save(article);
			session.getTransaction().commit();

		} catch (NoResultException | NonUniqueResultException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public List<Img> findByArticleId(Integer articleId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			String hql = "FROM Img WHERE articleId_fk = :a";
			List<Img> result = session.createQuery(hql, Img.class).setParameter("a", articleId).getResultList();

			session.getTransaction().commit();
			return result;

		} catch (NoResultException | NonUniqueResultException e) {
			session.getTransaction().rollback();
			e.getStackTrace();
			return null;
		}

	}

	public void deleteByArticleId(Integer articleId) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			Article article = session.get(Article.class, articleId);
			List<Img> imgList = article.getImg();

			if (imgList != null) {
				article.setImg(null);
				for (Img img : imgList) {
					session.delete(img);
				}
				session.save(article);
				session.getTransaction().commit();
			}

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();

		}
	}

	public void deleteByImgNo(Integer imgNo) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			Img img = session.get(Img.class, imgNo);
			session.delete(img);
			session.getTransaction().commit();

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();

		}
	}

	public Img findByImgNo(Integer imgNo) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {
			Img img = session.get(Img.class, imgNo);
			session.getTransaction().commit();
			return img;

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	public void update(Img img) {

		factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {

			Img updateImg = session.get(Img.class, img.getImgNo());
			updateImg.setImgName(img.getImgName());
			updateImg.setImg(img.getImg());

			session.update(updateImg);
			session.getTransaction().commit();

		} catch (NoResultException | NonUniqueResultException e) {

			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

}
