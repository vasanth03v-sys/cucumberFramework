package base;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setUP(){
       BaseClass.openBrowser();
    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            TakesScreenshot screenshot=(TakesScreenshot) BaseClass.driver;
            byte[] image=screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(image,"image/png","Failure Screenshot");
        }
       if(BaseClass.driver!=null){
           BaseClass.driver.quit();
       }
    }
}
