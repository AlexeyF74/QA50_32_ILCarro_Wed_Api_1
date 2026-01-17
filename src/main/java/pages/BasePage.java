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
package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    static  WebDriver driver;
    public void setDriver(WebDriver wd){
        driver = wd;
    }

    protected void pause(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
