package com.tech.mai.product.acceptance;

import com.tech.mai.product.ProductApplication;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The product steps to run the feature tests
 */
@ContextConfiguration
@SpringBootTest(classes = ProductApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductSteps {

    @Autowired
    TestRestTemplate restTemplate;
    ResponseEntity<String> response;

    String productId;

    @Given("^a product id of \"([^\"]*)\"$")
    public void a_valid_product_id_of(String productId) throws Throwable {
        this.productId = productId;
    }

    @When("^I ask for a product$")
    public void i_ask_for_a_product() throws Throwable {
        response = restTemplate.getForEntity(String.format("/product/%s", productId), String.class);
    }

    @Then("^a valid product should be returned$")
    public void a_valid_product_should_be_returned() throws Throwable {

        JSONObject json = new JSONObject(response.getBody());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(productId.toString()).isEqualTo(json.get("id"));
    }

    @Then("^an error should be returned$")
    public void an_error_should_be_returned() throws Throwable {
        JSONObject json = new JSONObject(response.getBody());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

        assertThat(json.has("code"));
        assertThat(json.get("code")).isEqualTo(400001);
        assertThat(json.has("description"));
        assertThat(json.get("description")).isEqualTo(String.format("Product not found for %s", productId));
    }
}
