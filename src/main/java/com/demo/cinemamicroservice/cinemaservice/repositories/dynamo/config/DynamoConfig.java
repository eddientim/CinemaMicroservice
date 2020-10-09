package com.demo.cinemamicroservice.cinemaservice.repositories.dynamo.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.naming.ConfigurationException;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableDynamoDBRepositories(dynamoDBMapperConfigRef = "DynamoDBMapperConfig",
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
     * @return aws credentials
     */
    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }

    /**
     * creates the local or AWS {@link AmazonDynamoDB} interface using configured properties
     * and credentials.
     * @return a fully configured {@link AmazonDynamoDB} interface.
     * @throws ConfigurationException thrown if there is a configuration exception.
     */
    @Bean
    public AmazonDynamoDB amazonDynamoDB() throws ConfigurationException {
        if (config.getLocal()) {
            return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(config.getEndpoint(), config.getRegion()))
                .build();
        }
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.withRequestTimeout(ONE_MINUTE_MS);

        return AmazonDynamoDBClientBuilder
            .standard()
            .withRegion(config.getRegion())
            .withClientConfiguration(clientConfiguration)
            .build();
    }

    /** Creates the{@link DynamoDBMapper} that is used for allowing the mapping of client-side
     * classes to Amazon tables. It is created bu using the {@link AmazonDynamoDB} interface and
     * the {@link DynamoDBMapperConfig}. This will be used to retrieve data from DynamoDB
     * @param amazonDynamoDB
     * @param dynamoDBMapperConfig
     * @return a fully configured {@link DynamoDBMapper}
     */
    @Bean
    public DynamoDBMapper createDynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig dynamoDBMapperConfig) {
        return new DynamoDBMapper(amazonDynamoDB, dynamoDBMapperConfig);
    }

    /**
     * Creates the {@link DynamoDBMapperConfig} object that will be used to create the {@link DynamoDBMapper}.
     * @return a configured {@link DynamoDBMapperConfig} object.
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

    @Bean(name = "mvcHandlerMappingIntrospector")
    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
        return new HandlerMappingIntrospector();
    }
}
