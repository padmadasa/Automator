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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testrunner.collector.Result;
import testrunner.collector.StepResult;
import testrunner.elements.Step;
import testrunner.elements.StepType;

/**
 * @author Padmapriya Dasarathy (padmadasa@gmail.com)
 * @version 1.0
 * @since 01-10-2014
 */
public class SubmitActionStepExecutor extends BaseStepExecutor {

	@Override
	protected void validateStep(Step step, WebDriver driver, StepResult result)
			throws InvalidStepException {
		if (step.getStepType() != StepType.SUBMIT) {
			throw new InvalidStepException("The passed Step :" + step
					+ " is not a Submit Button Step", Result.NOTRUN);
		}
		if (step.getSubmitAction() == null
				|| step.getSubmitAction().getLocateUsing() == null) {
			throw new InvalidStepException("The passed Step :" + step
					+ " is Not having any locator details", Result.NOTRUN);
		}
		if (step.getSubmitAction().getLocateUsing() == null) {
			throw new InvalidStepException(
					"The passed Step :"
							+ step
							+ " Doesn't have a valid XPATH of CSS Selector Text in Locator details",
					Result.NOTRUN);
		}
	}

	@Override
	protected void doExecuteStep(Step step, WebDriver driver, StepResult result)
			throws Exception {

		WebElement submitButton = step.getSubmitAction().getLocateUsing()
				.locate(driver, step.getWaitFor());

		if (submitButton == null) {
			throw new InvalidStepException(
					"Unable to Locate SubmitButton for the Step:" + step
							+ " Using Locator Details :"
							+ step.getSubmitAction().getLocateUsing(),
					Result.NOTRUN);
		}
		submitButton.click();
	}
}