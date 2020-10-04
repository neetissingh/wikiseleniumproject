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

public class WikiMainPageTest extends BaseClass {

	@Test(description = "the headings listed in the Contents box are used as headings on the page")
	public void verifyMainPagetest() throws InterruptedException {

		List<String> contentList = new ArrayList<String>();
		List<String> headerList = new ArrayList<String>();

		List<WebElement> contentListElement = driver.findElements(By.xpath("//*[@class='toctext']"));

		for (WebElement webelement : contentListElement) {
			contentList.add(webelement.getText()); // Add the contents in the Array List
			System.out.println(webelement.getText());
		}

		List<WebElement> headerListElement = driver.findElements(By.xpath("//*[@class='mw-headline']"));

		for (WebElement webelement : headerListElement) {
			headerList.add(webelement.getText());// Add the headlines in the Array List
			System.out.println(webelement.getText());
		}

		AssertJUnit.assertEquals(contentList, headerList);

	}

}
