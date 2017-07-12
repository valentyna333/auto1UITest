import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by valentina.chycha on 10/07/2017.
 */
public class BaseTest {
    WebDriver driver;


    @BeforeSuite
    public void setUp(){
        //Setting only for Windows OC
        System.setProperty("webdriver.chrome.driver", "chromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        readPropertyFile();

    }



    Properties properties=new Properties();
    File file;
    FileInputStream fileInputStream;

    public void readPropertyFile(){
        try {
            file=new File("config.properties");
            fileInputStream=new FileInputStream(file);
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @AfterSuite
    public void close(){
        driver.quit();
    }


}

