Feature: Obtener los detalles de una cancion

    API Songs Details

    Scenario: Obtener los detalles de una cancion en base a un id
        Given Tester quiere probar el endpoint "Songs Details"
        When Tester desea buscar el detalle de una cancion en la api de shazam con
            """
            {
                "pathParams": null,
                "queryParams": {
                    "id": 1217912247
                },
                "headers": {
                    "x-rapidapi-key": "fc41260419msh01ac5d2d1bc3f6ep1def72jsnfee4ea638cca",
                    "x-rapidapi-host": "shazam.p.rapidapi.com",
                    "Content-Type": "application/json"
                },
                "body": null
            }
            """
        Then Tester verifica que la respuesta del endpoint sea
            """
            {
                "status_line": {
                    "status_line": "HTTP/1.1 200 OK"
                },
                "headers": null,
                "body": null
            }
            """

    Scenario: Buscar una cancion en base a un id nulo
        Given Tester quiere probar el endpoint "Songs Details"
        When Tester desea buscar el detalle de una cancion en la api de shazam con
            """
            {
                "pathParams": null,
                "queryParams": null,
                "headers": {
                    "x-rapidapi-key": "fc41260419msh01ac5d2d1bc3f6ep1def72jsnfee4ea638cca",
                    "x-rapidapi-host": "shazam.p.rapidapi.com",
                    "Content-Type": "application/json"
                },
                "body": null
            }
            """
        Then Tester verifica que la respuesta del endpoint sea
            """
            {
                "status_line": {
                    "status_line": "HTTP/1.1 204 No Content"
                },
                "headers": null,
                "body": null
            }
            """
