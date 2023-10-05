package br.com.jwt.bearer.app.handle;


public class ServiceException extends Exception {

	private static final long serialVersionUID = 6376559008232800045L;

	public ServiceException(String message) {
		super(message);
	}

	
}
