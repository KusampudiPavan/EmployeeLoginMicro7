package com.stl.EmployeeLogin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;


@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeLoginApplicationTests {

    
    @Test
    @Order(2)
    public void testAdminLogin() {
        String jsonbody= "{\"email\" : \"pavan@gmail.com\",\"password\" : \"pavan\"}";
        String token=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8084/Employee/authenticatetoken")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
   
}
