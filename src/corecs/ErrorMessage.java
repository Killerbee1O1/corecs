package corecs;

public class ErrorMessage {
	
	ErrorMessage()
	{
		System.out.println("Error message class invoked!!!!");
	}
	public void setMessage(String msg)
	{
		message=msg;
	}
	public String getMessage()
	{
		return message;
	}

	private String message="";
}
