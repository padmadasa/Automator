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

/**
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
public class OptionValue {

	private String valueText = null;

	public String getValueText() {
		return valueText;
	}

	@XmlElement
	public void setValueText(String valueText) {
		this.valueText = valueText;
	}

	public String toString() {
		if (getValueText() != null && !getValueText().trim().equals("")) {
			return getValueText();
		}
		return super.toString();
	}

	public boolean equals(OptionValue optionValue) {
		boolean isEqual = false;
		if (getValueText() != null && optionValue.getValueText() != null) {
			isEqual = getValueText().trim().equalsIgnoreCase(
					optionValue.getValueText().trim());
		}
		return isEqual;
	}

}