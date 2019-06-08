package test.java.producer;

import controller.EvenOddController;
import controller.Greetingcontroller;
import controller.SCCProducerApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SCCProducerApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier

public class BaseTestClass {

    @Autowired
    private EvenOddController evenOddController;

    @Autowired
    private Greetingcontroller greetingController;

    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilderForEvenOdd = MockMvcBuilders.standaloneSetup(evenOddController, greetingController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilderForEvenOdd);
    }
}
