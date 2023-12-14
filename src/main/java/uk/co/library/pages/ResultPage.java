package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import uk.co.library.utility.Utility;

/**
 * ResultPage
 * Locators - resultText
 * Method - verifyTheResults(String expected)
 */
public class ResultPage extends Utility {
    @CacheLookup
    @FindBy(className = "search-header__title")
    WebElement result1;

    // * 	verify the result 'result'

    public void verifyTheResulTextOnResultPage(String result) {
        verifyThatTextIsDisplayed(result1, result);
        System.out.println(result);
    }

}
