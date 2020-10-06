package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.WikiMainPage;
import pages.WikiPopupPage;

import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WikiMainPageTest extends BaseClass {
	

	@Test(description = "the headings listed in the Contents box are used as headings on the page")
	public void verifyMainPagetest() throws InterruptedException {
		
		WikiMainPage mainPage = PageFactory.initElements(driver, WikiMainPage.class);
		mainPage.verifyContentAndheadings();
		mainPage.verifyHyperLinks();
		WikiPopupPage popUpPage = PageFactory.initElements(driver, WikiPopupPage.class);
		popUpPage.verifyPopuptext();

	}

}
