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
public class SelectOption {
	private LocateUsing locateUsing = null;
	private OptionValue optionValue = null;

	/**
	 * @return the optionValue
	 */
	public OptionValue getOptionValue() {
		return optionValue;
	}

	/**
	 * @param optionValue
	 *            the optionValue to set
	 */
	@XmlElement
	public void setOptionValue(OptionValue optionValue) {
		this.optionValue = optionValue;
	}

	public String toString() {
		if (getOptionValue() == null) {
			return super.toString();
		}
		return getOptionValue().toString();
	}

	/**
	 * This method compares current selectOption with passed SelectOption, and
	 * returns true if the option Value matches with the current Option Value
	 * 
	 * @param selectOption
	 * @return boolean
	 */
	public boolean equals(SelectOption selectOption) {
		boolean isEqual = false;
		isEqual = (getOptionValue() == selectOption.getOptionValue());
		return isEqual;
	}

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
}