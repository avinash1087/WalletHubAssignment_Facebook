package com.wallethub.facebook.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.wallethub.facebook.pages.HomePage;
import com.wallethub.facebook.pages.LoginPage;
import com.wallethub.facebook.utility.TestBase;

public class PostAnUpdate extends TestBase{
	LoginPage objLoginPage;
	HomePage objHomePage;

	@Test
	public void login() {
		objLoginPage = new LoginPage(driver,prop);
		objHomePage = objLoginPage.login();

		assertEquals(driver.getTitle().contains("Log in"), false); //assert that user has navigated away from login page
		assertEquals(driver.getTitle().contains("Facebook"), true); //assert that user has successfully logged in
	}
	
	@Test
	public void postAnUpdate() {
		objHomePage.postAnUpdate();
	}
}
