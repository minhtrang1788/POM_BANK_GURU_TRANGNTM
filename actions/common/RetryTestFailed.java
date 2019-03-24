package common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import pageUI.Constants;

public class RetryTestFailed implements IRetryAnalyzer {
	private int retryCount =  Constants.RETRY_COUNT;
	private int maxRetryCount = Constants.MAX_RETRY_COUNT;

	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			System.out.println("Retry test name: " + result.getName() + " with: " + (retryCount + 1) + " time(s).");
			retryCount++;
			return true;
		}
		return false;
	}
}