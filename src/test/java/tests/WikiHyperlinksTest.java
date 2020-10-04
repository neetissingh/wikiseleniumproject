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




public class WikiHyperlinksTest extends BaseClass {


	@Test(description="the headings listed in the Contents box have functioning hyperlinks")    
	public void verifyHyperLinkstest()  throws InterruptedException {      


	List<WebElement> hyperLinks = driver.findElements(By.xpath("//*[starts-with(@class,'toclevel-1')]/a"));
	for(WebElement webelement : hyperLinks)
	{
	 System.out.println(webelement.getAttribute("href"));
	 driver.get(webelement.getAttribute("href")); //Get the hyperlinks
	 List<WebElement> headerListElement1 = driver.findElements(By.xpath("//*[@class='mw-headline']"));
	 for(WebElement webelement1 : headerListElement1) {
		 System.out.println(driver.findElement(By.xpath("//*[@id='Family']")).isDisplayed());
			  System.out.println(webelement1.getText());
			  
			}
	}
	
	WebElement popup = driver.findElement(By.xpath("//a[@href='/wiki/Nike_(mythology)']"));
	Actions action = new Actions(driver);
	action.clickAndHold().moveToElement(popup);
	action.moveToElement(popup).perform();
	
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement element = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'mwe-popups-container')]/a[2]")));
	String actualText = element.getText();
	
	String expectedText = "In ancient Greek civilization, Nike was a goddess who personified victory. Her Roman equivalent was Victoria.";
	AssertJUnit.assertEquals(expectedText, actualText);
	System.out.println(actualText);
	popup.click();
	
	
	WebElement familyTree = driver.findElement(By.xpath("//*[@id='Family_tree']"));
	
	AssertJUnit.assertTrue(familyTree.isDisplayed());
	
	}
	


}
