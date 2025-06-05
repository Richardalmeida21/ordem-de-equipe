FROM maven:3.9.5-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Porta que a aplicação Spring Boot utilizará
EXPOSE 8080

# Variável de ambiente para definir o perfil do Spring
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]