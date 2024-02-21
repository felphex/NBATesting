package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MerchandisePurchasePage {
	private WebDriver driver;
	
	
	//locators for the elements
	private By searchField = By.xpath("//input[@id='typeahead-input-desktop']");
	private By addToCartButton = By.xpath("//button[@class='button large team-primary-colors primary false']");
	private By removeFromCartButton = By.xpath("(//button[@aria-label='Remove Item'])[1]");
	private By cartButton = By.xpath("//div[@role='complementary']//span[@role='presentation'][normalize-space()='1']");
	private By checkoutButton = By.xpath("//button[@class='button large checkout-button primary false']");
	
	public MerchandisePurchasePage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void enterSearchField(String desiredSearch) {
		WebElement searchFieldElement = driver.findElement(searchField);
        searchFieldElement.sendKeys(desiredSearch);
    }
	
	public void enterDesiredTeam(String desiredTeam) { //dynamic xpath in team merch //a[@title="Chicago Bulls Team Shop"]
		String teamXPath = String.format("//a[@title='%s Team Shop']", desiredTeam);
	    WebElement teamElement = driver.findElement(By.xpath(teamXPath));
	    teamElement.click();
    }
	
	public void enterDesiredItem(String desiredItem) { //dynamic xpath in item //a[@title="Men's Chicago Bulls '47 Black Clean-Up Adjustable Hat"]
		String itemXPath = String.format("//a[@title='%s']", desiredItem);
	    WebElement itemElement = driver.findElement(By.xpath(itemXPath));
	    itemElement.click();
    }
	
	public void clickAddToCart() {
        WebElement addToCartButtonElement = driver.findElement(addToCartButton);
        addToCartButtonElement.click();
    }
	
	public boolean isItemDisplayed(String desiredItem) {
		String itemXPath = String.format("//a[contains(text(),'%s')]", desiredItem);
	    WebElement itemElement = driver.findElement(By.xpath(itemXPath));
        return itemElement.isDisplayed();
    }

	
	public void clickCartButton() {
        WebElement cartButtonElement = driver.findElement(cartButton);
        cartButtonElement.click();
    }
	
	public void clickRemoveFromCartButton() {
        WebElement removeFromCartButtonElement = driver.findElement(removeFromCartButton);
        removeFromCartButtonElement.click();
    }
	
	public void clickCheckoutButton() {
        WebElement checkoutButtonElement = driver.findElement(checkoutButton);
        checkoutButtonElement.click();
    }
	
}
