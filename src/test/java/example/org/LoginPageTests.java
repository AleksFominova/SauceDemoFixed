package example.org;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.example.LoginPage;
import org.example.User;
import org.junit.Assert;
import org.junit.Test;

public class LoginPageTests extends TestsBase {




    @Test @Description("Login with valid data") @Feature("Login") @Story("Login with valid data")
    public void loginWithValidData(){



        User user = new User(username, password);//создали нового user
       // LoginPage loginPage = new LoginPage(driver);// создали новый экдемляр страницы
        //InventoryPage inventoryPage = new InventoryPage(driver);
        new LoginPage(driver).login(user).InventoryListShouldBeDisplayed();}//залогинились, и сразу проверили
        // что отображается inventory page






    @Test
    public void lockedOutUser(){
        User lockedOutUser = new User(lockedOutUserName, lockedOutPassword);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(lockedOutUser);
        loginPage.loginButtonShouldBeDisplayed();
        loginPage.loginButton.click();
        loginPage.errorMessageShouldBeDisplayed();
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Epic sadface: Sorry, this user has been locked out."));


    }
    @Test
    public void testAllFieldsPresence() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.allFieldsArePresent();

    }
}





