package com.tour.app.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tour.app.advice.ErrorCode;
import com.tour.app.advice.PageEndOverFlowException;
import com.tour.app.advice.TimeOutIOException;
import com.tour.app.domain.AttractionService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Slf4j
public class AttractionServiceApiExplorer 
{
	private final String serviceKey= "0LhzbgxfHbUWH9veox3LgaRJouEFZMou%2FzQk9XbH9T7ED6DO8u1sCZO8oYHIlPRzmC46s8VVfOudOl11AtjLsw%3D%3D";
	private int pageNo = 1;
	private int numOfRows =10;
	private final String resultType="json";
    private StringBuilder urlBuilder;
    List<AttractionService> attractionServices = null;
    URL url = null;
    HttpURLConnection conn = null;
    BufferedReader rd=null;
    
    public  List<AttractionService> requestASAPI(int pageNo, int numOfRows)
	{
        	urlBuilder =new StringBuilder("http://apis.data.go.kr/6260000/AttractionService/getAttractionKr"); /*URL*/
			urlBuilder.append("?serviceKey="+serviceKey);
	        urlBuilder.append("&pageNo=" +pageNo); /*페이지번호*/
	        urlBuilder.append("&numOfRows="+numOfRows); /*한 페이지 결과 수*/
	        urlBuilder.append("&resultType=" + resultType); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/
	        log.info(urlBuilder.toString());



	        try 
	        {
	        	url = new URL(urlBuilder.toString());
	        	conn = (HttpURLConnection) url.openConnection();
		        conn.setConnectTimeout(30000);
				conn.setReadTimeout(30000); // InputStream 읽어 오는 Timeout 시간 설정
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Content-type", "application/json");
		        
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"UTF-8"));
		        }
		        StringBuilder sb = new StringBuilder();
		        String line;
		        while ((line = rd.readLine()) != null) {
		            sb.append(line);
		        }
		        
		        // json 파싱
		        ObjectMapper objectMapper = new ObjectMapper();
		        Map<String, Object> map = new HashMap<>();
		        map= objectMapper.readValue(sb.toString(),  new TypeReference <Map<String,Object>>(){});

		        Map<String, Object> getAttractionKr = (Map<String, Object>) map.get("getAttractionKr");
		        List<Map<String, Object>> itemList =  (List<Map<String, Object>>) getAttractionKr.get("item");
		        	        		        
		        
		        attractionServices = new ArrayList<>();
		        for(Map<String, Object> item :itemList)
		        {
		        	AttractionService as = AttractionService.builder()
		        			.ucSeq(item.get("UC_SEQ").toString())
							.mainTitle(item.get("MAIN_TITLE").toString())
							.gugunName(item.get("GUGUN_NM").toString())
							.lat(item.get("LAT").toString())
							.lng(item.get("LNG").toString())
							.place(item.get("PLACE").toString())
							.addr1(item.get("ADDR1").toString())
							.mainImageNormal(item.get("MAIN_IMG_NORMAL").toString())
							.mainImageThumb(item.get("MAIN_IMG_THUMB").toString()).build();
		        	attractionServices.add(as);
		        }
		        

  
        } catch (UnsupportedEncodingException | MalformedURLException | ProtocolException e) {
			try {
				rd.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    conn.disconnect();
			e.printStackTrace();
		} catch(JsonParseException e) {
				try {
					rd.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		        conn.disconnect();
			log.info("JsonParseException");
			throw new PageEndOverFlowException("page overflow", ErrorCode.PAGE_END_OVERFLOW);
			
		}catch (IOException e) {
				try {
					rd.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		        conn.disconnect();
			log.info("IOException");
			throw new TimeOutIOException("time out", ErrorCode.TIME_OUT);

		}finally {
	        try {
				rd.close();
		        conn.disconnect();
		       
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	        
        
        return attractionServices;
        
	}
}
