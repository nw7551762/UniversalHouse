package evaluation;

import java.util.List;

public interface EvaluationDao {
	
	int updateProject(EvaluationBean bean);
	
	EvaluationBean findByID(int evID);
	
	EvaluationBean findByMember(int projectID,String memberID);

	EvaluationBean findByPJMember(int projectID,String memberID);
	
	void saveEvaluation(int pjID, String mbID, String pjMbID, int pjPrice);

	List<EvaluationBean> findByMember(String memberID);

	List<EvaluationBean> findByPJMember(String pjMemberID);

	int completeProject(EvaluationBean bean);
}
