package apponteotomasyon.page;

import apponteotomasyon.base.BasePage;
import io.appium.java_client.AppiumDriver;

import static apponteotomasyon.constants.Constants.*;

public class ProfilePage extends BasePage {

    AppiumDriver driver;
    public ProfilePage(AppiumDriver driver){
        super(driver);
    }

    //1.case methodu
    public ProfilePage profilePageCase() throws InterruptedException {
        Thread.sleep(1000);
        click(PROFILE_TAB);
        Thread.sleep(1000);
        click(PROFILE_BUTTON);
        Thread.sleep(1000);
        clear(COMPANY_NAME);
        Thread.sleep(1000);
        sendKeys(COMPANY_NAME,"PanteonGames");
        Thread.sleep(1000);
        clear(WEB_SITE);
        Thread.sleep(1000);
        sendKeys(WEB_SITE,"www.panteon.games");
        Thread.sleep(1000);
        clear(ADDRESS);
        Thread.sleep(1000);
        sendKeys(ADDRESS,"ODTU Teknokent");
        Thread.sleep(1000);
        click(PROFILE_SAVE);
        Thread.sleep(1000);
        return this;
    }


}
