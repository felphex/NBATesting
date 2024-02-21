package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    // elements on the home page
    private By signInBox = By.xpath("(//button[@type='button'])[3]");
    private By loginButton = By.xpath("//a[normalize-space()='Sign in with NBA ID']");
    private By signUpButton = By.xpath("(//a[normalize-space()='Don't have an NBA ID?'])");
    private By ticketsBox = By.cssSelector("a[href='https://nbatickets.nba.com/?cid=nba:tickets:institutional:nbacom:domsites:rd'][data-is-external='false'][data-has-more='false'][data-has-children='true'][data-track='click'][data-type='link'][data-pos='18/18']");
    private By buyTickets = By.xpath("//a[normalize-space()='NBATickets.com']");
    private By storeButton = By.xpath("//span[normalize-space()='Store']");
    
    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToLogInPage() {
        driver.findElement(signInBox).click();
        driver.findElement(loginButton).click();
    }
    
    public void navigateToSignUpPage() {
        driver.findElement(signInBox).click();
        driver.findElement(loginButton).click();
        driver.findElement(signUpButton).click();
    }
    
    public void navigateToTicketPurchasePage() { //is not working
    	//driver.get("https://nbatickets.nba.com/?cid=nba:tickets:institutional:nbacom:domsites:rd");
        driver.findElement(ticketsBox).click();
        driver.findElement(buyTickets).click();
        System.out.println("clicks ticketsbox");
    }
    
    public void navigateToMerchandisePurchasePage() {
        driver.findElement(storeButton).click();
    }

 // Method to check if login link is displayed
    public boolean isLoginLinkDisplayed() {
        WebElement login = driver.findElement(signInBox);
        return login.isDisplayed();
    }

    // Method to click on the login link
    public void clickLoginLink() {
    	driver.findElement(signInBox).click();
        WebElement login = driver.findElement(loginButton);
        login.click();
    }

    // Additional methods for interacting with other elements on the home page can be added here
}