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

import java.util.Date;

import org.openqa.selenium.WebDriver;

import testrunner.collector.Result;
import testrunner.collector.StepResult;
import testrunner.elements.Step;
import testrunner.elements.StepType;

/**
 * BaseStepExecutor is an abstract implementation of Step Executor. The Executor
 * framework decides how each step needs to be executed.The template method
 * pattern is used to expand the behavior of
 * {@link #executeStep(Step, WebDriver, StepResult)} method. The following
 * sequence of methods are called to execute a step <br>
 * <ul>
 * <li>{@link #recordStartTime(Step, WebDriver, StepResult)} - Before any step
 * execution, start time is recorded</li>
 * <li>{@link #validateStep(Step, WebDriver, StepResult)} The Validation that is
 * required for any step before actually executing the step</li>
 * <li>{@link BaseStepExecutor#doExecuteStep(Step, WebDriver, StepResult)} -
 * This method is responsible for actual execution. The underlying
 * implementations of BaseStepExecutors would do that</li>
 * <li>{@link #recordEndTime(Step, WebDriver, StepResult)} - This method is
 * responsible for recording the end time of step exeuction</li>
 * </ul>
 * 
 * @author Padmapriya Dasarathy -> (padmadasa@gmail.com)
 * @since 01-10-2014
 * @version 1.0
 * 
 */
public abstract class BaseStepExecutor implements StepExecutor {
	/**
	 * This method needs to validate if the step is a valid step to execute. For
	 * instance, {@link URLStepExecutor} will raise an exception if the passed
	 * step is not of type URL {@link StepType#URL}.
	 * 
	 * @param step
	 *            - Step to validate
	 * @param driver
	 *            - Driver on which this Step would be run
	 * @param result
	 *            - Result of validation
	 */
	protected abstract void validateStep(Step step, WebDriver driver,
			StepResult result) throws InvalidStepException;

	@Override
	public void executeStep(Step step, WebDriver driver, StepResult result) {
		try {
			recordStartTime(step, driver, result);

			validateStep(step, driver, result);
			doExecuteStep(step, driver, result);
			result.setResult(Result.PASSED);
		} catch (InvalidStepException ex) {
			System.out.println("The Step failed " + step + " Due to :"
					+ ex.getMessage());
			result.setResult(ex.getStepResult());
			result.setResultDetails("Error Message :" + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("The Step failed " + step + " Due to :"
					+ ex.getMessage());
			result.setResult(Result.FAILED);
			result.setResultDetails("Error Message :" + ex.getMessage()
					+ " Exception :" + ex + " Exception Trace: "
					+ ex.getStackTrace());
		} finally {
			recordEndTime(step, driver, result);
			if (result.getResult() == null) {
				result.setResult(Result.ABORTED);
				result.setResultDetails(result.getResultDetails()
						+ " : The step didn't complete successfully");
			}
		}

	}

	protected void recordStartTime(Step step, WebDriver driver,
			StepResult result) {
		Date startTime = new Date(System.currentTimeMillis());
		result.setStartTime(startTime);
	}

	protected void recordEndTime(Step step, WebDriver driver, StepResult result) {
		Date endTime = new Date(System.currentTimeMillis());
		result.setEndTime(endTime);
	}

	protected abstract void doExecuteStep(Step step, WebDriver driver,
			StepResult result) throws Exception;
	// TODO Auto-generated method stub

}
