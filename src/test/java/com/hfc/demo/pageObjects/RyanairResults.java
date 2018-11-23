package com.hfc.demo.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RyanairResults extends PageObject {
    @FindAll({@FindBy(css = "div.details")})
    private List<WebElementFacade> avibleFlight;

    public RyanairResults(WebDriver driver) {
        super(driver);

    }

    public int getNumberOfResults() {
        return avibleFlight.size();
    }
}