package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSetup {
	private static WebDriver driver;
	
	public static void initializeWebDriver() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.nba.com/");
    }
	
	//WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            initializeWebDriver();
        }
        return driver;
    }
    
    
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
