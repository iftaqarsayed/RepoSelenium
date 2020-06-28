package FirstPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IsSelected {
    @Test
    public void verifyButton() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.facebook.com/";
        driver.get(url);
        By maleButtonLocator = By.xpath("//input[@type='radio' and @value='2']");
        WebElement maleButton = driver.findElement(maleButtonLocator);
        Assert.assertFalse(maleButton.isSelected(), "male button is selected");
        if (!maleButton.isSelected()) {
            maleButton.click();
        }
        Assert.assertTrue(maleButton.isSelected(), "male button not selected");

        By monthLocator = By.id("month");
        WebElement monthDropDown = driver.findElement(monthLocator);
        Select month = new Select(monthDropDown);
        month.selectByVisibleText("Aug");

        By dayLocator = By.id("day");
        WebElement dayDropDown = driver.findElement(dayLocator);
        Select day = new Select(dayDropDown);
        day.selectByValue("31");

        By yearLocator = By.id("year");
        WebElement yearDropDown = driver.findElement(yearLocator);
        Select year = new Select(yearDropDown);
        year.selectByVisibleText("1985");


    }
}
