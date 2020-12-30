package br.com.sicredi.sincronizacaoreceita.All;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.sicredi.sincronizacaoreceita.SincronizacaoReceitaApplicationFailureTest;
import br.com.sicredi.sincronizacaoreceita.SincronizacaoReceitaApplicationFailureTest2;
import br.com.sicredi.sincronizacaoreceita.SincronizacaoReceitaApplicationTests;
import br.com.sicredi.sincronizacaoreceita.processor.SincronizacaoReceitaProcessorSyncWithServiceTests;

/**
* <b>TestAll</b><br><br>
* This test suit will be test all test cases made.
* @author      Rogério de C. Brito <krcbrito@gmail.com>
* @date 12/13/2020
* 
*/

// TODO: make tests to detect system.exit (with JUNIT 5) for wrong file name and no comomand lines arguments
@RunWith(Suite.class)
@Suite.SuiteClasses({
	SincronizacaoReceitaApplicationTests.class,
	SincronizacaoReceitaApplicationFailureTest.class,
	SincronizacaoReceitaApplicationFailureTest2.class,
	SincronizacaoReceitaProcessorSyncWithServiceTests.class
	})
public class TestAll {
  //nothing
}