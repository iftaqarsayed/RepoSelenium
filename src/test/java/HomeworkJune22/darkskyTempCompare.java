package HomeworkJune22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class darkskyTempCompare {

    @Test
    public void tempCompare() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        String webPage ="https://darksky.net/forecast/40.7127,-74.0059/us12/en";

        driver.get(webPage);

       By feelsLikeLocator = By.xpath("//span[@class='feels-like-text']");
       WebElement feelsLikeValue = driver.findElement(feelsLikeLocator);
       String feelsValue =  feelsLikeValue.getText();
       int n1 = feelsValue.length()-1;
       String feelsValueExceptDegree = feelsValue.substring(0, n1);
       int feelsLikeTemp = Integer.parseInt(feelsValueExceptDegree);

        System.out.println("Feels like temperature is " + feelsLikeTemp);
       By lowTemperatureLocator = By.xpath("//span[@class='low-temp-text']");
       WebElement lowTemperature = driver.findElement(lowTemperatureLocator);
       String lowTempValue = lowTemperature.getText();
       int n2 = lowTempValue.length() - 1;
       String lowTempExceptDegree = lowTempValue.substring(0, n2);
       int lowTemp = Integer.parseInt(lowTempExceptDegree);

        System.out.println("Low temperature is " +lowTemp);
        By highTempLocator = By.xpath("//span[@class='high-temp-text']");
        WebElement highTemperature = driver.findElement(highTempLocator);
        String highTempValue = highTemperature.getText();
        int n3 = highTempValue.length()-1;
        String highTempExceptDegree = highTempValue.substring(0, n3);
        int highTemp = Integer.parseInt(highTempExceptDegree);

        System.out.println("High temperature is " + highTemp);

        if (feelsLikeTemp>lowTemp && feelsLikeTemp<highTemp ) {
            System.out.println("Feels like temperature (" + feelsLikeTemp + ") is within the low temperature ("
                    + lowTemp + ") and high temperature (" + highTemp + ")");
        }
        //driver.quit();

    }
}
