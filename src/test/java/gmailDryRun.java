import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class gmailDryRun extends GmailUtility{

    WebDriver driver;

    @FindBy(how = How.CSS, css = "input#identifierId")
    WebElement usernameBox;

    @FindBy(how = How.CSS, css = "div.VfPpkd-RLmnJb")
    WebElement nextButton1;

    @FindBy(how = How.CSS, css = "input[type='password']")
    WebElement passwordBox;

    @FindBy(how = How.CSS, css = ".VfPpkd-LgbsSe-OWXEXe-k8QpJ > div:nth-child(3)")
    WebElement nextButton2;

    @FindBy(how = How.CSS, css = ".T-I-KE")
    WebElement composeButton;

    @FindBy(how = How.CSS, css = "textarea.vO[name='to']")
    WebElement toBox;

    @FindBy(how = How.CSS, css = "input[name='subjectbox']")
    WebElement subjectBox;

    @FindBy(how = How.CSS, css = "#\\:qe")
    WebElement attachButton;

    @FindBy(how = How.CSS, css = "div#\\:om")
    WebElement sendButton;



    public gmailDryRun(){

        ///home/ashwin/IdeaProjects/Gmail-Cucumber/geckodriver
        System.setProperty("webdriver.gecko.driver","/home/ashwin/IdeaProjects/Gmail-Cucumber/geckodriver");
        driver = new FirefoxDriver();
        PageFactory.initElements(driver,this);
    }


    public void gmailLogin(){

        driver.get("http://www.gmail.com");
        usernameBox.sendKeys("ashwin.k.gohil@gmail.com");
        nextButton1.click();

        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        passwordBox.sendKeys("!Nopassword9979737596");

        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        nextButton2.click();

    }

    public void composeFunction() throws AWTException{

        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        composeButton.click();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        toBox.sendKeys("ashwin.k.gohil@gmail.com");

        subjectBox.sendKeys("My data");

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }


        //attachButton.sendKeys("/home/ashwin/IdeaProjects/Gmail-Cucumber/dummydata.txt");
        attachButton.click();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        ///home/ashwin/IdeaProjects/Gmail-Cucumber/dummydata
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


        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        sendButton.click();
    }




    public static void main(String[] args){


        gmailDryRun object = new gmailDryRun();


        object.gmailLogin();
        try {
            object.composeFunction();
        }catch(AWTException ex){
            ex.printStackTrace();
        }



    }


}
