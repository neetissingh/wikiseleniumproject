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


	@Test(description ="the headings listed in the Contents box are used as headings on the page")          
	public void verifyMainPagetest()  throws InterruptedException {      
	
	List<String> contentList = new ArrayList<String>();
	List<String> headerList = new ArrayList<String>();
	
	List<WebElement> contentListElement = driver.findElements(By.xpath("//*[@class='toctext']"));
	for(WebElement webelement : contentListElement) {
		contentList.add(webelement.getText()); // Add the contents in the Array List
		System.out.println(webelement.getText());
		}
	
	
	List<WebElement> headerListElement = driver.findElements(By.xpath("//*[@class='mw-headline']"));
	for(WebElement webelement : headerListElement) {
		headerList.add(webelement.getText());//Add the headlines in the Array List
		  System.out.println(webelement.getText());
		}
	
	AssertJUnit.assertEquals(contentList, headerList);

	
	List<WebElement> hyperLinks = driver.findElements(By.xpath("//*[starts-with(@class,'toclevel-1')]/a"));
	for(WebElement webelement : hyperLinks)
	{
	 System.out.println(webelement.getAttribute("href"));
	 driver.get(webelement.getAttribute("href"));
	 List<WebElement> headerListElement1 = driver.findElements(By.xpath("//*[@class='mw-headline']"));
	 for(WebElement webelement1 : headerListElement1) {
		 System.out.println(driver.findElement(By.xpath("//*[@id='Family']")).isDisplayed());
			  System.out.println(webelement1.getText());
			  //System.out.println( webelement1.isDisplayed());
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
