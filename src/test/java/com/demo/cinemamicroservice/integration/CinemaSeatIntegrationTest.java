//package com.demo.cinemamicroservice.integration;
//
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
//import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
//import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
//import com.demo.cinemamicroservice.CinemaMicroserviceApplication;
//import com.demo.cinemamicroservice.cinemaservice.repositories.dynamo.models.CinemaSeat;
//import com.demo.cinemamicroservice.cinemaservice.repositories.dynamo.models.Room;
//import com.demo.cinemamicroservice.cinemaservice.repositories.CinemaSeatRepository;
//
//import com.demo.cinemamicroservice.cinemaservice.repositories.RoomRepository;
//import org.junit.Before;
//import org.junit.ClassRule;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.List;
//@SpringBootTest(classes = CinemaMicroserviceApplication.class)
//@WebAppConfiguration
//@ActiveProfiles("local")
//@TestPropertySource(properties = {
//    "amazon.dynamodb.endpoint=http://localhost:8000/",
//    "amazon.aws.accesskey=test1",
//    "amazon.aws.secretkey=test231" })
//class CinemaSeatIntegrationTest {
//
//    @ClassRule
//    public static LocalDbCreationRule dynamoDB = new LocalDbCreationRule();
//
//    private DynamoDBMapper dynamoDBMapper;
//
//    @Autowired
//    private AmazonDynamoDB amazonDynamoDB;
//
//    @Autowired
//    RoomRepository repository;
//
//    private static final String EXPECTED_COST = "20";
//    private static final String EXPECTED_PRICE = "50";
//
//    @Before
//    public void setup() throws Exception {
//
//        try {
//            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
//
//            CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(RoomRepository.class);
//
//            tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
//
//            amazonDynamoDB.createTable(tableRequest);
//        } catch (ResourceInUseException e) {
//            // Do nothing, table already created
//        }
//
//        // TODO How to handle different environments. i.e. AVOID deleting all entries in ProductInfo on table
//        dynamoDBMapper.batchDelete((List<Room>) repository.findAll());
//    }
//
//    @Test
//    @DisplayName("Hi new tests")
//    public void sampleTestCase() {
//        Room dave = new Room(EXPECTED_COST, EXPECTED_PRICE);
//        RoomRepository.save(dave);
//
//        List<Room> result
//            = (List<Room>) repository.findAll();
//
//        assertTrue(result.size() > 0, "Not empty");
//        assertTrue(result.get(0).getCost().equals(EXPECTED_COST), "Contains item with expected cost");
//    }
//}
