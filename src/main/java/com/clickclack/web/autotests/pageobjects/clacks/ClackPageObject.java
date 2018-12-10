package com.clickclack.web.autotests.pageobjects.clacks;

import org.openqa.selenium.WebDriver;

import com.clickclack.web.autotests.common.SeleniumPageObject;

public class ClackPageObject extends SeleniumPageObject{
	
	String clackId;

	/**
	 * @return the clackId
	 */
	public String getClackId() {
		return clackId;
	}

	public ClackPageObject(WebDriver driver, String EP, String host, String TITLE) {
		super(driver, EP, host, TITLE);
	}

	protected void setClackId(String id) {
		// TODO Auto-generated method stub
		clackId = id;
	}

}
