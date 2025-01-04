package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{

	public static final Logger logger = LogManager.getLogger(LoggingFilter.class);
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		logResponse(response);
		return response;
	}
	
	private void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URI: "+requestSpec.getBaseUri());
		logger.info("Request Header: "+requestSpec.getHeaders());
		logger.info("Request Body: "+requestSpec.getBody());
	}
	
	private void logResponse(Response response) {
		logger.info("Status code: "+response.getStatusCode());
		logger.info("Response Headers: "+response.getHeaders());
		logger.info("Response Body: "+response.getBody().prettyPrint());
	}

}
