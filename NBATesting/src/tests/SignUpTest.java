package tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SignUpPage;
import utils.TestSetup;

public class SignUpTest{

	private WebDriver driver;
    private HomePage homePage;
    private SignUpPage signUpPage;

    @BeforeTest
    public void setUp() {
        driver = TestSetup.getDriver();
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @Test //valid sign up
    public void testValidSignUp() {
        // Navigate to the sign-up page
        homePage.navigateToSignUpPage();

        // Perform sign-up with valid credentials
        signUpPage.enterEmail("control@risk.com");
        signUpPage.enterPassword("controlrisk123");
        signUpPage.enterFirstName("Felix");
        signUpPage.enterLastName("Saldana");
        signUpPage.enterMonth("January");
        signUpPage.enterYear("1999");
        signUpPage.enterCountry("Panama");
        signUpPage.clickSignUpButton();

        // Assert that sign-up is successful
        Assert.assertTrue(signUpPage.isSignUpSuccessful(), "Sign up was not successful");
    }
    
    @Test //invalid sign up
    public void testInvalidSignUp() {
        // Navigate to the sign-up page
        homePage.navigateToSignUpPage();

        // Perform sign-up with valid credentials
        signUpPage.enterEmail("control@risk.com");
        signUpPage.enterPassword("controlrisk123"); //no capital letter = error
        signUpPage.enterFirstName("Felix");
        signUpPage.enterLastName("Saldana");
        signUpPage.enterMonth("January");
        signUpPage.enterYear("1999");
        signUpPage.enterCountry("Panama");
        signUpPage.clickSignUpButton();

        // Assert that sign-up is successful
        Assert.assertTrue(signUpPage.isSignUpNotSuccessful(), "Sign up was successful");
    }
    

    @AfterTest
    public void tearDown() {
        TestSetup.tearDown();
    }
}
