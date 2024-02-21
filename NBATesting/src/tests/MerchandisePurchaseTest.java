package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MerchandisePurchasePage;
import pages.SignUpPage;
import pages.TicketPurchasePage;
import utils.TestSetup;

public class MerchandisePurchaseTest {

	private WebDriver driver;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private TicketPurchasePage ticketPurchasePage;
    private MerchandisePurchasePage merchandisePurchasePage;

    @BeforeMethod
    public void setUp() {
        driver = TestSetup.getDriver();
        homePage = new HomePage(driver);
        merchandisePurchasePage = new MerchandisePurchasePage(driver);
    }

    @Test //test to use the search field, the xpath is found for the team but does not work with automation
    public void testSearchAndAddToCart() throws InterruptedException {
    	homePage.navigateToMerchandisePurchasePage();
    	Thread.sleep(20000);
    	merchandisePurchasePage.enterSearchField("Men's Chicago Bulls '47 Black Clean-Up Adjustable Hat");
        merchandisePurchasePage.enterDesiredItem("Men's Chicago Bulls '47 Black Clean-Up Adjustable Hat");
        merchandisePurchasePage.clickAddToCart();
        merchandisePurchasePage.clickCartButton();
        
        Assert.assertTrue(merchandisePurchasePage.isItemDisplayed("Men's Chicago Bulls '47 Black Clean-Up Adjustable Hat"), "Item was not added to the cart successfully");
        
        merchandisePurchasePage.clickCheckoutButton();
    }

    @Test //test to use the select team
    public void testSelectTeamAndAddToCart() throws InterruptedException {
    	homePage.navigateToMerchandisePurchasePage();
    	Thread.sleep(20000);
        merchandisePurchasePage.enterDesiredTeam("Chicago Bulls");
        merchandisePurchasePage.enterDesiredItem("Men's Chicago Bulls '47 Black Clean-Up Adjustable Hat");
        merchandisePurchasePage.clickAddToCart();
        merchandisePurchasePage.clickCartButton();
        
        Assert.assertTrue(merchandisePurchasePage.isItemDisplayed("Men's Chicago Bulls '47 Black Clean-Up Adjustable Hat"), "Item was not added to the cart successfully");
        
        merchandisePurchasePage.clickCheckoutButton();
    }
    
    @Test //test remove item from cart
    public void testRemoveItemFromCart() throws InterruptedException {
    	homePage.navigateToMerchandisePurchasePage();
    	Thread.sleep(20000);
        merchandisePurchasePage.enterDesiredTeam("Chicago Bulls");
        merchandisePurchasePage.enterDesiredItem("Men's Chicago Bulls '47 Black Clean-Up Adjustable Hat");
        merchandisePurchasePage.clickAddToCart();
        merchandisePurchasePage.clickCartButton();
        merchandisePurchasePage.clickRemoveFromCartButton();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}