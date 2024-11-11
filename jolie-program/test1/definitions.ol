type HelloRequest {
    test: int
}
type HelloResponse: string
interface MainIface {
    RequestResponse: 
        hello(HelloRequest)(HelloResponse),
        goodbye(void)(void)
}