package br.com.sicredi.sincronizacaoreceita.listener;

import org.springframework.batch.core.ItemProcessListener;

import br.com.sicredi.sincronizacaoreceita.domain.ClientData;
/**
* <b>StepItemProcessListener</b>
* This class is the ItemProcess listener. There are tree methods:
* <p><li>show information before ItemProcess execution;
* <li>show information after ItemProcess execution;
* <li>show error from ItemProcess, if occur.
* @author - Rogerio de C.B.
*/
public class StepItemProcessListener implements ItemProcessListener<ClientData, ClientData> {
 
    @Override
	public void beforeProcess(ClientData item) {
    	//TODO: informaton before		
	}

	@Override
	public void afterProcess(ClientData item, ClientData result) {
		//TODO: information after		
	}

	@Override
	public void onProcessError(ClientData item, Exception e) {
    	System.out.println(">>> Process error: "+item +"\nMessage: "+e.getMessage());		
		
	}
}
