package apponteotomasyon.base;

import apponteotomasyon.App;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    AppiumDriver driver;
    WebDriverWait wait;

    public BasePage(AppiumDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public WebElement findElement(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
    }

    public void click(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        findElement(by).click();
    }

    public void clear(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        findElement(by).clear();

    }

    public String getText(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return findElement(by).getText();
    }
}
