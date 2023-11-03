package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {



    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;


    @FindBy(id = "login-button")
    public
    WebElement loginButton;


    @FindBy(id = "inventory_container")
    private WebElement inventoryList;

    @FindBy(css = "[data-test='error']")
    public
    WebElement errorMessage;

    @FindBy(css = ".login_logo")
    private WebElement logo;

    @FindBy(id = "login_credentials")
    private WebElement acceptedUsernames;
    @FindBy(css = "div.login_password")
    private WebElement passwordColumn;


    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void login(String usernameParam, String passwordParam) {
        userName.sendKeys(usernameParam);
        password.sendKeys(passwordParam);
        loginButton.click();

    }


    @Step("Filling in username, password and push the Login button")
    public InventoryPage login(User user) {
        enterTextToElement(user.getUsername(), userName);//вызываем текст-user.getName, в userName
        //userName.click();// нажмет на поле
        //userName.clear();// очистит данные
        //userName.sendKeys(user.getName());//введет данные
        enterTextToElement(user.getPassword(), password);
        // password.click();
        // password.clear();
        // password.sendKeys(user.getPassword());
        loginButton.click();
        return new InventoryPage(driver);// возвращает новый экземпляр класса с новой страницей
    }


    public boolean loginButtonShouldBeDisplayed() {
        return loginButton.isDisplayed();

    }

    public void errorMessageShouldBeDisplayed() {
        assertTrue(errorMessage.isDisplayed());
    }

    public void allFieldsArePresent() {
     assertTrue(logo.isDisplayed());
     assertTrue (userName.isDisplayed());
     assertTrue (password.isDisplayed());
     assertTrue(loginButton.isDisplayed());
     assertTrue (acceptedUsernames.isDisplayed());
     assertTrue (passwordColumn.isDisplayed());
    }
}



