package ru.appline;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.appline.logic.Model;
import ru.appline.logic.User;

/**
 * Servlet implementation class ServletDelete
 */
@WebServlet("/delete")
public class ServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Model model = Model.getInstance();
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		if (id > 0 && id <= model.getFromList().size()) {
			model.delete(id);
			
			pw.print("<html>" + "<h3>Пользователь успешно удален</h3><br>" +
					"<a href=\"index.jsp\">Домой</a>" + 
			 		"</html>");
		}
		
	}

}
