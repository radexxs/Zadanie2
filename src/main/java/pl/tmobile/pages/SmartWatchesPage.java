package pl.tmobile.pages;

import static com.codeborne.selenide.Selenide.$$x;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebDriver;

public class SmartWatchesPage extends BasePage {
  private ElementsCollection firstSmartWatch = $$x(".//*[contains(@data-qa, 'LST_ProductCard')]");

  public SmartWatchesPage(WebDriver driver) {
    super(driver);
  }

  public ProductPage selectFirstSmartWatches() {
    firstSmartWatch.get(0).click();
    return new ProductPage(driver);
  }

}