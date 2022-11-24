package testsuite;
/*1. Create the package ‘browserfactory’ and create the class
with the name ‘BaseTest’ inside the ‘browserfactory’
package. And write the browser setup code inside the
class ‘Base Test’.
2. Create the package ‘testsuite’ and create the following
class inside the ‘testsuite’ package.
1. LoginTest
3. Write down the following test into ‘LoginTest’ class
 1. userSholdLoginSuccessfullyWithValid Credentials
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify the text “PRODUCTS”
2. verifyThatSixProductsAreDisplayedOnPage
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify that six products are displayed
 on page

 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;


public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        //For opening browser
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        clickOnElement(By.linkText("Sign In"));
        //verify text
        String expectedMessage = "Welcome Back!";
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='page__heading']"));
        Assert.assertEquals("Welcome Back!",expectedMessage,actualMessage);

}

@Test
public void verifyTheErrorMessage(){
        clickOnElement(By.linkText("Sign In"));
// enter Invalid Username
    sendTextToElement(By.id("user[email]"),"123@gmail.com");
    //Enter Invalid password field element
    sendTextToElement(By.name("user[password]"),"secret123");
    //click on LOGIN button
    clickOnElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
    //Verify the error message ‘Invalid email or password.
    String expectedMessage = "Invalid email or password.";
    String actualMessage = getTextFromElement(By.xpath("//li[text()='Invalid email or password.']"));
    Assert.assertEquals("Invalid email or password.",expectedMessage,actualMessage);


}
    @After
    public void tearDown(){
        closeBrowser();

    }
}
