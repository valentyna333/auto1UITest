import static com.google.common.base.Verify.verify;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;


/**
 * Created by valentina.chycha on 10/07/2017.
 */
public class Auto1Tests extends BaseTest {

    DashboardPage dashboardPage;
    //Method for login
    public void login(){
	//Login URL, email, password nad brand are present in config.properties file
        driver.get(properties.getProperty("loginPage"));
        LoginPage loginPage=new LoginPage(driver);
        dashboardPage=loginPage.loginIntoSystem(properties.getProperty("email"),properties.getProperty("password"));
        assertTrue(dashboardPage.logoutButton.isEnabled(), "Logout button is not present");
    }


    @Test
    public void filterTest() {
        login();
	//BMW value is taken from properties file
        String brand=properties.getProperty("brand");
	// Select how many cars must be present on one page (via paggination block on page)
	int carsNumberOnPage=dashboardPage.getItemsCountOnPage();

	//Brand selection
        dashboardPage.selectBrand(brand);
	// Test usually has one assert - rest of checks are made via verify
	// Assert if filter block with BMW value appeared on page
        assertTrue(dashboardPage.brandBox(brand).isDisplayed(), "Filter was not selected");
	// Verify if all cars have the same brand (via title of every car)
        verify(carsNumberOnPage==dashboardPage.carTitleOnPage(brand),"Records have different brands");

	// Verify if all attributes for each car are not empty (there are 6 attributes in general). 
	// Must be optimized in general, because number of attributes can be bigger
        verify(carsNumberOnPage==dashboardPage.getStockNumbers(),"There are records without stock number");
        verify(carsNumberOnPage==dashboardPage.getMileages(),"There are records without mileages");
        verify(carsNumberOnPage==dashboardPage.getFirstRegistrations(),"There are records without first registration");
        verify(carsNumberOnPage==dashboardPage.getHorsepowers(),"There are records without horse power values");
        verify(carsNumberOnPage==dashboardPage.getFuelTypes(),"There are records without fuel types");
        verify(carsNumberOnPage==dashboardPage.getGearboxes(),"There are records without Gear boxes");
	// Verify if every car have an image
        verify(carsNumberOnPage==dashboardPage.getImageItemsCountOnPage(),"There are records without images");









    }

}
