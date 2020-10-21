package ru.appline;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.appline.logic.Model;
import ru.appline.logic.User;

@WebServlet("/get")
public class ServletList extends HttpServlet {
	
	Model model = Model.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (id == 0) {
			
			pw.print("<html>" +
					"<h3>��������� ������������</h3><br>" + 
					"ID ������������: " +
					 		"<ul>");
			
			for (Map.Entry<Integer, User> entry: model.getFromList().entrySet()) {
				
				pw.print("<li>" + entry.getKey() + "</li>" + "<ul>" +
						"<li>���: " + entry.getValue().getName() + "</li>" + 
						"<li>�������: " + entry.getValue().getSurname() + "</li>" +
						"<li>��������: " + entry.getValue().getSalary() + "</li>" + 
						"</ul>");
			}
			pw.print("</ul>" + "<a href=\"index.jsp\">�����</a>" + 
			 		"</html>");
		} else if (id > 0) {
			if (id > model.getFromList().size()) {
				pw.print("<html>" + "<h3>��� ������ ������������</h3><br>" +
						"<a href=\"index.jsp\">�����</a>" + 
				 		"</html>");
			} else {
				pw.print("<html>" + "<h3>����������� ������������:</h3><br>" +
						"���: " + model.getFromList().get(id).getName() + "<br>" +
						"�������: " + model.getFromList().get(id).getSurname() + "<br>" +
						"��������: " + model.getFromList().get(id).getSalary() + "<br>" +
						"<a href=\"index.jsp\">�����</a>" + 
				 		"</html>");
			}
		} else {
			pw.print("<html>" + "<h3>id ������ ���� ������ 0!</h3><br>" +
					"<a href=\"index.jsp\">�����</a>" + 
			 		"</html>");
		}
	}

}
