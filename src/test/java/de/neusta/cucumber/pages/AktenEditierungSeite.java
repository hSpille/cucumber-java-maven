package de.neusta.cucumber.pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.neusta.cucumber.connector.WebConnector;

public class AktenEditierungSeite {

  private final WebConnector connector;

  public AktenEditierungSeite(WebConnector connector) {
    this.connector = connector;

  }

  @When("^ich die spendeart MOD auswaehle$")
  public void ich_die_spendeart_MOD_auswaehle() throws InterruptedException {
    connector.click("spenderakte_bearbeiten_akkordeon:anamnese_tabview:form00_auswahl:formular0_spendeart:1");
    Thread.sleep(1000);
  }

  @When("^ich den spendetyp OG auswaehle$")
  public void ich_den_spendetyp_OG_auswaehle() throws InterruptedException {
    connector.click("spenderakte_bearbeiten_akkordeon:anamnese_tabview:form00_auswahl:formular0_vorgesehen_fuer_og_input");
    Thread.sleep(1000);
  }

  @When("^ich die vorgesehene spendeart speichere$")
  public void ich_die_vorgesehene_spendeart_speichere() throws InterruptedException {
    connector.click("spenderakte_bearbeiten_akkordeon:anamnese_tabview:form00_auswahl:speichernSpendeart");
    Thread.sleep(1500);
  }

  @Then("^sollte vorgesehene spendearten valide sein$")
  public void sollte_vorgesehene_spendearten_valide_sein() throws Throwable {
    List<WebElement> elemente = connector.findeElementeByTag("h3");
    for (WebElement webElement : elemente) {
      if(webElement.getText() !=null){
        if ("Vorgesehene Spendearten".equalsIgnoreCase(webElement.getText())) {
          org.junit.Assert.assertTrue(webElement.getCssValue("background-color").equalsIgnoreCase("rgba(0, 128, 0, 1)"));
          return;
        }
      }
    }
    assertTrue(false);
  }

  @When("^ich auf akte drucken klicke$")
  public void ich_auf_akte_drucken_klicke() throws Throwable {
    // Express the Regexp above with the code you wish you had
    connector.click("akteDruckenForm:akte_drucken");
    Thread.sleep(8000);
  }

  @Then("^sollte sich ein pdf oeffnen$")
  public void sollte_sich_ein_pdf_oeffnen() throws Throwable {
    assertFalse(connector.isTextPresent("Es ist ein Fehler aufgetreten"));
  }
  
  @Then("^sollte ich die sechs accordions sehen$")
  public void sollte_ich_die_sechs_accordions_sehen() throws InterruptedException {
    Thread.sleep(8000);
    assertTrue(connector.isTextPresent("Anamnese", "Freigabe Spendeakte"));
  }

}
