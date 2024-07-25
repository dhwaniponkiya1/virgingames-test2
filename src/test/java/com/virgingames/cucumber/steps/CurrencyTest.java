package com.virgingames.cucumber.steps;

import com.virgingames.currencyinfo.CurrencySteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class CurrencyTest {
    static ValidatableResponse response;

    @Steps
    CurrencySteps currencySteps;

    @When("I select {string} as query parameter")
    public void iSelectAsQueryParameter(String currency) {
        if (currency.equalsIgnoreCase("GBP"))
            response = currencySteps.getGBP();
        if (currency.equalsIgnoreCase("EUR"))
            response = currencySteps.getEUR();
        if(currency.equalsIgnoreCase("SEK"))
            response = currencySteps.getSEK();

        response.statusCode(200);
    }


    @Then("Verify currency in response contains {string}")
    public void verifyCurrencyInResponseContains(String currency) {
        response.body("data.pots[0].currency", equalTo(currency));
    }
}
