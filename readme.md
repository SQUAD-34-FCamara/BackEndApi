## SQUAD 34 - Backend API

### Sobre o projeto
<p>
   Esta API foi construída durante o Hackathon do programa de formação da Fcamara, ela fornece uma grande variedade
de serviços tanto para a criação de novos dados como para a consulta de dados, auxiliando o desenvolvimento da aplicação web.
</p>

   <br>

<h4 align="center"> 
	🚧 API 🚀 To the moon. 🚀
</h4>

### Features

<p align="center" id="license">  

- [x] Cadastro Mentor
- [x] Listar Mentores
- [x] Listar Mentor por ID
- [x] Listar Mentor por Categoria
- [x] Cadastro Usuário
- [x] Listar Aluno por email
- [ ] xxxxxxxx

<br id="techs">


### Getting started  
Etapas para testar o projeto.

### Email

Este projeto foi configurado para smtp da Google, então é necessário que o usuário tenha um email válido para enviar as mensagens.

```sh
spring.mail.username=${email}
spring.mail.password=${email-password}
```


### Docker

```sh
mvn clean package
```
build the image(from dockerfile):
```sh
docker build --tag=tag-name .
```
Run the container
```sh
docker-compose up- d 
```
Check if is alive:
```sh
docker-compose ps
```
check more in <a href="https://www.baeldung.com/dockerizing-spring-boot-application">
Docker-Spring-Guide
</a>

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgresSQL](https://www.postgresql.org/)
- [OpenApi](https://swagger.io/specification/)
- [Kotlin](https://kotlinlang.org/)

### 📚 Documentação
<a href="https://teset-pg.herokuapp.com/swagger-ui/index.html">Documentação</a> 🚧🚧
<br/>
<br/>


