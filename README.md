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
