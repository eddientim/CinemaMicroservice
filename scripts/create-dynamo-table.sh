#!/usr/bin/env bash

main() {

  if [ -z "$1" ]
  then
    echo "No endpoint provided"
    exit 1
  fi

    ENDPOINT_URL=$1

    aws dynamodb create-table --cli-input-json file://scripts/table.json --endpoint-url ${ENDPOINT_URL} --region eu-west-2
}

main $1