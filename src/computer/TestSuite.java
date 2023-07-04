package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility  {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Click on Computer Menu
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.name("products-orderby"));
        Select select = new Select(dropDown);
        select.selectByValue("6");
        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> productNames = driver.findElements(By.xpath("//h2[@class='product-name']/a"));
        List<String> productNameStrings = new ArrayList<String>();
        for (WebElement productName : productNames) {
            productNameStrings.add(productName.getText());
        }
        List<String> sortedProductNames = new ArrayList<String>(productNameStrings);
        Collections.sort(sortedProductNames, Collections.reverseOrder());
        Assert.assertEquals(productNameStrings, sortedProductNames);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        //2.2 Click on Desktop
        Thread.sleep(2000);
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectFromDropDownMenu(By.name("products-orderby"),"Name: A to Z");
        //2.4 Click on "Add To Cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //2.5 Verify the Text "Build your own computer"
        Assert.assertEquals("Build your computer page is not displayed", "Build your own computer", getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]")));
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Thread.sleep(2000);
        selectFromDropDownMenu(By.name("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(2000);
        selectFromDropDownMenu(By.name("product_attribute_2"),"8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//label[contains(text(),'400 GB [+$100.00]')]"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//label[contains(text(),'Vista Premium [+$60.00]')]"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        //Thread.sleep(2000);
        //clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
       // Thread.sleep(2000);
        clickOnElement(By.xpath("//label[contains(text(),'Total Commander [+$5.00]')]"));
        //2.11 Verify the price "$1,475.00"
        Thread.sleep(2000);
        Assert.assertEquals("$1,475.00", getTextFromElement(By.xpath("//span[@id='price-value-1']")));
        //2.12 Click on "ADD TO CARD" Button.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals("The product has been added to your shopping cart", getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]")));
        //Close the button
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.15 Verify the message "Shopping cart"
        Assert.assertEquals("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");
        clickOnElement(By.xpath("//button[@class='button-2 update-cart-button']"));
        //2.17 Verify the Total"$2,950.00"
        Assert.assertEquals("$2,950.00", getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")));
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.19 Click on “CHECKOUT”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals("Welcome, Please Sign In!", getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
        //2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.name("BillingNewAddress.FirstName"),"Riya");
        sendTextToElement(By.name("BillingNewAddress.LastName"),"Patel");
        sendTextToElement(By.name("BillingNewAddress.Email"),"reemexperts@gmail.com");
        WebElement dropDown3 = driver.findElement(By.name("BillingNewAddress.CountryId"));
        Select select3 = new Select(dropDown3);
        select3.selectByValue("233");
        sendTextToElement(By.name("BillingNewAddress.City"),"London");
        sendTextToElement(By.name("BillingNewAddress.Address1"),"123b, Lane");
        sendTextToElement(By.name("BillingNewAddress.ZipPostalCode"),"12B 2CD");
        sendTextToElement(By.name("BillingNewAddress.PhoneNumber"),"07912345678");
        //2.23 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        Thread.sleep(2000);
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@class='buttons']//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//div[@class='buttons']//button[@class='button-1 payment-method-next-step-button']"));
        //2.27 Select “Master card” From Select credit card dropdown
        Thread.sleep(2000);
        selectFromDropDownMenu(By.name("CreditCardType"),"Master card");
        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Riya Patel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"0759 2136 2156 5987");
        selectFromDropDownMenu(By.name("ExpireMonth"),"05");
        selectFromDropDownMenu(By.name("ExpireYear"),"2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"000");
        //2.29 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='buttons']//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("Credit Card", getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")));
        //2.32 Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals("Next Day Air", getTextFromElement(By.xpath("//div[@class='shipping-method-info']//ul[@class='info-list']//span[@class='value']")));
        //2.33 Verify Total is “$2,950.00”
        Assert.assertEquals("$2,950.00", getTextFromElement(By.xpath("//tr[@class='order-total']//td[@class='cart-total-right']//strong[text()='$2,950.00']")));
        //2.34 Click on “CONFIRM”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.35 Verify the Text “Thank You”
        Assert.assertEquals("Thank you", getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")));
        //2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
        //2.37 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        Assert.assertEquals("Welcome to our store", getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}

