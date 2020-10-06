package pages;

import org.testng.annotations.Test;

import base.BaseClass;

import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WikiMainPage extends BaseClass {
	
	WebDriver driver;
	
	public WikiMainPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath="//*[@class='toctext']") 
	List<WebElement> contentListElement;
	
	@FindBy(xpath="//*[@class='mw-headline']") 
	List<WebElement> headerListElement;
	
	@FindBy(xpath=("//*[starts-with(@class,'toclevel-1')]/a"))
	List<WebElement> tableOfContent;

	@Test(description = "the headings listed in the Contents box are used as headings on the page")
	public void verifyContentAndheadings() throws InterruptedException {

		List<String> contentList = new ArrayList<String>();
		List<String> headerList = new ArrayList<String>();

		contentList = getList(contentListElement);
		headerList = getList(headerListElement);
	
		AssertJUnit.assertEquals(contentList, headerList);

	}
	
	//Get the contents and headers in the Arraylist 
	public List<String>  getList(List<WebElement> listElement)
	{
		List<String> contentList = new ArrayList<String>();
		for (WebElement webelement : listElement) {
			contentList.add(webelement.getText()); // Add the contents in the Array List
			System.out.println(webelement.getText());
		}
		return contentList;
	}
	
	
	public void verifyHyperLinks() throws InterruptedException {

		for (WebElement webelement : tableOfContent) {
			webelement.click(); // click on the hyperlink
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals(webelement.getAttribute("href"), currentUrl);

//	 System.out.println(webelement.getAttribute("href"));
//	 System.out.println(currentUrl);

		}
	}
	

}
