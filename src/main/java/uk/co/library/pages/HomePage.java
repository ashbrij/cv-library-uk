package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import uk.co.library.utility.Utility;

/**
 * HomePage -
 * Locators - jobTitle, location, distanceDropDown, moreSearchOptionsLink, salaryMin, salaryMax, salaryTypeDropDown, jobTypeDropDown, findJobsBtn
 * Methods - enterJobTitle(String jobTitle), enterLocation(String location), selectDistance(String distance), clickOnMoreSearchOptionLink(),
 * enterMinSalary(String minSalary),  enterMaxSalary(String maxSalary), selectSalaryType(String sType), selectJobType(String jobType),
 * clickOnFindJobsButton().
 */
public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[@class='mat-button-wrapper']//span[text()='Accept All']")
    WebElement cookies;

    @CacheLookup
    @FindBy(xpath = "//iframe[@id='gdpr-consent-notice']")
    WebElement acceptIFrame;
    @CacheLookup
    @FindBy(xpath = "//input[@id='keywords']")
    WebElement jobTitle1;
    @CacheLookup
    @FindBy(xpath = "(//input[@id='location'])[1]")
    WebElement location1;

    @CacheLookup
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distance1;

    @CacheLookup
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOption;

    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement minSalary;
    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement maxSalary;

    @CacheLookup
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryType1;
    @CacheLookup
    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement jobType1;
    @CacheLookup
    @FindBy(xpath = "//input[@id='hp-search-btn']")
    WebElement searchButton;



    // * Accept cookies
    public void clickOnAcceptCookies() {
        // Switch to frame
       driver.switchTo().frame(acceptIFrame);
       //Click on element
        mouseHoverToElementAndClick(cookies);
        //Switch to default content
        driver.switchTo().defaultContent();

    }

    // *      enter job title 'jobTitle'
    public void enterJobTitle(String jobTitle) {
        sendTextToElement(jobTitle1, jobTitle);
    }

    // *     enter Location 'location'
    public void enterJobLocation(String location) {
        sendTextToElement(location1, location);
    }

    // *     select distance 'distance'
    public void selectDistanceFromDropDownList(String distance) {
        selectByVisibleTextFromDropDown(distance1, distance);
        // sendTextToElement(distance1, distance);
    }

    // * 	click on moreSearchOptionsLink
    public void clickOnMoreSearchOptionInBottom() {
        clickOnElement(moreSearchOption);
    }

    // *     enter salaryMin 'salaryMin'
    public void enterMinimumSalary(String salaryMin) {
        sendTextToElement(minSalary, salaryMin);
    }

    // *     enter salaryMax 'salaryMax'
    public void enterMaximumSalary(String salaryMax) {
        sendTextToElement(maxSalary, salaryMax);
    }

    // * 	select salaryType 'salaryType'
    public void selectSalaryTypeFromDropDownList(String salaryType) {
        selectByVisibleTextFromDropDown(salaryType1, salaryType);
    }

    // * 	select jobType 'jobType'
    public void selectJobTypeFromDropDownList(String jobType) {
        selectByVisibleTextFromDropDown(jobType1, jobType);
    }

    // * 	click on 'Find Jobs' button
    public void clickOnFindJobsButton() {
        clickOnElement(searchButton);
    }
}


