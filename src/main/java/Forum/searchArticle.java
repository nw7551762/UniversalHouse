package Forum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findById")
public class searchArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public searchArticle() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String articleId=request.getParameter("id");
		request.setAttribute("id", articleId);

	
		RequestDispatcher rd = request.getRequestDispatcher("/toConsole");
		rd.forward(request, response);
		return;
		
	}

}
