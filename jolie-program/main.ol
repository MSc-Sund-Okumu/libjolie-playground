from .definitions import MainIface

service Main {
    execution{ concurrent }
    inputPort MainPort {
        location: "socket://localhost:8080"
        protocol: http
        interfaces: MainIface
    }

    main {
        [hello(request)(response) {
            response = "hello"
            response = "Jeg virker :O"
        }]
    }
}