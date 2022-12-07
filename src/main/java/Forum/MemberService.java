package Forum;

import java.sql.SQLException;
import java.util.List;

public class MemberService {
	
	MemberDao mDao = null;
	
	public MemberService() {
		mDao = new MemberDao();
	}	
	
	public void save(MemberBean bean) throws SQLException {
		mDao.save(bean);
	}
	
	public MemberBean findById(Integer articleId) {
		return mDao.findById(articleId);
	}
	
	
	public void deleteById(Integer articleId) {
		mDao.deleteById(articleId);
	}
	
	public void updateById(MemberBean mb) {
		mDao.updateById(mb);
	}
	
	public List<MemberBean> findByAuthor(Integer id){
		return mDao.findByAuthor(id);
	}
	
	public List<MemberBean> findAll(){
		return mDao.findAll();
	}
	
	
}
