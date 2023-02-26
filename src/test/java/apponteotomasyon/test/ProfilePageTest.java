package apponteotomasyon.test;

import apponteotomasyon.base.BaseTest;
import apponteotomasyon.page.ProfilePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfilePageTest extends BaseTest {

    ProfilePage profilePage;
    @BeforeClass
    public void before(){
        profilePage = new ProfilePage(getAppiumDriver());
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(1000);

        profilePage.profilePageCase();
    }

    @AfterClass
    public void tearDownTest(){
        tearDown();
    }
}
