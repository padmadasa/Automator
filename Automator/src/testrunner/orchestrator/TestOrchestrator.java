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
package testrunner.orchestrator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import testrunner.collector.TestResult;
import testrunner.convertor.TestBuilder;
import testrunner.elements.Test;
import testrunner.elements.TestConfig;
import testrunner.executor.TestExecutor;

/**
 * This class is responsible for reading an XML from the input location, convert
 * it into {@link Test} and execute it using a {@link ThreadPoolExecutor}. For
 * each Task created, a new driver and TestResult is assigned, and Once test is
 * complete, the returned testResults are collated for providing a detailed time
 * based test execution
 * 
 * @author Padmapriya Dasarathy
 * @since 01-10-2014
 * @version 1.0
 * 
 */
public class TestOrchestrator {

	public static void main(String[] args) throws Exception {
		String xmlPath = (args != null && args.length > 0 ? args[0] : null);
		if (xmlPath == null || xmlPath.trim().equals("")) {
			xmlPath = "/Users/daponn/personals/2014/selenium-Priya/testXML/TestHomePageAndSearch.xml";
		}

		if (xmlPath == null || xmlPath.trim().equals("")) {
			System.out
					.println("No XML File is passed. Please pass an XML File to run the test");
			System.exit(0);
		}
		Test test = TestBuilder.buildTest(xmlPath);

		TestConfig testConfig = test.getTestConfig();
		System.out.println("The Test Object is :" + test);
		if (test == null || test.getFlows() == null
				|| test.getFlows().isEmpty()) {
			System.out
					.println("The XML :"
							+ xmlPath
							+ " Seems to have no Flows defined. Please specify a Valid Test with Flows");
			System.exit(0);
		}
		int users = test.getUsers();
		if (users <= 0) {
			users = 1;
		}
		ExecutorService fixedPoolExecutor = Executors.newFixedThreadPool(users);

		WebDriver ffDriver = null;
		WebDriver chromeDriver = null;
		WebDriver ieDriver = null;
		System.out.println("The testConfig is " + testConfig);
		List<Future<TestResult>> testResults = new ArrayList<Future<TestResult>>();
		for (int user = 1; user <= users; user++) {

			if (testConfig.isEnableFireFox()) {

				FirefoxProfile seleniumProfile = null;
				ProfilesIni allProfile = new ProfilesIni();
				seleniumProfile = allProfile.getProfile("default");
				ffDriver = new FirefoxDriver(seleniumProfile);

				TestExecutor testExecutor = new TestExecutor(ffDriver,
						"FFTestUser:" + user);

				if (test.isResetCookies()) {
					ffDriver.manage().deleteAllCookies();
				}
				testExecutor.setCurrentTestToExecute(test);
				Future<TestResult> result = fixedPoolExecutor
						.submit(testExecutor);
				testResults.add(result);

			}
			if (testConfig.isEnableChrome()) {

				System.out.println("The Chrome path is "
						+ testConfig.getChromePath());
				if (testConfig.getChromePath() != null) {
					System.setProperty("webdriver.chrome.driver", testConfig
							.getChromePath().trim());
				} else {
					System.setProperty("webdriver.chrome.driver",
							"c:\\Work\\Tools\\Selenium\\chromedriver.exe");
				}
				chromeDriver = new ChromeDriver();
				TestExecutor testExecutor = new TestExecutor(chromeDriver,
						"ChromeTestUser:" + user);
				if (test.isResetCookies()) {
					chromeDriver.manage().deleteAllCookies();
				}
				testExecutor.setCurrentTestToExecute(test);
				Future<TestResult> result = fixedPoolExecutor
						.submit(testExecutor);
				testResults.add(result);

			}
			if (testConfig.isEnableIE()) {
				System.setProperty("webdriver.ie.driver",
						testConfig.getIePath());
				DesiredCapabilities caps = DesiredCapabilities
						.internetExplorer();
				caps.setCapability(
						InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,
						false);
				caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,
						"about:blank");
				// caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,
				// true);
				ieDriver = new InternetExplorerDriver(caps);
				TestExecutor testExecutor = new TestExecutor(ieDriver,
						"IETestUser:" + user);
				if (test.isResetCookies()) {
					ieDriver.manage().deleteAllCookies();
				}
				testExecutor.setCurrentTestToExecute(test);
				Future<TestResult> result = fixedPoolExecutor
						.submit(testExecutor);
				testResults.add(result);

			}
		}
		for (Future<TestResult> result : testResults) {
			TestResult testResult = result.get();
			System.out.println("Test Result is " + testResult);
		}
		fixedPoolExecutor.shutdown();
		System.out.println("The test is completed ");
	}
}