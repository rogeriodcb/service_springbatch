package br.com.sicredi.sincronizacaoreceita.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sicredi.sincronizacaoreceita.listener.JobListener;
/**
* <b>SincronizaReceitaJobConfig</b>
* This class is the spring batch job configuration
* @author - Rogerio de C.B.
*/
@EnableBatchProcessing
@Configuration
public class SincronizaReceitaJobConfig {
	
		@Autowired
		public JobBuilderFactory jobBuilderFactory;
		/**
		* <b>sincronizacaoReceitaJob</b>
		* This method configures the spring batch job and use the listener JobListener
		* 
		* @param arguments (Application Arguments) - get the args from the main method of the main class
		* @param sincronizacaoReceitaStep (Step) - points to the spring batch object step method 
		* @return Spring batch object Job.
		*/
		@Bean
		public Job sincronizacaoReceitaJob(ApplicationArguments arguments, Step sincronizacaoReceitaStep) throws Exception{
						
			System.out.println("Processing the file: "+arguments.getSourceArgs()[0].toString());
			try {
				return jobBuilderFactory
						.get("sincronizacaoReceitaJob")
						.start(sincronizacaoReceitaStep)
						.incrementer(new RunIdIncrementer())
						.listener(new JobListener())
						.build();	
			}catch(Exception e) {
				System.out.println(">>> An error ocurred in the Job execution.");
				return null;
			}
			
		}
		

		
}
