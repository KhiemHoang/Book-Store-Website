package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addtocart
 */
@WebServlet("/addtocart")
public class addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL = request.getQueryString();
		URL= java.net.URLDecoder.decode(URL, StandardCharsets.UTF_8.name());
		if(URL.length()>0)
		{
		List<String> cartlist = new ArrayList<String>();
		
		HttpSession session=request.getSession(false);  
		cartlist = (List<String>) session.getAttribute("cartlist");
		cartlist.add(URL);
		session.setAttribute("cartlist",cartlist);
		}
		RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/cart.jsp");
		RequetsDispatcherObj.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> cartlist = new ArrayList<String>();
		HttpSession session=request.getSession(false);  
		cartlist = (List<String>) session.getAttribute("cartlist");
		String name = "button";
		for(int i = 0;i<cartlist.size();i++)
		{
			name = name+i;
			if(null != request.getParameter(name))
				 {
					System.out.println("delete " + name );
					cartlist.remove(i);
					session.setAttribute("cartlist",cartlist);
					break;
				 }
			name ="button";
			RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("IndexServlet");
			RequetsDispatcherObj.forward(request, response);
				 
		}
		
	}

}
