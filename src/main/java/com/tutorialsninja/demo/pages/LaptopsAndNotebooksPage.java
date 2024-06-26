package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    private static final Logger log = LogManager.getLogger(LaptopsAndNotebooksPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//div[1]//div[2]//div[1]//p//span[@class='price-tax']")
    List<WebElement> listOfPrice;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Sony VAIO']")
    WebElement sonyHeading;
    @CacheLookup
    @FindBy(xpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//div[1]//div[2]//div[1]//p//span[@class='price-tax']")
    List<WebElement> listOfPriceAfterFilter;

    public List<Double> getPriceList() {
        List<WebElement> prices = listOfPrice;
        List<Double> beforeFilterProductPriceList = new ArrayList<>();
        for (WebElement p : prices) {
            String beforeFilterPrice = p.getText().replaceAll("[E,x,T,a,x,£,:,$]", "").replace(",", "");
            Double priceValueBeforeFilter = Double.parseDouble(beforeFilterPrice);
            beforeFilterProductPriceList.add(priceValueBeforeFilter);
        }
        //Sort arraylist to ascending oreder
        Collections.sort(beforeFilterProductPriceList);
        //Reverse the list
        Collections.reverse(beforeFilterProductPriceList);
        log.info("Getting price list");
        return beforeFilterProductPriceList;

    }
    public List<Double> afterFilterPrice() {
        //Store elements after filtering
        List<WebElement> afterFilterProductPrice = listOfPriceAfterFilter;
        //Create anothor list to store text of elements after clicking on filter Price high to low
        List<Double> afterFilterProductPriceList = new ArrayList<>();
        for (WebElement s : afterFilterProductPrice) {
            String afterFilterPrice = s.getText().replaceAll("[E,x,T,a,x,£,:,$]", "").replace(",", "");
            Double afterFilterPriceValue = Double.parseDouble(afterFilterPrice);
            afterFilterProductPriceList.add(afterFilterPriceValue);
        }
        log.info("Getting price list after filtration");
        return afterFilterProductPriceList;
    }
    public void clickOnProduct(String product) {
        List<WebElement> products = listOfProducts;
        List<String> productList = new ArrayList<>();
        for (WebElement e : products) {
            if (e.getText().equalsIgnoreCase(product)) {
                e.click();
                break;
            }
        }

        log.info("Click on " + product);
    }

    public String getSonyVAIOHeading() {
        log.info("Getting the text from heading");
        return getTextFromElement(sonyHeading);
    }

}
