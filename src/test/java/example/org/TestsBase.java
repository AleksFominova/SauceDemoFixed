package example.org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class TestsBase {

    ChromeDriver driver;

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {

        @Override
        protected void failed(Throwable e, org.junit.runner.Description description) {
          // makeScreenshotOnFailure();// сделает скриншот и вложение упавшего теста
           // driver.close();
          //  driver.quit();
        }




       @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
         return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
       }

        @Override
        protected void succeeded(org.junit.runner.Description description) {

            driver.quit();
        }


    };

    @Before
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chrome_driver\\chromedriver.exe");
       driver = new ChromeDriver();
        String BASE_URL = "http://www.saucedemo.com/";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();



    }

    @After
    public void tearDown() {
        if (driver != null) {
         driver.quit();}
    }
     String username = "standard_user";
     String password = "secret_sauce";
     String lockedOutUserName = "locked_out_user";
     String lockedOutPassword = "secret_sauce";

     String errorMessage = "Epic sadface: Sorry, this user has been locked out.";

}


