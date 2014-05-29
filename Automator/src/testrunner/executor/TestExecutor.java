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
package testrunner.executor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

import testrunner.collector.FlowResult;
import testrunner.collector.Result;
import testrunner.collector.TestResult;
import testrunner.elements.Flow;
import testrunner.elements.Test;

/**
 * 
 * @author Padmapriya Dasarathy
 * @since 01-10-2014
 * @version 1.0
 * 
 */
public class TestExecutor implements Callable<TestResult> {
	private Test currentTestToExecute = null;
	private String testIdentifier = null;
	private WebDriver driver = null;

	private static FlowExecutor flowExecutor = new FlowExecutor();

	public TestExecutor(WebDriver driver, String testIdentifier) {
		setDriver(driver);
		this.testIdentifier = testIdentifier;

	}

	@Override
	public TestResult call() throws Exception {
		// TODO Auto-generated method stub
		if (getCurrentTestToExecute() == null) {
			throw new RuntimeException(
					"Invalid Flow or Empty FLow provided to execute");
		}
		TestResult testResult = new TestResult(this.testIdentifier);
		testResult.setCurrentTestToExecute(getCurrentTestToExecute());
		List<FlowResult> flowResults = new ArrayList<FlowResult>();
		testResult.setFlowResults(flowResults);
		List<Flow> flows = getCurrentTestToExecute().getFlows();
		testResult.setStartTime(new Date(System.currentTimeMillis()));
		try {
			for (Flow flow : flows) {
				FlowResult flowResult = new FlowResult("FlowResult:"
						+ flow.getName() + " -> "
						+ testResult.getResultIdentifier());

				flowExecutor.executeFlow(driver, flow, flowResult);
				System.out.println("The status of FLOW Result is :"
						+ flowResult.getResult());
				flowResults.add(flowResult);

				if (testResult.getResult() == null
						|| testResult.getResult() == Result.PASSED) {
					testResult.setResult(flowResult.getResult());
				}
			}
			Thread.sleep(3000);

			getDriver().close();
			getDriver().quit();
		} finally {
			testResult.setEndTime(new Date(System.currentTimeMillis()));
		}
		return testResult;
	}

	/**
	 * @return the currentFlowToExecute
	 */
	public Test getCurrentTestToExecute() {
		return currentTestToExecute;
	}

	/**
	 * @param currentFlowToExecute
	 *            the currentFlowToExecute to set
	 */
	public void setCurrentTestToExecute(Test testToExecute) {
		this.currentTestToExecute = testToExecute;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return the testIdentifier
	 */
	public String getTestIdentifier() {
		return testIdentifier;
	}

}
