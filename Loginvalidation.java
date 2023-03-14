
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Loginvalidation")
public class Loginvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Loginvalidation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = request.getParameter("opt");
		String name = request.getParameter("uname");
		String password = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		//out.println(option + " " + name + " " + password);
//Patient Validation----------------------------------------------------------------------------------------------------------------------------------	
		if (option.equals("1")) {
			int flag = 0;
			FileInputStream fos=new FileInputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card/password");
			ObjectInputStream oos=new ObjectInputStream(fos);
			LinkedHashMap<String,String> hm=null;
			try {
				hm=(LinkedHashMap<String,String>)oos.readObject();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			out.println(hm);
			//if(hm!=null) {
				//if(hm.containsKey(name)) {
					//if(hm.get(name).equals(password)) {
				      if(name.equals(password)) {
						flag=1;
					}
					else {
						System.out.println("Invalid Password");
					}
			//	}
			//}
			if (flag == 1) {
				response.sendRedirect("Patient.html");
			}
		}
//_____________________________________________________________________________________________________________________________________
// Manager Validation__________________________________________________________________________________________________________________	
		if (option.equals("3")) {
			System.out.println("hi manager");
			int flag=0;
			FileInputStream fis = new FileInputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card/ManagerDetails");
			ObjectInputStream ois = new ObjectInputStream(fis);
			LinkedHashMap<String, LinkedHashMap<String, String>> hm=null;
			try {
				hm = (LinkedHashMap)ois.readObject();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name1=hm.get("M101").get("Name");
			if(name1.equals(name)) {
				String pass=(hm.get("M101").get("Name"))+(hm.get("M101").get("DOB"));
				if(password.equals(pass)) {
					flag= 1;
				}
				else {
					System.err.println("Invalid PassWord");
				}
			}
			if(flag==1) {
				response.sendRedirect("Manager.html");
			}
			else {
				System.err.println("Invalid UserName");
			}
		}
//_____________________________________________________________________________________________________________________________________
// Manager Validation__________________________________________________________________________________________________________________	
		if (option.equals("2")) {
			int flag1=0;
			FileInputStream fis = new FileInputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card/chairmanDetails");
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashMap<String, HashMap<String, String>> hm=null;
			try {
				hm = (HashMap<String, HashMap<String, String>>) ois.readObject();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			String name1=hm.get("C101").get("Name"); 
			if(name1.equals(name1)) {
				String pass=(hm.get("C101").get("Name"))+(hm.get("C101").get("DOB"));
				if(password.equals(pass)) {
					flag1=1;
				}
			}
			if(flag1==1) {
				response.sendRedirect("Chairman.html");
			}
			else {
				System.err.println("Invalid UserName");
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
