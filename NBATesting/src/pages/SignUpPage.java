package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	private WebDriver driver;

    // Locators for elements on the sign up page
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By monthDropdownField = By.xpath("//select[@name='dobMonth']");
    private By yearDropdownField = By.xpath("//select[@name='dobyear']");
    private By countryDropdownField = By.xpath("//select[@name='country']");
    private By termsOfUseCheckbox = By.id("");
    private By recaptchaCheckbox = By.id("");
    private By signUpButton = By.xpath("//button[contains(text(),'Sign Up')]");
    private By successMessage = By.xpath("//h1[normalize-space()='Follow Your Favorite Teams']");
    private By errorMessage = By.xpath("//p[@class='Input_text__1eMN5']");
    
    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter email
    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }

    // Method to enter password
    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    // Method to enter first name
    public void enterFirstName(String firstName) {
        WebElement firstNameElement = driver.findElement(firstNameField);
        firstNameElement.sendKeys(firstName);
    }

    // Method to enter first name
    public void enterLastName(String lastName) {
        WebElement lastNameElement = driver.findElement(lastNameField);
        lastNameElement.sendKeys(lastName);
    }
    
    public void enterMonth(String month) {
    	WebElement monthDropdownElement = driver.findElement(monthDropdownField);
        Select select = new Select(monthDropdownElement);
        select.selectByVisibleText(month);
    }
    
    public void enterYear(String year) {
    	WebElement yearDropdownElement = driver.findElement(yearDropdownField);
        Select select = new Select(yearDropdownElement);
        select.selectByVisibleText(year);
    }
    
    public void enterCountry(String country) {
    	WebElement countryDropdownElement = driver.findElement(countryDropdownField);
        Select select = new Select(countryDropdownElement);
        select.selectByVisibleText(country);
    }
    
    
    
    // Method to click on the sign up button
    public void clickSignUpButton() {
        WebElement signUpButtonElement = driver.findElement(signUpButton);
        signUpButtonElement.click();
    }
    
    public boolean isSignUpSuccessful() {
        return driver.findElement(successMessage).isDisplayed();
    }
    
    public boolean isSignUpNotSuccessful() {
        return driver.findElement(successMessage).isDisplayed();
    }

    // Method to get error message text
    public String getErrorMessage() {
        WebElement errorMessageElement = driver.findElement(errorMessage);
        return errorMessageElement.getText();
    }

}
