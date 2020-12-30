package br.com.sicredi.sincronizacaoreceita.reader;


import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import br.com.sicredi.sincronizacaoreceita.domain.ClientData;

/**
* <b>SincronizacaoReceitaReaderConfig</b>
* This class is the spring batch ItemReader configuration, responsible to read the input CSV file
* @author - Rogerio de C.B.
*/
@Configuration
public class SincronizacaoReceitaReaderConfig {
	
	/**
	* <b>fileCSVReader</b>
	* This method reads the input CSV file to be processed by ItemProcess
	* @param arguments (Application Arguments) - get the args from the main method of the main class
	* @return data read from input CSV file (type FaltFileItemReader).
	*/
	@StepScope
	@Bean
	public FlatFileItemReader<ClientData> fileCSVReader(ApplicationArguments arguments) throws Exception{
		//get resource from arguments
		try {
		Resource in = new PathResource(arguments.getSourceArgs()[0].toString());
			try {
				return new FlatFileItemReaderBuilder <ClientData>()
					.name("fileCSVReader")
					.resource(in)
					.targetType(ClientData.class)
					.delimited()
					.delimiter(";")
					.names(new String[]{"agency","account","balance","status"})
					.build();
			}catch(Exception e) {
				System.out.println(">>> Error while reading CSV file.");
				return null;
			}

		}catch(Exception e) {
			System.out.println(">>> Error creating resource from file "+arguments.getSourceArgs()[0].toString());
			return null;
		}
		
		
	}

}




