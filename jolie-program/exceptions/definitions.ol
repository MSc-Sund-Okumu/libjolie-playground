/*
type HelloRequest {
    test: int
}
*/
type HelloRequest: void
type HelloResponse: string
interface MainIface {
    RequestResponse: 
        hello(HelloRequest)(HelloResponse),
        goodbye(void)(void)
}