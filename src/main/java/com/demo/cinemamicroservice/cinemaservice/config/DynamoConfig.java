package com.demo.cinemamicroservice.cinemaservice.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import javax.naming.ConfigurationException;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableDynamoDBRepositories(dynamoDBMapperConfigRef = "DynamoDBProperties",
    basePackages = "com.demo.cinemamicroservice.cinemaservice.repositories")
public class DynamoConfig {

    private static final int ONE_MINUTE_MS = 60000;

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    private final DynamoDBProperties config;

//    @Bean
//    public AmazonDynamoDB amazonDynamoDB() {
//        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
//        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
//            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
//        }
//        return amazonDynamoDB;
//    }

    /**
     * @return
     */
    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }

    /**
     * @param amazonDynamoDB
     * @param dynamoDBMapperConfig
     * @return
     */
    @Bean
    DynamoDBMapper createDynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig dynamoDBMapperConfig) {
        return new DynamoDBMapper(amazonDynamoDB, dynamoDBMapperConfig);
    }

    @Bean
    AmazonDynamoDB amazonDynamoDB() throws ConfigurationException {
        if (config.getLocal()) {
            return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(config.getEndpoint(), config.getRegion()))
                .build();
        }
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.withRequestTimeout(ONE_MINUTE_MS);

        return AmazonDynamoDBClientBuilder
            .standard()
            .withCredentials()
            .withRegion(config.getRegion())
            .withClientConfiguration(clientConfiguration)
            .build();
    }

    /**
     * Creates the {@Link DynamoDBMapperConfig} object that will be used to create the {@link DynamoDBMapper}.
     *
     * @return a configured {@Link DynamoMapperConfig} object.
     */
    @Bean
    public DynamoDBMapperConfig dynamoDBMapperConfig() {
        return new DynamoDBMapperConfig.Builder()
            .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride
                .withTableNamePrefix(getTableNamePrefix()))
            .build();
    }

    /**
     * Gets the table name prefix configured in the application profiles
     *
     * @return
     */
    private String getTableNamePrefix() {
        return config.getTableNameEnvironmentPrefix() + "-";
    }

//    @Bean(name = "mvcHandlerMappingIntrospector")
//    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
//        return new HandlerMappingIntrospector(context);
//    }
}
