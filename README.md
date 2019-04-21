## To clean:
ant -buildfile genericCheckpointing/src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile genericCheckpointing/src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 

ant -buildfile genericCheckpointing/src/build.xml run -Darg0=serdeser/deser -Darg1=N -Darg2=checkpoint.txt

-----------------------------------------------------------------------

## To generate javadocs 

ant -buildfile genericCheckpointing/src/build.xml doc 

-----------------------------------------------------------------------


Implementation of Dynamic Proxy,Strategy Pattern,Java Reflection:

The program operates in two modes : deser/serdeser mode. 
1. The serdeser mode will serialize the data in a XML format to the text file and deserialize the same data and compares both vectors to display the number of mismatched objects.
2. The deser mode will simply deserialize the XML file and display the objects created.

The strategy pattern is implemented with the processInput(Object) method where in a null object is passed to it in the Deserialize mode to create the object and for Serialization an existing object is sent to it for writing to a file in the specified wire format.

The deserialization works with the help of Java Reflection as various "set" methods are invoked with the help of the field names gathered from the XML file. The proxy is created in the driver with the help of which writeObj/readObj methods are called.
