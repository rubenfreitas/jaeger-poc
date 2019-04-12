# jaeger-poc
[![Build Status](https://travis-ci.org/rubenfreitas/jaeger-poc.svg?branch=master)](https://travis-ci.org/rubenfreitas/jaeger-poc)
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

Setup Kafka Broker
```
git clone git@github.com:wurstmeister/kafka-docker.git
```
set KAFKA_ADVERTISED_HOST_NAME in docker-compose-single-broker.yml to correct docker host and start the broker
```
docker-compose -f docker-compose-single-broker.yml up
```