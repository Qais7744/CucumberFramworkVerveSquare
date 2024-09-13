package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Set;

public class MyntraPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    By menTab = By.xpath("//a[@data-group='men']");

    By fashionAccessories = By.xpath("//a[text()='Fashion Accessories']");

    By phoneCase = By.xpath("//a[text()='Phone Cases']");

    By thirdItemInThirdRow = By.xpath("//ul[@class='results-base']//li[13]");

    By priceElement = By.xpath("//span[@class=\"product-discountedPrice\"]");

    By addToBagButton = By.xpath("//div[contains(@class, 'pdp-add-to-bag')]");

    public MyntraPage(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait =webDriverWait;
        this.actions = new Actions(driver);
    }

    public void hoverMenAndSelectPhoneCase(){
        WebElement menElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(menTab));

        actions.moveToElement(menElement).perform();

        WebElement fashionAccessoriesWebElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(fashionAccessories));

        actions.moveToElement(fashionAccessoriesWebElement).perform();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(phoneCase)).click();

    }

    public void clickThirdElementInThirdRow() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(thirdItemInThirdRow)).click();
    }

    public int getPrice() {
        String priceText = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(priceElement)).getText().replace("Rs. ", "").replace(",", "").trim();
        return Integer.parseInt(priceText);
    }

    public void switchToNewWindow() {
        String mainWindow =
                driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();

        for (String window : allWindow) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
    public boolean verifyAddToBagButtonInNewWindow() {
        switchToNewWindow();
        WebElement addToBag = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(addToBagButton));((JavascriptExecutor) driver).executeAsyncScript("arguments[0].scrollIntoView(true);",addToBag);
        return addToBag.isDisplayed();
    }
}
