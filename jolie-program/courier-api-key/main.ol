from .adder import AddingAPI
from .adder import adder
from console import Console
interface AggregatorInterface {
    RequestResponse:
        dummy_operation(void)(void)
}

service Api_key_service {
    execution: concurrent
    
    outputPort AdderPort {
    location: "socket://localhost:8080"
    // CHANGING THIS PROTOCOL AND THE MATCHING ONE IN CLIENT.OL TO HTTP RESULTS IN A TYPE-ERROR
    protocol: sodep
    interfaces: AddingAPI

    }
   inputPort api_key {
        location: "socket://localhost:8081"
        protocol: sodep
        interfaces: AggregatorInterface
        aggregates: AdderPort
    }
    embed Console as Console
    //we are embedding the adder to make the example easier to run
    embed adder
    
    define validate_api_key {
        // TODO validate the api key in the request
        valid_key = request.summand1 % 2 == 0
    }

    courier api_key {
        [ add(request)(response)] {
            validate_api_key
            if (valid_key) {
                println@Console("received valid key, request forwarded to Adder")();
                forward(request)(response)
            } else {
                println@Console("Received invalid key, request dropped")()
            }
            
        }
        
        //Example of how it would look if more endpoints were to be protected by this API_Key verification.
        /*
        [ sub(request)(response)] {

        }
        */
    }

    main {
            // keep the aggregator running
            dummy_operation()() {
                dummmy = dummy + 5
            }
            
        }
}
