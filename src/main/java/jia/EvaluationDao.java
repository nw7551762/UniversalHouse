package jia;

public interface EvaluationDao {
	
	void saveEvaluation(EvaluationBean bean);
	
	void updateProject(EvaluationBean bean);
	
	EvaluationBean findByPjID(int projectID);
}
