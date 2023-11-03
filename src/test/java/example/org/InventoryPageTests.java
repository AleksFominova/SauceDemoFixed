package example.org;

import org.example.InventoryPage;
import org.example.LoginPage;
import org.example.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InventoryPageTests extends TestsBase {

    @Test
    public void inventoryListIsDisplayed(){
        User user = new User(username, password);
        new LoginPage(driver).login(user).inventoryListIsDisplayed();

    }

    @Test
    public  void amountOfProducts(){
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkAllProductsAreDisplayed();
        inventoryPage.checkAmountOfProducts(6);
    }


    @Test
    public  void productsNames(){
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.allProductsNamesAreDisplayed();

    }

    @Test
    public  void productsPrices(){
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.allProductsPricesAreDisplayed();

    }
    @Test
    public  void buttonAddToCart(){
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.buttonAddToCartIsDisplayed();

    }
    @Test
    public  void productNameHasText(){
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkProductNameIsNotEmpty();

    }

    @Test
    public  void twitterIconIsPresent(){
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.twitterIconIsPresent();

    }


    @Test
    public void sideBar(){
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnTheSideBarIcon();;
        Assert.assertTrue(inventoryPage.allItemsAreDisplayed());
        inventoryPage.aboutIsDisplayed();
        //Assert.assertTrue(inventoryPage.aboutIsDisplayed());
        Assert.assertTrue(inventoryPage.logoutIsDisplayed());
        Assert.assertTrue(inventoryPage.resetAppStateIsDisplayed());
        Assert.assertTrue(inventoryPage.sidebarClosingButtonIsDisplayed());
        inventoryPage.clickSidebarClosingButton();
    }


}
