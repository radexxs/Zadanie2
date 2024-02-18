package pl.tmobile.pages;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuPage extends HomePage {

  private SelenideElement deviceButton = $x(".//button[contains(text(), 'Urządzenia')]");
  private SelenideElement smartWatchesLink = $x("(//span[text()='Bez abonamentu'])[2]");

  private SelenideElement deviceSubMenu = $x("(.//span[text()='Bez abonamentu'])[2]");
  Actions actions = new Actions(driver);

  public MenuPage(WebDriver driver) {
    super(driver);
  }

  public MenuPage moveToDeviceButton() {
    actions.moveToElement(deviceButton).perform();
    return this;
  }

  public MenuPage assertSubmenuIsVisible() {
    Assert.assertTrue(deviceSubMenu.isDisplayed());
    return this;
  }

  public SmartWatchesPage navigateToSmartWatches() {
    smartWatchesLink.click();
    return new SmartWatchesPage(driver);
  }
}
