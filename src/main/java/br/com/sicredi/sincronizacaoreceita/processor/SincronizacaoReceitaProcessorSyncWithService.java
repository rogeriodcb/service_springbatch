package br.com.sicredi.sincronizacaoreceita.processor;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.context.annotation.Bean;

import br.com.sicredi.sincronizacaoreceita.service.ReceitaService;
/**
* <b>SincronizacaoReceitaProcessorSyncWithService</b>
* This class is responsible to call ReceitaService (Simulator) and return if the data is ok or not
* @author - Rogerio de C.B.
*/
public class SincronizacaoReceitaProcessorSyncWithService {
	/**
	* Synchronize CSV data with Service by calling "atualizarConta" method from "ReceitaService" 
	* 
	*
	* @param data (Array of String) - in this implementation the data contains:
	* <ul>
	* <li> <b>data[0]</b> (String) - agency name;
	* <li> <b>data[1]</b> (String) - account (this stirng removes the "-" character to match the ReceitaService format);
	* <li> <b>data[2]</b> (String) - balance (cast to double to match the ReceitaService format);
	* <li> <b>data[3]</b> (String) - status can be 'A', 'I', 'B' and 'P'.
	* </ul>
	* @return execution is successfully (true) otherwise (false).
	*/
	@Bean
	@StepScope
	public  boolean SyncWithService(String[] data) throws Exception {
		
		
        try {
        	ReceitaService receitaService = new ReceitaService();
        	return receitaService.atualizarConta(data[0], data[1].replace("-",""),Double.parseDouble(data[2].replace(",", ".")),data[3]);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			System.out.println(">>> An error ocurr while calling \"ReceitaService\".");
			return false;
		}
		
	}
}
