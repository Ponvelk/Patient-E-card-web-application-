
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chairmanpro
 */
@WebServlet("/Chairmanpro")
public class Chairmanpro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Chairmanpro() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Patient-Medical</title>\r\n" + "</style>\r\n" + "<link\r\n"
				+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\"\r\n"
				+ "	rel=\"stylesheet\"\r\n"
				+ "	integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\"\r\n"
				+ "	crossorigin=\"anonymous\">\r\n" + "<script\r\n"
				+ "	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "	integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\"\r\n"
				+ "	crossorigin=\"anonymous\"></script>\r\n"
				+ "<body style=\"background-image: linear-gradient(to right, white, lightblue);\">");
		String opt = request.getParameter("buton");
		switch (opt) {

		case "Deleteuser": {
			int id = Integer.parseInt(request.getParameter("id"));
			FileInputStream fis = new FileInputStream(
					"C:/Users/ponve/eclipse-workspace/Medical_E-card//PatientDetails");
			ObjectInputStream ois = new ObjectInputStream(fis);
			LinkedHashMap<Integer, LinkedHashMap<String, String>> hm1 = null;
			try {
				hm1 = (LinkedHashMap) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			hm1.remove(id);
			FileOutputStream df = new FileOutputStream(
					"C:/Users/ponve/eclipse-workspace/Medical_E-card//PatientDetails");
			ObjectOutputStream doo = new ObjectOutputStream(df);
			doo.writeObject(hm1);
			out.println("<h1>Deleted SuccessFully</h1></body></html>");
			break;
		}

		case "AddManager": {
			String name = request.getParameter("name");
			String dob = request.getParameter("dob");
			String cardtype = request.getParameter("type");
			String Email = request.getParameter("email");
			String bgroup = request.getParameter("bgroup");
			String gender = request.getParameter("gender");
			String Address = request.getParameter("add");
			String Phone_number = request.getParameter("pno");
			String branchdetails = request.getParameter("branch");
			LinkedHashMap<String, String> hm = new LinkedHashMap<>();
			hm.put("Name", name);
			hm.put("DOB", dob);
			hm.put("E-mail", Email);
			hm.put("B-Group", bgroup);
			hm.put("Gender", gender);
			hm.put("Address", Address);
			hm.put("Phone_number", Phone_number);
			hm.put("branchdetails", branchdetails);
			LinkedHashMap<String, Map<String, String>> hm1 = new LinkedHashMap<>();
			hm1.put("M101", hm);
			FileOutputStream df = new FileOutputStream(
					"C:/Users/ponve/eclipse-workspace/Medical_E-card//ManagerDetails");
			ObjectOutputStream doo = new ObjectOutputStream(df);
			doo.writeObject(hm1);
			out.println("<h1>Added successfully</h1></body></html>");
		}

		case "Update Manager": {
			String id = request.getParameter("id");
			String field = request.getParameter("field");
			String value = request.getParameter("fieldval");
			FileInputStream fis = new FileInputStream(
					"C:/Users/ponve/eclipse-workspace/Medical_E-card//ManagerDetails");
			ObjectInputStream ois = new ObjectInputStream(fis);
			LinkedHashMap<String, Map<String, String>> hm = null;
			try {
				hm = (LinkedHashMap) ois.readObject();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LinkedHashMap<String, String> hms = (LinkedHashMap<String, String>) hm.get(id);
			hms.put(field, value);
			hm.put(id, hms);
			FileOutputStream df = new FileOutputStream(
					"C:/Users/ponve/eclipse-workspace/Medical_E-card//ManagerDetails");
			ObjectOutputStream doo = new ObjectOutputStream(df);
			doo.writeObject(hm);
			out.println("<div>" + "   <h1><span style=\"color: #e67e22;\">Here are</span> your  Updated Details......"
					+ "</div><br><br><BR><BR><BR>");
			out.println("<div style=\"padding-left:30%\">" + "<table style=\"\">");
			for (Map.Entry e : hms.entrySet()) {
				out.print("<tr><td><h3>" + e.getKey() + "</h3></td><td> <h3><span style=\"color: #e67e22;\">"
						+ (e.getValue()) + "</span></h3></td></tr>");
			}
			out.print("</table></div></body></html>");
		}
			break;
		case "View Manager": {
			String id = request.getParameter("id");
			FileInputStream fis = new FileInputStream(
					"C:/Users/ponve/eclipse-workspace/Medical_E-card//ManagerDetails");
			ObjectInputStream ois = new ObjectInputStream(fis);
			LinkedHashMap<String, Map<String, String>> hm = null;
			try {
				hm = (LinkedHashMap) ois.readObject();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LinkedHashMap<String, String> hms = (LinkedHashMap<String, String>) hm.get(id);
			FileOutputStream df = new FileOutputStream(
					"C:/Users/ponve/eclipse-workspace/Medical_E-card//ManagerDetails");
			ObjectOutputStream doo = new ObjectOutputStream(df);
			doo.writeObject(hm);

			out.println("<div>" + "   <h1><span style=\"color: #e67e22;\">Here are</span> Manager Details......"
					+ "</div><br><br><BR><BR><BR>");
			out.println("<div style=\"padding-left:30%\">" + "<table style=\"\">");
			for (Map.Entry e : hms.entrySet()) {
				out.print("<tr><td><h3>" + e.getKey() + "</h3></td><td> <h3><span style=\"color: #e67e22;\">"
						+ (e.getValue()) + "</span></h3></td></tr>");
			}
			out.print("</table></div></body></html>");
		}
			break;

		case "View Chairman": {
			String id = request.getParameter("id");
			HashMap<String, Map<String, String>> hm = null;
			FileInputStream fis = new FileInputStream(
					"C:/Users/ponve/eclipse-workspace/Medical_E-card//ChairmanDetails");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				hm = (HashMap<String, Map<String, String>>) ois.readObject();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (hm != null) {
				HashMap<String, String> hms = (HashMap<String, String>) hm.get(id);

				out.println("<div>" + "   <h1><span style=\"color: #e67e22;\">Here are</span> Manager Details......"
						+ "</div><br><br><BR><BR><BR>");
				out.println("<div style=\"padding-left:30%\">" + "<table style=\"\">");
				for (Map.Entry e : hms.entrySet()) {
					out.print("<tr><td><h3>" + e.getKey() + "</h3></td><td> <h3><span style=\"color: #e67e22;\">"
							+ (e.getValue()) + "</span></h3></td></tr>");
				}
				out.print("</table></div></body></html>");
			}
			break;
		}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
