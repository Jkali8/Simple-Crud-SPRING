# Simple-Crud-SPRING
REALLY Simple CRUD api for a Game database made with Java Spring boot using the postgreSQL database, built with maven and deployed using docker

## To launch:
```bash
git clone https://github.com/Jkali8/Simple-Crud-SPRING.git
cd GameDB-Api
docker-compose build
docker-compose up
```

## Usage
Test the API with [Postman](https://www.postman.com/).

### Example JSON

```JSON
[
    {
        "name": "CIV5",
        "price": "55"
    }
]
```

### GET

#### Get all games:

`localhost:8080/api/games`

### GET

#### Get a game:

`localhost:8080/api/games/{id}`

###POST

#### Create a game:

`localhost:8080/api/games`

###PUT

#### Update a game:

`localhost:8080/api/games/{id}`

###DELETE

#### Delete a game:

`localhost:8080/api/games/{id}`

