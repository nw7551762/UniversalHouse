package jia;

public interface ProjectDao {
	
	// 新增案件
	void saveProject(ProjectBean bean);
	
	// 用ID刪除案件
	void deleteByID(int projectID);
	
	//更新一筆案件，不改圖片
	int updateProject(ProjectBean bean);
	
	//更新一筆案件
	void updateProject(ProjectBean bean,long sizeImgType);

	//用案件ID查詢
	ProjectBean findByID(int projectID);
	
}
