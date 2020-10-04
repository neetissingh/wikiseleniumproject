package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WikiPopupTest extends BaseClass {

	@Test(description = "in the _Personified concepts_, `Nike` has a popup that contains the following text:")
	public void verifyPopuptest() throws InterruptedException {

		WebElement popup = driver.findElement(By.xpath("//a[@href='/wiki/Nike_(mythology)']"));
		Actions action = new Actions(driver);
		action.clickAndHold().moveToElement(popup);
		action.moveToElement(popup).perform();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class,'mwe-popups-container')]/a[2]")));
		String actualText = element.getText();

		String expectedText = "In ancient Greek civilization, Nike was a goddess who personified victory. Her Roman equivalent was Victoria.";
		AssertJUnit.assertEquals(expectedText, actualText);
		System.out.println(actualText);
		popup.click(); // Click on the Nike Link from the Personified concepts section 

		
		WebElement familyTree = driver.findElement(By.xpath("//*[@id='Family_tree']"));

		AssertJUnit.assertTrue(familyTree.isDisplayed()); //Verify Family Tree page is displayed

	}

}
