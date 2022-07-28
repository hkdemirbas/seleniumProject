package util;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    protected static WebDriver driver;
    public static WebDriver driver() {
        return driver;
    }
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromeDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.kariyer.net");
    }

    public void tearDown(){
        driver.quit();
    }

}
