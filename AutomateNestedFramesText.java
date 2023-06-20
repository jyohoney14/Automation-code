package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class AutomateNestedFramesText {
    ChromeDriver driver;

    public AutomateNestedFramesText() {
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

    public void nestedFrames() {
        System.out.println("Start Test case: nestedframes");
        // navigate to url https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // switch to left frame Using Locator "Name" frame-left
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        // print left frame value Using Locator "XPath" //body[contains(text(),'LEFT')]
        WebElement leftText = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println("Text of left frame:" + leftText.getText());
        // switch to middle frame Using Locator "Name" frame-middle
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        // print middle frame vlaue Using Locator "XPath" //div[@id='content']
        WebElement middleText = driver.findElement(By.xpath("//div[@id='content']"));
        System.out.println("Text of left frame:" + middleText.getText());
        // switch to parent frame parent frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        // print right frame vlaue Using Locator "XPath"
        // //body[contains(text(),'RIGHT')]
        WebElement rightText = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println("Text of left frame:" + rightText.getText());
        // switch to default frame default frame
        driver.switchTo().defaultContent();
        // switch to bottom frame Using Locator "Name" frame-bottom
        driver.switchTo().frame("frame-bottom");
        // print bottom frame value Using Locator "XPath"
        // //body[contains(text(),'BOTTOM')]
        WebElement bottomText = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println("Text of left frame:" + bottomText.getText());
        // switch to parent frame parent frame
        driver.switchTo().parentFrame();
        System.out.println("end Test case: nestedframes");
    }

}
