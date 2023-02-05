package apponteotomasyon;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginTest {
    public  AppiumDriver driver;
    public WebDriverWait wait;


    By consultantButton = By.id("mobi.appcent.apponte:id/btnInstitutional");
    By loginButton = By.id("mobi.appcent.apponte:id/ibSignIn");

    By numberText = By.id("mobi.appcent.apponte:id/etPhoneNumber");

    By sendCodeButton = By.id("mobi.appcent.apponte:id/btnSendCode");

    By otpSendCodeButton = By.id("mobi.appcent.apponte:id/btnOTPContinue");




    @BeforeTest
    public void beforeTest(){

        try {
            DesiredCapabilities cap  = new DesiredCapabilities();
            cap.setCapability("deviceName","Pixel 4 API 29");
            cap.setCapability("platformName","Android");
            cap.setCapability("udid","emulator-5554");
            cap.setCapability("platformVersion","10.0");
            cap.setCapability("appPackage","mobi.appcent.apponte");
            cap.setCapability("appActivity","mobi.appcent.apponte.ui.activity.login.LoginActivity");
            cap.setCapability("skipUnlock","true");
            cap.setCapability("noReset","false");

            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        catch (MalformedURLException mx){
            System.out.println("Hatalı URL oluşturuldu!");
        }

    }



    @Test
    public void test() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement consultantSelect = driver.findElement(consultantButton);
        consultantSelect.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement loginSelect = driver.findElement(loginButton);
        loginSelect.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement phoneNumberSelect = driver.findElement(numberText);
        phoneNumberSelect.click();
        new Actions(driver).sendKeys("5531807745").perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement sendButton = driver.findElement(sendCodeButton);
        sendButton.click();

        //OTP girişi manuel olarak yapılıyor
        Thread.sleep(10000);

        WebElement otpSendCodeSelect = driver.findElement(otpSendCodeButton);
        otpSendCodeSelect.click();

        Thread.sleep(10000);
    }

    @Test
    public void addClient(){

    }


    @AfterTest
    public void teardown(){
        driver.quit();
    }


}
