#!/usr/bin/env bash

main() {
  create_dynamo_docker_volume
}

#creates a local docker volume for DynamoDB instance and its data to exist
create_dynamo_docker_volume() {
  docker volume create dynamodb
}

main