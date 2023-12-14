package uk.co.library.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.BaseTest;

/**
 * 1.verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType,
 * String result).
 * enter job title 'jobTitle'
 * enter Location 'location'
 * select distance 'distance'
 * click on moreSearchOptionsLink
 * enter salaryMin 'salaryMin'
 * enter salaryMax 'salaryMax'
 * select salaryType 'salaryType'
 * select jobType 'jobType'
 * click on 'Find Jobs' button
 * verify the result 'result'
 * <p>
 * Data set
 * <p>
 * |jobTitle    |location   |distance   |salaryMin  |salaryMax  |salaryType |jobType    |result |
 * |Tester       |Harrow     | up to 5 miles |30000  |500000 |Per annum  | Permanent |Permanent Tester jobs in Harrow on the Hill    |
 * <p>
 * Create 6 More data set.
 */
@Listeners(CustomListeners.class)

public class JobSearchTest extends BaseTest {
    //Declaration
    HomePage homePage;
    ResultPage resultPage;

    //Initialisation
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        resultPage = new ResultPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"}, dataProvider = "JobSearchData", dataProviderClass = TestData.class)

    //* 1.verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location,
    // String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String result).
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location,
                                                           String distance, String salaryMin, String salaryMax,
                                                           String salaryType, String jobType, String result) throws InterruptedException {

        // * Accept cookies
        homePage.clickOnAcceptCookies();

        // *     enter job title 'jobTitle'
        homePage.enterJobTitle(jobTitle);

        // *     enter Location 'location'
        homePage.enterJobLocation(location);

        // *     select distance 'distance'
        homePage.selectDistanceFromDropDownList(distance);

        // * 	click on moreSearchOptionsLink
        homePage.clickOnMoreSearchOptionInBottom();

        // *     enter salaryMin 'salaryMin'
        homePage.enterMinimumSalary(salaryMin);

        // *     enter salaryMax 'salaryMax'
        homePage.enterMaximumSalary(salaryMax);

        // * 	select salaryType 'salaryType'
        homePage.selectSalaryTypeFromDropDownList(salaryType);

        // * 	select jobType 'jobType'
        homePage.selectJobTypeFromDropDownList(jobType);

        // * 	click on 'Find Jobs' button
        homePage.clickOnFindJobsButton();

        // * 	verify the result 'result'
        resultPage.verifyTheResulTextOnResultPage(result);

    }
}

