package com.tour.app.api;

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
import com.tour.app.domain.RecommendedService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;

@Setter
@Slf4j
public class BusanThemaApiExplorer
{
		private final String serviceKey= "0LhzbgxfHbUWH9veox3LgaRJouEFZMou%2FzQk9XbH9T7ED6DO8u1sCZO8oYHIlPRzmC46s8VVfOudOl11AtjLsw%3D%3D";
		private int pageNo = 1;
		private int numOfRows =10;
		private final String resultType="json";
		private String UC_SEQ="";
        private StringBuilder urlBuilder = null;
        

		public BusanThemaApiExplorer(  ) {
		}

		public  List<RecommendedService> requestAPI(int pageNo, int numOfRows)
		{
	        List<RecommendedService> recommenedServices = new ArrayList<>();
	        	urlBuilder =new StringBuilder("http://apis.data.go.kr/6260000/RecommendedService/getRecommendedKr"); /*URL*/
				urlBuilder.append("?serviceKey="+serviceKey);
		        urlBuilder.append("&pageNo=" +pageNo); /*페이지번호*/
		        urlBuilder.append("&numOfRows="+numOfRows); /*한 페이지 결과 수*/
		        urlBuilder.append("&resultType=" + resultType); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/
		        //urlBuilder.append("&UC_SEQ=" + UC_SEQ); /*콘텐츠 ID*/
		        System.out.println(urlBuilder.toString());

		        URL url = null;
		        HttpURLConnection conn = null;
		        BufferedReader rd=null;

		        try 
		        {
		        	url = new URL(urlBuilder.toString());	
		        	conn = (HttpURLConnection) url.openConnection();
			        conn.setConnectTimeout(30000);
					conn.setReadTimeout(30000); // InputStream 읽어 오는 Timeout 시간 설정
			        conn.setRequestMethod("GET");
			        conn.setRequestProperty("Content-type", "application/json");
			        log.info("Response code: " + conn.getResponseCode());
			        
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
			        
			        Map<String, Object> getRecommendedKr = (Map<String, Object>) map.get("getRecommendedKr");
			        List<Map<String, Object>> itemList =  (List<Map<String, Object>>) getRecommendedKr.get("item");
			        System.out.println("totalCount: "+getRecommendedKr.get("totalCount"));
			        	        		        
		        
			        for(Map<String, Object> item :itemList)
			        {
			        	RecommendedService rs= RecommendedService.builder()
			        							.uc_seq(item.get("UC_SEQ").toString())
			        							.main_title(item.get("MAIN_TITLE").toString())
			        							.gugun_nm(item.get("GUGUN_NM").toString())
			        							.cate2_nm(item.get("CATE2_NM").toString())
			        							.lat(item.get("LAT").toString())
			        							.lng(item.get("LNG").toString())
			        							.main_place(item.get("MAIN_PLACE").toString())
			        							.title(item.get("TITLE").toString())
			        							.main_img_normal(item.get("MAIN_IMG_NORMAL").toString())
			        							.main_img_thumb(item.get("MAIN_IMG_THUMB").toString())
			        							.itemcntnts(item.get("ITEMCNTNTS").toString()).build();
			        							recommenedServices.add(rs);
			        }
			        
			        try {
						rd.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        conn.disconnect();
	        
	        } catch (UnsupportedEncodingException | MalformedURLException | ProtocolException e) {
				try {
					rd.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    conn.disconnect();
				e.printStackTrace();
			} catch(JsonParseException e) {
					try {
						rd.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        conn.disconnect();
				log.info("JsonParseException");
				throw new PageEndOverFlowException("page overflow", ErrorCode.PAGE_END_OVERFLOW);
				
			}catch (IOException e) {
					try {
						rd.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        conn.disconnect();
				log.info("IOException");
				throw new TimeOutIOException("time out", ErrorCode.TIME_OUT);

			}
	        
	        return recommenedServices;
	        
		}

}