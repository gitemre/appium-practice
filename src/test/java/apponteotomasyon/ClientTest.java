package apponteotomasyon;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ClientTest {

    public  AppiumDriver driver;
    public WebDriverWait wait;

    By addClientButton = By.id("mobi.appcent.apponte:id/appointmentFragmentIcon");

    By addPersonButton = By.id("mobi.appcent.apponte:id/profileEditImgBox");

    By nameText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");

    By surnameText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");

    By phoneText  =By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");

    By clientSaveButton = By.id("mobi.appcent.apponte:id/btnSave");

    By searchText = By.id("mobi.appcent.apponte:id/search_src_text");

    By homeButton = By.id("mobi.appcent.apponte:id/toolbarBackBtn");
    @BeforeTest
    public void beforeTest(){
        try {
            DesiredCapabilities cap  = new DesiredCapabilities();
            cap.setCapability("deviceName","Pixel 4 API 29");
            cap.setCapability("platformName","Android");
            cap.setCapability("udid","emulator-5554");
            cap.setCapability("platformVersion","10.0");
            cap.setCapability("appPackage","mobi.appcent.apponte");
            cap.setCapability("appActivity","mobi.appcent.apponte.ui.activity.home.HomeActivity");
            cap.setCapability("skipUnlock","true");
            cap.setCapability("noReset","true");

            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        catch (MalformedURLException mx){
            System.out.println("Hatalı URL oluşturuldu!");
        }
    }

    @Test
    public void addClient() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement addClientSelect = driver.findElement(addClientButton);
        addClientSelect.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement clientAddSelect = driver.findElement(addPersonButton);
        clientAddSelect.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement nameTextSelect = driver.findElement(nameText);
        nameTextSelect.click();

        new Actions(driver).sendKeys("Emre").perform();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement surnameTextSelect  = driver.findElement(surnameText);
        surnameTextSelect.click();
        new Actions(driver).sendKeys("Ozturk").perform();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement phoneTextSelect = driver.findElement(phoneText);
        phoneTextSelect.click();
        new Actions(driver).sendKeys("05533223322").perform();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement clientSaveSelect = driver.findElement(clientSaveButton);
        clientSaveSelect.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement searchTextSelect = driver.findElement(searchText);
        searchTextSelect.click();

        new Actions(driver).sendKeys("E").perform();

        Thread.sleep(4000);

        WebElement nameTextView = driver.findElement(By.xpath("//android.widget.TextView[@text='Emre Ozturk']"));
        WebElement homePageButton = driver.findElement(homeButton);

        if (nameTextView.isDisplayed()){
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            nameTextView.click();
        }
        else{
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            homePageButton.click();
            Thread.sleep(4000);

        }



    }

    @AfterTest
    public void teardown(){

    }
}
