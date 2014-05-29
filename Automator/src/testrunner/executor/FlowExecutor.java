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

import org.openqa.selenium.WebDriver;

import testrunner.collector.FlowResult;
import testrunner.collector.Result;
import testrunner.collector.StepResult;
import testrunner.elements.Flow;
import testrunner.elements.Step;
/**
 * 
 * @author Padmapriya Dasarathy
 * @since 01-10-2014
 * @version 1.0
 * 
 */
public class FlowExecutor {
	private static StepExecutor enterTextExecutor = new EnterTextStepExecutor();
	private static StepExecutor linkClickExecutor = new LinkClickStepExecutor();
	private static StepExecutor selectOptionExecutor = new SelectOptionStepExecutor();
	private static StepExecutor submitActionExecutor = new SubmitActionStepExecutor();
	private static StepExecutor urlExecutor = new URLStepExecutor();

	public void executeFlow(WebDriver driver, Flow flow, FlowResult flowResult) {
		List<Step> steps = flow.getSteps();
		List<StepResult> stepResults = new ArrayList<StepResult>();
		flowResult.setStepResults(stepResults);
		flowResult.setStartTime(new Date(System.currentTimeMillis()));
		for (Step step : steps) {
			StepResult stepResult = new StepResult("StepResult:"
					+ step.getName() + " -> "
					+ flowResult.getResultIdentifier());
			stepResult.setExecutedStep(step);
			stepResults.add(stepResult);
			// System.out.println("The Step inside the flow is :" + step
			// + " Its Type " + step.getStepType());
			switch (step.getStepType()) {
			case URL:
				urlExecutor.executeStep(step, driver, stepResult);
				setFlowResult(stepResult.getResult(), flowResult);
				break;
			case LINK:
				linkClickExecutor.executeStep(step, driver, stepResult);
				setFlowResult(stepResult.getResult(), flowResult);
				break;
			case SUBMIT:
				submitActionExecutor.executeStep(step, driver, stepResult);
				setFlowResult(stepResult.getResult(), flowResult);
				break;
			case TEXT:
				enterTextExecutor.executeStep(step, driver, stepResult);
				setFlowResult(stepResult.getResult(), flowResult);
				break;
			case SELECT:
				selectOptionExecutor.executeStep(step, driver, stepResult);
				setFlowResult(stepResult.getResult(), flowResult);
				break;
			case INVALID_STEP:
				setFlowResult(Result.NOTRUN, flowResult);
				flowResult.setResultDetails("The passed Step :" + step
						+ " Is an Invalid Step");
				break;
			}

		}
		flowResult.setEndTime(new Date(System.currentTimeMillis()));
		// System.out.println("The Flow Result for Flow is :" + flowResult);
	}

	protected void setFlowResult(Result result, FlowResult flowResult) {
		if (flowResult.getResult() == null
				|| flowResult.getResult() == Result.PASSED) {
			System.out.println("The Step Result obtained is :" + result
					+ " To be set for the FlowResult " + flowResult);
			flowResult.setResult(result);
		}
	}
}
