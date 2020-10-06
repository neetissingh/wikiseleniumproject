package pages;

import org.testng.annotations.Test;

import base.BaseClass;

import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WikiPopupPage extends BaseClass {

	@FindBy(xpath="//a[@href='/wiki/Nike_(mythology)']") WebElement nikePopupLink;
	@FindBy(xpath="//div[contains(@class,'mwe-popups-container')]/a[2]") WebElement nikePopupText;
	@FindBy(xpath="//*[@id='Family_tree']") WebElement nikePageFamilyTree;

	WebDriver driver;
	
	public WikiPopupPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyPopuptext() throws InterruptedException {

		
		Actions action = new Actions(driver);
		action.clickAndHold().moveToElement(nikePopupLink);
		action.moveToElement(nikePopupLink).perform();

		WebDriverWait wait = new WebDriverWait(driver, 10);//had to wait few seconds to get the pop up Text
		WebElement element = wait.until(ExpectedConditions.visibilityOf(nikePopupText)); // Get the popup text
		String actualText = element.getText();

		String expectedText = "In ancient Greek civilization, Nike was a goddess who personified victory. Her Roman equivalent was Victoria.";
		AssertJUnit.assertEquals(expectedText, actualText);
		System.out.println(actualText);
		
		//in the _Personified concepts_, if you click on `Nike`, it takes you to a page that displays a family tree
		nikePopupLink.click(); // Click on the Nike Link from the Personified concepts section 

		

		AssertJUnit.assertTrue(nikePageFamilyTree.isDisplayed()); //Verify Family Tree page is displayed

	}

}
