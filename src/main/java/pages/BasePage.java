package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by valentina.chycha on 10/07/2017.
 */
public class BasePage {

    WebDriver driver;
    Actions ac;

    BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
        ac=new Actions(driver);
    }

    void typeValue(WebElement el, String value) {
        el.clear();
        el.sendKeys(value);
    }




}
