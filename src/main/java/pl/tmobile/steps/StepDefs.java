package pl.tmobile.steps;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertEquals;
import static com.codeborne.selenide.Selenide.open;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pl.tmobile.pages.*;

public class StepDefs {

  private final HomePage homePage;
  private final SmartWatchesPage smartWatchesPage;
  private final ProductPage productPage;
  private final CartPage cartPage;
  private final MenuPage menuPage;

  public StepDefs() {
    this.homePage = new HomePage(Context.getDriver());
    this.smartWatchesPage = new SmartWatchesPage(Context.getDriver());
    this.productPage = new ProductPage(Context.getDriver());
    this.cartPage = new CartPage(Context.getDriver());
    this.menuPage = new MenuPage(Context.getDriver());
  }

  String promisedStartPrice;
  String promisedMonthlyPaymentAmount;
  String cartStartPrice;
  String cartMonthlyPaymentAmount;

  @Then("Uzytkownik powinien zobaczyc strone glowna TMobile")
  public void uzytkowniPowinienemzobaczycstronegłównaTMobile(){
    Assert.assertEquals("https://www.t-mobile.pl/", getWebDriver().getCurrentUrl());
  }

  @When("Uzytkownik wybiera sekcje Urzadzenia i wybiera te bez abonamentu")
  public void uzytkownikWybieraSekcjeUrzadzeniaIWybierateBezAbonamentu(){
    menuPage.navigateToSmartWatches();
  }

  @When("Uzytkownik wybiera urządzenia z menu")
  public void uzytkownikWybieraUrzadzeniaZMenu(){
    menuPage.moveToDeviceButton();
  }

  @Then("Widoczna jest rozlijalna lista")
  public void widocznaJestRozwijalnaLista(){
    menuPage.assertSubmenuIsVisible();
  }

  @Then("Powinna zostac wyswietlona lista smartfonow")
  public void powinnaZostacWyswietlonaListaSmartfonow(){
    $$x(".//*[contains(@data-qa, 'LST_ProductCard')]").shouldBe(sizeGreaterThan(0));
  }

  @When("Klikam w pierwszy element z listy smartfonow")
  public void klikamWPierwszyElementZListySmartfonow(){
    smartWatchesPage.selectFirstSmartWatches();
  }

  @Then("Powinna zostac wyswietlona strona produktu")
  public void powinnaZostacWyswietlonaStronaProduktu(){
    $x(".//h1[@data-qa='PRD_ProductName']").shouldBe(visible);
  }

  @When("Dodaje produkt do koszyka")
  public void dodajeProduktDoKoszyka (){
    promisedStartPrice = productPage.getStartPriceValue();
    promisedMonthlyPaymentAmount = productPage.getMonthlyPaymentAmountValue();
    productPage.addProductToBasket();
  }

  @Then("Strona Twoj koszyk zostaje wyswietlona z odpowiednimi kwotami")
  public void stronaTwojKoszykZostajeWyswietlonaZOdpowiednimiKwotami(){
    cartStartPrice = cartPage.getStartPriceValue();
    cartMonthlyPaymentAmount = cartPage.getMonthlyPaymentAmountValue();

    Assert.assertEquals("Cena na start się nie zgadza.", promisedStartPrice, cartStartPrice);
    Assert.assertEquals("Miesięczna rata się nie zgadza.",promisedMonthlyPaymentAmount, cartMonthlyPaymentAmount);
  }

  @When("Uzytkownik wraca na strone głown TMobile")
  public void uzytkownikWracaNaStroneGlownaTMobile(){
    open("/");
  }

  @Then("Widoczna jest ikonka koszyka z liczba produktow w koszyku")
  public void widocznaJestIkonkaKoszykaZLiczbaProduktowWKoszyku(){
    assertEquals("Niepoprawna wartość", "1", homePage.getBasketIconProductQuantity());
    getWebDriver().quit();
  }

}