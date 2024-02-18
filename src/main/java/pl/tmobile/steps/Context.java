package pl.tmobile.steps;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class Context {

  static SelenideElement buttonCookies = $x(".//button[@id='didomi-notice-agree-button']");

  public static void closeCookieConsentMessage() {
    if (buttonCookies.isDisplayed()) {
      buttonCookies.click();
    }
  }

  public static WebDriver getDriver() {
    return getWebDriver();
  }

  @BeforeAll
  public static void before() {
    Configuration.browser = "chrome";
    Configuration.baseUrl = "https://www.t-mobile.pl";
    open("/");
    getWebDriver().manage().window().maximize();
    getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    closeCookieConsentMessage();
  }

  @AfterAll
  public static void after() {
    getWebDriver().quit();
  }

}