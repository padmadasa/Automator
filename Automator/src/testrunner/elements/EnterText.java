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
import javax.xml.bind.annotation.XmlType;

/**
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
@XmlType
public class EnterText {
	private LocateUsing locateUsing = null;
	private String text = null;
	private boolean submit = false;

	/**
	 * @return the locateUsing
	 */
	public LocateUsing getLocateUsing() {
		return locateUsing;
	}

	/**
	 * @param locateUsing
	 *            the locateUsing to set
	 */
	@XmlElement
	public void setLocateUsing(LocateUsing locateUsing) {
		this.locateUsing = locateUsing;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */

	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		if (getText() == null || getText().trim().equals("")) {
			return super.toString();
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("Text:" + getText());
		buffer.append(getLocateUsing());
		return buffer.toString();
	}

	/**
	 * Required to match two EnterTexts
	 * 
	 * @param enterText
	 * @return boolean = True if both the texts are same else false.
	 */
	public boolean equals(EnterText enterText) {
		boolean isEqual = false;
		boolean isSameLocateUsing = false;
		boolean isSameText = false;
		if (getLocateUsing() != null
				&& getLocateUsing().equals(enterText.getLocateUsing())) {
			isSameLocateUsing = true;
		}
		if (getText() != null
				&& enterText.getText() != null
				&& getText().trim()
						.equalsIgnoreCase(enterText.getText().trim())) {
			isSameText = true;
		}
		if (isSameText && isSameLocateUsing) {
			isEqual = true;
		}
		return isEqual;
	}

	/**
	 * @return the submit
	 */
	public boolean isSubmit() {
		return submit;
	}

	/**
	 * @param submit
	 *            the submit to set
	 */
	@XmlAttribute
	public void setSubmit(String submit) {
		System.out.println("Calling setSubmit with Submit value as :" + submit);
		if (submit != null && submit.trim().equalsIgnoreCase("true")) {
			this.submit = false;
		}

	}
}