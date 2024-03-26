package ListenersPackage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.reporters.IReporterConfig;
import org.testng.xml.XmlSuite;

import com.google.common.io.Files;

public class ListenersJava implements ITestListener, ISuiteListener, IInvokedMethodListener, IReporter{
	
	public WebDriver driver;
	
	@Test(priority=1)
	public void setUp()
	{
		driver = new ChromeDriver();
	}
	
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
		
		for(ISuite suite:suites)
		{
			String suitename=suite.getName();
			
			for(String testname:suite.getResults().keySet())
			{
				//System.out.println(suite.getResults().get(testname).getTestContext().getPassedTests().size());
				//System.out.println(suite.getResults().get(testname).getTestContext().getFailedTests().size());
				
				
				System.out.println(((ITestResult) suite).getTestContext());
                System.out.println(((ITestResult) suite).getTestContext());
				
				
				System.out.println(suite.getResults().get(testname).getTestContext().getSkippedTests().size());
			}
			
		}
		
		
		
		
	}

	@Override
	public IReporterConfig getConfig() {
		// TODO Auto-generated method stub
		return IReporter.super.getConfig();
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		IInvokedMethodListener.super.beforeInvocation(method, testResult);
		System.out.println("beforeInvocation");
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		IInvokedMethodListener.super.afterInvocation(method, testResult);
		System.out.println("afterInvocation");
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
		// TODO Auto-generated method stub
		IInvokedMethodListener.super.beforeInvocation(method, testResult, context);
		System.out.println("beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context");
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
		// TODO Auto-generated method stub
		IInvokedMethodListener.super.afterInvocation(method, testResult, context);
		System.out.println("afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context)");
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		ITestListener.super.onTestSuccess(result);
		System.out.println(result.getName());
		System.out.println("onTestSuccess");
		try
		{
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			Files.copy(f,  new File("C:\\Users\\viraj\\OneDrive\\Desktop\\Edubridge-Courses\\" +result.getName() +".jpg"));
		}catch (IOException e)
		{
			e.printStackTrace();
		} 
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		System.out.println(result.getName());
		
		System.out.println("onTestFailure");
		try
		{
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Files.copy(f,  new File("C:\\Users\\viraj\\OneDrive\\Desktop\\Edubridge-Courses\\" +result.getName() +".jpg"));
		}catch (IOException e)
		{
			e.printStackTrace();
		} 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		System.out.println("your suite has begun");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		System.out.println("your suite has finish");
	}

}
