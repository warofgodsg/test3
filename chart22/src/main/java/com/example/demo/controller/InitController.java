package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.DataClass;
import com.example.demo.service.selectDataService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class InitController {
	
	//protected Log log = LogFactory.getLog(this.getClass());
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	selectDataService selectDataService;
	
	@RequestMapping("/")
	public String IndexJsp(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("★★★★★★★★★★★★★★★	/  	★★★★★★★★★★★★★★");
		return "/index";
	}

	@RequestMapping("/callPopup.do")
	public String  callPopup(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("★★★★★★★★★★★★★★★		callPopup 	★★★★★★★★★★★★★★");
		DataClass dataClass = new DataClass(request);
		log.info(dataClass.getMap().toString());
		
		//List<Map<String, Object>> list = new ArrayList<>();
		//list = selectDataService.selectChartList(dataClass.getMap());
		//log.info(list.get(0).toString());
		//Map<String, Object> data = new HashMap();
		//data.put("DATA", list);
		return "/index";
	}
	
}

