# Use a imagem Nginx como base
FROM nginx:latest

# Remove o arquivo de configuração padrão do Nginx
RUN rm /etc/nginx/conf.d/default.conf

# Copie o arquivo de configuração personalizado para o diretório de configuração do Nginx
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Exponha a porta 80 para o tráfego HTTP
EXPOSE 80
EXPOSE 443