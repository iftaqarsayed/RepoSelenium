package HWJune25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkFacebook {

    @Test
    public void checkWrongMailAdd() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String webPage = "https://www.facebook.com/";

        String[] mailAddress = {"test####", "%%winvalied$$$", "%%$$emailAddress.co^^"};

        for (int i=0; i<mailAddress.length;i++) {

        driver.get(webPage);

        By fstNamelocator = By.xpath("//input[@name='firstname']");
        WebElement fstName = driver.findElement(fstNamelocator);
        fstName.sendKeys("henry");

        By lastNameLocator = By.xpath("//input[@aria-label='Last name']");
        WebElement lastName = driver.findElement(lastNameLocator);
        lastName.sendKeys("john");


        By emailLocator = By.xpath("//input[@name='reg_email__']");
            driver.findElement(emailLocator).sendKeys(mailAddress[i]);

            By passwordLocator = By.xpath("//input[@data-type='password']");
            driver.findElement(passwordLocator).sendKeys("abcd1234");

        By maleButtonLocator = By.xpath("//input[@type='radio' and @value='2']");
        driver.findElement(maleButtonLocator).click();

            By signupLocator = By.xpath("//button[@name='websubmit']");
            driver.findElement(signupLocator).click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            By errorMsgLocator = By.xpath("//div[@style='top: 0px;' and contains(text(), 'enter a valid mobile number or email')]");
            WebElement errorMsgElement = driver.findElement(errorMsgLocator);
            String expectedErrorMsg = "Please enter a valid mobile number or email address.";
            String realErrorMsg = errorMsgElement.getText();
            System.out.println(expectedErrorMsg);
            System.out.println(realErrorMsg);
           Assert.assertEquals(realErrorMsg, expectedErrorMsg, "error message mismatch");


        }

    }
}
