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
package testrunner.convertor;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import testrunner.elements.Test;

/**
 * 
 */

/**
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
public class TestBuilder {

	public static Test buildTest(String xmlPath) throws Exception {

		JAXBContext jc = JAXBContext.newInstance("testrunner.elements");
		Unmarshaller u = jc.createUnmarshaller();
		Test testToRun = (Test) u.unmarshal(new File(xmlPath));

		/*
		 * Iterator<Flow> iterator = this.currentTest.getFlows().iterator(); int
		 * count = 1;
		 * 
		 * while (iterator.hasNext()) { System.out.println("Flow Count :" +
		 * count); Flow flow = iterator.next(); count++;
		 * System.out.println("The flow is :" + flow.getName()); List<Step>
		 * steps = flow.getSteps(); for (Step step : steps) {
		 * System.out.println("The Step is :" + step); } }
		 */
		return testToRun;
	}

}