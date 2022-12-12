package article;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regist.MemberBean;

@WebServlet("/searchRecord")
public class SearchRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchRecord() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberId = request.getParameter("id");
		ArticleService articleService = new ArticleService();
		MemberBean memberBean=articleService.findBeanByMemberId(memberId);
		
		List<ArticleBean> myRecord = null;
		myRecord = articleService.findByAuthor(memberBean.getMemberPK());

		request.setAttribute("BeanList", myRecord);

		RequestDispatcher rd = request.getRequestDispatcher("/Forum/Article/record.jsp");
		rd.forward(request, response);
		return;

	}

}
