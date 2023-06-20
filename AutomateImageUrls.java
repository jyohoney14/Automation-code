package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class AutomateImageUrls {
    ChromeDriver driver;

    public AutomateImageUrls() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void imageurls() {
        System.out.println("Start Test case: image urls");
        // Open url https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // count of images Using Locator "Tag Name" image
        // =driver.findElementsBy.tagName("img")
        List<WebElement> RecommendedMovieImages = driver
                .findElements(By.xpath("(//div[@class='sc-lnhrs7-4 bmyqGC'])//img"));
        // h2[text()='Recommended Movies']/../../../following-sibling::div//img
        System.out.println("no.of images present: " + RecommendedMovieImages.size());
        // print urls Using Locator "Tag Name" image.get_attribute('src')
        for (WebElement urls : RecommendedMovieImages) {

            System.out.println("Recommended movies image urls are :" + urls.getAttribute("src"));
        }

        // h2[text()='Recommended Movies']/../../../following-sibling::div//img
        // get the title 'Premieres' Using Locator "XPath" //h2[text()='Premieres']
        // check 2nd item name and language in premieres Using Locator "XPath" put all
        // the movies title and language comes under premieres in a list and using loop
        // , when 2nd iteration comes get the title and language of the movie

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[text()='Uthami']")));
        List<WebElement> premiereText = driver
                .findElements(By.xpath("(//div[@class='sc-133848s-3 cWbeuJ'])[38]/div/div"));
        for (WebElement text : premiereText) {
            System.out.println(text.getText());
        }

        System.out.println("end Test case: image urls");
    }

}
