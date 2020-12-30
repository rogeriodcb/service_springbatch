package br.com.sicredi.sincronizacaoreceita.processor;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

/**
* <b>SincronizacaoReceitaProcessorSyncWithServiceTests</b>
* <br>Test Step processing of SincronizacaoReceitaApplication.
* <br>To execute the test the file Input.csv
* shall be copied to the folder c:\temp.
* <br>This test shall be execute in Windows operating system
* 
* @author      Rogério de C. Brito <krcbrito@gmail.com>
* @date 12/28/2020
*/

public class SincronizacaoReceitaProcessorSyncWithServiceTests {

	/**
	* <b>Init</b><br><br>
	* Initialize test before class execution.
	*/
    @BeforeClass
    public static void Init() {
    	System.out.println("==================================================================");
    	System.out.println("=                   Step Processor Tests                         =");
    	System.out.println("=               Test SyncWithService method                      =");
    	System.out.println("==================================================================");
    }

    /**
	* <b>testSyncWithService method</b><br><br>
	* Call SyncWithService and test:
	* <li> if the method atualizarConta from ReceitaService returns true when all parameters are ok;
	* <li> if the method atualizarConta from ReceitaService returns false when one parameter is wrong.
	* @author      Rogério de C. Brito <krcbrito@gmail.com>
	* @date 12/12/2020
	*/
	@Test
	public void testSyncWithService() throws Exception{
		
		/***************** initial setup *****************/
		System.out.println("Testing SyncWithService method...");
		String[] t1 = new String[] {"0101", "123456", "100.50", "A"};
		String[] t2 = new String[] {"101", "123456", "100.50", "A"}; // agency wrong size
		String[] t3 = new String[] {"0101", "23456", "100.50", "A"}; // account wrong size
		String[] t4 = new String[] {"0101", "123456", "100.50", "C"}; // wrong status
		// the third parameter was not tested due RecietaService is not handle this type of error.
		
		/***************** Execute and verify*****************/
		assertEquals(new SincronizacaoReceitaProcessorSyncWithService().SyncWithService(t1),true);
		assertEquals(new SincronizacaoReceitaProcessorSyncWithService().SyncWithService(t2),false);
		assertEquals(new SincronizacaoReceitaProcessorSyncWithService().SyncWithService(t3),false);
		assertEquals(new SincronizacaoReceitaProcessorSyncWithService().SyncWithService(t4),false);
		
		System.out.println("\n<<done>>\n");
	}
	

}
