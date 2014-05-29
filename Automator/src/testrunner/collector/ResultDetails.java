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

import java.util.Date;

/**
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
public class ResultDetails {
	private Date startTime = null;
	private Date endTime = null;
	private Result result = null;
	private String resultDetails = null;
	private String resultIdentifier = null;
	private ResultType resultType = null;

	public ResultType getResultType() {
		return this.resultType;
	}

	public String getResultIdentifier() {
		return this.resultIdentifier;
	}

	private ResultDetails() {

	}

	public ResultDetails(String resultIdentifier, ResultType resultType) {
		this.resultIdentifier = resultIdentifier;
		this.resultType = resultType;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Result result) {
		this.result = result;
	}

	/**
	 * @return the resultDetails
	 */
	public String getResultDetails() {
		return resultDetails;
	}

	/**
	 * @param resultDetails
	 *            the resultDetails to set
	 */
	public void setResultDetails(String resultDetails) {
		this.resultDetails = resultDetails;
	}

	public String toString() {
		return "{Test Identifier :" + this.resultIdentifier
				+ "}{ Started At : " + this.startTime + "}{ Ended at :"
				+ this.endTime + "}{Test Type:" + this.resultType
				+ "}{Test Result :" + this.result + "}{ Result Details :"
				+ this.resultDetails + "}";
	}
}
