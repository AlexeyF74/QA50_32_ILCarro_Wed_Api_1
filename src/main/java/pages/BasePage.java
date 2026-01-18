//package pages;
//
//import org.openqa.selenium.WebDriver;
//
//public abstract class BasePage {
//    static void WedDriver driver;
//
//
//    public static void setWedDriver(WedDriver wd) {
//        driver = wd;
//
//    }
//
//
//    public void pause(int time) {
//        try {
//            Thread.sleep(time * 1000L);
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//
//        }
//    }
//}
//package pages;
//
//import org.openqa.selenium.WebDriver;
//
//public abstract class BasePage {
//    static  WebDriver driver;
//    public void setDriver(WebDriver wd){
//        driver = wd;
//    }
//
//    protected void pause(int time) {
//        try {
//            Thread.sleep(time * 1000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean isPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    protected void click(By locator) {
        waitClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement el = waitVisible(locator);
        el.clear();
        el.sendKeys(text);
    }
}
