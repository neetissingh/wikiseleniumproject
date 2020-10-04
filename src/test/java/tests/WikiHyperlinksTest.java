package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WikiHyperlinksTest extends BaseClass {

	@Test(description = "the headings listed in the Contents box have functioning hyperlinks")
	public void verifyHyperLinkstest() throws InterruptedException {

		List<WebElement> hyperLinks = driver.findElements(By.xpath("//*[starts-with(@class,'toclevel-1')]/a"));
		for (WebElement webelement : hyperLinks) {
			webelement.click(); // click on the hyperlink
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals(webelement.getAttribute("href"), currentUrl);

//	 System.out.println(webelement.getAttribute("href"));
//	 System.out.println(currentUrl);

		}
	}
}
