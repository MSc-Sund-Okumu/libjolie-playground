# api_key_example
To make this example actualy secure it is expected that only the aggregator can connect to addingAPI.

Applying the pattern in this style would be creating the aggregator service and connecting to the protected service.
## How to run
run:
`jolie aggregator.ol`

in a separate terminal run: `jolie client.ol`

## BUG?
We intially used HTTP protocol for communication, but when we changed a responsetype 