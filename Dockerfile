FROM maven:3.9-eclipse-temurin-17

WORKDIR /app
VOLUME /tmp
COPY pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn package -DskipTests=true
RUN cp /app/target/va-call-api-demo-0.0.1-SNAPSHOT.jar /app/va-call-api-demo.jar
COPY h2-2.1.210.jar /app
RUN java -cp /app/h2*.jar org.h2.tools.RunScript -url jdbc:h2:/app/vacall -script /app/src/main/resources/create.sql -user sa -password password
RUN java -cp /app/h2*.jar org.h2.tools.RunScript -url jdbc:h2:/app/vacall -script /app/src/main/resources/data.sql -user sa -password password
EXPOSE 8088
ENTRYPOINT ["java","-jar","/app/va-call-api-demo.jar"]