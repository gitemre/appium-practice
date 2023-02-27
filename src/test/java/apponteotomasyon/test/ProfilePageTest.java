package apponteotomasyon.test;

import apponteotomasyon.base.BaseTest;
import apponteotomasyon.page.ProfilePage;
import apponteotomasyon.reports.ExtentTestReports;
import org.testng.annotations.*;

public class ProfilePageTest extends BaseTest {

    ProfilePage profilePage;

    @BeforeSuite
    public void setupSuite(){
        ExtentTestReports.beforeTest();
    }

    @AfterSuite
    public void afterSuite(){
        ExtentTestReports.afterTest();
    }

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
