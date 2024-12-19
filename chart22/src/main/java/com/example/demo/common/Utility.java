package com.example.demo.common;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URLEncoder;
import java.sql.Clob;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * 공통 유틸리티 클래스
 * @author 김태윤
 * since 2012. 9. 4.
 */
public final class Utility {
//
//	private static SimpleDateFormat shortDateFmt = new SimpleDateFormat("yyyyMMdd");
//	private static SimpleDateFormat longDateFmt = new SimpleDateFormat("yyyy/MM/dd");
//
//	private static SimpleDateFormat longToDateFmt = new SimpleDateFormat("yyyy-MM-dd");
//
//	private static SimpleDateFormat dayDateFmt = new SimpleDateFormat("MM/dd");
//
//	private static SimpleDateFormat shortTimeFmt = new SimpleDateFormat("yyyyMMddHHmm");
//	private static SimpleDateFormat LongTimeFmt = new SimpleDateFormat("yyyyMMddHHmmss");
//	private static SimpleDateFormat LongTimeFmtUnder = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
//	private static SimpleDateFormat timeFmt = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//
//	private static Log log = null;
//
//	static {
//		log = LogFactory.getLog((new Utility()).getClass());
//	}
//
//
//	/**
//	*	List Object 를 JSON 문자열로 변환한다.
//	*	@param obj Map데이터를 가지고있는 배열
//	*	@return String json형태의 문자열
//	*   @throws Exception
//	*/
//	public static String toJSON(List obj) throws Exception{
//		String jsonStr = "";
//		
//		//Gson gson = new Gson();
//		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//		
//        jsonStr = gson.toJson(obj);
//        
//		//log.debug("....................A:"+jsonStr);
//		
//		//jsonStr = jsonStr.replaceAll("&quot;", "″");
//		//jsonStr = jsonStr.replaceAll("&quot;", "\\u0026quot;");
//		jsonStr = jsonStr.replaceAll("&quot;", "\\\\\"");
//		jsonStr = StringEscapeUtils.unescapeHtml(jsonStr);
//		
//		//log.debug("....................B:"+jsonStr);
//	
//		
//        jsonStr = "{\"DATA\":"+jsonStr+"}";
//		return jsonStr;
//	}
//	
//	public static String clobToString(Clob clob) throws Exception {
//
//		if (clob == null) return "";
//
//		/* 이건 엔터키가 없어진다???
//		StringBuffer strOut = new StringBuffer();
//		String str = "";
//		BufferedReader br = new BufferedReader(clob.getCharacterStream());
//		while ((str = br.readLine()) != null) {
//			strOut.append(str);
//		}
//		return strOut.toString();
//		*/
//		
//		int j = 0;
//		StringBuffer buffer = new StringBuffer();
//		int ch;
//		Reader r = clob.getCharacterStream();
//		while ((ch = r.read())!=-1) {
//		   buffer.append(""+(char)ch);
//		}
//		return buffer.toString();
//
//	}
//	
//	public static String toJSON_Conv(List obj) throws Exception {
//		return  toJSON_Conv(obj, null); 
//	}
//	// colEncode : 암호화된 컬럼ID. 여러개인 경우 @로 구분
//	public static String toJSON_Conv(List obj, String colEncode) throws Exception {
//		HashMap data = null;
//		for(int i=0; i<obj.size(); i++){
//			data =  (HashMap)obj.get(i);
//			log.debug("..................data_PRE:"+data);
//			
//	        Set<String> keySet = data.keySet();
//	        for (String key : keySet) {
//	        	//log.debug("..................key:"+key+">>>"+data.get(key));
//	        	if(data.get(key) == null) continue;
//	        	if((data.get(key).toString()).indexOf("oracle.sql.CLOB") > -1) {
//	        		data.put(key, clobToString((Clob)data.get(key)));
//	        	}
//	        	if(!Utility.isNull(colEncode) && ("@"+colEncode+"@").indexOf("@"+key+"@") >= 0) {
//	        		data.put(key, AesClass.AES_Decode((String)data.get(key)));
//	        	}
//	        }
//			obj.set(i, data);
//			//log.debug("..................data_AFT:"+data);
//		}
//		return toJSON(obj);
//	}
//	
//	public static String toJSON_SELECT_RESULT(List obj) throws Exception{
//		String jsonStr = "";
//		
//		//Gson gson = new Gson();
//		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//		
//        jsonStr = gson.toJson(obj);
//        
//		//log.debug("....................A:"+jsonStr);
//		
//		//jsonStr = jsonStr.replaceAll("&quot;", "″");
//		//jsonStr = jsonStr.replaceAll("&quot;", "\\u0026quot;");
//		jsonStr = jsonStr.replaceAll("&quot;", "\\\\\"");
//		jsonStr = StringEscapeUtils.unescapeHtml(jsonStr);
//		
//		//log.debug("....................B:"+jsonStr);
//	
//		
//        jsonStr = "{\"SELECT_RESULT\":"+jsonStr+"}";
//		return jsonStr;
//	}
//	public static String toJSON_SELECT_LIST(List obj) throws Exception{
//		String jsonStr = "";
//		
//		//Gson gson = new Gson();
//		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//		
//        jsonStr = gson.toJson(obj);
//        
//		//log.debug("....................A:"+jsonStr);
//		
//		//jsonStr = jsonStr.replaceAll("&quot;", "″");
//		//jsonStr = jsonStr.replaceAll("&quot;", "\\u0026quot;");
//		jsonStr = jsonStr.replaceAll("&quot;", "\\\\\"");
//		jsonStr = StringEscapeUtils.unescapeHtml(jsonStr);
//		
//		//log.debug("....................B:"+jsonStr);
//	
//		
//        jsonStr = "{\"SELECT_LIST\":"+jsonStr+"}";
//		return jsonStr;
//	}
//	
//	public static String toJSON_PDA(Map obj, List obj2) throws Exception{
//		String jsonStr = "";
//		String jsonStr2 = "";
//		String jsonRslt = "";
//		Gson gson = new Gson();
//
//        //Map Object 를 JSON 문자열로 변환
//        jsonStr = gson.toJson(obj);
//        jsonStr2 = gson.toJson(obj2);
//        jsonStr2 = jsonStr2.replaceAll("&quot;", "\\\\\"");
//		jsonStr2 = StringEscapeUtils.unescapeHtml(jsonStr2);
//        jsonRslt = "{\"SELECT_RESULT\":"+jsonStr+", \"SELECT_LIST\":"+jsonStr2+"}";
//		return jsonRslt;
//	}
//
//	public static String toJSON(Object obj) throws Exception{
//		String jsonStr = "";
//		Gson gson = new Gson();
//        
//        jsonStr = gson.toJson(obj);
//        jsonStr = "{\"DATA\":"+jsonStr+"}";
//		return jsonStr;
//	}
//	
//	public static String toJSON_SELECT_RESULT(Object obj) throws Exception{
//		String jsonStr = "";
//		Gson gson = new Gson();
//        
//        jsonStr = gson.toJson(obj);
//        jsonStr = "{\"SELECT_RESULT\":"+jsonStr+"}";
//		return jsonStr;
//	}
//	public static String toJSON_SELECT_LIST(Object obj) throws Exception{
//		String jsonStr = "";
//		Gson gson = new Gson();
//        
//        jsonStr = gson.toJson(obj);
//        jsonStr = "{\"SELECT_LIST\":"+jsonStr+"}";
//		return jsonStr;
//	}
//
//	/**
//	*	Map Object 를 JSON 문자열로 변환한다.
//	*	@param obj Map데이터
//	*	@return String json형태의 문자열
//	*   @throws Exception
//	*/
//	public static String toJSON(Map obj) throws Exception{
//		String jsonStr = "";
//		Gson gson = new Gson();
//
//
//        //Map Object 를 JSON 문자열로 변환
//        jsonStr = gson.toJson(obj);
//        jsonStr = "{\"DATA\":"+jsonStr+"}";
//		return jsonStr;
//	}
//	
//	public static String toJSON_SELECT_RESULT(Map obj) throws Exception{
//		String jsonStr = "";
//		Gson gson = new Gson();
//
//        //Map Object 를 JSON 문자열로 변환
//        jsonStr = gson.toJson(obj);
//        jsonStr = "{\"SELECT_RESULT\":"+jsonStr+"}";
//		return jsonStr;
//	}
//	public static String toJSON_SELECT_LIST(Map obj) throws Exception{
//		String jsonStr = "";
//		Gson gson = new Gson();
//
//        //Map Object 를 JSON 문자열로 변환
//        jsonStr = gson.toJson(obj);
//        jsonStr = "{\"SELECT_LIST\":"+jsonStr+"}";
//		return jsonStr;
//	}
//
//	/**
//	*	Map Object 를 JSON 문자열로 변환한다.
//	*	@param obj Map데이터
//	*	@return String json형태의 문자열
//	*   @throws Exception
//	*/
//	public static String toJSONdefault(Map obj) throws Exception{
//		String jsonStr = "";
//		Gson gson = new Gson();
//
//        //Map Object 를 JSON 문자열로 변환
//        jsonStr = gson.toJson(obj);
//		return jsonStr;
//	}
//
//	/**
//	*	Map Object 를 JSON 문자열로 변환한다.
//	*	@param obj Map데이터
//	*	@return String json형태의 문자열
//	*   @throws Exception
//	*/
//	public static String toJSONdefault(List obj) throws Exception{
//		String jsonStr = "";
//		Gson gson = new Gson();
//
//        //Map Object 를 JSON 문자열로 변환
//        jsonStr = gson.toJson(obj);
//		return jsonStr;
//	}
//
//	/**
//	*	JSON 문자열을 출력한다.
//	*	@param res  HttpServletResponse
//	*	@param jsonStr json 형태의 문자열
//	*	@return void
//	*   @throws Exception
//	*/
//	public static void flushJSON(HttpServletResponse res, String jsonStr) throws Exception{
//
//		PrintWriter out = null;
//		
//		try {
//			out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "utf-8") ) ;
//			jsonStr = jsonStr.replaceAll("\r", "<br/>"); //두드림 결재창에서 엔터값 먹도록 처리함.
//	        out.print(jsonStr);
//	        out.flush();
//	        out.close();
//        
//		}catch (Exception e) {
//			log.debug(e.getMessage());
//		}finally {
//			if(out != null) out.close();
//		}
//        
//	}
//
//
//	/**
//	*	JSON 문자열을 출력한다.
//	*	@param res  HttpServletResponse
//	*	@param jsonStr json 형태의 문자열
//	*	@return void
//	*   @throws Exception
//	*/
//	public static void flushJSONKR(HttpServletResponse res, String jsonStr) throws Exception{
//		PrintWriter out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "euc-kr") ) ;
//        out.print(jsonStr);
//        out.flush();
//        out.close();
//	}
//
//
//
//	/**
//	*	XML 문자열을 출력한다.
//	*	@param res  HttpServletResponse
//	*	@param xmlStr xml 형태의 문자열
//	*	@return void
//	*   @throws Exception
//	*/
//	public static void flushXML(HttpServletResponse res, String xmlStr) throws Exception{
//		PrintWriter out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "utf-8") ) ;
//
//        StringBuffer xmlBuff = new StringBuffer();
//        xmlBuff.append("<?xml version=\"1.0\" encoding=\"euc-kr\" ?>\n") ;
//        xmlBuff.append(xmlStr);
//        out.print(xmlBuff.toString());
//        out.flush();
//        out.close();
//	}
//
//
//
//	/**
//	*	JSON 그리드 전체 로우 데이터를 DataClass 로 변환혀여 배열에 담아 리턴한다.
//	*	@param jsonArr  json배열데이터 문자열
//	*	@return ArrayList 전체 그리드데이터 배열
//	*   @throws Exception
//	*/
//	/*
//	public static ArrayList getGridArray(String jsonArr) throws Exception{
//		ArrayList dataArr = new ArrayList();
//		if(!isNull(jsonArr)){
//			Gson gson = new Gson();
//			JsonParser parser = new JsonParser();
//			JsonElement je = parser.parse(jsonArr);
//	
//			JsonElement dataJson = je.getAsJsonObject().get("data");
//			JsonArray array = dataJson.getAsJsonArray();
//	
//			String key = "";
//			String val = "";
//			Iterator it = null;
//			Map.Entry me = null;
//			DataClass data = null;
//			
//	
//			for(int i=0; i<array.size(); i++){
//				data = new DataClass();
//				it = (array.get(i).getAsJsonObject().entrySet()).iterator();
//	
//				while(it.hasNext()){
//					me = (Map.Entry)it.next();
//	
//					key = me.getKey().toString().toLowerCase();
//					val = me.getValue().toString();
//	
//					if(val.startsWith("\"")){
//						val = val.substring(1);
//					}
//					if(val.endsWith("\"")){
//						val = val.substring(0, val.length()-1);
//					}
//					data.set(key, val);
//				}
//	
//				dataArr.add(data);
//			}
//		}
//		return dataArr;
//	}
//	*/
//	
//	public static ArrayList getGridArray(String jsonArr) throws Exception {
//		return getGridArray2(jsonArr, "data"); // IBSheet는 "data", IBUpoad는 "ibupload"
//	}
//	public static ArrayList getGridArray2(String jsonArr, String jsonGubun) throws Exception {
//		Gson gson = new Gson();
//		// JsonParser parser = new JsonParser();
//		org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
//		if ("".equals(jsonArr)) {
//			return new ArrayList();
//		}
//
//		Object obj = parser.parse(jsonArr);
//
//		// JsonElement je = parser.parse(jsonArr);
//
//		// JsonElement dataJson = je.getAsJsonObject().get("data");
//		// JsonArray array = dataJson.getAsJsonArray();
//
//		JSONObject jj = (JSONObject) obj;
//		//
//		JSONArray ja = (JSONArray) jj.get(jsonGubun);
//
//		String key = "";
//		String val = "";
//		Iterator it = null;
//		// Map.Entry me = null;
//		DataClass data = null;
//		ArrayList dataArr = new ArrayList();
//
//		log.debug("........................................ getGridArray size():"+ ja.size());
//		for (int i = 0; i < ja.size(); i++) {
//			data = new DataClass();
//			// it = (ja.get(i).getAsJsonObject().entrySet()).iterator();
//			JSONObject oo = ((JSONObject) (ja.get(i)));
//
//			it = oo.keySet().iterator();
//
//			while (it.hasNext()) {
//				
//				if("ibupload".equals(jsonGubun)){
//					key = it.next().toString();
//					data.set(key, oo.get(key));
//				}
//				else{
//					// me = (Map.Entry)it.next();
//					key = it.next().toString().toLowerCase();
//	
//					// key = me.getKey().toString().toLowerCase();
//					// val = oo.get(key.toUpperCase());
//	
//					// if(val.startsWith("\"")){
//					// val = val.substring(1);
//					// }
//					// if(val.endsWith("\"")){
//					// val = val.substring(0, val.length()-1);
//					// }
//					data.set(key, oo.get(key.toUpperCase()));
//				}
//				//log.debug("........................................ getGridArray index"+i+":"+key+":"+data.get(key));
//			}
//
//			dataArr.add(data);
//		}
//		return dataArr;
//	}
//
//
//	//iamtheman
//	public static ArrayList getGridArray3(String jsonArr, String jsonGubun) throws Exception {
//		Gson gson = new Gson();
//		// JsonParser parser = new JsonParser();
//		org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
//		if ("".equals(jsonArr)) {
//			return new ArrayList();
//		}
//
//		Object obj = parser.parse(jsonArr);
//
//		// JsonElement je = parser.parse(jsonArr);
//
//		// JsonElement dataJson = je.getAsJsonObject().get("data");
//		// JsonArray array = dataJson.getAsJsonArray();
//
//		JSONObject jj = (JSONObject) obj;
//		//
//		JSONArray ja = (JSONArray) jj.get(jsonGubun);
//
//
//		String key = "";
//		String val = "";
//		Iterator it = null;
//		// Map.Entry me = null;
//		DataClass data = null;
//		ArrayList dataArr = new ArrayList();
//		if(ja != null){
//			log.debug("........................................ getGridArray size():"+ ja.size());
//			for (int i = 0; i < ja.size(); i++) {
//				data = new DataClass();
//				// it = (ja.get(i).getAsJsonObject().entrySet()).iterator();
//				JSONObject oo = ((JSONObject) (ja.get(i)));
//
//				it = oo.keySet().iterator();
//
//				while (it.hasNext()) {
//
//					if("ibupload".equals(jsonGubun)){
//						key = it.next().toString();
//						data.set(key, oo.get(key));
//					}
//					else{
//						key = it.next().toString();
//						data.set(key, oo.get(key));
//					}
//					//log.debug("........................................ getGridArray index"+i+":"+key+":"+data.get(key));
//				}
//
//				dataArr.add(data);
//			}
//		}
//		return dataArr;
//	}
//
//	/**
//	 * 현재 일자를 yyyy-MM-dd 형태로 리턴한다.
//	 *
//	 * @return		String
//	 */
//	public static String getLongDate() {
//		return toLongDate(null);
//	}
//
//	/**
//	 * 현재 일자를 yyyyMMdd 형태로 리턴한다.
//	 *
//	 * @return		String
//	 */
//	public static String getShortDate() {
//		return toShortDate(null);
//	}
//	/**
//	 * 현재 일자를 yyyyMMddhhmmss 형태로 리턴한다.
//	 *
//	 * @return		String
//	 */
//	public static String getLongDateTime() {
//		return LongTimeFmt.format(new Date());
//	}
//
//
//	/**
//	 * 현재 일자를 yyyy_MM_dd_hh_mm 형태로 리턴한다.
//	 *
//	 * @return		String
//	 */
//	public static String getLongDateTimeUnder() {
//		return LongTimeFmtUnder.format(new Date());
//	}
//
//	/**
//	 * yyyyMMdd 형태의 날짜 문자열을 yyyy-MM-dd 형태의 날짜 문자열로 변환하여 리턴한다.
//	 *
//	 * @param		s String
//	 * @return		String
//	 */
//	public static String toLongDate(String s) {
//		Date t;
//		if (s == null) {
//			t = new Date();
//		} else if( s.length() == 0 ){
//			return "";
//		} else {
//		    s = replace(s, "-", "");
//
//		    ParsePosition pos = new ParsePosition(0);
//			t = shortDateFmt.parse(s, pos);
//		}
//		if (t == null) return s;
//		return longToDateFmt.format(t);
//	}
//
//
//	/**
//	 * yyyyMMdd 형태의 날짜 문자열을 yyyy/MM/dd HH:mm 형태의 날짜 문자열로 변환하여 리턴한다.
//	 *
//	 * @param		s String
//	 * @return		String
//	 */
//	public static String toTimeDate(String s) {
//		Date t;
//		if (s == null) {
//			t = new Date();
//		} else if( s.length() == 0 ){
//			return "";
//		} else {
//		    s = replace(s, "-", "");
//		    ParsePosition pos = new ParsePosition(0);
//			t = shortTimeFmt.parse(s, pos);
//		}
//		if (t == null) return s;
//		return timeFmt.format(t);
//	}
//
//
//	/**
//	 * yyyyMMdd 형태의 날짜 문자열을 yyyy-MM-dd 형태의 날짜 문자열로 변환하여 리턴한다.
//	 *
//	 * @param		s String
//	 * @return		String
//	 */
//	public static String toLongToDate() {
//		Date t = new Date();
//		return longToDateFmt.format(t);
//	}
//
//	/**
//	 * yyyy-MM-dd 형태의 날짜 문자열을 yyyyMMdd 형태의 날짜 문자열로 변환하여 리턴한다.
//	 *
//	 * @param		s String
//	 * @return		String
//	 */
//	public static String toShortDate(String s) {
//		Date t;
//		if (s == null) {
//			t = new Date();
//		}else if( s.length() == 0 ){
//
//			return "";
//
//		} else {
//		    s = replace(s, "-", "");
//		    s = toLongDate(s);
//
//			ParsePosition pos = new ParsePosition(0);
//			t = longToDateFmt.parse(s, pos);
//		}
//		if (t == null) return s;
//		return shortDateFmt.format(t);
//	}
//
//	/**
//	 * yyyy-MM-dd 형태의 날짜 문자열을 MM/dd 형태의 날짜 문자열로 변환하여 리턴한다.
//	 *
//	 * @param		s String
//	 * @return		String
//	 */
//	public static String toDayDate(String s) {
//		Date t;
//		if (s == null) {
//			t = new Date();
//		}else if( s.length() == 0 ){
//
//			return "";
//
//		} else {
//		    s = replace(s, "-", "");
//		    s = toLongDate(s);
//
//			ParsePosition pos = new ParsePosition(0);
//			t = longDateFmt.parse(s, pos);
//		}
//		if (t == null) return s;
//		return dayDateFmt.format(t);
//	}
//
//	/**
//	 * 현재 년도를 return 한다.
//	 * @return 현재년도
//	 */
//	public static String getYearString() {
//		String yyyyMMdd = getShortDate();
//		return yyyyMMdd.substring(0,4);
//	}
//
//	/**
//	 * 현재 월을 return 한다.
//	 * 
//	 * @return 현재 월 (MM)
//	 */
//	public static String getMonthString() {
//		String yyyyMMdd = getShortDate();
//		return yyyyMMdd.substring(4, 6);
//	}
//	
//	/**
//	 * 현재 년월을 return 한다.
//	 * 
//	 * @return 현재 년월 (YYYYMM)
//	 */
//	public static String getYearMonthString() {
//		String yyyyMMdd = getShortDate();
//		return yyyyMMdd.substring(0, 6);
//	}
//	
//	/**
//	 * 현재 년월을 return 한다.
//	 * 
//	 * @return 현재 년월 (YYYY-MM)
//	 */
//	public static String getYearMonthString2() {
//		String yyyyMMdd = getLongDate();
//		return yyyyMMdd.substring(0, 7);
//	}
//	
//	/**
//	 * 현재 월 기준 +/-한 월을  return 한다.
//	 * @return 현재 월
//	 */
//	public static String getMonthStringSel(int val) {
//		String yyyyMMdd = getShortDate();
//		int month = Integer.parseInt(yyyyMMdd.substring(4,6));
//		int value = month+val;
//		if(value < 0){
//			value = value+12;
//		}else if(value > 12){
//			value = value-12;
//		}
//
//		if(value == 0){
//			return "12";
//		}else if(value<10){
//			return "0"+value;
//		}else{
//			return ""+value;
//		}
//	}
//	/**
//	 * 현재 일을  return 한다.
//	 * @return 현재 일
//	 */
//	public static String getDayString() {
//		String yyyyMMdd = getShortDate();
//		return yyyyMMdd.substring(6,8);
//	}
//
//	/**
//	 * 현재 월의 마지막일  return 한다.
//	 * @return 현재 일
//	 */
//	public static String getLastDayString() {
//		java.util.GregorianCalendar currDtim = new GregorianCalendar();
//		return ""+Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
//	}
//
//	/**
//	 * 해당 일의 달에 마지막 일을 리턴한다.
//	 * @return 현재 일자
//	 */
//	public static String getLastDay(){
//		return  getYearString()+ getMonthString()+getLastDayString();
//	}
//
//	/**
//	 * 설정 일의 마지막 일을 리턴한다.
//	 * @return 현재 일자
//	 */
//	public static String getLastDay(String s){
//
//		Date t;
//		if (s == null) {
//			t = new Date();
//		} else if( s.length() == 0 ){
//			return "";
//		} else {
//		    s = replace(s, "-", "");
//
//		    ParsePosition pos = new ParsePosition(0);
//			t = shortDateFmt.parse(s, pos);
//		}
//		if (t == null) return s;
//
//		String lastDay = "";
//		GregorianCalendar gc= new GregorianCalendar();
//	    gc.set(Integer.parseInt(s.substring(0,4)), Integer.parseInt(s.substring(4,6))-1, Integer.parseInt(s.substring(6,8)));
//
//	    lastDay = gc.get(Calendar.YEAR)+ "";
//	    lastDay += gc.get(Calendar.MONTH)+1+ "";
//	    lastDay += gc.getActualMaximum(Calendar.DAY_OF_MONTH)+ "";
//		return toLongDate(lastDay);
//	}
//
//	/**
//	 * 숫자 세자리마다 , 를 삽입한다.
//	 * @param		str String 숫자형식의 String
//	 * @return		String ,가 삽입된 숫자형식의 String
//	 */
//	public static String getCommaNum(String str) {
//		return getCommaNum(str, "###,###.###");
//	}
//
//
//	public static String getCommaNum(String str, String form) {
//		String rtn = "";
//		if(str == null || "".equals(str)) {
//			rtn = "";
//		} else {
//			try {
//				java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance();
//				java.text.DecimalFormat df = (java.text.DecimalFormat)nf ;
//				df.applyPattern(form);
//				rtn = df.format(Double.valueOf(str)) ;
//			} catch(Exception e) {
//				//rtn = "";
//				//출력물 스트링 반환
//				rtn = str;
//			}
//		}
//		return rtn;
//	}
//
//	/**
//	 * String을 받아 oldstr String을 찾아 newstr String으로 바꿔준다.
//	 *
//	 * @param		original String 원본
//	 * @param		oldstr String 바뀔 String
//	 * @param		newstr String 바꿀 String
//	 * @return		String
//	 */
//	public static String replace(String original, String oldstr, String newstr) {
//		StringBuffer convert = new StringBuffer();
//		int pos = 0;
//		int begin = 0;
//		pos = original.indexOf(oldstr);
//
//		if(pos == -1)
//			return original;
//
//		while(pos != -1) {
//			convert.append(original.substring(begin, pos) + newstr);
//			begin = pos + oldstr.length();
//			pos = original.indexOf(oldstr, begin);
//		}
//		convert.append(original.substring(begin));
//
//		return convert.toString();
//	}
//
//
//	/**
//	 * 문자열의 byte 수를 리턴한다.
//	 *
//	 * @param		in String
//	 * @return		int
//	 */
//	public static int getBytesLength(String in) {
//		if(in == null) {
//			return 0;
//		} else {
//			try {
//				return in.getBytes("KSC5601").length;
//			} catch(Exception e) {
//				return 0;
//			}
//		}
//	}
//
//	/**
//	 * day 수 만큼 +,- 한 일자를 리턴한다.
//	 *
//	 * @param		day int
//	 * @return		String
//	 */
//	public static String getDateAddString(int day) {
//		java.util.GregorianCalendar currDtim = new GregorianCalendar();
//		currDtim.add(Calendar.DATE, day);
//		java.sql.Date date = new java.sql.Date(currDtim.getTime().getTime());
//
//		return toLongDate(date.toString());
//	}
//
//
//
//	/**
//	 * 넘겨받은 날짜형 String에 day 수 만큼 +,- 한 일자를 리턴한다.
//	 * @param s String
//	 * @param day int
//	 * @return String
//	 */
//	public static String getDateAddString(String s, int day) {
//		Date t;
//		if (s == null) {
//			t = new Date();
//		} else if( s.length() == 0 ){
//			return "";
//		} else {
//		    s = replace(s, "-", "");
//
//		    ParsePosition pos = new ParsePosition(0);
//			t = shortDateFmt.parse(s, pos);
//		}
//		if (t == null) return s;
//
//		GregorianCalendar gc= new GregorianCalendar();
//	    gc.set(Integer.parseInt(s.substring(0,4)), Integer.parseInt(s.substring(4,6))-1, Integer.parseInt(s.substring(6,8)));
//
//	    gc.add(Calendar.DATE, day);
//		java.sql.Date date = new java.sql.Date(gc.getTime().getTime());
//		return toLongDate(date.toString());
//	}
//
//	/**
//	 * month 수 만큼 +,- 한 일자를 리턴한다.
//	 *
//	 * @param		mon int
//	 * @return		String
//	 */
//	public static String getMonthAddString(int mon) {
//		java.util.GregorianCalendar currDtim = new GregorianCalendar();
//		currDtim.add(Calendar.MONTH, mon);
////		currDtim.add(Calendar.DATE, -1);
//		java.sql.Date date = new java.sql.Date(currDtim.getTime().getTime());
//
//		return toLongDate(date.toString());
//	}
//
//	/**
//	 * 특정일의 month 수 만큼 +,- 한 일자를 리턴한다.
//	 *
//	 * @param		mon int
//	 * @return		String
//	 */
//	public static String getMonthAddString(String str, int mon) {
//		java.util.GregorianCalendar currDtim = new GregorianCalendar();
//
//		str = str.replaceAll("-", "");
//		int year = Integer.parseInt(str.substring(0, 4));
//		int month = Integer.parseInt(str.substring(4, 6));
//		int day = Integer.parseInt(str.substring(6, 8));
//		currDtim.set(year, month-1, day);
//
//		currDtim.add(Calendar.MONTH, mon);
////		currDtim.add(Calendar.DATE, -1);
//		java.sql.Date date = new java.sql.Date(currDtim.getTime().getTime());
//
//		return toLongDate(date.toString());
//	}
//	/**
//	 * year 수 만큼 +,- 한 일자를 리턴한다.
//	 *
//	 * @param		year int
//	 * @return		String
//	 */
//	public static String getYearAddString(int year) {
//		java.util.GregorianCalendar currDtim = new GregorianCalendar();
//		currDtim.add(Calendar.YEAR, year);
////		currDtim.add(Calendar.DATE, -1);
//		java.sql.Date date = new java.sql.Date(currDtim.getTime().getTime());
//
//		return toLongDate(date.toString());
//	}
//
//	/**
//	 * year 수 만큼 +,- 한 년도를 리턴한다.
//	 *
//	 * @param		year int
//	 * @return		String
//	 */
//	public static String getYearSetString(int year) {
//		java.util.GregorianCalendar currDtim = new GregorianCalendar();
//		currDtim.add(Calendar.YEAR, year);
////		currDtim.add(Calendar.DATE, -1);
//		java.sql.Date date = new java.sql.Date(currDtim.getTime().getTime());
//
//		return toLongDate(date.toString()).substring(0,4);
//	}
//
//	/**
//	 * String => int 변환
//	 *
//	 * @param		str String
//	 * @return		int
//	 */
//    public static int convInt(String str) {
//        return convInt( str, "0" );
//    }
//
//	/**
//	 * String => int 변환. str이 null이면 def 사용
//	 *
//	 * @param		str String
//	 * @param		def String def
//	 * @return		int
//	 */
//    public static int convInt(String str, String def) {
//        str = replace(nullCheck(str), ",", "");
//        if(str.indexOf(".") > -1) {
//        	str = str.substring(0, str.indexOf("."));
//        }
//        if("".equals(str)) str = def;
//        return Integer.parseInt(str);
//    }
//
//	/**
//	 * String => double 변환
//	 *
//	 * @param		str String
//	 * @return		double
//	 */
//    public static double convDouble(String str) {
//        return convDouble( str, "0" );
//    }
//
//
//	/**
//	 * String => double 변환. str이 null이면 def 사용
//	 *
//	 * @param		str String
//	 * @param		def String
//	 * @return		double
//	 */
//    public static double convDouble(String str, String def) {
//        str = replace(nullCheck(str), ",", "");
//        if("".equals(str)) str = def;
//        return Double.parseDouble(str);
//    }
//
//    /**
//	 * String => long 변환. str이 null이면 def 사용
//	 *
//	 * @param		str String
//	 * @param		def String
//	 * @return		double
//	 */
//    public static long convLong(String str, String def) {
//        str = replace(nullCheck(str), ",", "");
//        if("".equals(str)) str = def;
//        return Long.parseLong(str);
//    }
//
//
//	/**
//	 * null => ""으로 변환
//	 *
//	 * @param		param String
//	 * @return		String
//	 */
//	public static String nullCheck(String param){
//        if(param == null || "null".equals(param)){
//            param =  "";
//        }
//		return param.trim();
//    }
//
//	public static boolean isNull(String param){
//        if("".equals(nullCheck(param)))
//            return true;
//        else
//        	return false;
//    }
//	
//	/**
//	 * HTML 문자( < > " & ) => &lt; &gt; &quot; &amp;nbsp; 로 변환
//	 *
//	 * @param		htmlstr String
//	 * @return		String
//	 */
//	public static String convTag2Char(String htmlstr)	{
//		String convert = new String();
//		convert = replace(htmlstr,"<", "&lt;");
//		convert = replace(convert, ">", "&gt;");
//		convert = replace(convert, "\"", "&quot;");
//		convert = replace(convert, "&nbsp;", "&amp;nbsp;");
//		return convert;
//	}
//
//	/**
//	 * &lt; &gt; &quot; &amp;nbsp; 를 HTML 문자( < > " & ) 로 변환
//	 *
//	 * @param		str String
//	 * @return		String
//	 */
//	public static String convChar2Tag(String str) {
//		String convert = new String();
//		convert = replace(str, "&lt;", "<");
//		convert = replace(convert,"&gt;", ">");
//		convert = replace(convert,"&quot;", "\"");
//		convert = replace(convert, "&amp;nbsp;", "&nbsp;");
//		return convert;
//	}
//
//
//	/**
//	 * 주어진 String을 encoding한다.
//	 *
//	 * @param		str String
//	 * @return		String
//	 */
//	public static String ksc2ascii(String str){
//	   	String result = null;
//		try {
//          result = new String(str.getBytes("KSC5601"),"8859_1");
//       	} catch(Exception e) {}
//       	return result;
//    }
//	/**
//	 * 주어진 String을 encoding한다.
//	 *
//	 * @param		str String
//	 * @return		String
//	 */
//	public static String ascii2ksc(String str){
//	   	String result = null;
//		try {
//          result = new String(str.getBytes("8859_1"),"KSC5601");
//       	} catch(Exception e) {}
//       	return result;
//    }
//
//
//	/**
//     * 8859-1로 encoding 한다.
//     * @param str
//     * @return
//     */
//    public static String toascii(String str){
//        String result = null;
//        try{
//            result = new String(str.getBytes(),"8859_1");
//        } catch(Exception e) {}
//        return result;
//    }
//	/**
//     * EUC-KR로 encoding 한다.
//     * @param str
//     * @return
//     */
//    public static String toksc(String str){
//        String result = null;
//        try{
//            result = new String(str.getBytes(),"KSC5601");
//        } catch(Exception e) {}
//        return result;
//    }
//
//
//
//	/**
//	 * String을 start부터 substring 한다.
//	 *
//	 * @param attFile String 파일정보
//	 * @return int
//	 */
//	public static String cutString(String str, int start) {
//	    if(str.length() > start) {
//	    	return str.substring(start);
//	    } else {
//	    	return "";
//	    }
//	}
//
//	/**
//	 * String을 byte 개수만큼 잘라낸다. (한글이 잘리는 경우 고려)
//	 *
//	 * @param attFile String 파일정보
//	 * @return int
//	 */
//	public static String cutStringBytes(String str, int length) {
//	    byte[] bytes = str.getBytes();
//	    int len = bytes.length;
//	    int counter = 0;
//	    if(length >= len) {
//	    	return str;
//	    }
//		for(int i = length - 1; i >= 0; i--) {
//			if(((int)bytes[i] & 0x80) != 0)
//				counter++;
//		}
//	    return new String(bytes, 0, length - (counter % 2));
//	}
//
//	/**
//	 * 현재 월,일,요일을 가져온다.
//	 *
//	 * @return string
//	 */
//	public static String getWeek(){
//
//		Calendar time = Calendar.getInstance();
//
//		final String[] week = { "일" , "월" , "화" , "수" , "목" , "금" , "토" };
//
//		String yyyyMMdd = getShortDate();
//		String MM = yyyyMMdd.substring(4,6);//월
//
//		String dd = yyyyMMdd.substring(6,8);//일
//
//		StringBuffer timing = new StringBuffer();
//
//		timing.append( MM +"월 " + dd + "일 " + week[time.get(Calendar.DAY_OF_WEEK)-1] +  "요일" );
//
//		String weekday = timing.toString();
//		return weekday;
//
//	}
//
//
//	/**
//	 * 연도관련 셀렉트박스를 생성한다.
//	 * @param  int min(현재년도로부터 몇년전부터..)
//	 * @param int max(현재년도로부터 몇년후까지..)
//	 * @param String isAll(all:전체, sel:선택)
//	 * @param String selYear(선택연도)
//	 * @return String
//	 */
//	public static String mkSelBoxYear(int min, int max, String selYear){
//		StringBuffer buff = new StringBuffer();
//
//		String nowYear = getYearString();//현재연도를 가져온다.
//
//		int minYear = Integer.parseInt(nowYear) - min;
//		int maxYear = Integer.parseInt(nowYear) +max;
//
//		for(int i=maxYear; i>=minYear; i--) {
//			buff.append("\t\t<option value='"+i+"'");
//
//			if(!"".equals(selYear)){
//				if((i+"").equals(selYear)) buff.append(" selected='yes' ");
//			}else{
//				if((i+"").equals(nowYear)) buff.append(" selected='yes' ");
//			}
//
//
//			buff.append(">");
//			buff.append(i);
//			buff.append("</option>\n");
//		}
//
//		return buff.toString();
//	}
//
//	/**
//	 * 연도관련 셀렉트박스를 생성한다.
//	 * @param int min(현재년도로부터 몇년전부터..)
//	 * @param int max(현재년도로부터 몇년후까지..)
//	 * @param String selYear(선택연도)
//	 * @param int term(현재년도로부터 몇년전 값을 디폴트선택할것인가..)
//	 * @return String
//	 */
//	public static String mkSelBoxYearTerm(int min, int max, String selYear, int term){
//		StringBuffer buff = new StringBuffer();
//
//		String nowYear = getYearString();//현재연도를 가져온다.
//
//		int minYear = Integer.parseInt(nowYear) - min;
//		int maxYear = Integer.parseInt(nowYear) +max;
//
//		for(int i=maxYear; i>=minYear; i--) {
//			buff.append("\t\t<option value='"+i+"'");
//
//			if(!"".equals(selYear)){
//				if((i+"").equals(selYear)) buff.append(" selected='yes' ");
//			}else{
//				//term 값이 현재년도보다 클순없다.
//				if(Integer.parseInt(nowYear) > term){
//					if((i == (Integer.parseInt(nowYear) + term))) buff.append(" selected='yes' ");
//				}
//			}
//
//
//			buff.append(">");
//			buff.append(i);
//			buff.append("</option>	\n");
//		}
//
//		return buff.toString();
//	}
//
//	/**
//	 * 시작년도 설정가능한 연도관련 셀렉트박스를 생성한다.
//	 * @param  int start(시작년도)
//	 * @param int end(현재년도 기준으로부터 몇년 전후까지.. ex: -1)
//	 * @param String selYear(선택연도)
//	 * @return String
//	 */
//	public static String mkSelBoxYearStart(int start, int end, String selYear){
//		StringBuffer buff = new StringBuffer();
//
//		String nowYear = getYearString();//현재연도를 가져온다.
//		int startYear = start;
//
//		int endYear = Integer.parseInt(nowYear) + end;
//
//		for(int i=endYear; i>=startYear; i--) {
//			buff.append("\t\t<option value='"+i+"'");
//
//			if(!"".equals(selYear)){
//				if((i+"").equals(selYear)) buff.append(" selected='yes' ");
//			}else{
//				if((i+"").equals(nowYear)) buff.append(" selected='yes' ");
//			}
//
//			buff.append(">");
//			buff.append(i);
//			buff.append("</option>\n");
//		}
//
//		return buff.toString();
//	}
//
//	/**
//	 * 월관련 셀렉트박스를 생성한다.
//	 * @param String selMonth(선택 월)
//	 * @return String
//	 */
//	public static String mkSelBoxMonth(String selMonth){
//		StringBuffer buff = new StringBuffer();
//
//		String nowMonth = getMonthString();
//
//		if(selMonth == null || "".equals(selMonth.trim())){
//			selMonth = nowMonth;
//		}
//
//		for(int i=1; i<=12; i++) {
//
//			if((i+"").length() ==1){
//				buff.append("\t\t<option value='0"+i+"'");
//
//				if(!"".equals(selMonth)){
//					if(("0"+i).equals(selMonth)) buff.append(" selected='yes' ");
//				}
//
//			}else{
//				buff.append("\t\t<option value='"+i+"'");
//
//				if(!"".equals(selMonth)){
//					if((i+"").equals(selMonth)) buff.append(" selected='yes' ");
//				}
//			}
//
//			buff.append(">");
//
//			if((i+"").length() ==1){
//				buff.append("0"+i);
//			}else{
//				buff.append(i);
//			}
//
//
//			buff.append("</option>\n");
//		}
//
//		return buff.toString();
//	}
//
//	/**
//	 * 일자 관련 셀렉트박스를 생성한다.
//	 * @param String selDate(선택 일)
//	 * @return String
//	 */
//	public static String mkSelBoxDate(String selDate){
//		StringBuffer buff = new StringBuffer();
//
//		for(int i=1; i<=31; i++) {
//
//			if((i+"").length() ==1){
//				buff.append("\t\t<option value='0"+i+"'");
//
//				if(!"".equals(selDate)){
//					if(("0"+i).equals(selDate)) buff.append(" selected='yes' ");
//				}
//
//			}else{
//				buff.append("\t\t<option value='"+i+"'");
//
//				if(!"".equals(selDate)){
//					if((i+"").equals(selDate)) buff.append(" selected='yes' ");
//				}
//			}
//
//			buff.append(">");
//
//			if((i+"").length() ==1){
//				buff.append("0"+i);
//			}else{
//				buff.append(i);
//			}
//
//
//			buff.append("</option>\n");
//		}
//
//		return buff.toString();
//	}
//
//	/**
//	 * 분기관련 셀렉트박스를 생성한다.
//	 * @param String selQuarter(선택 분기)
//	 * @return String
//	 */
//	public static String mkSelBoxQuarter(String selQuarter){
//		StringBuffer buff = new StringBuffer();
//
//		for(int i=1; i<=4; i++) {
//
//			if((i+"").length() ==1){
//				buff.append("\t\t<option value='"+i+"'");
//
//				if(!"".equals(selQuarter)){
//					if((""+i).equals(selQuarter)) buff.append(" selected='yes' ");
//				}
//
//			}else{
//				buff.append("\t\t<option value='"+i+"'");
//
//				if(!"".equals(selQuarter)){
//					if((""+i).equals(selQuarter)) buff.append(" selected='yes' ");
//				}
//			}
//
//			buff.append(">");
//
//			buff.append(i);
//			buff.append("분기");
//
//			buff.append("</option>\n");
//		}
//
//		return buff.toString();
//	}
//
//
//	public static String mkSelBoxTime2(String selTime, String firstGubn){
//	  StringBuffer buff = new StringBuffer();
//	  
//	  if("sel".equals(firstGubn)){
//			buff.append("\t\t<option value=''>선택</option>");
//		}
//		else if("all".equals(firstGubn)){
//			buff.append("\t\t<option value=''>전체</option>");
//		}
//		else if("empty".equals(firstGubn)){
//			buff.append("\t\t<option value=''></option>");
//		}
//	  
//	  for (int i = 0; i <= 23; i++) {
//	   if ((i + "").length() == 1) {
//	    buff.append("\t\t<option value='0" + i + "'");
//	   } else {
//	    buff.append("\t\t<option value='" + i + "'");
//	   }
//	   if (!"".equals(selTime)) {
//	    if ((i + "").equals(selTime)) {
//	     buff.append(" selected='yes' ");
//	    } else if (("0"+i + "").equals(selTime)) {
//	     buff.append(" selected='yes' ");
//	    }
//	   }
//	   buff.append(">"); 
//
//	   if ((i + "").length() == 1) {
//	    buff.append("0" + i);
//	   } else {
//	    buff.append(i);
//	   }
//	   buff.append("</option>\n");
//	  }
//
//	  return buff.toString();
//	 }
//
//	
//	public static String mkSelBoxMin2(int term, String selMin, String firstGubn){
//	  StringBuffer buff = new StringBuffer();
//	  
//	  if("sel".equals(firstGubn)){
//			buff.append("\t\t<option value=''>선택</option>");
//		}
//		else if("all".equals(firstGubn)){
//			buff.append("\t\t<option value=''>전체</option>");
//		}
//		else if("empty".equals(firstGubn)){
//			buff.append("\t\t<option value=''></option>");
//		}
//	  
//	  for (int i = 0; i <= 59; i++) {
//	   if (i % term == 0 && term != 0) {
//	    if ((i + "").length() == 1) {
//	     buff.append("\t\t<option value='0" + i + "'");
//	    } else {
//	     buff.append("\t\t<option value='" + i + "'");
//	    }
//	    if ((i + "").equals(selMin)) {
//	     buff.append(" selected='yes' ");
//	    } else if (("0"+i + "").equals(selMin)) {
//	     buff.append(" selected='yes' ");
//	    }
//	    buff.append(">"); 
//
//	    if ((i + "").length() == 1) {
//	     buff.append("0" + i);
//	    } else {
//	     buff.append(i);
//	    }
//	    buff.append("</option>\n");
//	   }
//	  }
//
//	  return buff.toString();
//	 }
//	
//
//	/**
//	 * 넘어온 파라미터배열의 키명을 대문자로 변경하여 map 에 더하여준다.
//	 * @param params DataClass 파라미터배열
//	 * @param map HashMap 파라미터 배열을 더하여줄 맵 데이터
//	 * @return HashMap
//	 */
//	public static void addParamsToUpper(DataClass params, HashMap map) {
//		String key = "";
//		String val = "";
//		Map.Entry me = null;
//		Iterator it = params.getMap().entrySet().iterator();
//
//		while(it.hasNext()){
//			me = (Map.Entry)it.next();
//			key = me.getKey().toString().toUpperCase();
//			val = me.getValue().toString();
//
//			map.put(key, val);
//		}
//	}
//
//
//	/**
//	 * 파일이 저장되어있는 full경로를 어플리케이션 경로로 변경시켜준다.
//	 * @param fullPath String 파일이 저장되어있는 full 경로
//	 * @ex D:/project/upload/mp/1354236009855.jpg -> /mp/1354236009855.jpg
//	 * @return String 파일의 어플리케이션 경로
//	 */
//	public static String getFilePath(String fullPath) {
//
//
//		String str = nullCheck(fullPath);
//		if(str.indexOf("upload") >  -1){
//			str = str.substring(str.indexOf("upload")+6);
//			str = str.replaceAll("\\\\", "/");
//			log.info("★★★★★★★★★★★★★★★★★★★★★★★★★★★" + str);
//		}
//
//
//
//
//		return str;
//	}
//
//	/**
//	 * 파일이 image 파일인지 판단한다
//	 * @param 파일full경로 또는 파일명 (확장자포함)
//	 * @return Boolean 이미지파일여부
//	 */
//	public static Boolean isImageFile(String str) {
//		String ext = "";
//		int idx = str.lastIndexOf(".");
//		if(idx > -1){
//			ext = str.substring(idx+1).toLowerCase();//확장자
//			if(ext.equals("jpg") || ext.equals("jpeg") || ext.equals("jpe") ||
//					ext.equals("png") || ext.equals("bmp") || ext.equals("gif")){
//				return true;
//			}
//		}
//		return false;
//	}
//
//
//
//	/**
//	 * 현사이트의 도메인을 가져온다.
//	 * @param request
//	 * @return 도메인명
//	 */
//	public static String getSiteDomain(HttpServletRequest request) {
//
//		StringBuffer sb = request.getRequestURL();
//		String domainStr = sb.toString();
//
//		if(domainStr.indexOf("/cms") > -1){
//			domainStr = domainStr.substring(0, domainStr.indexOf("/cms"));
//		}
//		return domainStr;
//	}
//
//	public static String getDomainUrl() {
//
//		ResourceBundle resource = ResourceBundle.getBundle("conf.globals");
//		String url = "http://"+ resource.getString("EHS.DOMAIN.URL");
//		
//		return url;
//	}	
//	
//	
//	public static HashMap getGridComboData(List comboList, int type) {
//		HashMap comboData = new HashMap();
//		String vDelimiter;
//		String codeStr = "";
//		String textStr = "";
//		
//		if (type == 0) {
//			
//		}else if (type == 1) {
//			codeStr  = "|";
//			textStr = "선택|";
//		}else if (type == 2) {
//			codeStr  = "|";
//			textStr = "전체|";
//		}else if (type == 3) {
//			codeStr  = "|";
//			textStr = "|";
//		}
//		
//		
//		for(int i=0; i<comboList.size(); i++) {
//			comboData = (HashMap) comboList.get(i);
//			
//			if (i == 0) {
//				vDelimiter = "";
//				
//			} else {
//				vDelimiter = "|";
//			}
//			
//			codeStr += vDelimiter + comboData.get("CODE");
//			textStr += vDelimiter + comboData.get("NAME");
//		}
//		comboData = new HashMap();
//		comboData.put("codeStr", codeStr);
//		comboData.put("textStr", textStr);
//		return comboData;
//	}
//
//	
//	
//	/**
//	 * Rmate차트형태의 데이터를 생성한다.
//	 * @param obj
//	 * @return
//	 * @throws Exception
//	 */
//	public static String toJSONOfChart(List obj) throws Exception{
//        String jsonStr = "";
//        Gson gson = new Gson();
//
//        jsonStr = gson.toJson(obj);
//        return jsonStr;
//	}
//
//	
//	/**
//	 * W/S 바디에 들어갈 내용 작성
//	 * @param param
//	 * @return
//	 * @throws Exception
//	 */
//	public static String toBodyData(DataClass param) throws Exception {
//		
//		ResourceBundle resource = ResourceBundle.getBundle("conf.globals");
//		String url = "";//resource.getString("EHS.DOMAIN.URL");
//		String approvalMenu = "/c/appForm.do";
//		String approveUrl = "http://"+ url + approvalMenu  +"?view_st=1&appr_id="+param.get("appr_id");
//		
//		
//		
//		StringBuffer sb = new StringBuffer();
//		sb.append("<bodycontext>");
//		sb.append("<sysname>EHS</sysname>"); //시스템네임 고정
//		sb.append("<formname>"+param.get("menu_name")+ "</formname>"); // 폼명칭
//		sb.append("<systype>web</systype>"); // 고정
//		sb.append("<approvalurl><![CDATA["); //승인URL
//		sb.append(approveUrl+ "]]></approvalurl>"); //승인URL
//		sb.append("<readurl><![CDATA["); //승인URL
//		sb.append(approveUrl+ "]]></readurl>"); //승인URL
//		sb.append("</bodycontext>");
//		
//		return sb.toString();
//		
//	}
//	public static String toMoinMakeData(DataClass param) throws Exception {
//		
//		ResourceBundle resource = ResourceBundle.getBundle("conf.globals");
//		String mode = resource.getString("mode");
//		String strServerID = "DEV";
//
//		if( mode.equals("op") ){
//			strServerID = "PRD";
//		}
//		
//		String strDocName = getNullToString(param.get("sDOCNAME"));
//		String strSubName = getNullToString(param.get("sSUBNAME"));
//		String strContent = getNullToString(param.get("sAPPCONTENT"));
//		String strKey     = getNullToString(param.get("sKEY"));
//		String strEmpID   = getNullToString(param.get("EMP_NO"));
//		String strApprGbn   = getNullToString(param.get("APPRGBN"));
//
//		String strReserved1   = getNullToString(param.get("RESERVED1"));
//		String strReserved2   = getNullToString(param.get("RESERVED2"));
//		String strReserved3   = getNullToString(param.get("RESERVED3"));
//		
//		
//		StringBuffer strBuffer = new StringBuffer();
//		strBuffer.append("<?xml version='1.0' ?>                                                 ");
//		strBuffer.append("<HPC Version='2.0'>                                                    ");
//		strBuffer.append("<strServerID><![CDATA["+ strServerID +"]]></strServerID>                             ");		//운영:PRD,개발:DEV	
//		strBuffer.append("<strClientNumber><![CDATA[100]]></strClientNumber>                     ");	
//		strBuffer.append("<strFormAlias><![CDATA[HPCDBO_TYPE_B]]></strFormAlias>                 ");		//연구소EHS : HPCDBO_TYPE_B
//		strBuffer.append("<strEmpID><![CDATA["+ strEmpID +"]]></strEmpID>                        ");		//연구소EHS : 사번
//		strBuffer.append("<ApprovalDoc>                                                          ");
//		strBuffer.append("	<Header>                                                             ");
//		strBuffer.append("		<strSeq><![CDATA[001]]></strSeq>                                 ");
//		strBuffer.append("		<strModuleID><![CDATA[LEHS]]></strModuleID>                      ");		 //연구소EHS : LEHS
//		strBuffer.append("		<strProgramID><![CDATA[LEHS]]></strProgramID>                    ");		 //연구소EHS : LEHS
//		strBuffer.append("		<strObjectKey><![CDATA["+ strKey +"]]></strObjectKey> "); 		 //연구소EHS : 업무화면KEY
//		strBuffer.append("		<strRemark><![CDATA["+ strApprGbn  +"   ]]></strRemark>                              ");  // 업무구분
//		strBuffer.append("		<strDocName><![CDATA["+ strDocName +"]]></strDocName>              ");		 //연구소EHS : 업무화면명
//		strBuffer.append("		<strSubName><![CDATA["+ strSubName +"]]></strSubName>        ");		 //연구소EHS : 업무화면세부제목명	
//		strBuffer.append("		<strReserved1><![CDATA["+ strReserved1 +"]]></strReserved1>                        ");
//		strBuffer.append("		<strReserved2><![CDATA["+ strReserved2 +"]]></strReserved2>                        ");
//		strBuffer.append("		<strReserved3><![CDATA["+ strReserved3 +"]]></strReserved3>                        ");
//		strBuffer.append("	</Header>                                                            ");
//		strBuffer.append("	<Body>                                                               ");
//		strBuffer.append("		<strSeq><![CDATA[001]]></strSeq>                                 ");		
//		strBuffer.append("		<strContent><![CDATA["+ strContent +"]]></strContent>            ");		  //연구소EHS : 업무화면본문
//		strBuffer.append("	</Body>                                                              ");
//		strBuffer.append("</ApprovalDoc>                                                         ");
//		strBuffer.append("</HPC>                                                                 ");
//		return strBuffer.toString();
//	}
//	public static String getNullToString(String val) {
//		 
//		 String retValue = "";
//		 
//		 if (val == null) {
//			 retValue = "";
//		 } else {
//			 retValue = val.replace("'", "''");
//		 }
//		 
//		 return retValue;
//	 }
//	
//	
//	/**
//	 * 넘어온 params값으로 온실가스  에너지 사용량과 온실가스 배출량을
//	 * 계산하여 Insert 혹은 Update한다.
//	 * @param params DataClass 파라미터배열
//	 * @return Msg
//	 *//*
//	@SuppressWarnings("null")
//	public static String ghgEmissionAmount(DataClass params) throws Exception {
//
//		SqlMapClient sqlMap = null;
//		List list = null;
//
//		sqlMap = ConnectionManager.getSqlMap();
//
//		if(params.get("factor_chk").equals("N")){
//			list = sqlMap.queryForList("Common.ghgSearchList", params.getMap());//공통코드
//			log.info("★★★n:"+list);
//		}else if(params.get("factor_chk").equals("Y")){
//			list = sqlMap.queryForList("Common.ghgSearchListFactor", params.getMap());//공통코드
//			log.info("★★★y:"+list);
//		}
//
//		HashMap ghgDataChk = new HashMap();
//		HashMap ghgData = new HashMap();
//		HashMap ghgData2 = new HashMap();
//		HashMap ghgData3 = new HashMap();
//
//		//EGGT_EMERGY_USE_AMOUNT 에너지 사용량 Insert
//		//List list = (List)egg301Service.ghgSearchList(params);
//
//
//		List<String> id_chk = new ArrayList<String>();
//		int y = 0;
//		for(int j=0 ; j < list.size() ; j++){
//			ghgDataChk = (HashMap) list.get(j);
//
//			if(id_chk == null || id_chk.size() == 0){
//				id_chk.add(ghgDataChk.get("EMISSION_ACT_DATA_ID").toString());
//				y++;
//			}else if(!id_chk.get(y-1).toString().equals(ghgDataChk.get("EMISSION_ACT_DATA_ID").toString())){
//				id_chk.add(ghgDataChk.get("EMISSION_ACT_DATA_ID").toString());
//				y++;
//			}
//		}
//
//		log.info("★★★id_chk:"+id_chk);
//
//		try{
//			for(int i=0 ; i < id_chk.size() ; i++){
//
//				double MultiplySum = 0;
//				double feverSum = 0;
//				double emissionAmount03 = 0;
//				double emissionAmount02 = 0;
//				double emissionAmount01 = 0;
//				double co2eqAmount03 = 0;
//				double co2eqAmount02 = 0;
//				double co2eqAmount01 = 0;
//
//					for(int j=0 ; j < list.size() ; j++){
//						ghgData = (HashMap) list.get(j);
//						if(id_chk.get(i).toString().equals(ghgData.get("EMISSION_ACT_DATA_ID").toString())){
//
//							log.info("★★★ghgData:"+ghgData);
//							//EGGT_EMERGY_USE_AMOUNT 에너지 사용량 Insert
//							if(ghgData.get("GHG_CODE").equals("E") && Float.parseFloat(ghgData.get("FACTOR_TYPE_CODE").toString()) > 2){
//								if(MultiplySum == 0){
//									MultiplySum = Float.parseFloat(ghgData.get("USE_QUANTITY").toString()) * Float.parseFloat(ghgData.get("FACTOR_VALUE").toString());
//								}else{
//									MultiplySum = MultiplySum * Float.parseFloat(ghgData.get("FACTOR_VALUE").toString());
//								}
//							}
//							if(ghgData.get("GHG_CODE").equals("E") && ghgData.get("FACTOR_TYPE_CODE").equals("02")){
//								if(feverSum == 0){
//									feverSum = Float.parseFloat(ghgData.get("USE_QUANTITY").toString()) * Float.parseFloat(ghgData.get("FACTOR_VALUE").toString());
//								}else{
//									feverSum = feverSum * Float.parseFloat(ghgData.get("FACTOR_VALUE").toString());
//								}
//							}
//						}
//					}
//					log.info("★★★MultiplySum:"+MultiplySum);
//
//					for(int k=0 ; k < list.size() ; k++){
//						ghgData2 = (HashMap) list.get(k);
//						if(Integer.parseInt(ghgData2.get("EMISSION_ACT_CODE").toString()) < 6000){
//
//						//if(id_chk.get(i) == ghgData2.get("EMISSION_ACT_DATA_ID").toString()){
//						if(id_chk.get(i).toString().equals(ghgData2.get("EMISSION_ACT_DATA_ID").toString())){
//
//
//							if(ghgData2.get("GHG_CODE").equals("03")){
//								if(emissionAmount03 == 0){
//									emissionAmount03 += feverSum * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//								}else{
//									emissionAmount03 = emissionAmount03 * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//								}
//							}
//							if(ghgData2.get("GHG_CODE").equals("02")){
//								if(emissionAmount02 == 0){
//									emissionAmount02 += feverSum * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//								}else{
//									emissionAmount02 = emissionAmount02 * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//								}
//							}
//							if(ghgData2.get("GHG_CODE").equals("01")){
//								if(emissionAmount01 == 0){
//									emissionAmount01 += feverSum * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//								}else{
//									emissionAmount01 = emissionAmount01 * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//								}
//							}
//							log.info("★★★emissionAmount01:"+emissionAmount01);
//						}
//					}else{
//						for(int a=0 ; a < list.size() ; a++){
//							ghgData2 = (HashMap) list.get(a);
//
//							//if(id_chk.get(i) == ghgData2.get("EMISSION_ACT_DATA_ID").toString()){
//							if(id_chk.get(i).toString().equals(ghgData2.get("EMISSION_ACT_DATA_ID").toString())){
//
//								if(ghgData2.get("GHG_CODE").equals("03")){
//									if(emissionAmount03 == 0){
//										emissionAmount03 = Float.parseFloat(ghgData2.get("USE_QUANTITY").toString()) * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//									}else{
//										emissionAmount03 += emissionAmount03 * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//									}
//								}
//								if(ghgData2.get("GHG_CODE").equals("02")){
//									if(emissionAmount02 == 0){
//										emissionAmount02 = Float.parseFloat(ghgData2.get("USE_QUANTITY").toString()) * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//									}else{
//										emissionAmount02 += emissionAmount02 * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//									}
//								}
//								if(ghgData2.get("GHG_CODE").equals("01")){
//									if(emissionAmount01 == 0){
//										emissionAmount01 = Float.parseFloat(ghgData2.get("USE_QUANTITY").toString()) * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//									}else{
//										emissionAmount01 += emissionAmount01 * Float.parseFloat(ghgData2.get("FACTOR_VALUE").toString());
//									}
//								}
//								log.info("★★★emissionAmount01:"+emissionAmount01);
//							}
//						}
//					}
//
//				}
//
//
//				for(int p=0; p < list.size() ; p++){
//					ghgData3 = (HashMap) list.get(p);
//
//
//					//if(id_chk.get(i) == ghgData3.get("EMISSION_ACT_DATA_ID").toString()){
//					if(id_chk.get(i).toString().equals(ghgData3.get("EMISSION_ACT_DATA_ID").toString())){
//
//
//
//						if(ghgData3.get("GHG_CODE").equals("03") && co2eqAmount03 == 0){
//							co2eqAmount03 = emissionAmount03 * Float.parseFloat(ghgData3.get("GWP").toString());
//						}else if(ghgData3.get("GHG_CODE").equals("02") && co2eqAmount02 == 0){
//							co2eqAmount02 = emissionAmount02 * Float.parseFloat(ghgData3.get("GWP").toString());
//						}else if(ghgData3.get("GHG_CODE").equals("01") && co2eqAmount01 == 0){
//							co2eqAmount01 = emissionAmount01 * Float.parseFloat(ghgData3.get("GWP").toString());
//						}
//
//					}
//				}
//
//
//				log.info("★★★MultiplySum"+MultiplySum);
//				log.info("★★★feverSum"+feverSum);
//				log.info("★★★emissionAmount03"+emissionAmount03);
//				log.info("★★★emissionAmount02"+emissionAmount02);
//				log.info("★★★emissionAmount01"+emissionAmount01);
//				log.info("★★★co2eq_amount03"+co2eqAmount03);
//				log.info("★★★co2eq_amount02"+co2eqAmount02);
//				log.info("★★★co2eq_amount01"+co2eqAmount01);
//
//				params.set("energy_use_amount", MultiplySum);		//emergy_use_amount
//				params.set("emission_amount03", emissionAmount03);	//emission_amount
//				params.set("emission_amount02", emissionAmount02);	//emission_amount
//				params.set("emission_amount01", emissionAmount01);	//emission_amount
//				params.set("co2eq_amount03", co2eqAmount03);	//co2eqAmount
//				params.set("co2eq_amount02", co2eqAmount02);	//co2eqAmount
//				params.set("co2eq_amount01", co2eqAmount01);	//co2eqAmount
//				params.set("ghg_code03", "03");	//ghg_code
//				params.set("ghg_code02", "02");	//ghg_code
//				params.set("ghg_code01", "01");	//ghg_code
//
//				log.info("★★★"+ params.get("grid_status"));
//				if(params.get("grid_status").equals("I")){
//					if(MultiplySum < 10e11 && emissionAmount03 < 10e11 && emissionAmount02 < 10e11 && emissionAmount01 < 10e11 && co2eqAmount03 < 10e11 && co2eqAmount02 < 10e11 && co2eqAmount01 < 10e11){
//
//						sqlMap.insert("Common.energyUseInsertData", params.getMap());
//						sqlMap.insert("Common.emissionAmountInsertData", params.getMap());
//						sqlMap.insert("Common.emissionAmountInsertData2", params.getMap());
//						sqlMap.insert("Common.emissionAmountInsertData3", params.getMap());
//
//						log.info("★★★Insert Sucess");
//
//					}else{
//						return "MSG.CHKSUM.FACTOROVER";
//					}
//				}else if(params.get("grid_status").equals("U")){
//					if(MultiplySum < 10e11 && emissionAmount03 < 10e11 && emissionAmount02 < 10e11 && emissionAmount01 < 10e11 && co2eqAmount03 < 10e11 && co2eqAmount02 < 10e11 && co2eqAmount01 < 10e11){
//
//						log.info("★★★Update 1");
//						sqlMap.insert("Common.energyUseUpdateData", params.getMap());
//						log.info("★★★Update 2");
//						sqlMap.insert("Common.emissionAmountUpdateData", params.getMap());
//						log.info("★★★Update 3");
//						sqlMap.insert("Common.emissionAmountUpdateData2", params.getMap());
//						log.info("★★★Update 4");
//						sqlMap.insert("Common.emissionAmountUpdateData3", params.getMap());
//
//						log.info("★★★Update Sucess");
//
//					}else{
//						return "MSG.CHKSUM.FACTOROVER";
//					}
//				}
//
//			}
//
//			return "MSG.SAVE.OK";
//
//	}catch(Exception e){
//		return "MSG.CHK.FACTOR";
//	}
//	}*/
//
//	public static HashMap getComboValueSet(List comboList) {
//
//		String codeStr = "";
//		String textStr = "";
//		String descStr = "";
//		String vDelimiter = "";
//		HashMap comboData = new HashMap();
//
//		for(int i=0; i<comboList.size(); i++) {
//			comboData = (HashMap) comboList.get(i);
//
//			if (i == 0) {
//				vDelimiter = "";
//			} else {
//				vDelimiter = "|";
//			}
//
//			codeStr += vDelimiter + comboData.get("ITEM_CODE");
//			textStr += vDelimiter + comboData.get("ITEM_NAME");
//			descStr += vDelimiter + comboData.get("ITEM_DESC");
//		}
//		comboData.put("codeStr", codeStr);
//		comboData.put("textStr", textStr);
//		comboData.put("descStr", descStr);
//
//		return comboData;
//	}
//
//	/**
//	 * 단순 JSON 메시지 코드를 담기 위한 메시지 처리용
//	 * @param param
//	 * @return
//	 */
//	public static String getJsonMessage(String param) {
//		return "{\"DATA\":[{\"MSG\":\""+ param +"\"}]}";
//	}
//
//	/**
//	 * 엑셀 업로드 시 자리수가 제각각인 경우 처리하기 위해서 사용
//	 * @param date(YYYY-M-D, YYYY-M-DD, YYYY-MM-D, YY-MM-DD, YYYYMMDD)
//	 * @return date(YYYY-MM-DD)
//	 */
//	public static String getDateFormatString(String date) {
//
//		StringBuffer ret = new StringBuffer("");
//
//		if (date==null || "".equals(date)) return date;
//
//		try {
//			int nIdx1st = date.indexOf("-");
//			int nIdx2nd = date.lastIndexOf("-");
//
//			// YYYYMMDD
//			if (nIdx1st<0)
//			{
//				switch(date.length())
//				{
//				case 8 :
//					ret.append(date.substring(0,4)); //YYYY
//					ret.append("-");
//					ret.append(date.substring(4,6)); //MM
//					ret.append("-");
//					ret.append(date.substring(6,8)); //DD
//					break;
//				case 6 :
//					ret.append(Utility.makeYYyy(date)); //YY->YYYY
//					ret.append("-");
//					ret.append(date.substring(2,4)); //MM
//					ret.append("-");
//					ret.append(date.substring(4,6)); //DD
//					break;
//				default :
//				}
//			} else {
//				String[] val = date.split("-");
//				if (val.length==3) {
//					if (val[0].length()==2 || val[0].length()==4) {
//						//YY
//						if (val[0].length()==2) {
//							ret.append(Utility.makeYYyy(val[0]));
//						}
//						//YYYY
//						else if (val[0].length()==4) {
//							ret.append(val[0]);
//						}
//						ret.append("-");
//						//MM(2 Digit)
//						if (val[1].length()==1) {
//							ret.append("0").append(val[1]);
//						} else {
//							ret.append(val[1]);
//						}
//						ret.append("-");
//						//DD(2 Digit)
//						if (val[2].length()==1) {
//							ret.append("0").append(val[2]);
//						} else {
//							ret.append(val[2]);
//						}
//					}
//				}
//			}
//		} catch (Exception e) {
//			ret.append(date);
//		}
//
//		return ret.length()==0 ? date : ret.toString();
//	}
//
//	public static String makeYYyy(String date) {
//
//		int thisYear = Integer.parseInt(Utility.getLongDate().substring(2,4));
//		int curYy = Integer.parseInt(Utility.getLongDate().substring(0,2));
//		int preYy = Integer.parseInt(Utility.getLongDate().substring(0,2))-1;
//		int yy = Integer.parseInt(date.substring(0,2));
//		if (thisYear-yy<0) {
//			return Integer.toString(preYy) + date.substring(0,2);
//		} else {
//			return Integer.toString(curYy) + date.substring(0,2);
//		}
//	}
//
//	public static void main(String[] args) {
//		System.out.println("63-3-7 -> "+ Utility.getDateFormatString("63-3-7"));
//		System.out.println("1963-3-7 -> "+ Utility.getDateFormatString("1963-3-7"));
//		System.out.println("1963-3-07 -> "+ Utility.getDateFormatString("1963-3-07"));
//		System.out.println("1963-03-07 -> "+ Utility.getDateFormatString("1963-03-07"));
//
//		System.out.println("63-3-17 -> "+ Utility.getDateFormatString("63-3-17"));
//		System.out.println("1963-3-17 -> "+ Utility.getDateFormatString("1963-3-17"));
//		System.out.println("1963-03-17 -> "+ Utility.getDateFormatString("1963-03-17"));
//
//		System.out.println("140317 -> "+ Utility.getDateFormatString("140317"));
//		System.out.println("150317 -> "+ Utility.getDateFormatString("150317"));
//		System.out.println("630317 -> "+ Utility.getDateFormatString("630317"));
//		System.out.println("19630317 -> "+ Utility.getDateFormatString("19630317"));
//	}
//	
//	public static String makeHtmlForm(List detailSludge, List detailRuntime, List detailWater, List detailWater1){
//		String htmlForm = "";		
//		HashMap runtimeResult = new HashMap();
//		
//		htmlForm += "<p class=approvalTitle> - 가동시간  </p>";
//		
//		htmlForm += "<table align=center class=approval_table>";
//		htmlForm += "   <colgroup>";
//		htmlForm += "      <col width=20%>";
//		htmlForm += "      <col width=80%>";
//		htmlForm += "   </colgroup>";
//		htmlForm += "   <thead>";
//		htmlForm += "   	<tr>";
//		htmlForm += "   		<th class=ft11tdbg>시설명</th>";
//		htmlForm += "   		<th class=ft11tdbg>가동시간</th>";
//		htmlForm += "   	</tr>";
//		htmlForm += "   </thead>";
//		htmlForm += "   <tbody>";	
//		for(int i = 0; i < detailRuntime.size(); i++){	
//			ArrayList tempList = new ArrayList();
//			HashMap listTime = (HashMap)detailRuntime.get(i);
//		 	Iterator iterator = listTime.entrySet().iterator();
//		 	while(iterator.hasNext()){
//		 		Entry entry = (Entry)iterator.next();
//		 		if(entry.getKey().toString().contains("TM_") && entry.getValue().equals("1")){
//		 			String tempTime = entry.getKey().toString().substring(3, entry.getKey().toString().length());
//		 			tempList.add(tempTime);
//		 		}
//		 	}
//		 	htmlForm += "   	<tr>";
//			htmlForm += "   	<td>" + listTime.get("FACILITY_NM") + "</td>";
//			htmlForm += "   	<td>" + Collections.min(tempList).toString().replace('_', ':') + " ~ " + Collections.max(tempList).toString().replace('_', ':') + "("+ listTime.get("RUN_HOUR") + ":"+listTime.get("RUN_MIN")+")</td>";
//			htmlForm += "   	</tr>";
//		 	
//		}
//		htmlForm += "   </tbody>";	
//		htmlForm += "</table>";	
//
//		htmlForm += "<p class=approvalTitle> - 용수  </p>";
//		
//		htmlForm += "<table align=center class=approval_table>";
//		htmlForm += "   <colgroup>";
//		htmlForm += "      <col width=20%>";
//		htmlForm += "      <col width=20%>";
//		htmlForm += "      <col width=20%>";
//		htmlForm += "      <col width=20%>";
//		htmlForm += "      <col width=20%>";
//		htmlForm += "   </colgroup>";
//		htmlForm += "   <thead>";
//		htmlForm += "   	<tr>";
//		htmlForm += "   		<th class=ft11tdbg>항목</th>";
//		htmlForm += "   		<th class=ft11tdbg>전일지침(㎥)</th>";
//		htmlForm += "   		<th class=ft11tdbg>금일지침(㎥)</th>";
//		htmlForm += "   		<th class=ft11tdbg>보정</th>";
//		htmlForm += "   		<th class=ft11tdbg>사용량(㎥/일)</th>";
//		htmlForm += "   	</tr>";
//		htmlForm += "   </thead>";
//		htmlForm += "   <tbody>";	
//			for(int i = 0; i < detailWater.size(); i++){
//				HashMap list = (HashMap)detailWater.get(i);
//				htmlForm += "   	<tr>";
//				htmlForm += "   	<td>" + list.get("WATER_TYPE_NM") + "</td>";
//				htmlForm += "   	<td>" + list.get("GAUGE_YESTERDAY") + "</td>";
//				htmlForm += "   	<td>" + list.get("GAUGE_TODAY") + "</td>";
//				htmlForm += "   	<td>" + list.get("CALIBRATION") + "</td>";
//				htmlForm += "   	<td>" + list.get("USAGE") + "</td>";
//				htmlForm += "   	</tr>";
//			}		
//		htmlForm += "   </tbody>";
//		htmlForm += "</table>";
//		
//		htmlForm += "<p class=approvalTitle> - 폐수  </p>";
//		htmlForm += "<table align=center class=approval_table>";
//		htmlForm += "   <colgroup>";
//		htmlForm += "      <col width=20%>";
//		htmlForm += "      <col width=20%>";
//		htmlForm += "      <col width=20%>";
//		htmlForm += "      <col width=20%>";
//		htmlForm += "      <col width=20%>";
//		htmlForm += "   </colgroup>";
//		htmlForm += "   <thead>";
//		htmlForm += "   	<tr>";
//		htmlForm += "   		<th class=ft11tdbg>항목</th>";
//		htmlForm += "   		<th class=ft11tdbg>전일지침(㎥)</th>";
//		htmlForm += "   		<th class=ft11tdbg>금일지침(㎥)</th>";
//		htmlForm += "   		<th class=ft11tdbg>보정</th>";
//		htmlForm += "   		<th class=ft11tdbg>배출량(㎥/일)</th>";
//		htmlForm += "   	</tr>";
//		htmlForm += "   </thead>";
//		htmlForm += "   <tbody>";	
//			for(int i = 0; i < detailWater1.size(); i++){
//				HashMap list1 = (HashMap)detailWater1.get(i);
//				htmlForm += "   	<tr>";
//				htmlForm += "   	<td>" + list1.get("WATER_TYPE_NM") + "</td>";
//				htmlForm += "   	<td>" + list1.get("GAUGE_YESTERDAY") + "</td>";
//				htmlForm += "   	<td>" + list1.get("GAUGE_TODAY") + "</td>";
//				htmlForm += "   	<td>" + list1.get("CALIBRATION") + "</td>";
//				htmlForm += "   	<td>" + list1.get("USAGE") + "</td>";
//				htmlForm += "   	</tr>";
//			}		
//		htmlForm += "   </tbody>";
//		htmlForm += "</table>";		
//		
//		return htmlForm;
//		
//	}
//	public static String toViewText(String dayString) {
//		String returnStr = "";
//		returnStr = dayString;
//		/*
//		returnStr = dayString.substring(0, dayString.indexOf(":"));
//		
//		if (dayString.indexOf(",") > 0) {
//			String[] strArr = dayString.split(",");
//
//			for (int j = 0; j < strArr.length; j++) {
//				if (j == 0) {
//					if (strArr[j].substring(strArr[j].indexOf(":") + 1)
//							.indexOf("|") > 0) {
//						String PIPE1 = strArr[j].substring(strArr[j]
//								.indexOf(":") + 1);
//						String[] PIPE_SUN1 = PIPE1.split("\\|");
//						returnStr += "<br><img src=/images" + PIPE_SUN1[0]
//								+ "><a href=" + "javascript:doDetail('detail',"
//								+ PIPE_SUN1[1] + ")" + "> " + PIPE_SUN1[2]
//								+ "</a>";
//					}
//				} else {
//					if (strArr[j].indexOf("|") > 0) {
//						String PIPE1 = strArr[j];
//						String[] PIPE_SUN1 = PIPE1.split("\\|");
//						returnStr += "<br><img src=/images" + PIPE_SUN1[0]
//								+ "><a href=" + "javascript:doDetail('detail',"
//								+ PIPE_SUN1[1] + ")" + "> " + PIPE_SUN1[2]
//								+ "</a>";
//					}
//				}
//			}
//		} else {
//			if (dayString.substring(dayString.indexOf(":") + 1,
//					dayString.length()).indexOf("|") > 0) {
//				String PIPE = dayString.substring(dayString.indexOf(":") + 1,
//						dayString.length());
//				String[] PIPE_SUN1 = PIPE.split("\\|");
//				returnStr += "<br><img src=/images" + PIPE_SUN1[0]
//						+ "><a href=" + "javascript:doDetail('detail',"
//						+ PIPE_SUN1[1] + ")" + "> " + PIPE_SUN1[2] + "</a>";
//			}
//		}*/
//		return returnStr;
//	}
//	
//	
//	/****************************************************************************************
//	 * 2021 고도화
//	 ***************************************************************************************/	
//	public static boolean isLocal() throws Exception {
//		ResourceBundle resource = ResourceBundle.getBundle("conf.globals");  
//		String mode = resource.getString("mode");
//		boolean bLocal = false;
//		if("local".equals(resource.getString("mode"))){
//			bLocal = true;
//		}
//		return bLocal;
//	}
//	
//	public static boolean isOP() throws Exception {
//		ResourceBundle resource = ResourceBundle.getBundle("conf.globals");  
//		String mode = resource.getString("mode");
//		boolean bOP = false;
//		
//		return bOP;
//	}
//	
//	// isOP를 쓰는 화면이 있어서 임시로 만듬
//	public static boolean isOP2() throws Exception {
//		ResourceBundle resource = ResourceBundle.getBundle("conf.globals");  
//		String mode = resource.getString("mode");
//		boolean bOP = false;
//		
//		return bOP;
//	}
//	
//	
//	// gubn : WAS, DB
//	public static String getMode(String gubn) throws Exception {
//		ResourceBundle resource = ResourceBundle.getBundle("conf.globals");  
//		String mode_global = resource.getString("mode");
//		String mode = "";
//
//		if("prd".equals(mode_global))
//			mode = "PRD";
//		else if("dev".equals(mode_global))
//			mode = "개발";
//		else
//			mode = "로컬";
//
//		return mode;
//	}
//	
//	public static String getFilePathPhysical (String path) {
//		String rtn = nullCheck(path);
//		if(rtn.indexOf("/upload2/") == 0) {
//			ResourceBundle resource = ResourceBundle.getBundle("conf.globals");
//			String mode = resource.getString("mode");
//			rtn = rtn.replace("/upload2/", resource.getString("FILE.UPLOAD.PATH."+mode));
//		}
//		return rtn;
//	}
//
//	public static String toJSONError(Exception e) throws Exception {
//		int idx = e.getMessage().indexOf("\n");
//		if(idx >= 0)
//			return "{\"ERR\":{\"MSG\":\"" + e.getMessage().substring(0, idx - 1) + "\"}}";
//		else
//			return "{\"ERR\":{\"MSG\":\"" + e.getMessage() + "\"}}";
//	}
//	
//	
//	public static String encodeURIComponent(String s) {
//		String result = null;
//		try {
//				result = URLEncoder.encode(s, "UTF-8")
//					   .replaceAll("\\+", "%20")
//					   .replaceAll("\\%21", "!")
//					   .replaceAll("\\%27", "'")
//					   .replaceAll("\\%28", "(")
//					   .replaceAll("\\%29", ")")
//					   .replaceAll("\\%7E", "~");
//		}
//		catch (Exception e) {
//			result = s;
//		}
//		return result;
//	}
//	
//	public static List AESEncodeListPath_ImgURL(List list, String cols) throws Exception {
//		//log.debug(".......AESEncodeListPath cols:"+cols);
//		/* AESEncodeHashMapPath_ImgURL 추가 전...
//		String[] arrCols = cols.split(",");
//		HashMap data = null;
//		for(int i=0; i<list.size(); i++) {
//			data = (HashMap)list.get(i);
//			for(int j=0; j<arrCols.length; j++) {
//				if(!Utility.isNull(data.get(arrCols[j])+"")) {
//					log.debug("......."+arrCols[j]+">>>" + AesClass.AES_Encode((String)data.get(arrCols[j])));
//					// 변경시 common.js의 gfnGetUploadURL()도 변경해줄것!!
//					data.put(arrCols[j], "/common/GetImgVwDec.do?path_enc="+encodeURIComponent(encodeURIComponent(AesClass.AES_Encode((String)data.get(arrCols[j])))));
//				}				
//			}
//			list.set(i, data);
//		}
//		return list;
//		*/
//		
//		HashMap data = null;
//		for(int i=0; i<list.size(); i++) {
//			list.set(i, AESEncodeHashMapPath_ImgURL((HashMap)list.get(i), cols));
//		}
//		return list;
//		
//	}
//	public static HashMap AESEncodeHashMapPath_ImgURL(HashMap data, String cols) throws Exception {
//		//log.debug(".......AESEncodeListPath cols:"+cols);
//		if(data != null) {
//			String[] arrCols = cols.split(",");
//			for(int j=0; j<arrCols.length; j++) {
//				if(!Utility.isNull(data.get(arrCols[j])+"")) {
//					log.debug("......."+arrCols[j]+">>>" + AesClass.AES_Encode((String)data.get(arrCols[j])));
//					// 변경시 common.js의 gfnGetUploadURL()도 변경해줄것!!
//					data.put(arrCols[j], "/common/GetImgVwDec.do?path_enc="+encodeURIComponent(encodeURIComponent(AesClass.AES_Encode((String)data.get(arrCols[j])))));
//				}				
//			}
//		}
//		return data;
//	}
//	
//	public static List AESEncodeListPath(List list, String cols) throws Exception {
//		//log.debug(".......AESEncodeListPath cols:"+cols);
//		if(list != null) {
//			String[] arrCols = cols.split(",");
//			HashMap data = null;
//			for(int i=0; i<list.size(); i++) {
//				data = (HashMap)list.get(i);
//				for(int j=0; j<arrCols.length; j++) {
//					if(!Utility.isNull(data.get(arrCols[j])+"")) {
//						log.debug("......."+arrCols[j]+">>>" + AesClass.AES_Encode((String)data.get(arrCols[j])));
//						data.put(arrCols[j], AesClass.AES_Encode((String)data.get(arrCols[j])));
//					}				
//				}
//				list.set(i, data);
//			}
//		}
//		return list;
//	}
//	
//	public static String getIPAddress(HttpServletRequest request) {
//		String ip = null;
//        ip = request.getHeader("X-Forwarded-For");
//        if (Utility.isNull(ip) || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("Proxy-Client-IP"); 
//        if (Utility.isNull(ip) || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("WL-Proxy-Client-IP"); 
//        if (Utility.isNull(ip) || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("HTTP_CLIENT_IP"); 
//        if (Utility.isNull(ip) || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
//        if (Utility.isNull(ip) || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("X-Real-IP"); 
//        if (Utility.isNull(ip) || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("X-RealIP"); 
//        if (Utility.isNull(ip) || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("REMOTE_ADDR");
//        if (Utility.isNull(ip) || "unknown".equalsIgnoreCase(ip)) ip = request.getRemoteAddr(); 
//        return ip;
//	}
//	
//	
//	
//	//이녹스에서 가져옴
//	/**
//	 * null => "0"으로 변환
//	 * 
//	 * @param param
//	 *            String
//	 * @return String
//	 */
//	public static String nullToZero(String param) {
//		String rtnParam = param.trim();
//		if (rtnParam == "" || rtnParam == null || "null".equals(rtnParam)) {
//			rtnParam = "0";
//		}
//		return rtnParam;
//	}
//	
//	
//	//이녹스에서 가져옴
//	/**
//	 * 
//	 * 
//	 * @param param
//	 *            String
//	 * @return boolean
//	 */
//	public static boolean isNumber(String str){
//        boolean result = false;
//        try{
//            Double.parseDouble(str) ;
//            result = true ;
//        }catch(Exception e){}
//         
//        return result ;
//    }		
//	
//	// 현재 일 기준 +/-한 일을 return 한다.
//	public static String getShortDateStringSel(int val) {
//		Calendar cal = Calendar.getInstance();
//		cal.add(cal.DATE, val);
//		return shortDateFmt.format(cal.getTime());
//	}
//	
//	/**
//	 * 입력한 날짜 기준 내년 전일자를 리턴한다.
//	 * ex) 20221111 -> 20231110
//	 *
//	 * @return String
//	 */
//	public static String getNextYearString(String s) {
//		
//		//s = s.replaceAll("-", "");
//		int year = Integer.parseInt(s.substring(0,4));
//		int month = Integer.parseInt(s.substring(4,6));
//		int day = Integer.parseInt(s.substring(6,8));
//				
//		LocalDate localDate = LocalDate.of(year, month, day);
//		
//		LocalDate targetDate = localDate.plusYears(1).minusDays(1);
//		
//		return toLongDate(targetDate.toString());
//	}
//
//	public static String mkSelBoxWeek(String selWeek) {
//		StringBuffer buff = new StringBuffer();
//
//		for (int i = 1; i <= 5; i++) {
//			buff.append("\t\t<option value='" + i + "'");
//
//			if (!"".equals(selWeek)) {
//				if ((i + "").equals(selWeek))
//					buff.append(" selected='yes' ");
//			}
//
//			buff.append(">");
//
//			buff.append(i);
//
//			buff.append("</option>\n");
//		}
//
//		return buff.toString();
//	}
//	
//	
//	/**
//	 * 파라미터의 해당하는 년월의 전달을 구한다.
//	 * 
//	 * @param s
//	 *            String
//	 * @param day
//	 *            int
//	 * @return String
//	 */
//	 public static String getBeforeYearMonthByYM(String yearMonth, int minVal){
//		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
//		 Calendar cal = Calendar.getInstance();
//		 int year = Integer.parseInt(yearMonth.substring(0,4));
//		 int month = Integer.parseInt(yearMonth.substring(4,6));
//	
//		 cal.set(year, month-minVal, 0);
//		 
//		 String beforeYear = dateFormat.format(cal.getTime()).substring(0,4);
//		 String beforeMonth = dateFormat.format(cal.getTime()).substring(4,6);
//		 String retStr = beforeYear + beforeMonth;
//	
//		 return retStr;
//	 }
//	 	
}
