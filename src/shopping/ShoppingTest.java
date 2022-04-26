package shopping;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class ShoppingTest extends Utility {


    String baseUrl = "https://mobile.x-cart.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {

        //  1.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));

        //	1.2 Mouse hover on the “Bestsellers”  link and click
        Thread.sleep(2000);
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));

        //	1.3 Verify the text “Bestsellers”
        Thread.sleep(2000);
        assertVerifyText(By.id("page-title"), "Bestsellers");

        //	1.4 Mouse hover on “Sort By” and select “Name A-Z”
        Thread.sleep(1500);
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        Thread.sleep(1500);
        clickOnMouseHoverOnElement(By.linkText("Name A - Z"));

        //	1.5 Click on “Add to cart” button of the product “Ollie - The App Controlled Robot”
        Thread.sleep(1500);
        mouseHoverOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[8]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//ul[@class = 'products-grid grid-list']/li[8]/div/div[2]/div[4]/div/button"));

        //  1.6 Verify the message “Product has been added to your cart” display in green bar
        assertVerifyText(By.xpath("//li[contains(text(),'Product has been added to your cart')]"), "Product has been added to your cart");

        //  1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//div[@id='status-messages']/a"));

        //  1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.linkText("View cart"));

        //  1.9 Verify the text “Your shopping cart - 1 item”
        assertVerifyText(By.id("page-title"), "Your shopping cart - 1 item");

        //  1.10 Verify the Subtotal $19.99
        assertVerifyText(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']" +
                "/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]" +
                "/div[1]/div[1]/ul[1]/li[1]/span[1]/span[1]/span[1]"),"$19.99");

        //  1.11 Verify the total $25.84
        assertVerifyText(By.xpath("//li/span/span[@class='surcharge-cell']"),"$25.84");

        //  1.12 Click on “Go to checkout” button
        clickOnElement(By.xpath("//span[text()='Go to checkout']"));

        //  1.13 Verify the text “Log in to your account”
        assertVerifyText(By.xpath("//h3[contains(text(),'Log in to your account')]"), "Log in to your account");

        //  1.14 Enter Email address
        sendTextToElement(By.id("email"), "abc1234235@gmail.com");

        //  1.15 Click on “Continue” Button
        clickOnElement(By.xpath("//span[contains(text(),'Continue')]"));

        //  1.16 Verify the text “Secure Checkout”
        assertVerifyText(By.xpath("//h1[@class='title']"), "Secure Checkout");

        //  1.17 Fill all the mandatory fields
        Thread.sleep(4000);
        sendTextToElement(By.id("shippingaddress-firstname"), "abcdfg");
        sendTextToElement(By.id("shippingaddress-lastname"), "xyzpoi");
        sendTextToElement(By.id("shippingaddress-street"), "abc street");

        clickOnElement(By.id("shippingaddress-country-code"));
        selectByValueFromDropDown(By.id("shippingaddress-country-code"),"FI");

        sendTextToElement(By.id("shippingaddress-custom-state"), "Anyland");

        //  1.18 Check the check box “Create an account for later use”
        Thread.sleep(1000);
        clickOnElement(By.id("create_profile"));

        //  1.19 Enter the password
        Thread.sleep(2000);
        sendTextToElement(By.id("password"),"918273645mznxbcv");

        //  1.20 Select the Delivery Method to “Local Shipping”
        Thread.sleep(2000);
        clickOnElement(By.id("method128"));

        //  1.21 Select Payment Method “COD”
        Thread.sleep(2000);
        clickOnElement(By.id("pmethod6"));

        //  1.22 Verify the total $26.86
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']" +
                "/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/" +
                "div[2]/div[1]/div[3]/span[2]/span[1]/span[1]"), "$26.86");

        //  1.23 Click on “Place Order” Button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@type= 'submit']"));

        //  1.24 Verify the text “Thank you for your order”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h1[@id='page-title']"), "Thank you for your order");

    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

        //  2.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));

        //	2.2 Mouse hover on the “Bestseller”  link and click
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));

        //	2.3 Verify the text “Bestsellers”
        assertVerifyText(By.id("page-title"), "Bestsellers");

        //	2.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Name A - Z"));

        //	2.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        Thread.sleep(2000);
        mouseHoverOnElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div/div/div[3]/ul/li[7]/div/div[1]/a/img"));

        //  2.6 Verify the message “Product has been added to your cart” display in  green bar
        assertVerifyText(By.xpath("//li[contains(text(),'Product has been added to your cart')]"), "Product has been added to your cart");

        //  2.7 Click on X sign to close the message
        clickOnElement(By.xpath("//div[@id='status-messages']/a"));

        //  2.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));

        //  2.9 Verify the text “Your shopping cart - 1 item”
        Thread.sleep(2000);
        clickOnElement(By.linkText("View cart"));

        //  2.10 Click on “Empty your cart” link
        assertVerifyText(By.id("page-title"), "Your shopping cart - 1 item");

        //  2.11 Verify the text “Are you sure you want to clear your cart?” on alert
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

        //  2.12 Click “Ok” on alert
        acceptAlert();

        //  2.13 Verify the message “Item(s) deleted from your cart”
        assertVerifyText(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"),"Item(s) deleted from your cart");

        //  2.14 Verify the text “Your cart is empty”
        assertVerifyText(By.xpath("//h1[contains(text(),'Your cart is empty')]"),"Your cart is empty");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}