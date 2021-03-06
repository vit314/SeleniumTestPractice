package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Checkout extends Base {
  public Checkout(WebDriver driver) {
    AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
    PageFactory.initElements(ajaxElementLocatorFactory, this);
  }

  private String errorFirstNameNotification = "Error: First Name is required";
  private String errorLastNameNotification = "Error: Last Name is required";
  private String errorPostalCodeNotification = "Error: Postal Code is required";


  private By firstNameField = By.xpath("//input[@id='first-name']");
  private By lastNameField = By.xpath("//input[@id='last-name']");
  private By postalCodeField = By.xpath("//input[@id='postal-code']");
  private By continueButton = By.xpath("//input[@class='btn_primary cart_buttons']");
  private By errorNotification = By.xpath("//h3");

  //"Fill field \"First Name\" with data ({firstname}), fill field \"Last Name\" with data ({lastName}), fill field \"Zip/Postal Code\" with data ({postalCode})")
  public void fillFields(String firstname, String lastName, String postalCode) {
    driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstname);
    driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
    driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(postalCode);
  }

  //"Click \"CONTINUE\" button on the Checkout page")
  public void clickContinueButton() {
    driver.findElement(continueButton).click();
  }

  //"Method returns notification with requirement of necessary about First Name")
  public String getErrorFirstNameNotification() {
    return errorFirstNameNotification;
  }

  //"Method returns notification with requirement of necessary about Last Name")
  public String getErrorLastNameNotification() {
    return errorLastNameNotification;
  }

  //"Method returns notification with requirement of necessary about Postal Code")
  public String getErrorPostalCodeNotification() {
    return errorPostalCodeNotification;
  }

  //"Method returns error notification")
  public String errorNotification() {
    return driver.findElement(errorNotification).getText();
  }
}