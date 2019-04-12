# jaeger-poc

## Prerequisites

This POC uses CNCF Jaeger (https://jaegertracing.io) as the tracing backend.
For this POC, first start Jaeger via Docker with the default in-memory storage, exposing only the required ports. We'll also enable "debug" level logging:

```
docker run \
  --rm \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 16686:16686 \
  jaegertracing/all-in-one:latest \
  --log-level=debug
```