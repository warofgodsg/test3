package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ChartMapper;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class selectDataService  {
	
	@Autowired
	ChartMapper chartMapper;
	public List<Map<String, Object>> selectChartList(HashMap<String, Object> request) throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("listData");
		List<Map<String, Object>> list = new ArrayList<>();
		list = chartMapper.selectChartList(request);
		return list;
	}

}
