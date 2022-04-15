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


### Teste no Postman
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/6aeb9e678fc69deb5063?action=collection%2Fimport)

### Exemplo de uso
Exemplo de uso
``
curl --request GET \
--url https://teset-pg.herokuapp.com/api/v1/mentores/1
``

### EndPoints
Listar Mentor por ID

```
curl --request GET \
  --url https://teset-pg.herokuapp.com/api/v1/mentores/1
```
Listar Mentor por Categoria
```
curl --request GET \
  --url 'https://teset-pg.herokuapp.com/api/v1/mentores?especialidade=CLOUD'
```
Listar Todos os Mentores
```
curl --request GET \
  --url https://teset-pg.herokuapp.com/api/v1/mentores
```
Listar Aluno por email
```
curl --request GET \
  --url https://teset-pg.herokuapp.com/api/v1/alunos/{email}
```
### 📚 Documentação
<a href="https://teset-pg.herokuapp.com/swagger-ui/index.html">Documentação</a> 🚧🚧
<br/>


### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgresSQL](https://www.postgresql.org/)
- [OpenApi](https://swagger.io/specification/)
- [Kotlin](https://kotlinlang.org/)


### Teste Container
<a href="https://github.com/SQUAD-34-FCamara/BackEndApi/tree/feature/container"> Docker Teste</a>


