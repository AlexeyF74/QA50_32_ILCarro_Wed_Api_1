//package pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
//
//public class HomePage extends BasePage{
//    public HomePage(WebDriver driver){
//        setDriver(driver);
//        driver.get("https://ilcarro.web.app/search");
//        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
//    }
//
//    @FindBy(xpath = "//a[text()='Log in']")
//    WebElement bthLogin;
//    public void clikBthLogin(){
//    bthLogin.click();
//    }
//
//    public void clickLogin() {
//    }
//
//
//}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By loginBtn = By.xpath("//a[normalize-space()='LOGIN' or normalize-space()='Log in' or normalize-space()='Login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ ВАЖНО: этот метод у тебя и отсутствовал
    public HomePage open(String url) {
        driver.get(url);
        return this;
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void clikBthLogin() {
    }

    public boolean isLogoutVisible() {
        return false;
    }
}
