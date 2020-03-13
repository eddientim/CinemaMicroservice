#!/usr/bin/env bash

main() {

    chmod +x start-cinema.sh
    # start cinemaservice and DynamoDB
    docker-compose up -d --build --force-recreate

    create_table

    docker-compose logs -f
}

create_table() {
#    Check to see if database is still running in docker before creating a refresh table
#    and loops through each second until the DB is running
    DYNAMODB_RUNNING=false
    until [ "$DYNAMODB_RUNNING" = true ]
    do
      echo "awaitng to start DynamoDB..."
      sleep 1
      DYNAMODB_RUNNING=$(docker inspect -f '{{.State.running}}' cinemamicroservice)
    done

  echo"DynamoDB started."
  ./scripts/create-dynamodb-table.sh "http://localhost:8000"
}

main