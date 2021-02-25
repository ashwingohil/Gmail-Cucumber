package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import resources.Utils;
import static org.junit.Assert.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class StepDefinition extends Utils {

    WebDriver driver;
    String pageURL = "http://www.gmail.com";

    WebElement usernameBox;
    WebElement nextButton1;
    WebElement passwordBox;
    WebElement nextButton2;
    WebElement composeButton;
    WebElement toBox;
    WebElement subjectBox;
    WebElement attachButton;
    WebElement sendButton;


    public void setWait(long l){
        try{
            Thread.sleep(l);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }


    @Given("navigate to gmail page")
    public void navigate_to_gmail_page() {
        //CHANGE THE PATH OF DRIVER ACCORDINGLY
        System.setProperty("webdriver.gecko.driver","/home/ashwin/IdeaProjects/Gmail-Cucumber/geckodriver");
        this.driver = new FirefoxDriver();
        driver.get(pageURL);
    }


    @When("user logs in using username as {string} and password as {string}")
    public void user_logs_in_using_username_as_and_password_as(String username, String password) throws IOException {

        usernameBox = driver.findElement(By.cssSelector(getElement("usernameBox")));
        usernameBox.sendKeys(username);

        nextButton1 = driver.findElement(By.cssSelector(getElement("nextButton1")));
        nextButton1.click();

        setWait(2000);

        passwordBox = driver.findElement(By.cssSelector(getElement("passwordBox")));
        passwordBox.sendKeys(password);

        setWait(2000);

        nextButton2 = driver.findElement(By.cssSelector(getElement("nextButton2")));
        nextButton2.click();

        setWait(2000);
    }


    @Then("gmail account page title should contain {string}")
    public void gmail_account_page_title_should_contain(String expectedTitle) {

        String actualTitleString = null;
        String title = driver.getTitle();

        if(title.contains(expectedTitle)){

            actualTitleString = expectedTitle;
        }
        System.out.println("actual:"+actualTitleString);
        System.out.println("expected:"+expectedTitle);
        assertEquals(actualTitleString,expectedTitle);
    }


    @Given("User is at his account page with username as {string} and clicks on compose")
    public void user_is_at_his_account_page_with_username_as_and_clicks_on_compose(String expectedTitle) throws IOException {

        setWait(5000);
        composeButton = driver.findElement(By.cssSelector(getElement("composeButton")));
        composeButton.click();
        setWait(3000);
    }


    @When("user sends email with attachment to {string} and subject as {string}")
    public void user_sends_email_with_attachment_to_and_subject_as(String to, String subjectLine) throws AWTException,IOException{

        toBox = driver.findElement(By.cssSelector(getElement("toBox")));
        toBox.sendKeys(to);

        subjectBox = driver.findElement(By.cssSelector(getElement("subjectBox")));
        subjectBox.sendKeys(subjectLine);

        setWait(5000);

        attachButton = driver.findElement(By.cssSelector(getElement("attachButton")));
        attachButton.click();

        setWait(5000);

        //CHANGE THE PATH OF DUMMYDATA ACCORDINGLY
        StringSelection ss = new StringSelection("/home/ashwin/IdeaProjects/Gmail-Cucumber/dummydata");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(ss, null);

        Robot robot = new Robot();

        robot.delay(300);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(800);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        setWait(3000);

        sendButton = driver.findElement(By.cssSelector(getElement("sendButton")));
        sendButton.click();

    }

    @Then("in sent items email should be present with subject as {string}")
    public void in_sent_items_email_should_be_present_with_subject_as(String string) {
        //USE OF javax.mail api to parse the contents of sent folder emails by subject line
        //google blocks my sign in and validates authentication failure
    }
    @Then("a message should pop up stating {string}")
    public void a_message_should_pop_up_stating(String string) {

        //cannot inspect a dynamic element which is shorlived for 2 seconds. This step cannot be performed
    }


}
