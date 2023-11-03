package example.org;

import io.qameta.allure.Story;
import org.example.CartPage;
import org.example.InventoryPage;
import org.example.LoginPage;
import org.example.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CartPageTests extends TestsBase {
  @Test
    public void cartPageIsOpen() {

        User user = new User(username, password);// залогинились
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        //inventoryPage.resetAppState();
        inventoryPage.clickOnTheSideBarIcon();
        inventoryPage.clickTheResetAppState();
        inventoryPage.clickSidebarClosingButton();
        inventoryPage.refreshPage();
        inventoryPage.clickOAddToCartBackpack();
        inventoryPage.clickTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.checkoutButtonIsDisplayed());


    }

    @Test
    public void addSeveralItems() {
        User user = new User(username, password);// залогинились
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOAddToCartBackpack();
        inventoryPage.clickOnAddToCartBikeLight();
        inventoryPage.clickTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.checkProductCardsQuantity(2));


    }

    @Test @Story("Check that cart is empty")
    public void cartIsEmpty() {
        User user = new User(username, password);// залогинились
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.cartIsEmpty());

    }
}
