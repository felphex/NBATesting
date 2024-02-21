package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LogInPage;
import utils.TestSetup;

public class LogInTest {
	private WebDriver driver;
    private HomePage homePage;
    private LogInPage loginPage;

    @BeforeMethod
    public void setUp() {
    	driver = TestSetup.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LogInPage(driver);
    }

    @Test //valid log in
    public void testValidLogin() throws InterruptedException {
    	homePage.navigateToLogInPage();
        
        String username = "felphex@hotmail.com";
        String password = "2250E5f8!";
        
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
    }
    
    @Test //invalid log in
    public void testInvalidLogin() throws InterruptedException {
    	homePage.navigateToLogInPage();
        
        String username = "felphex@hotmail.com";
        String password = "wrongpassword123";
        
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.isLoginNotSuccessful(), "Login was not successful");
    }


    @AfterMethod
    public void tearDown() {
        TestSetup.tearDown();
    }
}