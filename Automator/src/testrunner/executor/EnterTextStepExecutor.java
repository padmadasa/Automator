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
public class EnterTextStepExecutor extends BaseStepExecutor {

	@Override
	protected void validateStep(Step step, WebDriver driver, StepResult result)
			throws InvalidStepException {
		// TODO Auto-generated method stub
		if (step.getStepType() != StepType.TEXT) {
			throw new InvalidStepException("The passed Step Type :"
					+ step.getStepType()
					+ " Is not an Text Step. Halting and failing the test",
					Result.NOTRUN);
		} else if (step.getEnterText() == null
				|| step.getEnterText().getLocateUsing() == null
				|| step.getEnterText().getText() == null
				|| step.getEnterText().getText().trim().equals("")) {
			throw new InvalidStepException("The passed Text Step :"
					+ step.getEnterText() + " is Empty", Result.NOTRUN);
		}

	}

	@Override
	protected void doExecuteStep(Step step, WebDriver driver, StepResult result)
			throws Exception {
		WebElement textElement = null;
		textElement = step.getEnterText().getLocateUsing()
				.locate(driver, step.getWaitFor());
		if (textElement != null) {
			textElement.clear();
			textElement.sendKeys(step.getEnterText().getText());
			System.out.println("The status of SUBMIT is :"
					+ step.getEnterText().isSubmit());
			if (step.getEnterText().isSubmit()) {
				textElement.click();
			}
		} else {
			throw new InvalidStepException(
					"The Step :"
							+ step
							+ " Doesn't have any text and locator details associated to it",
					Result.NOTRUN);
		}
	}
}
