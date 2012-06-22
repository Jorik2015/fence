/**
 * WebService1Test.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package samples.quickstart.clients;

/*
 *  WebService1Test Junit test case
 */

public class WebService1Test extends junit.framework.TestCase {

	/**
	 * Auto generated test method
	 */
	public void testhelloWorld() throws java.lang.Exception {

		samples.quickstart.clients.WebService1Stub stub = new samples.quickstart.clients.WebService1Stub();

		samples.quickstart.clients.WebService1Stub.HelloWorld helloWorld2 = (samples.quickstart.clients.WebService1Stub.HelloWorld) getTestObject(samples.quickstart.clients.WebService1Stub.HelloWorld.class);
		String result = stub.helloWorld(helloWorld2).getHelloWorldResult();
		System.out.print(result);
		assertNotNull(result);

	}

	// Create an ADBBean and provide it as the test object
	public org.apache.axis2.databinding.ADBBean getTestObject(java.lang.Class type) throws java.lang.Exception {
		return (org.apache.axis2.databinding.ADBBean) type.newInstance();
	}

}
