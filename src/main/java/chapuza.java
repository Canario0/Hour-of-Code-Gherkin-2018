import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class chapuza {
    public static void main(String args[]){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/firefox/geckodriver.exe");
        WebDriver a = new FirefoxDriver();
        a.get("https://www.google.es/");
    }
}
