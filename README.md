# gerador-de-corridas
- Neste projeto utilizei o framework Spring para trazer agilidade no desenvolvimento da parte REST. Além disso, é o framework mais utilizado pelo mercado (Java).
- Optei por salvar os itens em memória e também separei as regras de negócio no package domain.
- Código para executar: spring-boot:run

Endpoints
- POST: localhost:8080/ride
- DELETE: localhost:8080/ride?id=

Exemplo:
## Criar corrida
POST: localhost:8080/ride
Body: 
```
{
    "passenger": {
        "name": "Andre Bovis",
        "username": "andre.bovis",
        "document": "374.267.358-00"
    },
    "from": {
        "streetName": "Fernando de Albuquerque",
        "number": "89",
        "complement": "1",
        "city": "Sao Paulo",
        "state": "SP",
        "zipCode": "01309-030",
        "geoPoint": {
            "lat": -19.95419971373237,
            "lon": -43.93834834232896
        }
    },
    "to": {
        "streetName": "Augusta",
        "number": "18",
        "complement": "9",
        "city": "Sao Paulo",
        "state": "SP",
        "zipCode": "01208-030",
        "geoPoint": {
            "lat": -19.93347189060052,
            "lon": -43.930374445812724
        }
    }
}
```

## Cancelar corrida
DELETE: localhost:8080/ride?id={rideId}