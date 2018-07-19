package com.tech.mai.product.acceptance;

import com.tech.mai.product.ProductApplication;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.Annotation;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The product steps to run the feature tests
 */
@ContextConfiguration
@SpringBootTest(classes = ProductApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductSteps implements En {

    @Autowired
    TestRestTemplate restTemplate;

    private String productId;
    private ResponseEntity<String> response;

    public ProductSteps() {

        Given("^a product id of \"([^\"]*)\"$", (String id) -> { productId = id; });

        When("^I ask for a product$", () -> {
            response = restTemplate.getForEntity(String.format("/product/%s", productId), String.class);
        });

        Then("^a valid product should be returned$", () -> {
            JSONObject json = buildJSONObject(response);

            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
            assertThat(productId.toString()).isEqualTo(getJsonValue(json, "id"));
        });

        Then("^an error should be returned$", () -> {
            JSONObject json = buildJSONObject(response);

            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
            assertThat(json.has("code"));
            assertThat(getJsonValue(json, "code")).isEqualTo(400001);
            assertThat(json.has("description"));
            assertThat(getJsonValue(json, "description")).isEqualTo(String.format("Product not found for %s", productId));
        });

    }

    private Object getJsonValue(JSONObject json, String name) {
        try { return json.get(name); }
        catch (JSONException e) { e.printStackTrace(); }

        throw new RuntimeException(String.format("Cannot get json value from %s", name));
    }

    private JSONObject buildJSONObject(ResponseEntity<String> responseEntity) {
        try { return new JSONObject(responseEntity.getBody()); }
        catch (JSONException e) { e.printStackTrace(); }

        throw new RuntimeException(String.format("Cannot convert %s to JSONObject", responseEntity));
    }
}
