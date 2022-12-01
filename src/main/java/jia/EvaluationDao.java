package jia;

public interface EvaluationDao {
	
	void saveEvaluation(EvaluationBean bean);
	
	int updateProject(EvaluationBean bean);
	
	EvaluationBean findByID(int projectID,int memberPk);
}
