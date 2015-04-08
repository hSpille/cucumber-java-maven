package de.neusta.cucumber.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.neusta.cucumber.connector.WebConnector;

public class UebersichtSeiteGSK {

  private final WebConnector connector;
  private static final String TEST_REGION_KUERZEL = "VIT";

  public UebersichtSeiteGSK(WebConnector connector) {
    this.connector = connector;

  }

  @Then("^sollte ich die Uebersicht sehen$")
  public void sollte_ich_die_Uebersicht_sehen() throws InterruptedException {
    Thread.sleep(3000);
    assertTrue(connector.isTextPresent("Schreibtisch", "Akte erstellen"));
  }

  @When("^ich eine beliebige Akte oeffne$")
  public void ich_eine_beliebige_Akte_oeffne() {
    List<WebElement> elements = connector.findeElementeDieDenTextEnthalten(TEST_REGION_KUERZEL);
    for (WebElement webElement : elements) {
      if ("a".equalsIgnoreCase(webElement.getTagName())) {
        System.out.println("Oeffne Akte " + webElement.getText());
        connector.clickElement(webElement);
        break;
      }
    }
  }

  @When("^ich eine neue akte erstelle und diese oeffne$")
  public void ich_eine_neue_akte_erstelle_und_diese_oeffne() throws InterruptedException {
    String aktuelleZeit = connector.textImTextfeld("spendermeldung_form:meldezeitpunktCalendar_input");
    assertTrue(aktuelleZeit != null);
    connector.clickAndWait("spendermeldung_form:spenderakte_anlegen_button");
    System.out.println("Text im Textfeld:" + aktuelleZeit);
    String uhrZeit = aktuelleZeit.substring((aktuelleZeit.indexOf(":") - 2), (aktuelleZeit.indexOf(":") + 3)).replace(":", "");
    Thread.sleep(2000);
    List<WebElement> potenzielleAngelegteAkten = connector.findeElementeDieDenTextEnthalten(uhrZeit);
    assertTrue(potenzielleAngelegteAkten.size() != 0);
    WebElement webElement = potenzielleAngelegteAkten.get(0);
    connector.click(webElement.getAttribute("id"));
  }

}
