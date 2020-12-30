package br.com.sicredi.sincronizacaoreceita.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sicredi.sincronizacaoreceita.domain.ClientData;
/**
* <b>SincronizacaoReceitaProcessorConfig</b>
* This class is the spring batch ItemProcessor configuration, responsible to call SyncWithService method if the data is not the header
* @author - Rogerio de C.B.
*/
@Configuration
public class SincronizacaoReceitaProcessorConfig {
	/**
	* <b>dataProcess</b>
	* This method reads the input data as ClientData and outputs processed data as ClientData
	* @param ClientData - ClientData input data;
	* @return ClientData - ClientData output processed data.
	*/
	@Bean
	public ItemProcessor<ClientData, ClientData> dataProcess() throws Exception{
		try {
			return new ItemProcessor<ClientData,ClientData>() {
				
				@Override
				public ClientData process(ClientData item) {
					// avoiding the header processing if the header was loaded from csv in Reader step
					if (item.getBalance().equals("saldo")) {
						item.setResult("resultado");
						System.out.println("Processed data "+item.toString());
						return item;
					}
					
					try {
					// if it is not header process
					SincronizacaoReceitaProcessorSyncWithService s = new SincronizacaoReceitaProcessorSyncWithService();
					item.setResult(s.SyncWithService(
							new String[] {
									item.getAgency(),
									item.getAccount(),
									item.getBalance(),
									item.getStatus()
									})==true ? "Ok":"FAIL");
					System.out.println("Processed data "+item.toString());
					return item;
					}catch(Exception e) {
						System.out.println(">>> Error calling SyncWithServices.");
						return null;
					}
				}
			};
		}catch(Exception e) {
			System.out.println(">>> Error while writing CSV file.");
			return null;
		}
	}
		
	

}



