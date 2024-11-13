package exceptions;

public class InvalidGauloisException extends Exception{
	public InvalidGauloisException() {
		super();
	}

	public InvalidGauloisException(String s) {
		super(s);
	}
	
	public InvalidGauloisException(String s,Throwable cause) {
		super(cause);
	}
	
	public InvalidGauloisException(Throwable cause) {
		super(cause);
	}
}
