package spring;

@SuppressWarnings("serial")
public class DuplicateMemberException extends RuntimeException{

	public DuplicateMemberException(String msg) {
		super(msg);
	}
}
