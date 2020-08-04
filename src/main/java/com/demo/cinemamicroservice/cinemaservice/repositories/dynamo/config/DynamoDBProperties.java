package com.demo.cinemamicroservice.cinemaservice.repositories.dynamo.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Component
@Slf4j
@Setter
@Validated
@ConfigurationProperties("dynamodb")
public class DynamoDBProperties {

    private String endpoint;
    private String tableNameEnvironmentPrefix;
    private Boolean local;
    @NotBlank
    private String region;
    private String crossAccountRoleArn;
}
