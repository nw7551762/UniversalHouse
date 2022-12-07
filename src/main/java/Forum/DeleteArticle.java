package Forum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Message.MessageService;

@WebServlet("/delete")
public class DeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteArticle() {}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		MemberService mbs = new MemberService();
		MessageService mss = new MessageService();
		int nId = 0;
		try {
			nId = Integer.parseInt(id);
		} catch(NumberFormatException ex) {
			;
		}
		MemberBean mb=mbs.findById(nId);
		mss.deleteMessageById(mb.getArticleId());
		mbs.deleteById(mb.getArticleId());
		
		RequestDispatcher rd = request.getRequestDispatcher("/Forum/frontPage.jsp");
		rd.forward(request, response);
		return;
		
	}

}
