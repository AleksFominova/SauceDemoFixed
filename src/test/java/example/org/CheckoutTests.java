package example.org;

import org.example.*;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;


public class CheckoutTests extends TestsBase{


    @Test
    public void checkQuantityOfProducts(){
        User user = new User(username, password);// залогинились
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOAddToCartBackpack();
        inventoryPage.clickOnAddToCartBikeLight();
        inventoryPage.clickTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterFirstName("Harry");
        checkoutStepOnePage.enterLastName("Belly");
        checkoutStepOnePage.enterZipCode("123");
        checkoutStepOnePage.pushContinueButton();
        CheckoutStepTwoPage  checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        Assert.assertTrue(checkoutStepTwoPage.checkProductCardsQuantity(2));
        assertThat(checkoutStepTwoPage.getProductCards(),hasSize(2));

    }
}
