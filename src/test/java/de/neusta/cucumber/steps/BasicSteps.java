package de.neusta.cucumber.steps;

import cucumber.api.java.en.Given;
import de.neusta.cucumber.connector.WebConnector;
import de.neusta.cucumber.pages.LoginPage;
import de.neusta.cucumber.pages.UebersichtSeiteGSK;

public class BasicSteps {

  
  private LoginPage login;
  private UebersichtSeiteGSK uebersichtGsk;

  public BasicSteps(WebConnector connector, LoginPage login, UebersichtSeiteGSK uebersichtGsk) {
    this.login = login;
    this.uebersichtGsk = uebersichtGsk;
  }

  @Given("^ich bin eingeloggt auf der uebersichtsseite$")
  public void ich_bin_eingeloggt_auf_der_uebersichtsseite() throws InterruptedException {
    login.ich_kann_die_Login_Seite_sehen();
    login.ich_logge_mich_in_die_Spenderdatenbank_ein();
    Thread.sleep(1000);
    uebersichtGsk.sollte_ich_die_Uebersicht_sehen();
  }

  

 

}
