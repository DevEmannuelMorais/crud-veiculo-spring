package br.com.detran.cruddetranspring.exceptionhandler;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {

	public BadRequestException(String message) {
		super(message);
	}

}
