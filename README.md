# Gestion-Forum — Community Forum Service

Manages the community **forum** for Money Minder MS: posts and their comments.

## Tech stack
Java · Spring Boot · Spring Data JPA · MySQL · Spring Cloud (Eureka, Config) · RabbitMQ (AMQP)

## API — port `8083`
| Base path | Resource |
| --- | --- |
| `/api/posts` | Forum posts (CRUD) |
| `/api/commentaires` | Comments, incl. `/post/{postId}` |

## Data & messaging
MySQL `moneyminder_forum` (port 3307) · RabbitMQ events.

## Run
```bash
mvn spring-boot:run
```

## Configuration
Settings live in `src/main/resources/application.properties`. Override the database and RabbitMQ credentials with environment variables outside local development.

## Part of Money Minder MS

One service of the **Money Minder MS** Spring Cloud platform. Full architecture and
the other services: [API-Gateway README](https://github.com/Money-Minder-MS/API-Gateway).
Start EurekaServer (8761) and Config-Server (8099) first.

