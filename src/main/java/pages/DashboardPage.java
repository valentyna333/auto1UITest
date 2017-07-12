package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;



/**
 * Created by valentina.chycha on 11/07/2017.
 */
public class DashboardPage extends BasePage {

    static final String carBrandCheckbox= "//div[@class='car-search']//span[text()='%s']";
    static final  String carBrandFilter="//div[@class='selected-filter']//span[text()='%s']";


    @FindBy(xpath = "//li/a[@class='logout']")
    public WebElement logoutButton;

    String carBrandTitle = "//div[@class='car-name']//a[contains(text(), '%s')]";


    @FindBy(xpath = "//div[@class='pagination-info']")
    private WebElement pagination;


    @FindBy(xpath = "//div[@class='car-img']//img")
    private List<WebElement>  carImages;


    @FindBy(xpath = "//div[@class='content cars-list']//span[text()='Stock number']//following::td[1]")
    private List<WebElement>  stockNumbers;


    @FindBy(xpath = "//div[@class='content cars-list']//span[text()='Mileage']/following::td[1]")
    private List<WebElement>  mileages;

    @FindBy(xpath = "//div[@class='content cars-list']//span[text()='First registration']//following::td[1]")
    private List<WebElement>  firstRegistrations;


    @FindBy(xpath = "//div[@class='content cars-list']//span[text()='Horsepower']//following::td[1]")
    private List<WebElement>  horsepowers;


    @FindBy(xpath = "//div[@class='content cars-list']//span[text()='Fuel type']//following::td[1]")
    private List<WebElement>  fuelTypes;


    @FindBy(xpath = "//div[@class='content cars-list']//span[text()='Gear box']//following::td[1]")
    private List<WebElement>  gearboxs;



    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public DashboardPage selectBrand(String brandName) {
        WebElement filterValue = driver.findElement(By.xpath(String.format(carBrandCheckbox, brandName)));
        ac.moveToElement(filterValue);
        ac.click().build().perform();
        return this;
    }


    public WebElement brandBox(String brandName) {
        WebElement filterValue = driver.findElement(By.xpath(String.format(carBrandFilter, brandName)));
        return filterValue;
    }


    public int carTitleOnPage(String brandName) {
        List<WebElement> carTitle = driver.findElements(By.xpath(String.format(carBrandTitle, brandName)));
        return carTitle.size();
    }


    public int getItemsCountOnPage(){
        String itemCount = pagination.getText();
        String temp = itemCount.substring(itemCount.indexOf("-")+1,itemCount.indexOf("o"));
        return Integer.parseInt(temp.replace(" ",""));
    }


    public int getImageItemsCountOnPage(){
        return carImages.size();
    }


    public int getStockNumbers(){
        return countOfNotEmptyAttributes(stockNumbers);
    }


    public int getMileages(){
        return countOfNotEmptyAttributes(mileages);
    }


    public int getFirstRegistrations(){
        return countOfNotEmptyAttributes(firstRegistrations);
    }

    public int getHorsepowers(){
        return countOfNotEmptyAttributes(horsepowers);
    }


    public int getFuelTypes(){
        return countOfNotEmptyAttributes(fuelTypes);
    }

    public int getGearboxes(){
        return countOfNotEmptyAttributes(gearboxs);
    }



    private int countOfNotEmptyAttributes(List<WebElement> listEl){
        int count=0;
        for (int i=0; i<listEl.size();i++){
            if(!(listEl.get(i).getText().equals(""))){
                count++;
            }
        }
        return count;
    }


}
