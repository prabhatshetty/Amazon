package com.amazon.testdata;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.amazon.testcase.Base_Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.model.Media;

public class Listener extends Base_Test implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		if (ITestResult.SUCCESS == result.getStatus()) {
			try {

				System.out.println("PASSING Screen Shot");
				String path = ScreenCap.screenCap(driver, result.getMethod().getMethodName());
				test = extent.createTest(result.getMethod().getMethodName());
				test.log(Status.PASS, "TestCase Failed");
				test.addScreenCaptureFromBase64String(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {

				// System.out.println("Taking Screen Shot");
				String path = ScreenCap.screenCap(driver, result.getMethod().getMethodName());
				test = extent.createTest(result.getMethod().getMethodName());
				test.log(Status.FAIL, "TestCase Failed");
				test.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
