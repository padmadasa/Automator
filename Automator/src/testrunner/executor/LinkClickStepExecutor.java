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
 * 
 * @author Padmapriya Dasarathy
 * @since 01-10-2014
 * @version 1.0
 * 
 */
public class LinkClickStepExecutor extends BaseStepExecutor {

	@Override
	protected void validateStep(Step step, WebDriver driver, StepResult result)
			throws InvalidStepException {
		if (step.getStepType() != StepType.LINK) {
			throw new InvalidStepException("The passed Step :" + step
					+ " Is not a Link Step", Result.NOTRUN);
		}
		if (step.getLinkClick() == null
				|| step.getLinkClick().getLocateUsing() == null) {
			throw new InvalidStepException("The passed Step :" + step
					+ " Is not a Link Step", Result.NOTRUN);
		}
	}

	@Override
	protected void doExecuteStep(Step step, WebDriver driver, StepResult result)
			throws Exception {

		WebElement linkClickElement = step.getLinkClick().getLocateUsing()
				.locate(driver, step.getWaitFor());

		if (linkClickElement == null) {

			throw new InvalidStepException(
					"Unable to complete the step :"
							+ step
							+ " As the Link element could not be found with LocateUsing: "
							+ step.getLinkClick().getLocateUsing(),
					Result.NOTRUN);
		}
		linkClickElement.click();

	}
}