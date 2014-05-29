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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
@XmlRootElement
public class Test {
	private List<Flow> flows = null;

	private int users = 1;

	private String name = null;

	private TestConfig testConfig = null;

	private boolean resetCookies = false;

	/**
	 * @return the flows
	 */

	public List<Flow> getFlows() {
		return flows;
	}

	/**
	 * @param flows
	 *            the flows to set
	 */
	@XmlElementWrapper(name = "flows")
	@XmlElement(name = "flow")
	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

	/**
	 * @return the users
	 */
	public int getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	@XmlAttribute
	public void setUsers(int users) {
		this.users = users;
	}

	public String toString() {
		if (flows == null || flows.isEmpty()) {
			return super.toString();
		}
		StringBuffer strBuffer = new StringBuffer("");
		Iterator<Flow> iterator = flows.iterator();
		while (iterator.hasNext()) {
			strBuffer.append("Flow:{");
			strBuffer.append(iterator.next().toString());
			strBuffer.append("}");
		}
		return strBuffer.toString();
	}

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
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method compares two tests and checks if the Flows and users match.If
	 * so returns true else false.
	 * 
	 * @param test
	 *            - Test to compare with current test.
	 * @return
	 */
	public boolean equals(Test test) {
		return (getFlows().equals(test.getFlows()) && getUsers() == test
				.getUsers());
	}

	/**
	 * @return the testConfig
	 */
	public TestConfig getTestConfig() {
		return testConfig;
	}

	/**
	 * @param testConfig
	 *            the testConfig to set
	 */
	@XmlElement
	public void setTestConfig(TestConfig testConfig) {
		this.testConfig = testConfig;
	}

	/**
	 * @return the resetCookies
	 */
	public boolean isResetCookies() {
		return resetCookies;
	}

	/**
	 * @param resetCookies
	 *            the resetCookies to set
	 */
	@XmlAttribute
	public void setResetCookies(String resetCookies) {
		if (resetCookies != null
				&& resetCookies.trim().equalsIgnoreCase("true")) {
			this.resetCookies = true;
		}

	}
}
