package br.com.client.sem.autenticacao.app.handle;

public class ServiceNoContentExcetion extends Exception {

	private static final long serialVersionUID = 6376559008232800045L;

	public ServiceNoContentExcetion() {
		super("");
	}
	
	public ServiceNoContentExcetion(String msg) {
		super(msg);
	}
}
