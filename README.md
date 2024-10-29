# Projeto de Estudo NoSQL com Spring Boot

Este projeto foi desenvolvido em Java usando Spring Boot e adota uma estrutura de banco de dados NoSQL para gerenciar informações de usuários, posts e comentários. A aplicação permite criar, listar e organizar dados de usuários e suas interações em uma rede social simples. **Este projeto é apenas para fins de estudo e prática de desenvolvimento com Spring Boot e MongoDB.**

## Estrutura do Projeto

### Entidades Principais

1. **User (Usuário)**
   - Campos: `id`, `name`, `email`
   - Relacionamentos: um usuário pode ter vários posts (relação 1:N).

2. **Post (Publicação)**
   - Campos: `id`, `date`, `title`, `body`
   - Relacionamentos: cada post tem um autor (1:N com `User`) e pode ter vários comentários (relação 1:N com `Comment`).

3. **Comment (Comentário)**
   - Campos: `id`, `text`, `date`
   - Relacionamentos: cada comentário possui um autor (`User`) e está associado a um post.
  
  ### Tecnologias Utilizadas:
- Java : Linguagem de programação principal.
- Spring Boot: Framework para criação de aplicações Java, facilitando a configuração e a implementação de APIs.
- Spring Data MongoDB: Módulo Spring Data para integração com MongoDB.
- MongoDB: Banco de dados NoSQL utilizado para armazenamento das informações de usuários, posts e comentários.

  ### Funcionalidades:
1. Gerenciamento de Usuários:
   - Cadastro de novos usuários.
   - Listagem de usuários com detalhes de seus posts e comentários.
2. Gerenciamento de Posts:
   - Criação de posts com título, data e conteúdo.
   - Relacionamento dos posts com um autor (usuário) e associação de comentários.
3. Comentários em Posts:
   - Permite adicionar comentários a posts existentes.
   - Cada comentário é associado a um autor (usuário) e vinculado ao post.
