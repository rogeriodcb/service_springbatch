package br.com.sicredi.sincronizacaoreceita.listener;

import javax.batch.runtime.BatchStatus;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
/**
* <b>StepResultListener</b>
* This class is the Step listener. There are two methods:
* <p><li>show information before step execution;
* <li>show information after step execution.
* @author - Rogerio de C.B.
*/
public class StepResultListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
    	//TODO: informaton before		
	}

	@Override
    public ExitStatus afterStep(StepExecution stepExecution) {
		// we must use the .tostring() to garantees the logic comparison
        if(stepExecution.getStatus().toString().equals(BatchStatus.COMPLETED.toString())) {
			System.out.println(">>> Step execution was successfully!");
			return ExitStatus.COMPLETED;
		}else {
			System.out.println(">>> Step execution was failed!");
	        return ExitStatus.FAILED;

		}
	}
}

