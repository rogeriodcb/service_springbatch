package br.com.sicredi.sincronizacaoreceita.error;

import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.exception.ExceptionHandler;
/**
* <b>handleException</b>
* This class is the exception handle for step object
* @author - Rogerio de C.B.
*/
//TODO: improve handle Exception
public class handleException implements ExceptionHandler {

	@Override
	public void handleException(RepeatContext context, Throwable throwable) throws Throwable {
		System.err.println("Error: "+context+" >> "+throwable.getMessage());
		
	}

}
