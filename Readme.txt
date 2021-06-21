This is a SpringBoot based application.

1) We can run this through either command prompt by using the command - mvnw spring-boot:run through command line

If there is some trouble in running this. Import the project in Eclipse/IntelliJ Idea Project. Right click AbnSpringbootApplication.java
and then run as Java Application.

2) The embbeded web server starts immediately.
3) On Web Browser hit the url -  http://localhost:8080/file/load/input.txt
	-> The Input.txt is already on the root directory
	-> It will load the data and you can see those in the console and the log file
4) output.csv generated on the root directory

5) In case of any error application in debug mode and check where the error is comming
	-> Dev tool is already there for faster debugging and development
6) Log file is generated at root directory with the name Abn-logger.log
7) To run the unit test - mvnw clean compile test
	-> In case of some issue use eclise to run the test cases from the class -> AbnSpringbootTests.java