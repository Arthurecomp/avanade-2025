Usuário

O Usuário pode ter filmes assistidos, críticas, e favoritos.
O relacionamento com Credenciais (email e senha) segue a mesma lógica do diagrama anterior.
Filmes

Um Filme tem atributos como título, gênero, descrição, ano de lançamento e diretor.
Críticas

O Usuário pode fazer críticas a filmes, que contêm comentários e classificação (nota de 1 a 5).
Favoritos

O Usuário pode ter uma lista de filmes favoritos.

### Diagrama de classes

```mermaid
classDiagram
    class Usuario {
        - String name
        - Credentials credentials
        - Movie[] watchedMovies
        - Review[] reviews
        - Favorite[] favorites
    }

    class Credentials {
        - String email
        - String senhaHash
    }

    class Movie {
        - String title
        - String genre
        - String description
        - int releaseYear
        - String director
    }

    class Review {
        - String comment
        - int rating
        - Movie movie
    }

    class Favorite {
        - Movie movie
    }

    Usuario "1" *--> "1" Credentials
    Usuario "1" *--> "N" Movie
    Usuario "1" *--> "N" Review
    Usuario "1" *--> "N" Favorite
    Movie "1" *--> "N" Review



```
