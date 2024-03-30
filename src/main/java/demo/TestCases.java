package demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public  void testCase01() throws InterruptedException{

        System.out.println("Start Test case: testCase01");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
       
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement nameTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-labelledby='i1' or @class='ndJi5d snByac']")));
        nameTextbox.sendKeys("Archita");
        
        Thread.sleep(3000);
        WebElement questionField = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        questionField.sendKeys("To become proficient in writing automation code.");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        Thread.sleep(3000);
        WebElement selectCheckBox = driver.findElement(By.xpath("//div[@id='i13']"));
        selectCheckBox.click();

        Thread.sleep(3000);
        WebElement selectOptions = driver.findElement(By.xpath("//div[@id='i33']"));
        selectOptions.click();


        Thread.sleep(3000);

        WebElement selectDropdown = driver.findElement(By.xpath("//span[text()='Choose']"));
        selectDropdown.click();

        Thread.sleep(3000);

        String option = "Mrs";
        List<WebElement> allOptions = driver.findElements(By.xpath("//div/span[contains(text(),'"+option+"')]"));
      
        // Iterate the list using for loop
        for (int i = 0; i < allOptions.size(); i++) {

         if (allOptions.get(i).getText().contains(option)) {

       allOptions.get(i).click();

         System.out.println("clicked");

          break;
        }
     }
        
        Thread.sleep(3000);
        LocalDateTime currentDateObj = LocalDateTime.now().minusDays(7);
        DateTimeFormatter myDateformatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formatteddate = currentDateObj.format(myDateformatObj);

        WebElement selectDate = driver.findElement(By.xpath("//input[@type='date']"));
        selectDate.clear();
        Thread.sleep(2000);
        selectDate.sendKeys(formatteddate);
        selectDate.sendKeys(Keys.ENTER);

        
        Thread.sleep(2000);
        WebElement timeinHrs = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        timeinHrs.sendKeys("16");

        Thread.sleep(3000);
        WebElement timeinMin = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        timeinMin.sendKeys("20");

        Thread.sleep(2000);

        WebElement clickonSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
        clickonSubmit.click();

        Thread.sleep(2000);


        System.out.println("end Test case: testCase01");
    }


    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
}
