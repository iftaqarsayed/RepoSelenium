package HomeworkJune22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class facebookLogin {

    @Test
    public void compareErrorMsg(){
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
        WebDriver driver = new ChromeDriver();

       String webPage = "https://www.facebook.com/";
       driver.get(webPage);

       By fstNamelocator = By.xpath("//input[@name='firstname']");
       WebElement fstName = driver.findElement(fstNamelocator);
       fstName.sendKeys("henry");

        By lastNamelocator = By.xpath("//input[@aria-label='Last name']");
        WebElement lastName = driver.findElement(lastNamelocator);
        lastName.sendKeys("john");

        By emailLocator = By.xpath("//input[@name='reg_email__']");
        driver.findElement(emailLocator).sendKeys("mailingid@gmail.com");

       By secondemailLocator = By.xpath("//input[@name='reg_email_confirmation__']");
       driver.findElement(secondemailLocator).sendKeys("mailingid@gmail.com");

        By passwordLocator = By.xpath("//input[@data-type='password']");
        driver.findElement(passwordLocator).sendKeys("abcd1234");

        By signupLoca = By.xpath("//button[@name='websubmit']");
        driver.findElement(signupLoca).click();

        By errorMsgLocator = By.xpath("//div[@id='js_1e0']");
        WebElement errorMsg = driver.findElement(errorMsgLocator);

        String expectedErrorMsg = "Please choose a gender. You can change who can see this later.";
        String realErrorMsg = errorMsg.getText();
        System.out.println(realErrorMsg);

        Assert.assertEquals(expectedErrorMsg, realErrorMsg, "error message didn't match");

        //driver.quit();

    }


}
