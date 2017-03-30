# Log cloud with Netty disruptor and Kafka

# Build and Run
To build
  - ./gradlew clean build

To generate fatJar
  - ./gradlew fatJar
  
To run the coordinator
  - ./gradlew run
  - java -cp build/libs/cloud-logger-1.0.0.jar com.logicmonitor.research.logserver.server.Main
  
To run the client
  - java -cp build/libs/cloud-logger-1.0.0.jar com.logicmonitor.research.logserver.client.Main $clientId

# Tags
distributed, concurrency, fault tolerance, jdk executor, netty, disruptor, Kafka LogManager, google protocol buffer
