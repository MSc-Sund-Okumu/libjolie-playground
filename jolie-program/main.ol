from .definitions import MainIface
from console import Console

service Main {
    execution{ concurrent }
    inputPort MainPort {
        location: "socket://localhost:8080"
        protocol: http
        interfaces: MainIface
    }
    embed Console as Console
    main {
        [hello(request)(response) {
            println@Console("received request")()
            response = "hello"
            response = "Jeg virker :O"
        }]
    }
}