package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {




    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "cart_item_label")
    private List<WebElement> productCards;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(id = "shopping_cart_container")
    WebElement cartIcon;

    @Step("Checkout button is displayed")
    public boolean checkoutButtonIsDisplayed() {
        return checkoutButton.isDisplayed();
    }

    //public int checkProductCardsQuantity(){
    //return productCards.indexOf(2);

    @Step("Get quantity of products")
    public boolean checkProductCardsQuantity(int expectedQuantity){
        return productCards.size() == expectedQuantity;

        }


    @Step("Click on teh checkout button")
    public void clickOnCheckoutButton(){
        clickOnTheElement(checkoutButton);
        }



    @Step("Cart is empty")
    public boolean cartIsEmpty() {
            boolean empty = false;
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
                wait.until(ExpectedConditions.visibilityOf(productCards.get(0)));

            } catch (Exception e) {
                empty = true;
            }
           return empty;
       }



    }

