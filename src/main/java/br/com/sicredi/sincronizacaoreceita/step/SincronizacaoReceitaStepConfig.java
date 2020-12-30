package br.com.sicredi.sincronizacaoreceita.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sicredi.sincronizacaoreceita.domain.ClientData;
import br.com.sicredi.sincronizacaoreceita.error.handleException;
import br.com.sicredi.sincronizacaoreceita.listener.StepItemProcessListener;
import br.com.sicredi.sincronizacaoreceita.listener.StepItemReadListener;
import br.com.sicredi.sincronizacaoreceita.listener.StepItemWriteListener;
import br.com.sicredi.sincronizacaoreceita.listener.StepResultListener;
/**
* <b>SincronizacaoReceitaStepConfig</b>
* This class is the spring batch step configuration
* @author - Rogerio de C.B.
*/
@Configuration
public class SincronizacaoReceitaStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	/**
	* <b>sincronizacaoReceitaStep</b>
	* This method configures the spring batch step and use the listeners: step, itemread, itemprocess and itemwrite (for this 3 last ones there are error handle inside the methods)
	* Also, points to the handlerException class and provides exception handle for step
	* @param arguments (Application Arguments) - get the args from the main method of the main class
	* @param fileCSVReader (ItemReader) - points to the spring batch object ItemRead method 
	* @param dataProcess (ItemProcessor) - points to the spring batch object ItemProcessor method 
	* @param fileCSVWriter (ItemWriter) - points to the spring batch object ItemWriter method 
	* @return Spring batch object Step.
	* 
	* TODO: improve exception handle in spring batch. Now, I use the exceptionHandler to capture reading error for example.
	*/
	@Bean
	public Step sincronizacaoReceitaStep
		(ApplicationArguments arguments,
		ItemReader<ClientData> fileCSVReader,
		ItemProcessor<ClientData, ClientData> dataProcess,
		ItemWriter<ClientData> fileCSVWriter) throws Exception {
		
		System.out.println("Configuring job step...");
		// Note: the first line of the file (header) was not skipped and will be processed in the Processor step
		// With this the file can be with or without header
		try {
			
			return stepBuilderFactory
					.get("sincronizacaoReceitaStep")
					.<ClientData, ClientData>chunk(1)
					.reader(fileCSVReader)
					.processor(dataProcess)
					.writer(fileCSVWriter)
					.faultTolerant()
					.listener(new StepResultListener()) 		// main step listener
					.listener(new StepItemReadListener()) 		// item read listener
					.listener(new StepItemProcessListener()) 	// item process listener 
					.listener(new StepItemWriteListener())		// item write listener
					.exceptionHandler(new handleException())	// exception handler
					.build();
			}catch(Exception e) {
				System.out.println(">>> Error while executing step.");
				return null;
			}
		}
	    
}	
