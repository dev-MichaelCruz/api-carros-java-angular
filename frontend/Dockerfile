FROM node:17.6-alpine AS builder

# Defina o diretório de trabalho dentro do container
WORKDIR /usr/src/app

# Copie o arquivo package.json e package-lock.json
COPY package*.json ./

# Instale as dependências
RUN npm install

# Copie o restante dos arquivos do projeto
COPY . .

# Execute o build da aplicação Angular
RUN ng build --prod

# Use a imagem base do Nginx
FROM nginx:alpine

# Copie os arquivos de build da aplicação Angular para o diretório de publicação do Nginx
COPY --from=builder /usr/src/app/dist/meu-projeto-angular /usr/share/nginx/html

# Exponha a porta 80
EXPOSE 80

# Inicie o servidor Nginx
CMD ["nginx", "-g", "daemon off;"]
