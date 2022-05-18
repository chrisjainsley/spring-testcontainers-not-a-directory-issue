package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import org.testcontainers.containers.localstack.LocalStackContainer;
import static org.testcontainers.containers.localstack.LocalStackContainer.Service.S3;

@ActiveProfiles("it")
@SpringBootTest
@Testcontainers
class DemoApplicationTests {

	@Container
	public static LocalStackContainer localstack = new LocalStackContainer(
			DockerImageName.parse("localstack/localstack")
					.withTag("latest"))
			.withServices(S3);

	@Test
	void contextLoads() {
		localstack.start();
	}
}
