/**
 * Copyright (C) 2014 January by Padmapriya Dasarathy -> (padmadasa@gmail.com)
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package testrunner.elements;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
@XmlType
public class LocateUsing {
	private String id = null;
	private XPath xPath = null;
	private CSSSelector cssSelector = null;

	/**
	 * @return the xPath
	 */
	public XPath getxPath() {
		return xPath;
	}

	/**
	 * @param xPath
	 *            the xPath to set
	 */
	@XmlElement
	public void setxPath(XPath xPath) {
		this.xPath = xPath;
	}

	/**
	 * @return the cssSelector
	 */
	public CSSSelector getCssSelector() {
		return cssSelector;
	}

	/**
	 * @param cssSelector
	 *            the cssSelector to set
	 */
	@XmlElement
	public void setCssSelector(CSSSelector cssSelector) {
		this.cssSelector = cssSelector;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer("");
		if (getxPath() != null) {
			buffer.append(getxPath().toString());
		}
		if (getCssSelector() != null) {
			buffer.append(getCssSelector().toString());
		}
		if (buffer.toString().trim().equals("")) {
			return super.toString();
		}
		return buffer.toString();
	}

	/**
	 * This method compares the LocateUsing element based on XPATH and then
	 * CSSSelector.
	 * 
	 * @param locateUsing
	 * @return false.
	 */
	public boolean equals(LocateUsing locateUsing) {
		boolean isEqual = false;
		if (getxPath() != null && locateUsing.getxPath() != null) {
			isEqual = getxPath().equals(locateUsing.getxPath());
		}
		if (!isEqual) {
			isEqual = getCssSelector().equals(locateUsing.getCssSelector());
		}
		if (!isEqual) {
			isEqual = getId().equals(locateUsing.getId());
		}
		return isEqual;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * This method takes the responsibility of locating a web element using the
	 * following Order
	 * <ul>
	 * <li>{@link #getId()} The ID of the element specified if its NOT null</li>
	 * <li>{@link #getXPath()} The XPath of the element specified if its NOT
	 * null</li>
	 * <li>{@link #getCSSSelector()} The CSS Selector text of the element
	 * specified if its NOT null</li>
	 * </ul>
	 * 
	 * @return WebElement - Located WebElement or Null
	 */
	public WebElement locate(WebDriver driver, int waitFor) {
		WebElement elementToLocate = null;
		try {
			if (getId() != null && !getId().trim().equals("")) {
				if (waitFor > 0) {
					WebDriverWait wait = new WebDriverWait(driver, waitFor);
					elementToLocate = wait.until(ExpectedConditions
							.elementToBeClickable(By.id(getId())));
				} else {
					elementToLocate = driver.findElement(By.id(getId()));
				}

			}
			if (elementToLocate == null
					&& (getxPath() != null && !getxPath().getPath().trim()
							.equals(""))) {
				if (waitFor > 0) {
					WebDriverWait wait = new WebDriverWait(driver, waitFor);
					elementToLocate = wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath(this.getxPath()
									.getPath().trim())));

				} else {
					elementToLocate = driver.findElement(By.xpath(this
							.getxPath().getPath().trim()));
				}

			}
			if (elementToLocate == null
					&& (getCssSelector() != null && !getCssSelector()
							.getSelectorText().trim().equals(""))) {
				if (waitFor > 0) {
					WebDriverWait wait = new WebDriverWait(driver, waitFor);
					elementToLocate = wait
							.until(ExpectedConditions.elementToBeClickable(By
									.cssSelector(this.getCssSelector()
											.getSelectorText().trim())));

				} else {
					elementToLocate = driver.findElement(By.cssSelector(this
							.getCssSelector().getSelectorText().trim()));
				}
			}
		} catch (Exception ex) {
			System.out.println("Unable to Locate Element with ID" + getId()
					+ " OR XPATH" + this.getxPath() + " OR CSS Selector"
					+ cssSelector);
		}
		return elementToLocate;
	}
}