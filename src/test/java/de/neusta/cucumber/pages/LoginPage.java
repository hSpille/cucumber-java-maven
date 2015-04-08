package de.neusta.cucumber.pages;

import static org.junit.Assert.assertTrue;

import de.neusta.cucumber.connector.WebConnector;

public class LoginPage {
  private static final String LOGIN_FORM_LOGIN_BUTTON = "loginForm:loginButton";
  private static final String TEXT_FIELD_LOGIN_NAME = "loginForm:login";
  private static final String TEXT_FIELD_LOGIN_PASSWORD = "loginForm:password";;
  
  private WebConnector connector;

  public LoginPage(WebConnector connector) {
    this.connector = connector;
  }
  
  @Given("^ich kann die Login Seite sehen$")
  public void ich_kann_die_Login_Seite_sehen() throws InterruptedException {
    connector.open("http://hspille2.vit.de:8080/gewebe-webapp/login.jsf"); 
    assertTrue(connector.isTextPresent("Spendermeldung","Benutzername","Passwort" ,"Anmeldung"));
  }
  
  
  @When("^ich logge mich in die Spenderdatenbank ein$")
  public void ich_logge_mich_in_die_Spenderdatenbank_ein() {
    connector.enterTextToField("user", TEXT_FIELD_LOGIN_NAME);
    connector.enterTextToField("passwort", TEXT_FIELD_LOGIN_PASSWORD);
    connector.click(LOGIN_FORM_LOGIN_BUTTON);
  }
}
