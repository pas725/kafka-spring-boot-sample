Kafka is a distributed streaming platform.

What is Kafka good for?

Building real-time streaming data pipelines that reliably get data between systems or applications
Building real-time streaming applications that transform or react to the streams of data
More information on how Kafka works, you can visit its official website: http://kafka.apache.org/intro.html

Lets see a step-by-step guide of installing and running Apache Zookeeper and Apache Kafka on a Windows OS.

Install 7-zip

Download and install 7-zip from here.
Install Java SE Server JRE

Download Server JRE according to your OS and  CPU architecture from here.
Start JRE installation and installation directory can be selected as per your need or you can keep the default one.
Create an environment variable JAVA_HOME in “System Variables” section and set your JRE path in value.
Edit the environment variable “Path” in “System Variables” section and type “;%JAVA_HOME%\bin” at the end of the text already written there.
To confirm the Java installation, open the command prompt and type “java –version”. You should see the version of the java you just installed.
Zookeeper Installation

Download and extract Zookeeper using 7-zip from here. You can extract Zookeeper anywhere. For me, its C:\zookeeper-3.4.9
Go to your Zookeeper config directory. For me its C:\zookeeper-3.4.9\conf
Rename file “zoo_sample.cfg” to “zoo.cfg”
Open zoo.cfg in any text editor and edit dataDir=/tmp/zookeeper to C:\zookeeper-3.4.9\data(set as per your)
Create an environment variable ZOOKEEPER_HOME in “System Variables” section and set your Zookeeper path in value.
Edit the environment variable “Path” in “System Variables” section and type “;%ZOOKEEPER_HOME%\bin” at the end of the text already written there.
You can change the default Zookeeper port in zoo.cfg file (Default port 2181).
Open command prompt and type “zkserver” to start the Zookeeper on port 2181!
Setting Up Kafka

Download Apache Kafka binary and extract it using 7-zip from here. You can extract Zookeeper anywhere. For me, its C:\kafka_2.10-0.10.0.1.
Go to your Kafka config directory. For me its C:\kafka_2.10-0.10.0.1\config
Edit file “server.properties” and edit line “log.dirs=/tmp/kafka-logs” to “log.dir= C:\kafka_2.10-0.10.0.1\kafka-logs”.
Your Kafka will run on default port 9092 & connect to zookeeper’s default port which is 2181.
If your Zookeeper is running on some other machine, then you can edit “zookeeper.connect:2181″ to your custom IP and port. Kafka port & broker id are configurable in this file.
Open config\zookeeper.properties, change dataDir=/tmp/zookeeper to dataDir=c:/kafka_2.10-0.10.0.1/zookeeper-data
Start Zookeeper

Kafka uses Zookeeper so you need to first start a Zookeeper server. Open command prompt and move to directory C:/kafka_2.10-0.10.0.1/z(For my case)
Enter and hit: .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
This will start the Zookeeper.
Start Kafka

Open another command prompt and and move to directory C:/kafka_2.10-0.10.0.1/z(For my case)
Enter and hit: .\bin\windows\kafka-server-start.bat .\config\server.properties
This will start the Kafka.
Create a topic

Let’s create a topic named “custom_topic” with a single partition and only one replica
Enter and hit: .\bin\windows\kafka-topics.bat –create –zookeeper localhost:2181 –replication-factor 1 –partitions 1 –topic custom_topic
List Topics

Enter and hit: .\bin\windows\kafka-topics.bat –list –zookeeper localhost:2181
Send Messages

Kafka comes with a command line client that will take input from standard input and send it out as messages to the Kafka. By default each line will be sent as a separate message.
Open a new command prompt and move to directory C:/kafka_2.10-0.10.0.1/z(For my case)
Enter and hit: .\bin\windows\kafka-console-producer.bat –broker-list localhost:9092 –topic custom_topic
Write some message
Start a consumer

Open a new command prompt and move to directory C:/kafka_2.10-0.10.0.1/z(For my case)
Enter and hit: .\bin\windows\kafka-console-consumer.bat –zookeeper localhost:2181 –topic custom_topic –from-beginning