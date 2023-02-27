package apponteotomasyon.page;

import apponteotomasyon.base.BasePage;
import io.appium.java_client.AppiumDriver;

import static apponteotomasyon.constants.Constants.*;

public class ProfilePage extends BasePage {

    AppiumDriver driver;
    public ProfilePage(AppiumDriver driver){
        super(driver);
    }


    public ProfilePage profilePageCase() throws InterruptedException {
        click(PROFILE_TAB);
        passLog("Profil tab'e tıklandı!");
        click(PROFILE_BUTTON);
        infoLog("Profil ayarlarına tıklandı!");
        clear(COMPANY_NAME);
        infoLog("Şirket ismi silindi");
        sendKeys(COMPANY_NAME,"PanteonGames");
        infoLog("Şirket ismi girişi yapıldı!");
        clear(WEB_SITE);
        infoLog("Şirket web site silindi");
        sendKeys(WEB_SITE,"www.panteon.games");
        infoLog("Web site girişi yapıldı");
        clear(ADDRESS);
        infoLog("adres silindi");
        sendKeys(ADDRESS,"ODTU Teknokent");
        infoLog("Adres girişi yapıldı");
        click(PROFILE_SAVE);
        passLog("Kaydet butonuna tıklandı");
        infoLog("Profil testi tamamlandı!");
        return this;
    }


}
