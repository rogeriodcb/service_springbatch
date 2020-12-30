package br.com.sicredi.sincronizacaoreceita.listener;

import org.springframework.batch.core.ItemReadListener;

import br.com.sicredi.sincronizacaoreceita.domain.ClientData;
/**
* <b>StepItemReadListener</b>
* This class is the ItemReader listener. There are tree methods:
* <p><li>show information before ItemReader execution;
* <li>show information after ItemReader execution;
* <li>show error from ItemReader, if occur.
* @author - Rogerio de C.B.
*/
public class StepItemReadListener implements ItemReadListener<ClientData> {
 
    @Override
    public void beforeRead() {
    	//TODO: informaton before		
    }
    
    @Override
    public void afterRead(ClientData clientData) {
		//TODO: information after		
    }
 
    @Override
    public void onReadError(Exception ex) {
        System.out.println(">>> Reader error.\nMessage:  "+ex.getMessage());
        
    }
}
