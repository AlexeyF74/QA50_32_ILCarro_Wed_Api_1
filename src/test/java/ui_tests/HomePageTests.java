//package ui_tests;
//
//public class HomePageTests {
//}
package ui_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTest {

    private final String BASE_URL = "https://ilcarro.web.app/search"; // поставь свой URL, если другой

    @Test
    public void openHomePageTest() {
        driver.get("https://ilcarro.web.app/");

        driver.get(BASE_URL);
        String title = driver.getTitle();
        System.out.println("Title = " + title);
        Assert.assertTrue(driver.getCurrentUrl().contains("ilcarro"), "URL does not contain ilcarro");
    }

    @Test
    public void loginButtonExistsAndClickableTest() {
        HomePage home = new HomePage(driver);
        home.open(BASE_URL);
        home.clickLogin(); // если не кликается — упадёт, и это нормально для проверки
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"), "Not navigated to login page");
    }

    @Test
    public void openAndBackTest() {
        HomePage home = new HomePage(driver);
        home.open(BASE_URL);
        String url1 = driver.getCurrentUrl();
        home.clickLogin();
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), url1, "Back navigation failed");
    }
}
