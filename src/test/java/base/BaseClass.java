package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static Properties properties;
    public static void openBrowser() {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String browser = properties.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefoox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        }
        driver.manage().window().maximize();
    }
        public static void waitForElement(By locator){
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

    }
