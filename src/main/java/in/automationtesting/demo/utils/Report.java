package in.automationtesting.demo.utils;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Report implements ITestListener {
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().fail("Ocorreu uma falha no teste.", Screenshot.capture());
    }

    public static void log(Status status, String message) {
        ExtentTestManager.getTest().log(status, message);
    }
}