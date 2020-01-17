# Object creation and cloning
This project gives a simple overview of the following stuff :
* Different ways of object creation in java (mainly using new operator, cloning and reflection) 
* Deep copy using 2 types of serialization

Please also refer to my blog here [Soumik's blog on Object creation, cloning and serialization](https://msoumik78.github.io/java/2019/05/18/object-creation-and-serialization.html)


### Dependencies

* Java 8 should be installed and available in the system. JAVA_HOME environment variable should be set and pointing to the location of Java 8.
* Maven should be installed in the system and set in PATH.

### Compiling

 `mvn clean compile `

### Running program

The below command runs the program to create java objects by different methods:          
`mvn exec:java -Dexec.mainClass="objectCreation.ObjectCreationTester" `

The below command runs the program to demonstrate deep copy using in memory serialization:               
`mvn exec:java -Dexec.mainClass="deepCopy.DeepCopyUsingInMemorySerialization" `

The below command runs the program to demonstrate deep copy using Apache library  :                
`mvn exec:java -Dexec.mainClass="deepCopy.DeepCopyUsingSerializationUtils" `
