from .adder import AddingAPI
from console import Console
from .aggregator import AggregatorInterface

service Client {
    outputPort Aggregator {
        location: "socket://localhost:8081"
        // CHANGING THIS PROTOCOL AND THE MATCHING ONE IN AGGREGATOR.OL TO HTTP RESULTS IN A TYPE-ERROR
        protocol: sodep
        interfaces: AddingAPI, AggregatorInterface
    }
    embed Console as Console
    main {
        add@Aggregator({summand1= 2, summand2= 4})(result);
        add@Aggregator({summand1= 3, summand2= 4})(result2);
        println@Console("result:" + result)()
        println@Console("result2:" + result2)()
    }
}