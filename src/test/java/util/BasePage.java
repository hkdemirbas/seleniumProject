package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    WebDriver driver = null;
    WebDriverWait wait = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,60);
    }

    public WebElement findElement(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public void sendKeys(By by, String text){
        findElement(by).clear();
        findElement(by).sendKeys(text);
    }

    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    protected void writeText(By elementBy, int index, String text) {
        List<WebElement> list = driver.findElements(elementBy);
        WebElement element = list.get(index);
        element.clear();
        element.sendKeys(text);
    }
    protected String readText(By elementBy) {
        waitClickable(elementBy);
        highlightElement(driver.findElement(elementBy));
        return driver.findElement(elementBy).getText();
    }
    protected void waitClickable(By elementBy) {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }
    private void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                "color: red; border: 1px dashed red;");
    }

}