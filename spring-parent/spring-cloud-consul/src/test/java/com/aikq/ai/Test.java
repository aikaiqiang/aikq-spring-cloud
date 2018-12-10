package com.aikq.ai;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

/**
 *  E
 * @author aikq
 * @date 2018年12月10日 9:35
 */
public class Test {

	// 时区
	private static String[][] map = new String[][]{{"ACT", "Australia/Darwin"}, {"AET", "Australia/Sydney"}, {"AGT", "America/Argentina/Buenos_Aires"}, {"ART", "Africa/Cairo"}, {"AST", "America/Anchorage"}, {"BET", "America/Sao_Paulo"}, {"BST", "Asia/Dhaka"}, {"CAT", "Africa/Harare"}, {"CNT", "America/St_Johns"}, {"CST", "America/Chicago"}, {"CTT", "Asia/Shanghai"}, {"EAT", "Africa/Addis_Ababa"}, {"ECT", "Europe/Paris"}, {"IET", "America/Indiana/Indianapolis"}, {"IST", "Asia/Kolkata"}, {"JST", "Asia/Tokyo"}, {"MIT", "Pacific/Apia"}, {"NET", "Asia/Yerevan"}, {"NST", "Pacific/Auckland"}, {"PLT", "Asia/Karachi"}, {"PNT", "America/Phoenix"}, {"PRT", "America/Puerto_Rico"}, {"PST", "America/Los_Angeles"}, {"SST", "Pacific/Guadalcanal"}, {"VST", "Asia/Ho_Chi_Minh"}};


	public static void main(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
		Date now = new Date();
		System.out.println(now);

//		JSONArray jsonArray = new JSONArray();
//		for (int i=0; i<map.length;i++){
//			JSONObject object = new JSONObject();
//			object.put(map[i][0], map[i][01]);
//			jsonArray.add(object);
//		}
//
//		System.out.println(jsonArray);

	}
}
