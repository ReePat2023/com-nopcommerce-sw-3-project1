package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //1.3 Verify the text “Cell phones”
        Assert.assertEquals("Cell phones", getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")));
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //2.3 Verify the text “Cell phones”
        Assert.assertEquals("Cell phones", getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")));
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        //2.6 Verify the text “Nokia Lumia 1020”
        Assert.assertEquals("Nokia Lumia 1020", getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]")));
        //2.7 Verify the price “$349.00”
        Assert.assertEquals("$349.00", getTextFromElement(By.xpath("//span[@id='price-value-20']")));
        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        //2.9 Click on “ADD TO CART” tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals("The product has been added to your shopping cart", getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]")));
        //Close the button
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverAndClickOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.12 Verify the message "Shopping cart"
        Assert.assertEquals("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        //2.13 Verify the quantity is 2
        //Assert.assertEquals("2", getTextFromElement(By.xpath("//input[@id='itemquantity11223']")));

        //2.14 Verify the Total $698.00
        Assert.assertEquals("$698.00", getTextFromElement(By.xpath("//tr[@class='order-total']//td[@class='cart-total-right']//strong[text()='$698.00']")));
        //2.15 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals("Welcome, Please Sign In!", getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
        //2.18 Click on “REGISTER” tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19 Verify the text “Register”
        clickOnElement(By.xpath("//h1[contains(text(),'Register')]"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Riya");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='Email']"),"reeemexperts@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"),"riya123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"riya123");
        //2.21 Click on “REGISTER” Button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //2.22 Verify the message “Your registration completed”
        Assert.assertEquals("Your registration completed", getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]")));
        //2.23 Click on “CONTINUE” tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 Verify the text “Shopping card”
        Assert.assertEquals("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        // 2.24 Click on login
        clickOnElement(By.xpath("//a[normalize-space()='Log in']"));
        sendTextToElement(By.xpath("//input[@id='Email']"), "iambossy11@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "bossy111");
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        // 2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields
        Thread.sleep(2000);
        selectFromDropDownMenu(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        Thread.sleep(2000);
        selectFromDropDownMenu(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Other");
        sendTextToElement(By.id("BillingNewAddress_City"), "283 High Road");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "LeytonStone");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "E11 4HH");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "9825868472");
        //2.28 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        //2.30 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectFromDropDownMenu(By.xpath("//select[@id='CreditCardType']"), "Visa");
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Riya Patel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "0759 2136 2156 5987");
        selectFromDropDownMenu(By.xpath("//select[@id='ExpireMonth']"), "09");
        selectFromDropDownMenu(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "000");
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedCard = "Credit Card";
        String actualCard = driver.findElement(By.xpath("//span[contains(text(),'Credit Card')]")).getText();
        verifyElementMethod(expectedCard, actualCard);
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedShippingMethod = "2nd Day Air";
        String actualShippingMethod = driver.findElement(By.xpath("//li[@class='shipping-method']/span[@class='value']")).getText();
        verifyElementMethod(expectedShippingMethod, actualShippingMethod);
        //2.37 Verify Total is “$698.00”
        String expectedTotalPrice = "$698.00";
        String actualTotalPrice = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")).getText();
        verifyElementMethod(expectedTotalPrice, actualTotalPrice);
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank You”
        String expectedMessage14 = "Thank you";
        String actualMessage14 = driver.findElement(By.xpath("//h1[text()='Thank you']")).getText();
        verifyElementMethod(expectedMessage14, actualMessage14);
        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedMessage15 = "Your order has been successfully processed!";
        String actualMessage15 = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']")).getText();
        verifyElementMethod(expectedMessage15, actualMessage15);
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //2.42 Verify the text “Welcome to our store”
        String expectedMessage16 = "Welcome to our store";
        String actualMessage16 = driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText();
        verifyElementMethod(expectedMessage16, actualMessage16);
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedMessage17 = "https://demo.nopcommerce.com/";
        String actualMessage17 = driver.getCurrentUrl();
        verifyElementMethod(expectedMessage17, actualMessage17);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
