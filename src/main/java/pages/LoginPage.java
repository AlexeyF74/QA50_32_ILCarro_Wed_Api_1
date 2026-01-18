package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailField = By.id("email");          // если у тебя другие id - поправим
    private final By passwordField = By.id("password");    // если у тебя другие id - поправим
    private final By submitBtn = By.xpath("//button[@type='submit']");
    private final By errorAlert = By.xpath("//*[contains(text(),'Wrong') or contains(text(),'invalid') or contains(text(),'error')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillEmail(String email) {
        type(emailField, email);
        return this;
    }

    public LoginPage fillPassword(String password) {
        type(passwordField, password);
        return this;
    }

    public LoginPage submit() {
        click(submitBtn);
        return this;
    }

    public boolean isErrorVisible() {
        return isPresent(errorAlert);
    }
}

