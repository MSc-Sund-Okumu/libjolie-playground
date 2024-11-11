from console import Console
type summands {
    summand1: int
    summand2: int
}
type responsetype: int | void
interface AddingAPI {
    RequestResponse:
        add(summands)(responsetype)
        //Only 'add' to keep the example simple.
}

service adder {
    execution: concurrent
    inputPort IPort {
        location: "socket://localhost:8080"
        protocol: sodep
        interfaces: AddingAPI
    }

    embed Console as Con
    main {
        add(request)(response) {
            println@Con("adding: " + request.summand1 + " and " + request.summand2)()
            response = request.summand1 + request.summand2
            println@Con("result: " + response)()
        }

    }

}
