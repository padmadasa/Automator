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

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import testrunner.collector.Result;
import testrunner.collector.StepResult;
import testrunner.elements.Step;
import testrunner.elements.StepType;

/**
 * 
 * @author Padmapriya Dasarathy
 * @since 01-10-2014
 * @version 1.0
 * 
 */
public class URLStepExecutor extends BaseStepExecutor {

	@Override
	protected void validateStep(Step step, WebDriver driver, StepResult result)
			throws InvalidStepException {
		if (step.getStepType() != StepType.URL) {
			throw new InvalidStepException("The passed Step Type :"
					+ step.getStepType()
					+ " Is not an URL Step. Halting and failing the test",
					Result.NOTRUN);
		} else if (step.getUrl() == null || step.getUrl().trim().equals("")) {
			throw new InvalidStepException("The passed Step URL :"
					+ step.getUrl() + " is Empty", Result.NOTRUN);
		}

	}

	/**
	 * This method executes the step by loading the step's URL using the passed
	 * driver.
	 */
	protected void doExecuteStep(Step step, WebDriver driver, StepResult result)
			throws Exception {
		driver.get(step.getUrl());
		try {
			if (driver.getTitle().matches(
					"Certificate Error: Navigation Blocked")) {
				driver.get("javascript:document.getElementById('overridelink').click();");
				Thread.sleep(500);
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
		} catch (NoAlertPresentException e) {

		}
	}

}