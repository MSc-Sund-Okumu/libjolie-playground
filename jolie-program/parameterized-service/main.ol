type MyServiceParam {
    factor: int
    location: string
}

interface MyServiceInterface {
    RequestResponse: multiply ( int )( int )
}

service MyService( p: MyServiceParam ) {

    execution: concurrent

    inputPort IP {
        location: p.location
        protocol: sodep
        interfaces: MyServiceInterface
    }

    main {
        multiply ( number )( result ) {
            result = number * p.factor
        }
    }
}