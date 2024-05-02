package demo;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");

        String currentURL = driver.getCurrentUrl();

        if(currentURL.contains("calendar")){
            System.out.println("calendar present in the current URL");
        } else {
            System.out.println("calendar not present in the current URL");
        }
        System.out.println("end Test case: testCase01");
    }


    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        // driver.get("https://calendar.google.com/");
        // Thread.sleep(5000);

        WebElement dropdown = driver.findElement(By.xpath("(//div[@jsname='WjL7X'])[2]"));
        dropdown.click();

        driver.findElement(By.xpath("//ul[@jsname='rymPhb']/li/span[text()='Month']")).click();
        Thread.sleep(2000);

        String selectedView = driver.findElement(By.xpath("(//div[@jsname='WjL7X'])[2]//span")).getText();

        if(selectedView.equals("Month")){
            System.out.println("Month view is selected");
        } else {
            System.out.println("Month view is not selected");
        }
        
        driver.findElement(By.xpath("//div[text()='Create']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Task']")).click();
        Thread.sleep(2000);
        // driver.findElement(By.xpath("//h2[contains(@class,'F262Ye')]/..")).click();
        // driver.findElement(By.xpath("//div[text()='Task']")).click();

        driver.findElement(By.xpath("//div[@class='DgKtsd']//input")).sendKeys("Crio INTV Task Automation");
        driver.findElement(By.xpath("//div[contains(@class,'hpykHb')]//textarea")).sendKeys("Crio INTV Calendar Task Automation");
        driver.findElement(By.xpath("//span[text()='Save']/..")).click();
        Thread.sleep(1000);
        
        String message = driver.findElement(By.xpath("//div[@class='VYTiVb']")).getText();

        if(message.contains("Task created")){
            System.out.println("Task created message displayed correctly");
        } else {
            System.out.println("Task created mesaage not displayed");
        }

        System.out.println("end Test case: testCase02");
    }

    

    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        // driver.get("https://calendar.google.com/");
        // Thread.sleep(5000);

        driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']/..")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='wv9rPe']//button)[2]")).click();
        Thread.sleep(2000);

        String desc = "Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application";

        driver.findElement(By.xpath("//textarea")).clear();
        driver.findElement(By.xpath("//textarea")).sendKeys(desc);
        driver.findElement(By.xpath("//span[text()='Save']/..")).click();
        Thread.sleep(2000);

        // String message = driver.findElement(By.xpath("//div[@class='VYTiVb']")).getText();

        // if(message.contains("Task updated")){
        //     System.out.println("Task updated message displayed correctly");
        // } else {
        //     System.out.println("Task updated mesaage not displayed");
        // }

        driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']/..")).click();
        Thread.sleep(2000);

        String description = driver.findElement(By.xpath("//div[@class='toUqff D29CYb']")).getText();

        if(description.contains(desc)){
            System.out.println("Description updated successfully");
        } else {
            System.out.println("Updated description do not match the updated value");
        }

        driver.findElement(By.xpath("(//div[@class='wv9rPe']//button)[1]")).click();
        Thread.sleep(2000);

        System.out.println("end Test case: testCase03");
    }

    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        // driver.get("https://calendar.google.com/");
        // Thread.sleep(5000);

        driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']/..")).click();
        Thread.sleep(2000);

        String title = driver.findElement(By.xpath("//div[@class='nBzcnc OcVpRe fqZQ1b']//span")).getText();

        if(title.contains("Crio INTV Task Automation")){
            System.out.println("Title verified successfully");
        } else {
            System.out.println("Title verification failed");
        }

        driver.findElement(By.xpath("(//div[@class='pPTZAe']//button)[2]")).click();
        Thread.sleep(2000);

        String message = driver.findElement(By.xpath("//div[@class='VYTiVb']")).getText();

        if(message.contains("Task deleted")){
            System.out.println("Task deleted message displayed correctly");
        } else {
            System.out.println("Task deleted mesaage not displayed");
        }

        System.out.println("end Test case: testCase04");
    }

}
