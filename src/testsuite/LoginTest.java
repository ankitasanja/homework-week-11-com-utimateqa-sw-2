package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /*
    1. userShouldNavigateToLoginPageSuccessfully
    * click on the ‘Sign In’ link
    * Verify the text ‘Welcome Back!’
    */
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Verify the text ‘Welcome Back!’
        String expectedMessage = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message", expectedMessage, actualMessage);
    }

    /*2. verifyTheErrorMessage
    * click on the ‘Sign In’ link
    * Enter invalid username
    * Enter invalid password
    * Click on Login button
    * Verify the error message ‘Invalid email
    or password.’
    */
    @Test
    public void verifyTheErrorMessage() {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("prime123@gmail.com");

        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("prime123");

        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify the error message ‘Invalid email or password.
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message", expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
