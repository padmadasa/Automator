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
package testrunner.collector;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import testrunner.elements.Test;

/**
 * This class is responsible for collecting the test results.
 * 
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
@XmlRootElement
public class TestResult extends ResultDetails {

	public TestResult(String resultIdentifier) {
		super(resultIdentifier, ResultType.TEST_RESULT);
	}

	private List<FlowResult> flowResults = null;
	private Test currentTestToExecute = null;

	/**
	 * @return the flowResults
	 */
	public List<FlowResult> getFlowResults() {
		return flowResults;
	}

	/**
	 * 
	 * @param flowResults
	 *            the flowResults to set
	 */
	@XmlElementWrapper(name = "flowResults")
	@XmlElement(name = "flowResult")
	public void setFlowResults(List<FlowResult> flowResults) {
		this.flowResults = flowResults;
	}

	/**
	 * @return the currentTestToExecute
	 */
	public Test getCurrentTestToExecute() {
		return currentTestToExecute;
	}

	/**
	 * @param currentTestToExecute
	 *            the currentTestToExecute to set
	 */
	@XmlElement
	public void setCurrentTestToExecute(Test currentTestToExecute) {
		this.currentTestToExecute = currentTestToExecute;
	}

}
