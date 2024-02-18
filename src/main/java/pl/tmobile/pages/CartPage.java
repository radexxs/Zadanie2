package pl.tmobile.pages;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

  private SelenideElement startPrice = $x("//span[@data-qa='BKT_TotalupFront']");
  private SelenideElement monthlyPaymentAmount = $x("//span[@data-qa='BKT_SubTotalMonthly']");

  public CartPage(WebDriver driver) {
    super(driver);
  }


  public String getStartPriceValue() {
    return startPrice.getText();
  }

  public String getMonthlyPaymentAmountValue() {
    return monthlyPaymentAmount.getText();
  }

}