FROM openjdk:8-jre
MAINTAINER jugomez3@gmail.com
ADD target/marketplace-0.0.1-SNAPSHOT.jar marketplace-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/marketplace-0.0.1-SNAPSHOT.jar"]