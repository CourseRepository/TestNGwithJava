package com.testcase;

import static io.restassured.RestAssured.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestRetryListener {
	
	@Test
	public void testRetry() throws URISyntaxException {
		//Assert.assertEquals("TestNg1", "TestNg2");
		given()
		.accept(ContentType.XML)
		.when()
		.get(new URI("http://localhost:8080/laptop-bag/webapi/api/all"))
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_NO_CONTENT);
	}

}
