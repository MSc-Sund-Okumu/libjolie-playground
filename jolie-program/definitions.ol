type HelloRequest: void
type HelloResponse: string
interface MainIface {
    RequestResponse: 
        hello(HelloRequest)(HelloResponse)
}