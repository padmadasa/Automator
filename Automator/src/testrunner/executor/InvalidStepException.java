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

import testrunner.collector.Result;

/**
 * 
 * @author Padmapriya Dasarathy
 * @since 01-10-2014
 * @version 1.0
 * 
 */
public class InvalidStepException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Result stepResult = null;

	/**
	 * This exception is thrown for Step validation phase.
	 * 
	 * @param exceptionTxt
	 * @param Result
	 *            - The result of whether the exception should cause Result to
	 *            fail or Abort or No Run Status
	 */
	public InvalidStepException(String exceptionTxt, Result result) {
		super(exceptionTxt);
		stepResult = result;
	}

	/**
	 * @return the stepResult
	 */
	public Result getStepResult() {
		return stepResult;
	}

	/**
	 * @param stepResult
	 *            the stepResult to set
	 */
	public void setStepResult(Result stepResult) {
		this.stepResult = stepResult;
	}

}
