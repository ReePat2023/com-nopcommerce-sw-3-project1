package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    String menu ="computers";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu){
        //1.2 This method should click on the menu whatever name is passed as parameter
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/child::li"));
        for (WebElement element:elements){
            if (element.getText().equalsIgnoreCase(menu)){
                element.click();
                break;
            }
        }
    }
    @Test
    public void verifyPageNavigation(){
        selectMenu(menu);
        String expectedMessage = "Computers";
        String actualMessage= getTextFromElement(By.xpath("//h1[normalize-space()='Computers']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}


