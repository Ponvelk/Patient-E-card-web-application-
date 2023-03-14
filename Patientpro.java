
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Patientpro
 */
@WebServlet("/Patientpro")
public class Patientpro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Patientpro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Patient-Medical</title>\r\n"
				+ "</style>\r\n"
				+ "<link\r\n"
				+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\"\r\n"
				+ "	rel=\"stylesheet\"\r\n"
				+ "	integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\"\r\n"
				+ "	crossorigin=\"anonymous\">\r\n"
				+ "<script\r\n"
				+ "	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "	integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\"\r\n"
				+ "	crossorigin=\"anonymous\"></script>\r\n"
				+ "<body\r\n"
				+ "	style=\"background-image: linear-gradient(to right, white, lightblue);\">"
				+ "<style>"
				+ ".wrapper {\r\n"
				+ "    height: 100vh;\r\n"
				+ "    display: flex;\r\n"
				+ "    justify-content: center;\r\n"
				+ "    align-items: center\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".wrapper {\r\n"
				+ "    height: 50vh;\r\n"
				+ "    display: flex;\r\n"
				+ "    justify-content: center;\r\n"
				+ "    align-items: center;\r\n"
				+ "    width: 100%;\r\n"
				+ "    background-color: #E1F5FE\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".card {\r\n"
				+ "    padding: 10px;\r\n"
				+ "    width: 350px;\r\n"
				+ "    height: 80px;\r\n"
				+ "    overflow: hidden;\r\n"
				+ "    border-radius: 10px;\r\n"
				+ "    cursor: pointer;\r\n"
				+ "    border: none;\r\n"
				+ "    position: relative\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".coral {\r\n"
				+ "    transform: rotate(90deg)\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".card-details {\r\n"
				+ "    margin-top: 5px\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".details {\r\n"
				+ "    display: flex;\r\n"
				+ "    justify-content: space-between;\r\n"
				+ "    align-items: center\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".plus {\r\n"
				+ "    color: #ccc;\r\n"
				+ "    font-size: 15px\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".amount {\r\n"
				+ "    color: #fff\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".number {\r\n"
				+ "    line-height: 17px;\r\n"
				+ "    color: #ccc\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".upper:hover .card {\r\n"
				+ "    animation: height 1s ease-in forwards\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".upper:hover .card-details {\r\n"
				+ "    animation: card-details 1.5s ease-in forwards\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "@keyframes card-details {\r\n"
				+ "    0% {\r\n"
				+ "        left: 3%;\r\n"
				+ "        top: 0%\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    100% {\r\n"
				+ "        margin-top: 5px;\r\n"
				+ "        left: 4%;\r\n"
				+ "        top: 29%;\r\n"
				+ "        position: absolute\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".card:hover .coral {\r\n"
				+ "    animation: coral 2s ease-in-out forwards\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "@keyframes coral {\r\n"
				+ "    0% {\r\n"
				+ "        left: 0%\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    100% {\r\n"
				+ "        left: -89%\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".upper:hover .card-number {\r\n"
				+ "    top: 45%;\r\n"
				+ "    position: relative\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "@keyframes height {\r\n"
				+ "    0% {\r\n"
				+ "        height: 70px\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    25% {\r\n"
				+ "        height: 100px\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    50% {\r\n"
				+ "        height: 140px\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    50% {\r\n"
				+ "        height: 170px\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    100% {\r\n"
				+ "        height: 210px\r\n"
				+ "    }\r\n"
				+ "}"
				+ "table,tr,td{"
				+ "border:1px solid black;border-collapse:collapse\""
				+ "</style>");
		String option=request.getParameter("buton");
		switch(option) {
		case "Calculate Discount":{
		int amount = Integer.parseInt(request.getParameter("amt"));
		String id = request.getParameter("id");
		FileInputStream fis = new FileInputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card//PatientDetails");
		ObjectInputStream ois = new ObjectInputStream(fis);
		LinkedHashMap<Integer, LinkedHashMap<String, String>> lhm = null;
		try {
			lhm = (LinkedHashMap) ois.readObject();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		LinkedHashMap<String, String> hm = (LinkedHashMap) lhm.get(Integer.parseInt(id));
		String cardtype = hm.get("cardtype");
		String name=hm.get("Name");
		String Dob=hm.get("DOB");
		int discount = 0;
		switch (cardtype) {
		case "Silver": {
			discount = (int) (amount * (double) (100 - 10) / 100);
			break;
		}
		case "Gold": {
			discount = (int) (amount * (double) (100 - 15) / 100);
			break;
		}
		case "Platinum": {
			discount = (int) (amount * (double) (100 - 18) / 100);
			break;
		}
		}
		out.println("<h1><span style=\"color: #e67e22;\">Discount</span> Details......</h1>\n"
				+ "<div class=\"wrapper\"> \r\n"
				+ "    <div class=\"upper\"> \r\n"
				+ "        <div class=\"card bg-dark\"> \r\n"
				+ "            <div class=\"details\"> <div class=\"d-flex flex-column card-details\">\r\n"
				+ "                 <span class=\"plus\"><h2><span style=\\\"color: #e67e22;\\\">"+cardtype+"</span></h2></span> <h4 class=\"amount\">Your ID:"+id+"</h4> \r\n"
				+ "                 </div> \r\n"
				+ "                   <img src=\"https://i.imgur.com/ZnvAG93.png\" width=\"40\" class=\"coral\"> \r\n"
				+ "                 </div> \r\n"
				+ "                 <div class=\"d-flex justify-content-between mt-3 align-items-center card-number\"> \r\n"
				+ "                     <img src=\"https://i.imgur.com/xTeZOlU.png\" width=\"30\">\r\n"
				+ "                      <div class=\"d-flex flex-column number\">\r\n"
				+ "                           <span>"+name+"</span> <span class=\"text-right\">"+Dob+"</span> \r\n"
				+ "                           </div> \r\n"
				+ "                        </div>\r\n"
				+ "                     </div>\r\n"
				+ "                 </div>\r\n"
				+ "             </div>"
				+ ""
				+"<div style=\"padding-left:20%\">"
				+ "   <h1><span style=\"color: #e67e22;\">Here are </span>your Discount Details......</h1>"
				+ "<table ><br><br>"
				+ "<tr><td><h3>The total Amount</h3></td><td><h3>"+amount+"</h3></td></tr> <tr><td><h3>The Discount Amount</h3></td><td><h3>"+discount
				+"</h3><tr><td><h3>The Amount to Pay</h3></td><td><h3>"+(amount-discount)+"</h3></td></tr></table>"
						+ "</div>"
						+ "</div></body></html>");
		//out.println("The Discount Amount = " + (amount - discount) + "\nAmount to Pay = " + discount);
		break;
		}
		
		case "View Details":{
			int id=Integer.parseInt(request.getParameter("id"));
			LinkedHashMap<Integer,Map<String,String>> hm=null;
			FileInputStream fis = new FileInputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card//PatientDetails");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				hm = (LinkedHashMap<Integer, Map<String, String>>) ois.readObject();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(hm!=null){
				LinkedHashMap<String,String> hms=(LinkedHashMap<String, String>) hm.get(id);
				out.println("<div>"
						+ "   <h1><span style=\"color: #e67e22;\">Here are</span> your Details......"
						+ "</div><br><br><BR><BR><BR>");
				out.println("<div style=\"padding-left:30%\">"
						+ "<table style=\"\">"
						);
				for(Map.Entry e:hms.entrySet()) {
					//out.println(String.format("|%-12s | %-25s|",e.getKey(),e.getValue()));
					out.print("<tr><td><h3>"+e.getKey()+"</h3></td><td> <h3><span style=\"color: #e67e22;\">"+(e.getValue())+"</span></h3></td></tr>");
				}
				out.print("</table></div></div></body></html>");
			}
			else {
				System.err.println("Invalid User Name");
			}
			break;
		}
		case "Update Details":{
			int id=Integer.parseInt(request.getParameter("id"));
			String field=request.getParameter("field");
			String value =request.getParameter("fieldval");
			FileInputStream fis = new FileInputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card//PatientDetails");
			ObjectInputStream ois = new ObjectInputStream(fis);
			LinkedHashMap<Integer, Map<String, String>> hm = null;
			try {
				hm = (LinkedHashMap) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			LinkedHashMap<String, String> hms = (LinkedHashMap<String, String>) hm.get(id);
				hms.put(field, value);
				hm.put(id, hms);
				FileOutputStream df = new FileOutputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card//PatientDetails");
				ObjectOutputStream doo = new ObjectOutputStream(df);
				doo.writeObject(hm);
				
				//Printing Details
				LinkedHashMap<Integer,Map<String,String>> hm1=null;
				FileInputStream fis1 = new FileInputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card//PatientDetails");
				ObjectInputStream ois1 = new ObjectInputStream(fis1);
				try {
					hm1 = (LinkedHashMap<Integer, Map<String, String>>) ois1.readObject();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(hm1!=null){
					LinkedHashMap<String,String> hms1=(LinkedHashMap<String, String>) hm1.get(id);
					out.println("<div>"
							+ "   <h1><span style=\"color: #e67e22;\">Here are</span> your  Updated Details......"
							+ "</div><br><br><BR><BR><BR>");
					out.println("<div style=\"padding-left:30%\">"
							+ "<table style=\"\">"
							);

					for(Map.Entry e:hms1.entrySet()) {
						//out.println(String.format("|%-12s | %-25s|",e.getKey(),e.getValue()));
						out.print("<tr><td><h3>"+e.getKey()+"</h3></td><td> <h3><span style=\"color: #e67e22;\">"+(e.getValue())+"</span></h3></td></tr>");					}
					out.print("</table></div></body></html>");
				}
				break;
		}
	}}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
