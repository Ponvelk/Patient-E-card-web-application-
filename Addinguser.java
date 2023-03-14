

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addinguser
 */
@WebServlet("/Addinguser")
public class Addinguser extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Addinguser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileInputStream fis = new FileInputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card/PatientDetails");
		ObjectInputStream ois = new ObjectInputStream(fis);
		LinkedHashMap<Integer, Map<String, String>> hm2 = null;
		try {
			hm2 = (LinkedHashMap<Integer, Map<String, String>>) ois.readObject();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		Set<Integer> st = hm2.keySet();
		int pid=st.size()+1;
		
		LinkedHashMap<String,String> hm=new LinkedHashMap<>();
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String cardtype=request.getParameter("type");
		String Email=request.getParameter("email");
		String bgroup=request.getParameter("bgroup");
		String gender=request.getParameter("gender");
		hm.put("Name", name);
		hm.put("DOB", dob);
		hm.put("cardtype", cardtype);
		hm.put("E-mail", Email);
		hm.put("B-Group", bgroup);
		hm.put("Gender", gender);
		
		
		
		LinkedHashMap<Integer, Map<String, String>> hm1 = null;
		try {
			FileInputStream fis1 = new FileInputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card/PatientDetails");
			ObjectInputStream ois1 = new ObjectInputStream(fis1);
			try {
				hm1 = (LinkedHashMap<Integer, Map<String, String>>) ois1.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (EOFException e) {
		}
		if (hm1 == null) {
			hm1 = new LinkedHashMap<Integer, Map<String, String>>();
		}
		hm1.put(pid,hm);
		FileOutputStream df = new FileOutputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card/PatientDetails");
		ObjectOutputStream doo = new ObjectOutputStream(df);
		doo.writeObject(hm1);
		// Creating username & password.
		String username = Integer.toString(pid);
		String password = hm1.get(pid).get("name");
		pid++;

		LinkedHashMap<String, String> hm21 = null;
		try {
			FileInputStream fos = new FileInputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card/password");
			ObjectInputStream oos = new ObjectInputStream(fos);
			try {
				hm21 = (LinkedHashMap<String, String>) oos.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (EOFException e) {
		}
		if (hm21 == null) {
			hm21 = new LinkedHashMap<String, String>();
		}
		hm21.put(username, password);
		FileOutputStream pf = new FileOutputStream("C:/Users/ponve/eclipse-workspace/Medical_E-card/password");
		ObjectOutputStream poo = new ObjectOutputStream(pf);
		poo.writeObject(hm21);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
