package com.audio1414.ssw.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.audio1414.ssw.domain.Ping;
import com.audio1414.ssw.service.SswService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("${ssw.api.endpoint.url}")
@Api(description = "Set of endpoints for controlling squeezebox software player.")
public class SswController {
	
	private SswService sswService;
	
	/**
	 * @return the sswService
	 */
	public SswService getSswService() {
		return sswService;
	}

	/**
	 * @param sswService the sswService to set
	 */
	@Autowired
	public void setSswService(SswService sswService) {
		this.sswService = sswService;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/ping", produces = "application/json")
    @ApiOperation("${ssw.api.controller.ping}")
	public Ping ping() {
		return sswService.ping();
	}
	
}
