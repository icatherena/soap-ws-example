package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.SoapClient;
import com.example.demo.wsdl.AddResponse;
import com.example.demo.wsdl.DivideResponse;
import com.example.demo.wsdl.MultiplyResponse;
import com.example.demo.wsdl.SubtractResponse;

@RestController
public class SoapController {
	@Autowired
	private SoapClient client;
	
	@PostMapping("/sumar")
	public ResponseEntity<?> add(@RequestParam int numberA, @RequestParam int numberB) {
		AddResponse addResponse = client.getAddResponse(numberA, numberB);
		Map<String, Integer> response = new HashMap<>();
		response.put("Respuesta: ", addResponse.getAddResult());
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("/restar")
	public ResponseEntity<?> subtract(@RequestParam int numberA, @RequestParam int numberB) {
		SubtractResponse subtractResponse = client.getSubtractResponse(numberA, numberB);
		Map<String, Integer> response = new HashMap<>();
		response.put("Respuesta: ", subtractResponse.getSubtractResult());
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("/multiplicar")
	public ResponseEntity<?> multiply(@RequestParam int numberA, @RequestParam int numberB) {
		MultiplyResponse multiplyResponse = client.getMultiplyResponse(numberA, numberB);
		Map<String, Integer> response = new HashMap<>();
		response.put("Respuesta: ", multiplyResponse.getMultiplyResult());
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("/dividir")
	public ResponseEntity<?> divide(@RequestParam int numberA, @RequestParam int numberB) {
		DivideResponse divideResponse = client.getDivideResponse(numberA, numberB);
		Map<String, Integer> response = new HashMap<>();
		response.put("Respuesta: ", divideResponse.getDivideResult());
		return ResponseEntity.ok().body(response);
	}
}
