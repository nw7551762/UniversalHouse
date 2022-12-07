package dao;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Part;

import model.TestBean;

public interface testService {

	void deletetestCenter() throws SQLException;

	void addIOConnent(List<TestBean> list) throws SQLException;

	List<TestBean> IOConnent(Part part) throws SQLException;

	List<TestBean> checkFieldTest(String field);

	void modify(String examinationQuestion, String answer, String field, String options, String options2,
			String options3, String options4, String testId) throws SQLException;

}
