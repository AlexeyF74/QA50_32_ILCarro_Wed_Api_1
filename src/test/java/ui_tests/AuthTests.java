//package ui_tests;
//
//public class AuthTests {
//}
package ui_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class AuthTests extends BaseTest {

    // 1) Позитив: успешный логин
    @Test
    public void loginPositiveTest() {
        HomePage home = new HomePage(driver);
        home.clikBthLogin();

        LoginPage login = new LoginPage(driver);
        login.fillEmail("Alexey123@gmail.com")
                .fillPassword("Password123$")   // поставь свой правильный пароль
                .submit();

        Assert.assertTrue(home.isLogoutVisible(), "Logout не появился — логин не подтвердился");
    }

    // 2) Негатив: неправильный пароль
    @Test
    public void loginNegativeWrongPasswordTest() {
        HomePage home = new HomePage(driver);
        home.clikBthLogin();

        LoginPage login = new LoginPage(driver);
        login.fillEmail("Alexey123@gmail.com")
                .fillPassword("WRONG_PASSWORD")
                .submit();

        Assert.assertTrue(login.isErrorVisible(), "Не появилось сообщение об ошибке при неверном пароле");
    }

    // 3) Logout: залогинились → вылогинились → проверили что logout пропал
    @Test
    public void logoutTest() {
        HomePage home = new HomePage(driver);
        home.clikBthLogin();

        LoginPage login = new LoginPage(driver);
        login.fillEmail("Alexey123@gmail.com")
                .fillPassword("Password123@")
                .submit();

        Assert.assertTrue(home.isLogoutVisible(), "Перед logout не появился Logout — логин не выполнен");

        home.clickLogin();

        Assert.assertFalse(home.isLogoutVisible(), "Logout всё ещё виден после выхода");
    }
}
