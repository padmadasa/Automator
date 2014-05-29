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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
public class Step {
	private String name = null;
	private String url = null;
	private EnterText enterText = null;
	private SubmitAction submitAction = null;
	private LinkClick linkClick = null;
	private SelectOption selectOption = null;
	private int waitFor = 0;
	private boolean enableTimer = true;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public StepType getStepType() {
		if (url != null && !url.trim().equals("")) {
			return StepType.URL;
		}
		if (enterText != null && enterText.getText() != null
				&& !enterText.getText().trim().equals("")) {
			return StepType.TEXT;
		}
		if (submitAction != null && submitAction.getLocateUsing() != null) {
			return StepType.SUBMIT;
		}
		if (linkClick != null && linkClick.getLocateUsing() != null) {
			return StepType.LINK;
		}
		if (submitAction != null && submitAction.getLocateUsing() != null) {
			return StepType.SUBMIT;
		}
		return StepType.INVALID_STEP;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@XmlAttribute
	public void setName(String name) {
		// System.out.println("The name is :" + name);
		this.name = name;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	@XmlElement
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the enterText
	 */
	public EnterText getEnterText() {
		return enterText;
	}

	/**
	 * @param enterText
	 *            the enterText to set
	 */
	@XmlElement
	public void setEnterText(EnterText enterText) {
		this.enterText = enterText;
	}

	/**
	 * @return the submitAction
	 */
	public SubmitAction getSubmitAction() {
		return submitAction;
	}

	/**
	 * @param submitAction
	 *            the submitAction to set
	 */
	@XmlElement
	public void setSubmitAction(SubmitAction submitAction) {
		this.submitAction = submitAction;
	}

	/**
	 * @return the linkClick
	 */
	public LinkClick getLinkClick() {
		return linkClick;
	}

	/**
	 * @param linkClick
	 *            the linkClick to set
	 */
	@XmlElement
	public void setLinkClick(LinkClick linkClick) {
		this.linkClick = linkClick;
	}

	/**
	 * @return the selectOption
	 */
	public SelectOption getSelectOption() {
		return selectOption;
	}

	/**
	 * @param selectOption
	 *            the selectOption to set
	 */
	@XmlElement
	public void setSelectOption(SelectOption selectOption) {
		this.selectOption = selectOption;
	}

	public String toString() {
		if (this.getName() == null || this.getName().trim().equals("")) {
			return super.toString();
		}
		StringBuffer stepBuffer = new StringBuffer(this.getName());
		stepBuffer.append("[Step Type :" + this.getStepType().toString() + "]");
		if (getUrl() != null && !getUrl().trim().equals("")) {
			stepBuffer.append("->URL:");
			stepBuffer.append(getUrl());
		}
		if (getEnterText() != null) {
			stepBuffer.append("->" + getEnterText());
		}
		if (getLinkClick() != null) {
			stepBuffer.append("->" + getLinkClick());
		}
		if (getSelectOption() != null) {
			stepBuffer.append("->" + getSelectOption());
		}
		if (getSubmitAction() != null) {
			stepBuffer.append("->" + getSubmitAction());
		}
		stepBuffer.append(":EndStep}");
		return stepBuffer.toString();
	}

	/**
	 * This method compares two steps. Two Steps are said to be same in the
	 * following order
	 * <ul>
	 * <li>The passed Step's URL is not empty and current Step's URL is not
	 * empty and both of them matches. (Case Insensitive)</li>
	 * <li>IF URL is empty for the current Step, the next element that is
	 * compared is, EnterText.If passed EnterText is not empty and current
	 * EnterText is not empty, a comparison is made.</li>
	 * <li>If EnterText is empty, then next element that is compared
	 * is,LinkClick</li>
	 * <li>If LinkClick is empty, then next element that is compared
	 * is,SelectOption</li>
	 * <li>If SelectOption is empty, then next element that is compared
	 * is,SubmitAction</li>
	 * <li>In All the cases, if any one of the elements matches in the order, a
	 * value of true is returned. Else false is returned
	 * </ul>
	 * 
	 * @param step
	 *            - Step to Compare
	 * @return boolean (Result of comparison of passed step with this Step)
	 */
	public boolean equals(Step step) {
		boolean isEqual = false;

		return isEqual;
	}

	/**
	 * @return the waitFor
	 */
	public int getWaitFor() {
		return waitFor;
	}

	/**
	 * @param waitFor
	 *            the waitFor to set
	 */
	@XmlElement
	public void setWaitFor(int waitFor) {
		this.waitFor = waitFor;
	}

	/**
	 * @return the enableTimer
	 */
	public boolean isEnableTimer() {
		return enableTimer;
	}

	/**
	 * @param enableTimer
	 *            the enableTimer to set
	 */
	@XmlAttribute
	public void setEnableTimer(String pEnableTimer) {

		// System.out.println("The Enable Timer is :" + pEnableTimer);
		if (pEnableTimer != null
				&& pEnableTimer.trim().equalsIgnoreCase("false")) {
			this.enableTimer = false;
		}
	}

	/**
	 * Returns the timer
	 * 
	 * @return
	 */
	public String getEnableTimer() {
		return String.valueOf(this.enableTimer);
	}
}