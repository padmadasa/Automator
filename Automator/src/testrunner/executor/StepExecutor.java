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

import testrunner.collector.Result;
import testrunner.collector.StepResult;
import testrunner.elements.Step;

/**
 * The StepExecutor Interface defines the single behavior which is executing a
 * passed Step. For more concrete implementations, extending classes should
 * extend {@link BaseStepExecutor}
 * 
 * @author Padmapriya Dasarathy (padmadasa@gmail.com)
 * @version 1.0
 * @since 01-10-2014
 * 
 * 
 */
public interface StepExecutor {
	/**
	 * This method defines the entry point for any step execution. Implementing
	 * classes should ensure that following aspects of steps are taken care
	 * <ul>
	 * <li>
	 * The start time of step execution needs to be recorded in StepResult</li>
	 * <li>The Step should be validated before being executed</li>
	 * <li>If there are any validation errors then the error needs to be
	 * recorded in StepResult along with a status of {@link Result#FAILED}</li>
	 * <li>Irrespective of step execution the end time needs to be recorded.</li>
	 * </ul>
	 * 
	 * @param step
	 *            - Step to execute
	 * @param driver
	 *            - Driver to use to execute the step
	 * @param result
	 *            - Result of the step
	 * 
	 */
	public void executeStep(Step step, WebDriver driver, StepResult result);

}
