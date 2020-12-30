package br.com.sicredi.sincronizacaoreceita.listener;

import javax.batch.runtime.BatchStatus;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
/**
* <b>JobListener</b>
* This class is the Job listener. There are two methods:
* <p><li>show information before job execution;
* <li>show information after job execution.
* @author - Rogerio de C.B.
*/
public class JobListener extends JobExecutionListenerSupport{
	@Override
	public void beforeJob(JobExecution jobExecution){
		System.out.println("Starting Job execution...");
	}

	@Override
	public void afterJob(JobExecution jobExecution){
		System.out.print("Job execution was ");
		if(jobExecution.getStatus().toString().equals(BatchStatus.COMPLETED.toString())) {
			System.out.println("Successfully!");
		}else {
			System.out.println("Failed!");
		}
	}
}


