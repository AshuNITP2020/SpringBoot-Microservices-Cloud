package com.ak.productService;

import com.ak.productService.dto.ProductRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers//annotate so that Junit understands we are going to use test containers for this particular test
@AutoConfigureMockMvc//for autowiring mockmvc
class ProductServiceApplicationTests {

//	@BeforeAll
//	static void setupDockerCredentials() {
//		// Set Docker Hub credentials as environment variables
//		System.setProperty("DOCKER_REGISTRY_USERNAME", "ashutosh7579");
//		System.setProperty("DOCKER_REGISTRY_PASSWORD", "Pass@3227");
//	}
	@Container//so that Junit5 will understand that it is a mongoDB container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	@Autowired
	private MockMvc mockMvc;
	@Autowired	//content will take String for that we use Object Mapper to convert POJO to json and json to POJO

	private ObjectMapper objectMapper;//from jackson databind package
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
	}
	@Test
	void createProduct() throws Exception {
		ProductRequest productRequest = getProductRequest();//Object Type
		String requestString = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestString))
				.andExpect(status().isCreated());

	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("Redmi")
				.desc("Redmi note pro")
				.price(BigDecimal.valueOf(1200))
				.build();
	}

}
