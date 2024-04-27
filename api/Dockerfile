# Use uma imagem Java como base
FROM openjdk:17-jdk AS builder

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR da aplicação Spring Boot para o diretório de trabalho
COPY target/api-0.0.1-SNAPSHOT.jar .

# A segunda fase da imagem
FROM openjdk:17-jdk

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR da primeira fase para o diretório de trabalho
COPY --from=builder /app/api-0.0.1-SNAPSHOT.jar .

# Exponha a porta 8080 para o tráfego HTTP
EXPOSE 8080

# Comando para iniciar a aplicação Spring Boot quando o contêiner for executado
CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]
