FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY UserModule/pom.xml /tmp/
COPY UserModule /tmp/UserModule/
WORKDIR /tmp/
RUN mvn clean install

FROM openjdk:8-jdk-alpine
COPY --from=MAVEN_TOOL_CHAIN /tmp/UserModule/target/UserModule-1.0-SNAPSHOT.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


#   docker rmi -f
#
#   docker build -t aws-project-app:0.1 .
#   docker images
#   docker run