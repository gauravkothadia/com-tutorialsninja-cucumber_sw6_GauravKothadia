package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopMenuPage extends Utility {

    private static final Logger log = LogManager.getLogger(TopMenuPage.class.getName());

    @CacheLookup
    //@FindBy(xpath = "//li[@class='dropdown open']//a[@class='see-all']")
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[@class='dropdown']/a")
    List<WebElement> topMenu;

    @CacheLookup
    @FindBy(xpath = "//li[@class='dropdown open']//div[@class='dropdown-menu']/a")
    WebElement subMenuShowAll;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h2")
    WebElement pageHeadingText;


    public void topMenu(String menuText){
        List<WebElement> topMenuElements = topMenu;
        for (WebElement ele : topMenuElements){
            if(ele.getText().trim().equalsIgnoreCase(menuText)){
                mouseHoverToElementAndClick(ele);
                log.info("Mouse hover to top menu link and clicked "+menuText);
                break;
            }
        }
    }

    public void selectMenu(String menu) {
        WebElement showAllCategoryElement = subMenuShowAll;
        if (getTextFromElement(showAllCategoryElement).trim().equalsIgnoreCase(menu)) {
                clickOnElement(showAllCategoryElement);
                log.info("Clicked on "+menu);
        }
    }

    public String getPageHeadingText() {
        String headingText =getTextFromElement(pageHeadingText);
        log.info("getting page heading text "+headingText);
        return headingText;
    }
}
