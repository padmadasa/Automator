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
import javax.xml.bind.annotation.XmlType;

/**
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
@XmlType
public class CSSSelector {
	private String selectorText = null;

	public String getSelectorText() {
		return selectorText;
	}

	@XmlAttribute
	public void setSelectorText(String selectorText) {
		this.selectorText = selectorText;
	}

	public String toString() {
		if (getSelectorText() != null && !getSelectorText().trim().equals("")) {
			return getSelectorText();
		}
		return super.toString();
	}

	public boolean equals(CSSSelector selector) {
		boolean isEquals = false;
		if (getSelectorText() != null && selector.getSelectorText() != null) {
			isEquals = getSelectorText().trim().equalsIgnoreCase(
					selector.getSelectorText().trim());
		}
		return isEquals;
	}
}
