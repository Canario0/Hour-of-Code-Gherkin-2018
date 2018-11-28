package com.hfc.demo.serenitySteps;

import com.hfc.demo.pageObjects.RyanairHome;
import com.hfc.demo.pageObjects.RyanairResults;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UserSteps {
    private RyanairHome ryanairHome;
    private RyanairResults ryanairResults;

    @Step("Given I am in ryanair webpage")
    public void i_am_in_Ryanair_Webpage() {
        ryanairHome.open();
        ryanairHome.waitLoad();
    }

    @Step("And I close cookies politics")
    public void i_close_cookies_politics() {
        ryanairHome.closeCookiesPopUp();
    }

    @Step("When I click for '<direction>'")
    public void i_click_for(String direction) {
        Serenity.setSessionVariable("direction").to(direction);
        ryanairHome.selectDirection(direction);
    }

    @Step("And I want to go from '<fromPlace>' to '<toPlace>'")
    public void i_want_to_go_from_to(String from, String to) {
        ryanairHome.writeOrigin(from);
        ryanairHome.writeDestination(to);
    }

    @Step("And I want to go tomorrow")
    public void i_want_to_go_tomorrow() {
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.setTime(new Date());
        tomorrow.add(Calendar.DATE, 1);
        ryanairHome.setStartingDate(tomorrow);
    }

    @Step("And I click in go button")
    public void i_click_in_go_button() {
        ryanairResults = ryanairHome.clickGoButton();
    }

    @Step("Then I should see the result page with at least one flight")
    public void i_should_see_at_least_one_flight() {
        Assert.assertTrue("At least one fligth should be found", ryanairResults.getNumberOfResults() >= 1);
    }

    @Step("And with dates: '<dateOut>'")
    public void with_start_date(String entranceDay) {
        try {
            Date entranceDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH).parse(entranceDay);
            Serenity.setSessionVariable("entranceDay").to(entranceDay);
            Date today = new Date();
            System.out.println(today + "-" + entranceDate);
            Assert.assertTrue(entranceDate.after(today));
            Calendar inputDate = Calendar.getInstance();
            inputDate.setTime(entranceDate);
            ryanairHome.setStartingDate(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Step("And '<dateReturn>'")
    public void with_return_date(String dayReturn) {
        if (Serenity.sessionVariableCalled("direction").equals("idaVuelta")) {
            try {
                Date dateReturn = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH).parse(dayReturn);
                System.out.println(dayReturn);
                Calendar outputDate = Calendar.getInstance();
                outputDate.setTime(dateReturn);
                ryanairHome.setReturnDate(outputDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
