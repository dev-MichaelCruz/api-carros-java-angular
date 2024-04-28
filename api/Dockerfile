FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo JAR gerado pelo Maven para o container
COPY target/api-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta em que a aplicação Spring Boot está executando
EXPOSE 8080

# Comando para iniciar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]