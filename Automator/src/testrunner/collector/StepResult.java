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

import testrunner.elements.Step;

/**
 * This class is responsible for collecting the test results.
 * 
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
public class StepResult extends ResultDetails {

	public StepResult(String resultIdentifier) {
		super(resultIdentifier, ResultType.STEP_RESULT);
		// TODO Auto-generated constructor stub
	}

	private Step executedStep = null;

	/**
	 * @return the step
	 */
	public Step getExecutedStep() {
		return executedStep;
	}

	/**
	 * @param step
	 *            the step to set
	 */
	public void setExecutedStep(Step step) {
		this.executedStep = step;
	}

}
