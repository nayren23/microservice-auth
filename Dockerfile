FROM openjdk:17

LABEL authors="Nayren"

WORKDIR /app

EXPOSE 8082

COPY ./spring-auth/target/spring-auth-0.0.1-SNAPSHOT.jar /app/spring-auth.jar

ENTRYPOINT ["java","-jar","spring-auth.jar"]
