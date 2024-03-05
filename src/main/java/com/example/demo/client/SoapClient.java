package com.example.demo.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.demo.wsdl.Add;
import com.example.demo.wsdl.AddResponse;
import com.example.demo.wsdl.Divide;
import com.example.demo.wsdl.DivideResponse;
import com.example.demo.wsdl.Multiply;
import com.example.demo.wsdl.MultiplyResponse;
import com.example.demo.wsdl.Subtract;
import com.example.demo.wsdl.SubtractResponse;

public class SoapClient extends WebServiceGatewaySupport {
	public AddResponse getAddResponse(int numberA, int numberB) {
		Add addRequest = new Add();
		addRequest.setIntA(numberA);
		addRequest.setIntB(numberB);
		SoapActionCallback callback = new SoapActionCallback("http://tempuri.org/Add");
		AddResponse addResponse = (AddResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", 
						addRequest, 
						callback);
		return addResponse;
	}
	public SubtractResponse getSubtractResponse(int numberA, int numberB) {
		Subtract subtractRequest = new Subtract();
		subtractRequest.setIntA(numberA);
		subtractRequest.setIntB(numberB);
		SoapActionCallback callback = new SoapActionCallback("http://tempuri.org/Subtract");
		SubtractResponse subtractResponse = (SubtractResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
						subtractRequest,
						callback);
		return subtractResponse;
	}
	public MultiplyResponse getMultiplyResponse(int numberA, int numberB) {
		Multiply multiplyRequest = new Multiply();
		multiplyRequest.setIntA(numberA);
		multiplyRequest.setIntB(numberB);
		SoapActionCallback callback = new SoapActionCallback("http://tempuri.org/Multiply");
		MultiplyResponse multiplyResponse = (MultiplyResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
						multiplyRequest,
						callback);
		return multiplyResponse;
	}
	public DivideResponse getDivideResponse(int numberA, int numberB) {
		Divide divideRequest = new Divide();
		divideRequest.setIntA(numberA);
		divideRequest.setIntB(numberB);
		SoapActionCallback callback = new SoapActionCallback("http://tempuri.org/Divide");
		DivideResponse divideResponse = (DivideResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", 
						divideRequest,
						callback);
		return divideResponse;
	}
}
