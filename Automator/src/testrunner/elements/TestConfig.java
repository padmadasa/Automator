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
public class TestConfig {
	private boolean enableFireFox = false;

	private boolean enableChrome = false;

	private boolean enableIE = false;

	private String fireFoxPath = null;

	private String iePath = null;

	private String chromePath = null;

	private String testResultPath = null;

	private String env = null;

	private String build = null;

	private String project = null;

	/**
	 * @return the enableFireFox
	 */
	public boolean isEnableFireFox() {
		return enableFireFox;
	}

	/**
	 * @param enableFireFox
	 *            the enableFireFox to set
	 */
	@XmlElement
	public void setEnableFireFox(boolean enableFireFox) {
		this.enableFireFox = enableFireFox;
	}

	/**
	 * @return the enableChrome
	 */
	public boolean isEnableChrome() {
		return enableChrome;
	}

	/**
	 * @param enableChrome
	 *            the enableChrome to set
	 */
	@XmlElement
	public void setEnableChrome(boolean enableChrome) {
		this.enableChrome = enableChrome;
	}

	/**
	 * @return the enableIE
	 */
	public boolean isEnableIE() {
		return enableIE;
	}

	/**
	 * @param enableIE
	 *            the enableIE to set
	 */
	@XmlElement
	public void setEnableIE(boolean enableIE) {
		this.enableIE = enableIE;
	}

	/**
	 * @return the driverPath
	 */
	public String getFireFoxPath() {
		return fireFoxPath;
	}

	/**
	 * @param driverPath
	 *            the driverPath to set
	 */
	public void setFireFoxPath(String driverPath) {
		this.fireFoxPath = driverPath;
	}

	/**
	 * @return the iePath
	 */
	public String getIePath() {
		return iePath;
	}

	/**
	 * @param iePath
	 *            the iePath to set
	 */
	public void setIePath(String iePath) {
		this.iePath = iePath;
	}

	/**
	 * @return the chromePath
	 */
	public String getChromePath() {
		return chromePath;
	}

	/**
	 * @param chromePath
	 *            the chromePath to set
	 */
	public void setChromePath(String chromePath) {
		this.chromePath = chromePath;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Chrome :" + this.isEnableChrome() + " Path "
				+ this.chromePath);
		buf.append("FF :" + this.isEnableFireFox() + " Path "
				+ this.fireFoxPath);
		buf.append("IE :" + this.isEnableIE() + " Path " + this.iePath);
		return buf.toString();

	}

	/**
	 * @return the testResultPath
	 */
	public String getTestResultPath() {
		return testResultPath;
	}

	/**
	 * @param testResultPath
	 *            the testResultPath to set
	 */
	@XmlElement
	public void setTestResultPath(String testResultPath) {
		this.testResultPath = testResultPath;
	}

	/**
	 * @return the env
	 */
	public String getEnv() {
		return env;
	}

	/**
	 * @param env
	 *            the env to set
	 */
	@XmlElement
	public void setEnv(String env) {
		this.env = env;
	}

	/**
	 * @return the build
	 */
	public String getBuild() {
		return build;
	}

	/**
	 * @param build
	 *            the build to set
	 */
	@XmlElement
	public void setBuild(String build) {
		this.build = build;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	@XmlElement
	public void setProject(String project) {
		this.project = project;
	}
}
