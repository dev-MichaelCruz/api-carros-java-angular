# Use uma imagem Node.js como base
FROM node:latest AS builder

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie os arquivos de package.json e package-lock.json para o diretório de trabalho
COPY package*.json ./

# Instale as dependências do projeto
RUN npm install

# Copie o restante do código-fonte da aplicação para o diretório de trabalho
COPY . .

# Compile a aplicação Angular para produção
RUN npm run build

# A segunda fase da imagem
FROM nginx:alpine

# Copie os arquivos estáticos da aplicação Angular compilada para o diretório do servidor Nginx
COPY --from=builder /app/dist/* /usr/share/nginx/html/

# Exponha a porta 80 para o tráfego da web
EXPOSE 80
EXPOSE 443

# Comando para iniciar o servidor Nginx quando o contêiner for executado
CMD ["nginx", "-g", "daemon off;"]
