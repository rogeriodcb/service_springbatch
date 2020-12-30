package br.com.sicredi.sincronizacaoreceita.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import br.com.sicredi.sincronizacaoreceita.domain.ClientData;
/**
* <b>StepItemWriteListener</b>
* This class is the ItemWriter listener. There are tree methods:
* <p><li>show information before ItemWriter execution;
* <li>show information after ItemWriter execution;
* <li>show error from ItemWriter, if occur.
* @author - Rogerio de C.B.
*/
public class StepItemWriteListener implements ItemWriteListener<ClientData> {

	@Override
	public void beforeWrite(List<? extends ClientData> items) {
    	//TODO: informaton before		
		
	}

	@Override
	public void afterWrite(List<? extends ClientData> items) {
		//TODO: information after		
		
	}

	@Override
	public void onWriteError(Exception exception, List<? extends ClientData> items) {
    	System.out.println(">>> Write error.\nItems: "+items.toString() +"\nMessage: "+exception.getMessage());
		
	}
}
