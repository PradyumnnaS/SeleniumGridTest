package com.test.grid;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestNgRunner {

	public void xmlWithCode() {
		List<XmlSuite> suitetest = new ArrayList<XmlSuite>();
		List<XmlClass> classlist = new ArrayList<XmlClass>();
		
		List<Class<? extends ITestNGListener>> ilistener = new ArrayList<Class<? extends ITestNGListener>>();
		
		XmlSuite suitename = new XmlSuite();
		suitename.setName("SeleniumGrid Test Suite");
		
		XmlTest testname =  new XmlTest(suitename);
		testname.setName("Chrome test");
		
		XmlClass classname = new XmlClass("com.test.grid.SeleniumGridTest");
		classlist.add(classname);
		ilistener.add(XmlListener.class);
		
		testname.setXmlClasses(classlist);
		
		suitetest.add(suitename);
		
		TestNG testrun = new TestNG();
		testrun.setXmlSuites(suitetest);
		testrun.setListenerClasses(ilistener);
		testrun.run();
		
 	}
	
	public static void main(String args[]) {
		
		TestNgRunner testngrunner = new TestNgRunner();
		testngrunner.xmlWithCode();
	}
}
