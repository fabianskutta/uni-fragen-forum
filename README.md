# Fragen-Forum

## Technologien

- Java / Spring Boot 4
- Thymeleaf (Templates)
- PostgreSQL (Datenbank)
- Liquibase (Datenbankmigrationen)
- Maven

## Voraussetzungen

- Java 21+
- Maven
- Docker (für die Datenbank)

## Starten

**1. Datenbank starten**

```bash
docker compose -f src/docker/docker-compose.yaml up -d
```

**2. Anwendung starten**

```bash
./mvnw spring-boot:run
```

Die Anwendung ist dann unter [http://localhost:8080](http://localhost:8080) erreichbar.
