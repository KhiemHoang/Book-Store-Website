package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import model.*;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;


/**
 * Servlet implementation class ForgotServlet
 */
@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/book_controlling")
	private DataSource dataSource;
    public ForgotServlet() {
        super();
    }
    private forgotDAO abc;
    public void init() throws ServletException {
		super.init();
		
		try {
			abc = new forgotDAO(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

    public static boolean isValidEmailAddress(String email) {
    	   boolean result = true;
    	   try {
    	      InternetAddress emailAddr = new InternetAddress(email);
    	      emailAddr.validate();
    	   } catch (AddressException ex) {
    	      result = false;
    	   }
    	   return result;
    	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		Users temp = new Users(username,email);
		if (isValidEmailAddress(email) == false)
		{
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'INVALID EMAIL' ,  'FAIL !' ,  'error' );");
			out.println("});");
			out.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("forgotpwd.jsp");
			rd.include(request, response);
		}
		else 
		{
			if (abc.Find(temp) == 0)
			{
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'USER NOT FOUND OR EMAIL ADDRESS IS INCORRECT' ,  'FAIL !' ,  'error' );");
				out.println("});");
				out.println("</script>");
			}
			else
			{
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'SUCCESS' ,  'Please check your email for verification code!' ,  'success' );");
				out.println("});");
				out.println("</script>");
				
				int randomPIN = (int)(Math.random()*9000)+1000;
				request.setAttribute("code", randomPIN);
				
				final String un = "tuanjggaa98@gmail.com";
		        final String password = "tuan7777";

		        Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
		        prop.put("mail.smtp.port", "587");
		        prop.put("mail.smtp.auth", "true");
		        prop.put("mail.smtp.starttls.enable", "true"); //TLS
		        
		        Session session = Session.getInstance(prop,
		                new javax.mail.Authenticator() {
		                    protected PasswordAuthentication getPasswordAuthentication() {
		                        return new PasswordAuthentication(un, password);
		                    }
		                });

		        try {

		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress("MAILSV@gmail.com"));
		            message.setRecipients(
		                    Message.RecipientType.TO,
		                    InternetAddress.parse(email)
		            );
		            message.setSubject("Reset your Password");
		            message.setText("Here's the code to reset your password: "
		                    + randomPIN);

		            Transport.send(message);

		            RequestDispatcher rd = request.getRequestDispatcher("Verify.jsp");
					rd.include(request, response);
		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }
				
					
				  
			    
			}
		}
	}
	

}
