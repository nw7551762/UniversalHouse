package member.model;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.HqlASTFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.HibernateUtil;

public class MemberDao {
	private static Logger log = LoggerFactory.getLogger(MemberDao.class);

	public MemberDao() {
	}

	public Member findByMemberIdAndPassword(String memberId, String password) {
		String hql = "from Member m where m.memberId = :memberId and m.password = :password";
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		try {
			Member result = session.createQuery(hql, Member.class).setParameter("memberId", memberId)
					.setParameter("password", password).getSingleResult();
			
			session.getTransaction().commit();
			return result;
		} catch (NoResultException | NonUniqueResultException e) {
			session.getTransaction().rollback();
			System.out.println("rollback!");
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	public List<Member> findAllMember() {
		String hql = "from Member";
		List<Member> resultList=null;
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		try {
			Query<Member> query = session.createQuery(hql, Member.class);
			resultList = query.getResultList();
			
			session.getTransaction().commit();
			return resultList;
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println("rollback!");
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
		
	}
	
	public Member findByMemberId(String memberId) {
		String hql = "from Member where memberId = :m";

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		try {
			Member member = session.createQuery(hql,Member.class)
					.setParameter("m", memberId)
					.getSingleResult();
			
			session.getTransaction().commit();
			return member;
			
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("rollback!");
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	public Member findByMemberPK(Integer pk) {
		log.info("會員登入功能之Dao: 檢查帳號/密碼"); 
		Member member=null;
		String hql = "from Member where memberPk = :m";
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		try {
			member = session.createQuery(hql,Member.class).setParameter("m", pk).getSingleResult();
			session.getTransaction().commit();
			return member;
		}catch( Exception e){
			session.getTransaction().rollback();
			System.out.println("rollback!");
			return null;
		}finally {
			session.close();
		}
	}
	
	public boolean existsById(String memberId) {
		log.info("會員註冊功能之Dao: 檢查會員輸入的編號是否已被使用");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		try {
			if( session.get(Member.class, memberId)!=null ) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
	}
	

	public void deleteByMemberPk(Integer memberPk) {
		log.info("會員刪除功能之Dao: 檢查會員是否存在");
		Member member = null;
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		member = session.get(Member.class, memberPk);
		
		try {
			if( member!=null ) {
				session.delete(member);
				session.getTransaction().commit();
				System.out.println("刪除一筆資料");
			}else {
				System.out.println("不存在該會員無法刪除");
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void update(Member mb) {
		log.info("會員註冊功能之Dao: 儲存會員資料");
		Member member = null;
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		try {
			if( mb!=null ) {
				member = session.get(Member.class, mb.getMemberPk());
				member.setMemberId(mb.getMemberId());
				member.setName(mb.getName());
				member.setPassword(mb.getPassword());
				member.setLocation(mb.getLocation());
				member.setEmail(mb.getEmail());
				member.setPhone(mb.getPhone());
				member.setUserType(mb.getUserType());
				member.setMemberImage(mb.getMemberImage());
				member.setLastLogin(mb.getLastLogin());
				member.setVerification(mb.getVerification());
				member.setPermission(mb.getPermission());
				
				session.update(member);
				session.getTransaction().commit();
				System.out.println("update member OK");
			}else {
				System.out.println("memberBean is null, pls check");
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
	}
	
	public void save(Member mb) {
		log.info("會員註冊功能之Dao: 更新會員資料");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		try {
			System.out.println("session dao:"+session);
			session.save(mb);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	
}

