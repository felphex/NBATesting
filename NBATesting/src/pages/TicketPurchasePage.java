package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TicketPurchasePage {
	private WebDriver driver;
	
	//locators for the elements
	private By weekField = By.xpath("//select[@class='ng-pristine ng-valid ng-touched']");
	private By favoriteTeamField = By.xpath("//select[@ng-model='selectedTeam']");
	private By findTicketsButton = By.xpath("//a[normalize-space()='Find Tickets']");
	
	private By opponentTeamField = By.cssSelector("span.large-12.columns.schedule-game__team.ng-binding");
	private By cheapestTicket = By.xpath("//button[@id='quickpick-buy-button-qp-0']");
	
	public TicketPurchasePage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void enterWeek(String weekNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        WebElement ticketsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(weekField));
    	WebElement weekDropdownElement = driver.findElement(weekField);
        Select select = new Select(weekDropdownElement);
        select.selectByVisibleText(weekNumber);
    }
	
	public void enterFirstTeam(String favoriteTeam) { //atlanta hawks
    	WebElement firstTeamDropdownElement = driver.findElement(favoriteTeamField);
        Select select = new Select(firstTeamDropdownElement);
        select.selectByVisibleText(favoriteTeam);
    }
	
	public void clickFindTicketsButton() {
        WebElement findTicketsButtonElement = driver.findElement(findTicketsButton);
        findTicketsButtonElement.click();
    }
	
	public void enterSecondTeam(String opponentTeam) { //utah jazz
		List<WebElement> secondTeams = driver.findElements(opponentTeamField);
		for(int i=0;i<secondTeams.size();i++) {
			String secondTeam = secondTeams.get(i).getText();
			if(secondTeam.contains(opponentTeam)&&i%2==0) { //teams comes in pairs and theres only one buy ticket button
				int buttonIndex=i-1;
				driver.findElements(By.xpath("//a[@class='schedule-game__tix-button ng-scope']")).get(buttonIndex).click();
			}else {
				driver.findElements(By.xpath("//a[@class='schedule-game__tix-button ng-scope']")).get(i).click();
			}
			
		}
    }
	
	public void buyTicket() {
        WebElement cheapestTicketElement = driver.findElement(cheapestTicket);
        cheapestTicketElement.click();
    }
	
	
}
