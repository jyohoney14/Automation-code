package demo;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class AutomateWindowHandle {
    ChromeDriver driver;

    public AutomateWindowHandle() {
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

    public void windowhandle() throws IOException {
        System.out.println("Start Test case: windowhandle");
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.switchTo().frame("iframeResult");
        WebElement tryItButton = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryItButton.click();
        String originalWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                driver.switchTo().window(handle);
                String title = driver.switchTo().window(handle).getTitle();
                String url = driver.switchTo().window(handle).getCurrentUrl();
                System.out.println("title :" + title);
                System.out.println("url :" + url);
            }
        }
        // takeScreenshot(driver, "info", "screenshot_number_");
        // TakesScreenshot ts = (TakesScreenshot) driver;
        // File src = ts.getScreenshotAs(OutputType.FILE);
        // File trg = new File(".\\screenshot\\page.png");
        // FileUtils.copyFile(src, trg);
        // driver.close();
        // driver.switchTo().window(originalWindowHandle);
        // Thread.sleep(3000);
        // driver.quit();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("C:\\Users\\rames\\Desktop\\My TestCase Templates\\w3school.png"));
        // driver.close();

        System.out.println("end Test case: windowhandle");
    }

}