package com.hfc.demo.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@DefaultUrl("https://www.ryanair.com/gb/en/")
public class RyanairHome extends PageObject {

    @FindBy(xpath = "//div[@data-ref=\"cookies-policy-icon\"]")
    private WebElementFacade closeCookies;

    @FindBy(xpath = "//div[@class=\"flight-search-type-option return\"]")
    private WebElementFacade freturn;

    @FindBy(xpath = "//div[@class=\"flight-search-type-option one-way\"]")
    private WebElementFacade foneway;

    @FindBy(xpath = "//input[@tabindex=\"0\" and @placeholder=\"Departure airport\"]")
    private WebElementFacade origin;

    @FindBy(xpath = "//input[@tabindex=\"0\" and @placeholder=\"Destination airport\"]")
    private WebElementFacade destination;

    @FindBy(xpath = "//input[@name=\"dateInput0\" and @aria-label=\"Fly out: - DD\"]")
    private WebElementFacade dayOut;

    @FindBy(xpath = "//input[@name=\"dateInput1\" and @aria-label=\"Fly out: - MM\"]")
    private WebElementFacade monthOut;

    @FindBy(xpath = "//input[@name=\"dateInput2\" and @aria-label=\"Fly out: - YYYY\"]")
    private WebElementFacade yearOut;

    @FindBy(xpath = "//input[@name=\"dateInput0\" and @aria-label=\"Fly back: - DD\"]")
    private WebElementFacade dayBack;

    @FindBy(xpath = "//input[@name=\"dateInput1\" and @aria-label=\"Fly back: - MM\"]")
    private WebElementFacade monthBack;

    @FindBy(xpath = "//input[@name=\"dateInput2\" and @aria-label=\"Fly back: - YYYY\"]")
    private WebElementFacade yearBack;

    @FindBy(xpath = "//button[@ng-keypress=\"searchFlights()\"]")
    private WebElementFacade submit;


    public RyanairHome(WebDriver driver) {
        super(driver);
        maximize(driver);
    }

    private void maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void waitLoad() {
        this.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    public void closeCookiesPopUp() {
        closeCookies.waitUntilClickable();
        closeCookies.click();
    }

    public void selectDirection(String direction) {
        switch (direction) {
            case "ida":
                foneway.waitUntilClickable();
                foneway.click();
                break;
            case "idaVuelta":
                freturn.waitUntilClickable();
                freturn.click();
                break;
            default:
                break;
        }
    }

    public void writeOrigin(String from) {
        origin.waitUntilClickable();
        origin.typeAndEnter(from);
    }

    public void writeDestination(String to) {
        destination.waitUntilClickable();
        destination.typeAndEnter(to);
    }

    public void setStartingDate(Calendar startDate) {
        yearOut.waitUntilVisible();
        monthOut.waitUntilVisible();
        dayOut.waitUntilVisible();
        yearOut.type("" + startDate.get(Calendar.YEAR));
        monthOut.type("" + startDate.get(Calendar.MONTH));
        dayOut.type("" + startDate.get(Calendar.DAY_OF_MONTH));
    }

    public void setReturnDate(Calendar calendarOut) {
        yearBack.waitUntilVisible();
        monthBack.waitUntilVisible();
        dayBack.waitUntilVisible();
        yearBack.type("" + calendarOut.get(Calendar.YEAR));
        monthBack.type("" + calendarOut.get(Calendar.MONTH));
        dayBack.type("" + calendarOut.get(Calendar.DAY_OF_MONTH));
    }

    public RyanairResults clickGoButton() {
        submit.waitUntilClickable();
        submit.click();
        return new RyanairResults(this.getDriver());
    }
}
