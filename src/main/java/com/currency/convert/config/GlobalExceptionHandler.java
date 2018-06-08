package com.currency.convert.config;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author yeshendra Globally handling of exceptions
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	private String getRequestDetails(HttpServletRequest req) {
		Map<String, String> requestMap = new HashMap<String, String>();
		Enumeration<?> requestParamNames = req.getParameterNames();

		while (requestParamNames.hasMoreElements()) {
			String requestParamName = (String) requestParamNames.nextElement();
			String requestParamValue = req.getParameter(requestParamName);

			requestMap.put(requestParamName, requestParamValue);
		}

		StringBuilder requestDetails = new StringBuilder("Request Details:\n").append("HTTP METHOD: ")
				.append(req.getMethod()).append("\nPATH INFO: ").append(req.getRequestURI());
		requestDetails.append("\nREQUEST PARAMETERS: ").append(requestMap).append("\nREMOTE ADDRESS: ")
				.append(req.getRemoteAddr());

		return requestDetails.toString();
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ExceptionDto handleException(HttpServletRequest req, Exception ex) {
		logger.debug(getRequestDetails(req));
		logger.debug("Exception occurred", ex);

		ExceptionDto response = new ExceptionDto();

		response.setCode(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		response.setMessage(ex.getMessage());

		return response;
	}

}
