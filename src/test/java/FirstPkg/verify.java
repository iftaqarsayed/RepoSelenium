package FirstPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verify {
    @Test
    public void verify() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.facebook.com/";
        driver.get(url);

        String expectedUrl = driver.getCurrentUrl();

        Assert.assertEquals(url,expectedUrl, "url mismatch");

        driver.quit();

    }
}
