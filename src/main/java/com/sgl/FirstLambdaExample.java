package com.sgl;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FirstLambdaExample implements RequestHandler<String, String> {

	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Override
	public String handleRequest(String input, Context context) {

		LambdaLogger logger = context.getLogger();
		String response = "200 OK";
		logger.log("Environment Variable: " + gson.toJson(System.getenv()));
		logger.log("Context: " + gson.toJson(context));
		logger.log("Hello world, Lambda. Input to the function is  " + input);
		logger.log("Input: " + input.getClass());
		return response;
	}

}
