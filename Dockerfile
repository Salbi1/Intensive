FROM maven:3.8.6 as build
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY  --from=build /app/target/demo-0.0.1-SNAPSHOT.jar ./application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./application.jar"]

docker build -t my-java-app .
docker run -p 8080:8080 my-java-app