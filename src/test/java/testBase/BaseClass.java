package testBase;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.ExtentReportManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
//java -jar selenium-server-4.18.1.jar standalone


public class BaseClass extends ExtentReportManager {
    public static WebDriver driver ;
    public Logger logger;
    public static WebDriverWait myWait;

    static public Properties p;


    @BeforeClass(groups = {"sanity","regression","master"})
    @Parameters({"browser","os"})
    public void setUp(@Optional("chrome")String br, @Optional("windows")String os) throws IOException {
        //loading properties file
        FileReader file = new FileReader(".//src/test/java/resources/config.properties");
        p = new Properties();
        p.load(file);
        //loading log4j2 file
        logger = LogManager.getLogger(this.getClass());//log4j
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            //os
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No match for os");
                return;
            }
            //browser
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("edge");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("No match for browser");
            }
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        } else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            //local
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("No matching browser");
                    return;
            }

        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get(p.getProperty("appUrl"));


    }
    @AfterClass(groups = {"sanity","regression","master"})
    public void tearDown(){
        driver.close();
    }

    public static String generateName() {
        // Get today's date
        LocalDate today = LocalDate.now();

        // Format the date
        String formattedDate = today.toString();

        // Generate a random number
        Random random = new Random();
        int randomNumber = random.nextInt(1000); // Change 1000 to your desired upper limit
        StringBuilder randomAlphabets = new StringBuilder();
        for (int i = 0; i < 3; i++) { // Change 3 to the desired length of random alphabets
            char randomChar = (char) ('A' + random.nextInt(26)); // Generate a random uppercase alphabet
            randomAlphabets.append(randomChar);
        }
        // Combine the date and random number into a string
        String result = formattedDate + "-" + randomNumber+randomAlphabets;

        return result;
    }
    public static String generatePhnNum(){
        // Get today's date
        LocalDate today = LocalDate.now();

        // Format the date
        String formattedDate = today.toString();

        // Generate a random number
        Random random = new Random();
        int randomNumber = random.nextInt(100); // Change 1000 to your desired upper limit

        // Combine the date and random number into a string
        String result = formattedDate  + randomNumber;

        return result;
    }
    public static String generateEmail(){
        return generateName()+"@yopmail.com";
    }
    public static String generatePassword(){
        return generatePhnNum();
    }

    public String captureScreen(String tname) throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }

    public void pressTab() {
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
    }
    public void pressEnter() {
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }
    public void pressBack(){
        //driver.navigate().back();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.history.go(-1)");
    }
    public String getTitle(){
        return driver.getTitle();
    }
}
