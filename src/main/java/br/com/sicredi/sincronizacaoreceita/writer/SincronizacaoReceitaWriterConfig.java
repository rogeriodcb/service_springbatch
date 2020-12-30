package br.com.sicredi.sincronizacaoreceita.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import br.com.sicredi.sincronizacaoreceita.domain.ClientData;
/**
* <b>SincronizacaoReceitaWriterConfig</b>
* This class is the spring batch ItemWriter configuration, responsible to save the data processed into CSV file with header
* @author - Rogerio de C.B.
*/
@ Configuration
public class SincronizacaoReceitaWriterConfig {
		/**
		* <b>fileCSVWriter</b>
		* This method writes the data processed into CSV file with header
		* @param arguments (Application Arguments) - get the args from the main method of the main class (this file name will be modified to sufix _outptu.csv"
		* @return ClientData fileDataWriter - ClientData output processed data.
		*/
		@StepScope
		@Bean
		public FlatFileItemWriter<ClientData> fileCSVWriter(ApplicationArguments arguments) throws Exception {
			Resource out = new FileSystemResource(arguments.getSourceArgs()[0].replace(".csv","_output.csv"));
			String[] names = new String[] {"Agency", "Account","Balance","Status","Result"};
			return new FlatFileItemWriterBuilder<ClientData>()
					.name("fileCSVWriter")
					.resource(out)
					.shouldDeleteIfExists(true)
					.delimited()
					.delimiter(";")
					.names(names)	
					.build();
			}

		}
