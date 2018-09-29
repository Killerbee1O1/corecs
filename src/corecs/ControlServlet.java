package corecs;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("starting gthe doget");
		
		//assingning the values to our request and response so that we can use response request outside the do get function
		this.request=request;
		this.response= response;
		
		//Creating a variable that stores the request of which page to display
		String param = request.getParameter("param");
		//initially would be null so converting to string
		if(param==null)
		{
			param="null";
		}
		System.out.println("value of param is: "+param);
		switch(param)
		{
			case "null"       : loginPage();
						  	    break;
						  
			case "signIn"     : checkUser();
							    break;
			
			case "signUp" 	  : signUpPage();
								break;
	
			case "addMe"      : signUp();
								break;
		}
	
	
	}//ending of doget

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//creating loginPage()
	public void loginPage()throws IOException,ServletException
	{
		System.out.println("Entering loginPage() starting login page");
		moveToPage("loginPage.jsp");
		
	}
	
	public void checkUser()
	{
		String userID = request.getParameter("username");
		String userPWD = request.getParameter("password");
		try {
				System.out.println("trying to make connection");
				String query ="SELECT count(*) acount from user where usr_login_id='"+userID+"'and usr_login_pwd='"+userPWD+"';";
				ResultSet rs = executeQuery(query);
				rs.next();
				if(rs.getInt("acount")==1)
				{
					System.out.println("USER EXISTS");	
					System.out.println("moving to home page of the user as known!!!!");
					moveToPage("homepage.jsp");
					
				}
				else
				{
					String errorMsg="UserName or Password Invalid!";
					showError(errorMsg,"loginPage.jsp");
				}
				
				
			}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(ServletException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void signUpPage()
	{
		try
		{
				System.out.println("moving to signup page");
				moveToPage("SignUp.jsp");
		}
		catch(ServletException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void signUp() throws ServletException, IOException
	{
		String userId = request.getParameter("signUpUsername");
		String pwd = request.getParameter("signUpPassword");
		String rePwd = request.getParameter("signUpRe-password");
		boolean check = checkInput(userId , pwd , rePwd);
		if(check)
		{
			java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
			String query = "insert into user (usr_type,usr_login_id,usr_login_pwd,usr_creation_time) values(703,'"+userId+"','"+pwd+"','"+new java.sql.Timestamp(date.getTime())+"');";
			try {
				executeQuery(query);
			} catch (SQLException e) {
				System.out.println("query not executed");
				e.printStackTrace();
			}
			moveToPage("corecs-home.jsp");
		}
		
	}
	
	public boolean checkInput(String userId , String pwd , String rePwd) throws ServletException, IOException
	{
		if((userId.length()<5)&&(pwd.equals(rePwd)))
		{
			String errorMsg="Too Short User Name Should be at least 5 char!";
			showError(errorMsg,"SignUp.jsp");
			return false;
		}
		else if((userId.length()>5)&&!(pwd.equals(rePwd)))
		{
			String errorMsg="Password and re password dosent match";
			showError(errorMsg,"SignUp.jsp");
			return false;
		}
		else if(!(userId.length()>5)&&!(pwd.equals(rePwd)))
		{
			String errorMsg="Wrong input min character 5 and password should match";
			showError(errorMsg,"SignUp.jsp");
			return false;
		}
		if(userId.toLowerCase().equals("admin"))
		{
			String errorMsg="Username cannot be admin!!!!";
			showError(errorMsg,"SignUp.jsp");
			return false;
		}
		return true;
	}
	
	public void showError(String errorMsg , String url) throws ServletException, IOException
	{
		ErrorMessage error = new ErrorMessage();
		error.setMessage(errorMsg);
		String e = error.getMessage();
		System.out.println("message from class  :" + e);
		request.setAttribute("error",error);
		moveToPage(url);
		
	}
	
	public void moveToPage(String url) throws ServletException, IOException
	{
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
	
	public ResultSet executeQuery(String query) throws SQLException
	{
		Connection connection = ConnectDB.getConnection();
		System.out.println("Connection made");
		Statement stat = connection.createStatement();
		ResultSet rs = stat.executeQuery(query);
		return rs;
	}
	

	HttpServletRequest request;
	HttpServletResponse response;
}
