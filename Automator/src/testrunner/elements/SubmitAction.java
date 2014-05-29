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

/**
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class SubmitAction {
	private LocateUsing locateUsing = null;

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

	public String toString() {
		if (getLocateUsing() == null) {
			return super.toString();
		}
		return getLocateUsing().toString();
	}

	public boolean equals(SubmitAction action) {
		return (getLocateUsing() == action.getLocateUsing());
	}
}
