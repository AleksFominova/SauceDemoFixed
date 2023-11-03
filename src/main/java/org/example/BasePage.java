package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    WebDriver driver;

    final int waitTimeBeforeClick = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTextToElement(String text, WebElement element){
        element.click();// вместо sent.Keys
        element.clear();
        element.sendKeys(text);
    }

    public boolean allElementsOfCollectionAreDisplayed(List<WebElement> collection){
        for (WebElement element:collection) {
            if (!element.isDisplayed()) {// если хотя бы один элемент вернул false
                return false;
            }
        }
            return true;

        }
        public void refreshPage(){
        driver.navigate().refresh(); //обновит страницу
        }

        public void clickOnTheElement(WebElement element){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeBeforeClick));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

        }


}
