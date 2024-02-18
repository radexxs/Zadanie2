package pl.tmobile.pages;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

  private SelenideElement basketIcon = $x(".//a[@data-ma='menu-basket']//div");

  public HomePage(WebDriver driver) {
    super(driver);
  }


  public String getBasketIconProductQuantity() {
    return basketIcon.getText();
  }

}