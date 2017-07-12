package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by valentina.chycha on 10/07/2017.
 */
public class LoginPage extends BasePage {


    @FindBy(id = "login-email")
    private WebElement emailInput;

    @FindBy(id = "login-password")
    private WebElement passwordInput;


    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;


    public LoginPage(WebDriver driver){
        super(driver);
    }


    public DashboardPage loginIntoSystem(String email, String password){
        typeValue(emailInput, email);
        typeValue(passwordInput, password);
        loginButton.click();
        return new DashboardPage(driver);
    }





}
