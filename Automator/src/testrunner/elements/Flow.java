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

import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
public class Flow {

	private String name = null;

	private List<Step> steps = null;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		if (this.getName() == null || this.getName().trim().equals("")) {
			return super.toString();
		}
		StringBuffer toStrBuffer = new StringBuffer(this.getName());
		Iterator<Step> iterator = (steps != null ? steps.iterator() : null);
		if (iterator == null || !iterator.hasNext()) {
			return toStrBuffer.toString();
		}
		while (iterator.hasNext()) {
			toStrBuffer.append(":");
			toStrBuffer.append(iterator.next().toString());
		}
		return toStrBuffer.toString();
	}

	/**
	 * @return the steps
	 */
	public List<Step> getSteps() {
		return steps;
	}

	/**
	 * @param steps
	 *            the steps to set
	 */
	@XmlElementWrapper(name = "steps")
	@XmlElement(name = "step")
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public boolean equals(Flow flow) {
		return (getSteps() == flow.getSteps());
	}

}
