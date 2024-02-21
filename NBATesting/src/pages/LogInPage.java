package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LogInPage {
	private WebDriver driver;

    // Locators for elements on the login page
    private By usernameField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("(//button[@id='submit'])");
    private By profileBox = By.xpath("(//button[@type='button'])[3]");
    private By myAccount = By.xpath("//a[normalize-space()='My Account']");
    private By errorMessage = By.xpath("(//p[@class='SignIn_formError__QXKNi'])");
    
    
    // Constructor
    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter username
    public void enterUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    // Method to click on the login button
    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }

    // Method for errors JUST IN CASE!
    public String getErrorMessage() {
        WebElement errorMessageElement = driver.findElement(errorMessage);
        return errorMessageElement.getText();
    }
    
    //method for login successufl
    public boolean isLoginSuccessful() {
    	driver.findElement(profileBox).click();
        return driver.findElement(myAccount).isDisplayed();
    }
    
    public boolean isLoginNotSuccessful() {
        return driver.findElement(errorMessage).isDisplayed();
    }

}
