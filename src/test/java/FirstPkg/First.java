package FirstPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class First {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

    }
}
