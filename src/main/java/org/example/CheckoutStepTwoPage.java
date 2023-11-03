package org.example;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@Getter
public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cart_item_label")
    private List<WebElement> productCards;



    public boolean checkProductCardsQuantity(int expectedQuantity) {
        return productCards.size() == expectedQuantity;
    }
}
