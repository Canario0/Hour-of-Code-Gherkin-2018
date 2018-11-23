package com.hfc.demo.stepDefinitions;

import com.hfc.demo.serenitySteps.UserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GherkinSteps {
    @Steps
    private UserSteps user;

    @Given("^I am in ryanair webpage$")
    public void iAmInaRyanairWebpage() {
        user.i_am_in_Ryanair_Webpage();
    }

    @And("^I close cookies politics$")
    public void iCloseCookiesPolitics() {
        user.i_close_cookies_politics();
    }

    @When("^I click for \'([^\']*)\'$")
    public void iClickForIda(String direction) {
        user.i_click_for(direction);
    }

    @And("^I want to go from \'([^\']*)\' to \'([^\']*)\'$")
    public void iWantToGoFromTo(String from, String to) {
        user.i_want_to_go_from_to(from, to);
    }

    @And("^I want to go tomorrow$")
    public void iWantToGoTomorrow() {
        user.i_want_to_go_tomorrow();
    }

    @And("^I click in go button$")
    public void iClickInGoButton() {
        user.i_click_in_go_button();
    }

    @Then("^I should see the result page with at least one flight$")
    public void iShouldSeeTheResultPageWithAtLeastOneFlight() {
        user.i_should_see_at_least_one_flight();
    }

    @When("^I click for '<direction>'$")
    public void iClickForDirection(String direction) {
        user.i_click_for(direction);
    }

    @And("^I want to go from '<fromPlace>' to '<toPlace>'$")
    public void iWantToGoFromFromPlaceToToPlace(String from, String to) {
        user.i_want_to_go_from_to(from, to);
    }

    @And("^with dates '<dateOut>'$")
    public void withDatesDateOut(String dateOut) {
        user.with_start_date(dateOut);
    }

    @And("^'<dateReturn>'$")
    public void dateReturn(String dateReturn) {
        user.with_return_date(dateReturn);
    }
}
