
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayDetails
 */
@WebServlet("/DisplayDetails")
public class DisplayDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String opt = request.getParameter("buton");
		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Patient-Medical</title>\r\n" + "<link\r\n"
				+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\"\r\n"
				+ "	rel=\"stylesheet\"\r\n"
				+ "	integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\"\r\n"
				+ "	crossorigin=\"anonymous\">\r\n" + "<script\r\n"
				+ "	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "	integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\"\r\n"
				+ "	crossorigin=\"anonymous\"></script>\r\n" + "<style>" + "table,tr,td{\r\n"
				+ "border:1px solid black;\r\n" + "border-collapse: collapse;\r\n" + "</style>" + "</head>"
				+ "<body style=\"background-image: linear-gradient(to right, white, lightblue);\">");
		String option = request.getParameter("buton");
		switch (opt) {
		case "ViewallDetails": {
			FileInputStream fis = new FileInputStream(
					"C:/Users/ponve/eclipse-workspace/Medical_E-card//PatientDetails");
			ObjectInputStream ois = new ObjectInputStream(fis);
			LinkedHashMap<Integer, Map<String, String>> hm = null;
			try {
				hm = (LinkedHashMap<Integer, Map<String, String>>) ois.readObject();
			} catch (Exception e2) {
				e2.printStackTrace();
			}out.println("<div>"
							+ "   <h1><span style=\"color: #e67e22;\">Here are</span> your Details......"
							+ "</div><br><br><BR><BR><BR>");
			if (hm != null) {
				for (Map.Entry e : hm.entrySet()) {
					int key = (int) e.getKey();
					out.println(" <h1><span style=\"color: #e67e22;\">Patient ID:</span>" + key+"</h1>");
					
					out.println("<div style=\"padding-left:30%\">"
							+ "<table style=\"\">"
							);
					for (Map.Entry e1 : (hm.get(key)).entrySet()) {
						out.print("<tr><td><h3>"+e1.getKey()+"</h3></td><td> <h3><span style=\"color: #e67e22;\">"+(e1.getValue())+"</span></h3></td></tr>");
					}
					out.print("</table></div></div></body></html>");
				}

			}
		}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
