package br.com.sicredi.sincronizacaoreceita;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
* <b>SincronizacaoReceitaApplication</b><br><br>
* Based in the original code SincronizacaoReceita.java from Gustavo and Sicredi.
* <p>This implementation was made in Spring Batch framework.
* <p>This class is the main starter class of the project
* <p>Modified by</p>
* @author      Rogério de C. Brito <krcbrito@gmail.com>
* @date 12/28/2020
**/

//TODO: log information with Log4j2 or another logger
@SpringBootApplication
public class SincronizacaoReceitaApplication {

	public static void main(String[] args) {
		
		System.out.println("Sincronizacao Receita");
		System.out.println("=====================");


		// checks the minimal arguments required by application (it does not check if the file exists)
		if (args.length <1) {
			System.out.println("To few arguments.\nUsage: java -jar SincronizacaoReceita <CSV input file name path>\n"
					+ "                     For example: java -jar SincronizacaoReceita.jar \"c:\\temp\\Input.csv\".");
			System.exit(0);
		}
		else if(!Files.exists(Paths.get(args[0].toString()))){
			System.out.println("The given file was not found. Exiting.\nTry one of these solutions:\n"
					+ "* verify if the file path and the name of the file are correct;\n"
					+ "* verify if the command given was java -jar SincronizacaoReceita.jar <file path>\n"
					+ "                     For example: java -jar SincronizacaoReceita.jar \"c:\\temp\\Input.csv\".");
			System.exit(0);
		}
		
		try {
			SpringApplication.run(SincronizacaoReceitaApplication.class, args);
		
		}catch(Exception e) {
			System.out.println("\n\n>>> Error starting job.\nMessage: "+ e.getMessage());
		}
	}

}
