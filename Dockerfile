FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml pom.xml
COPY UserModule/pom.xml UserModule/pom.xml
COPY UserModule UserModule
RUN mvn clean install

FROM openjdk:8-jdk-alpine
COPY --from=MAVEN_TOOL_CHAIN UserModule/target/UserModule-1.1.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]