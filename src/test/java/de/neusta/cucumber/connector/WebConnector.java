package de.neusta.cucumber.connector;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;

public class WebConnector {
  private final static long DEFAULT_TIMEOUT = 500;
  private WebDriver driver;

  public WebConnector() throws MalformedURLException {

    Proxy proxy = new Proxy();
    proxy.setProxyType(ProxyType.AUTODETECT);
    DesiredCapabilities dc = DesiredCapabilities.firefox();
    dc.setPlatform(Platform.WINDOWS);
    dc.setCapability(CapabilityType.PROXY, proxy);
    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

  }

  @Before
  public void initSelenium() throws Exception {
  }

  @After
  public void destroySelenium() {
    System.out.println("Closing connection");
    driver.close();
  }

  public void clickAndWait(String selector) {
    WebElement element = driver.findElement(By.id(selector));
    element.click();
    driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
  }

  public void click(String selector) {
    WebElement element = driver.findElement(By.id(selector));
    element.click();
  }
  
  public void clickElement(WebElement element){
    element.click();
  }
  
  public void open(String location) {
    driver.get(location);
    // driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT,
    // TimeUnit.MILLISECONDS);
  }

  public boolean isTextPresent(String... text) {
    WebElement content = driver.findElement(By.tagName("body"));
    boolean toReturn = true;
    String contentText = content.getText();
    for (String string : text) {
      if(!contentText.contains(string)){
        toReturn = false;
      }
    }
    return toReturn;
  }
  
  public boolean enterTextToField(String text, String field) {
    WebElement content = driver.findElement(By.id(field));
    boolean toReturn = false;
    if(content != null){
      content.sendKeys(text);
      toReturn = true;
    }
    return toReturn;
  }

  public List<WebElement> findeElementeDieDenTextEnthalten(String testRegionKuerzel) {
     List<WebElement> elements = driver.findElements(By.partialLinkText(testRegionKuerzel));
     return elements;
  }

  public String textImTextfeld(String text) {
    WebElement element = driver.findElement(By.id(text));
    if("input".equalsIgnoreCase(element.getTagName())){
      return element.getAttribute("value");
    }
    return null;
  }

  public List<WebElement> findeElementeByTag(String tagName) {
      return driver.findElements(By.tagName(tagName));
  }

  
}
