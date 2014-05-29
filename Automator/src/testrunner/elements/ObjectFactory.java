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
package testrunner.elements;

import javax.xml.bind.annotation.XmlType;

/**
 * @author Padmapriya Dasarathy
 * @version 1.0
 * @since 01-10-2014
 */
@XmlType
public class ObjectFactory {
	public static Flow getFlow() {
		return new Flow();
	}

	public static Step getStep() {
		return new Step();
	}

	public static CSSSelector getCSSSelector() {
		return new CSSSelector();
	}

	public static EnterText getEnterText() {
		return new EnterText();
	}

	public static LinkClick getLinkClick() {
		return new LinkClick();
	}

	public static LocateUsing getLocateUsing() {
		return new LocateUsing();
	}

	public static OptionValue getOptionValue() {
		return new OptionValue();
	}

	public static SelectOption getSelectOption() {
		return new SelectOption();
	}

	public static SubmitAction getSubmitAction() {
		return new SubmitAction();
	}

	public static Test getTest() {
		return new Test();
	}

	public static XPath getXPath() {
		return new XPath();
	}

	public static TestConfig getTestConfig() {
		return new TestConfig();
	}
}