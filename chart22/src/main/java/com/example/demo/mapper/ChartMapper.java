package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChartMapper {
	
	public List<Map<String,Object>> selectChartList(HashMap<String, Object> hashmap);

}
