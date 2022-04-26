package hotdeals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotDealsTest extends Utility {


    String baseUrl = "https://mobile.x-cart.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifySaleProductsArrangeAlphabetically() {

        //  1.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));

        //  1.2 Mouse hover on the “Sale”  link and click
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a"));

        //  1.3 Verify the text “Sale”
        assertVerifyText(By.id("page-title"), "Sale");

        //  1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Name A - Z"));

        //  1.5 Verify that the product arrange alphabetically
        clickOnElement(By.partialLinkText("Name A -"));
        assertVerifyText(By.xpath("//span[contains(text(),'Name A - Z')]"), "Name A - Z");
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {

        //  2.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));

        //	2.2 Mouse hover on the “Sale”  link and click
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a"));

        //	2.3 Verify the text “Sale”
        assertVerifyText(By.id("page-title"), "Sale");

        //	2.4 Mouse hover on “Sort By” and select “Price Low-High”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Price Low - High"));

        //	2.5 Verify that the product’s price arrange Low to High
        assertVerifyText(By.xpath("//span[contains(text(),'Price Low - High')]"), "Price Low - High");
    }

    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {

        //  3.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));

        //	3.2 Mouse hover on the “Sale”  link and click
        clickOnMouseHoverOnElement(By.xpath("//*[@id='header-area']/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a"));

        //	3.3 Verify the text “Sale”
        Thread.sleep(1500);
        assertVerifyText(By.id("page-title"), "Sale");

        //	3.4 Mouse hover on “Sort By” and select “Rates”
        Thread.sleep(1500);
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Rates"));

        //	3.5 Verify that the product’s arrange Rates
        assertVerifyText(By.xpath("//span[contains(text(),'Rates')]"), "Rates");

    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {

        //  4.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));

        //	4.2 Mouse hover on the “Bestsellers”  link and click
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));

        //	4.3 Verify the text “Bestsellers”
        Thread.sleep(1500);
        assertVerifyText(By.xpath("//h1[@id='page-title']"), "Bestsellers");

        //	4.4 Mouse hover on “Sort By” and select “Name Z-A”
        Thread.sleep(1500);
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Name Z - A"));

        //	4.5 Verify that the product arrange by Z to A
        List<WebElement> originalProductList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/h5/a"));
        // Create the list object
        List<String> sortPriceList = new ArrayList();
        // Add all web element value to list object
        for (WebElement element : originalProductList) {
            sortPriceList.add(element.getText());
        }
        Collections.sort(sortPriceList, Collections.reverseOrder());
        // Sort by Z to A
        mouseHoverOnElement(By.className("sort-by-label"));
        clickOnElement(By.partialLinkText("Name Z -"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/h5/a"));
        // Create the list object
        List<String> actualPriceList = new ArrayList();
        // Add all web element value to list object
        for (WebElement element : actualProductListElements) {
            actualPriceList.add(element.getText());
        }
        Assert.assertEquals(sortPriceList, actualPriceList);
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {

        //  5.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));

        //	5.2 Mouse hover on the “Bestsellers” link and click
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));

        //	5.3 Verify the text “Bestsellers”
        Thread.sleep(1500);
        assertVerifyText(By.xpath("//h1[@id='page-title']"), "Bestsellers");

        //	5.4 Mouse hover on “Sort By” and select “Price High-Low”
        Thread.sleep(1500);
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Price High - Low"));

        //	5.5 Verify that the product’s price arrange High to Low
        List<WebElement> originalProductList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> sortPriceList = new ArrayList();
        /*remove $ sign and add the sortPriceList
        //add all web element value to list object*/
        for (WebElement element : originalProductList) {
            sortPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        Collections.sort(sortPriceList, Collections.reverseOrder());
        //Mouse hover on “Sort By”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “Price: Low to High”
        clickOnElement(By.partialLinkText("Price High - L"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> actualPriceList = new ArrayList();
        /*remove $ sign and add the sortPriceList
        add all web element value to list object*/
        for (WebElement element : actualProductListElements) {
            actualPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        Assert.assertEquals(sortPriceList, actualPriceList);
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {

        //  6.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));

        //	6.2 Mouse hover on the “Bestsellers”  link and click
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));

        //	6.3 Verify the text “Bestsellers”
        Thread.sleep(1500);
        assertVerifyText(By.xpath("//h1[@id='page-title']"), "Bestsellers");

        //	6.4 Mouse hover on “Sort By” and select “Rates”
        Thread.sleep(1500);
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Rates"));

        //	6.5 Verify that the product’s arrange Rates

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
