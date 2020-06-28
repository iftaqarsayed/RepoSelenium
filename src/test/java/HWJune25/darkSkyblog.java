package HWJune25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class darkSkyblog {
    @Test
    public void darkSkyTest(){
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        String webPage ="https://darksky.net/forecast/40.7127,-74.0059/us12/en";

        driver.get(webPage);
        By darkSkyAPILocator = By.xpath("//a[contains(text(),'Dark Sky API')]");
       WebElement darkSkyAPI =  driver.findElement(darkSkyAPILocator);
        darkSkyAPI.click();
        String DarkSkyAPIUrl = driver.getCurrentUrl();
        driver.get(DarkSkyAPIUrl);
        By blogPostLocator = By.xpath("//a[contains(text(),'blog post')]");
        WebElement blogPost = driver.findElement(blogPostLocator);
        blogPost.click();
        String blogPostUrl = driver.getCurrentUrl();
        driver.get(blogPostUrl);


        String blogPostTitle = driver.getTitle();
     //   System.out.println("current title:= " + blogPostTitle );
        String expectedPageTitle = "Dark Sky Blog";
        Assert.assertEquals(blogPostTitle, expectedPageTitle, "Title mismatch");

        By pageBannerLocator = By.xpath("//a[contains(text(),'Dark Sky Has a New Home')]");
        WebElement pageBanner = driver.findElement(pageBannerLocator);
       String pageBannerText = pageBanner.getText();

        By titleHeaderLocator = By.xpath("//p[@class='post_link_title']");
        WebElement titleHeader = driver.findElement(titleHeaderLocator);
        String titleHeaderText = titleHeader.getText();

        Assert.assertEquals(pageBannerText, titleHeaderText, "Page Banner Text doesn't match Tile Header-Text");

        By pageBannerDateLocator = By.xpath("//p[@class='post_link_date']");
        WebElement pageBannerDateElement = driver.findElement(pageBannerDateLocator);
        String pageBannerDate = pageBannerDateElement.getText();

        By titleDateLocator = By.xpath("//time[@itemprop='datePublished']");
        WebElement titleDateElement = driver.findElement(titleDateLocator);
        String titleDate = titleDateElement.getText();

        String[] newTitleDate = titleDate.split(" ");

        String firstIndex = newTitleDate[0].substring(0,3);
        String otherIndex= newTitleDate[1] + " " + newTitleDate[newTitleDate.length-1];

       String editedDate = firstIndex + " " + otherIndex;

        Assert.assertEquals(pageBannerDate, editedDate, "date mismatch");

        driver.navigate().back();
       String lastUrl = driver.getCurrentUrl();

        Assert.assertEquals(DarkSkyAPIUrl, lastUrl, "doesn't lands on Dark Sky API HomePage");



    }

}
