package stepdefinations;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MyntraPage;
import utils.BaseClass;

public class MyntraSteps extends BaseClass {

    MyntraPage myntraPage;

    @Given("I am on the Myntra Website")
    public void I_am_on_the_Myntra_Website() {
        initializeDriver();
        driver.get("https://www.myntra.com/");
        myntraPage = new MyntraPage(driver, webDriverWait);
    }

    @When("I navigate to the Men Tab and select Phone Case from Fashion Accessories")
    public void I_navigate_to_the_Men_Tab_and_select_Phone_Case_from_Fashion_Accessories() {

        myntraPage.hoverMenAndSelectPhoneCase();
    }

    @When("I click on the 3rd row, 3rd item")
    public void I_click_on_the_3rd_row_3rd_item() {
        myntraPage.clickThirdElementInThirdRow();
    }

    @Then("I verify that the price is displaced and it is not less that Rs. 10")

    public void I_verify_that_the_price_is_displaced_and_it_is_not_less_that_Rs_10() {
        int price = myntraPage.getPrice();
        System.out.println("Price: " + price);
        Assert.assertTrue("Price should not be less that Rs. 10", price >= 10);
    }

    @Then("I verify that the Add to bag button is displaced")

    public void I_verify_that_the_Add_to_bag_button_is_displaced() {
        boolean isDisplayed =
                myntraPage.verifyAddToBagButtonInNewWindow();Assert.assertTrue("Add to Bag button is not Displayed", isDisplayed);

    }

}
