package br.com.sicredi.sincronizacaoreceita;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
* <b>SincronizacaoReceitaApplicationTests</b>
* <br>Integration test of SincronizacaoReceitaApplication
* by using an existing file and right data inside it
* <br>To execute the test the file Input.csv
* shall be copied to the folder c:\temp.
* <br>This test shall be executed in Windows operating system
* 
* @author      Rogério de C. Brito <krcbrito@gmail.com>
* @date 12/28/2020
*/

@SpringBatchTest
@SpringBootTest(args ="C:\\temp\\Input.csv")
@RunWith(SpringRunner.class)
public class SincronizacaoReceitaApplicationTests {
		
	@Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;
    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;
      
    /**
	* <b>Init</b><br><br>
	* Initialize test before class execution.
	*/
    @BeforeClass
    public static void Init() {
    	System.out.println("==================================================================");
    	System.out.println("=                     Job Failure Tests                          =");
    	System.out.println("=                Existing file and right data                    =");
    	System.out.println("==================================================================");
    }
    
    /**
   	* <b>cleanUp</b><br><br>
   	* Clear job allocations.
   	*/
    @After
    public void cleanUp() {
        jobRepositoryTestUtils.removeJobExecutions();
    }
    
    /**
   	* <b>TestJob1</b>
   	* <br> This test case executes the job and expects that job executes normally.
   	* <br> This test use the Input.csv in the c:\temp and shall be run on Windows OS.
   	**/
    @Test
    public void TestJob1() throws Exception {
    	
    	/***************** initial setup *****************/
        System.out.println("Starting TestJob1...");
        String in = "C:\\temp\\Input.csv";
        String[] linesToCheck = {
        		"agencia;conta;saldo;status;resultado",
        		"0101;12225-6;100,00;A;Ok",
        		"0101;12226-8;3200,50;A;Ok",
        		"3202;40011-1;-35,12;I;Ok",
        		"3202;54001-2;0,00;P;Ok",
        		"3202;00321-2;34500,00;B;Ok"
        };
        
        /***************** Execution *****************/
        //testing a job
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        
        /***************** verification *****************/
        // checks the existence of the input file and check if the application was not remove it
        assertTrue(Files.exists(Paths.get(in)));
                
        // check if the Spring batch was completed successfully        
        assertEquals(BatchStatus.COMPLETED.toString(), jobExecution.getStatus().toString());
        
        // check if the output file was created
        assertTrue(Files.exists(Paths.get(in.replace(".csv","_output.csv"))));
        
        // check the file consistence 
        // Note: the "Resultado" column may vary. Depends of the ReceitaService response, due the ReceitaService may simulate problem
        // TODO: improve the algorithm do detect this
        try (BufferedReader br = new BufferedReader(new FileReader(in.replace(".csv","_output.csv")))){ // try-with-resources block
        	int i=0;
        	String line = br.readLine();
        	while(line !=null){
        		System.out.println("Comparing line "+i+": "+linesToCheck[i].toString());
        		assertEquals(line.toString(),linesToCheck[i].toString()); // check each line
        		line=br.readLine();
        		i++;
        	}
        }catch(IOException e){
        	System.out.println("Error: "+e.getMessage());
        }
        

        System.out.println("\n<<done>>\n");

    }
    
        
}