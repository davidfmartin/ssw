package com.audio1414.ssw.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import com.audio1414.ssw.domain.Ping;

@Service
public class SswService {

	@Autowired
	private Environment env;
	
	public Ping ping() {
		String version = env.getProperty("ssw.api.version");
		Ping ping = new Ping("ssw is up!", new Date().toString(), version);
		return ping;
	}
}
