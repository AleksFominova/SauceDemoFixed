package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.util.EnumSet.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;



public class InventoryPage extends BasePage {



    //@FindBy(id = "inventory_container")
    @FindBy (css = "[class='inventory_list']")
    private WebElement inventoryList;

    @FindBy(css = "[class='inventory_item']")
    private List<WebElement> productCards;

    @FindBy(css = "[class='inventory_item_name']")
    private List<WebElement> productsNames;

    @FindBy(css = "[class='inventory_item_price']")
    private List<WebElement> productsPrice;

    @FindBy(css = "[class='btn btn_primary btn_small btn_inventory']")
    private List<WebElement> buttonsAddToCart;

    @FindBy(xpath = "//a[@href='https://twitter.com/saucelabs']")
    private WebElement twitterIcon;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement sideBarOpenIcon;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItems;

    @FindBy(id = "about_sidebar_link")
    private WebElement about;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppState;
    @FindBy(id = "react-burger-cross-btn")
    private WebElement sidebarClosingButton;

    @FindBy(css = "class='bm-menu'")
    private WebElement sidebar;


    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCartButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeLightToCartButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void InventoryListShouldBeDisplayed() {
        assertTrue(inventoryList.isDisplayed());
    }

    public void checkAllProductsAreDisplayed() {
        for (WebElement product : //для каждого Webelement product из коллекция productCards сделай...
                productCards) {
            assertTrue(product.isDisplayed());

        }

    }

    public void checkAmountOfProducts(int expectedAmount) {
        assertEquals("Amount of products is not  " + expectedAmount, productCards.size(), expectedAmount);
        //вернет количемтво карточек, сравнит с expectedAmount
        //если тест упадет, то выйдет сообщение
        // assertThat(productCards, hasSzize(expectedAmount));
    }

    public void allProductsNamesAreDisplayed() {
        for (WebElement name :
                productsNames) {
            assertTrue(name.isDisplayed());

        }
    }

    public void checkProductNameIsNotEmpty() {
        for (WebElement text :
                productsNames) {
            assertFalse(text.getText().isEmpty());// проверит, что есть текст

        }

    }

    public void buttonAddToCartIsDisplayed() {
        for (WebElement button :
                productCards) {
            assertTrue(button.isDisplayed());


        }
    }

    public void allProductsPricesAreDisplayed() {
        for (WebElement price :
                productCards) {
            assertTrue(price.isDisplayed());
        }
    }

    public void twitterIconIsPresent() {
        assertTrue(twitterIcon.isDisplayed());

    }


    public void clickOnTheSideBarIcon() {
        clickOnTheElement(sideBarOpenIcon);
        // Matchers.
        // assertThat(sideBarOpenIcon.getAttribute("dhjm"), empty);


    }

    public void clickTheResetAppState() {
        clickOnTheElement(resetAppState);


    }

    public void clickSidebarClosingButton() {
        assertTrue(sidebarClosingButton.isDisplayed());
        clickOnTheElement(sidebarClosingButton);

    }


    public boolean allItemsAreDisplayed() {
        return allElementsOfCollectionAreDisplayed(productsNames);
    }

    public void aboutIsDisplayed() {
       // return about.isDisplayed();
        assertThat(about.isDisplayed(),is(true));
        assertThat(about.getAttribute("href"), startsWith("https://"));
       // assertThat(about.getText(),allOf(startsWith("https://"),containsString("saucedemo")));
    }

    public boolean logoutsDisplayed() {
        return logout.isDisplayed();
    }

    public boolean resetAppStateIsDisplayed() {
        return resetAppState.isDisplayed();
    }

    public boolean sidebarIsClosed() {
        return !sidebar.isDisplayed();
    }


    public void clickOAddToCartBackpack() {

        addBackpackToCartButton.click();
    }

    public void clickOnAddToCartBikeLight() {
        clickOnTheElement(addBikeLightToCartButton);
    }

    public void clickTheCartIcon() {
        clickOnTheElement(cartIcon);

    }

    public void resetAppState() {

        clickOnTheSideBarIcon();
        clickTheResetAppState();
        clickSidebarClosingButton();
        refreshPage();
    }


    //public void inventoryListShouldBeDisplayed() {
        //assertTrue(inventoryList.isDisplayed());
        //assertFalse("Element " + "is NOT visible", inventoryList.isDisplayed());
   // }

    public boolean logoutIsDisplayed() {
        return logout.isDisplayed();
    }

    public boolean sidebarClosingButtonIsDisplayed() {
        return sidebarClosingButton.isDisplayed();
    }

    public void inventoryListIsDisplayed() {
        assertTrue(inventoryList.isDisplayed());
        //assertFalse("Element " + "is NOT visible", inventoryList.isDisplayed());

    }
}




