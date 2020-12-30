# service_springbatch

This is a Java Spring Batch framework application that contacts a simulated server to validate each account from the CSV file.
<p>There are two main directories:
<li><b>JAR:</b> contains the JAR file to be executed from command line. To use the JAR file use: <b>java -jar SincronizacaoReceita.jar input.csv.</b><p>Also, there are 3 input files to be used (see explanation in Input files description section).
<li><b>src:</b> contains the JAVA Spring Batch application, the application tests and resource input file (see explanation in Input files description section)
<li><b>tests:</b> the JUnit 4 suit to test JAVA development made. To use this suit correctly copy into C:\temp folder the files from JAR\inputExcel.csv and JAR\inputExcel2.csv.

## Usage
At the JAR directory use the jar file to execute: 
```bash
java -jar SincronizacaoReceita.jar <input file path>
```
## Example
In case that input file is in the same folder:
```bash
cd JAR
java -jar SincronizacaoReceita.jar Input.csv
java -jar SincronizacaoReceita.jar InputWrong.csv
```
In case that input file is in another folder:
```bash
cd JAR
java -jar SincronizacaoReceita.jar "c:\temp\Input.csv"
```
## Test execution
There is a TestAll.java, made with JUnit4, in the src\test\java\br\com\sicredi\sincronizacaoreceita\All. This application tests all test cases made. You can run in your own preferred IDE. You must to copy the input files, locate in the src\test\resources folder to c:\temp folder.
Note: these tests were made to run on Windows OS.

## Input Files Description
For example purpose there are 3 files in the "\src\main\resources" folder:
```bash
<li><b>Input.csv</b>          - this is the good input file;
<li><b>InputWrong.csv</b>     - this is the non process file. In this file a data row is corrupted and the application will ignore this row;
<li><b>InputDataWrong.csv</b> - this is the bad input file but it will be processed by the application. Two rows have wrong status and the application will be add FAIL in the result column at output file.
 ``` 
