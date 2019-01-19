package ds_demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Connect {
	
	public static String[] ismall_array = {
			"pchome",
			"shopee",
			"momomall",
			"momoshop",
			"mall.yahoo",
			"bid.yahoo",
			"buy.yahoo",
			"rakuten",
			"books",
			"friday",
			"taobao",
			"payeasy",
			"treemall",
			"myfone",
			"momoshop",
			"ruten",
			"etmall",
			"udn"};

	public static String get_content(String url) throws Exception{
		/* new 一個url類*/ 
		URL website = new URL(url);
		SslUtils.ignoreSsl();
		
		/* call url 類底下的一個方法，來建立連線*/ 
		URLConnection conn = website.openConnection();
		for (String ismall_name:ismall_array){
			if (url.contains(ismall_name)){
				conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
			}else{
				conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
			}
		}
		
		/* 取得文字資料後讓 java 去讀取 */ 
		BufferedReader text = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		/* 利用 StringBuilder 做字串串接， StringBuilder類 比 String 類更適合字串串接*/ 
		StringBuilder response = new StringBuilder();
		String line = new String();
		while ((line = text.readLine()) != null) 
	        response.append(line);
		return response.toString();
	}
	
	public static String get_google_content(String key_word) throws Exception{
		String url = "https://www.google.com/search?q="+key_word+"+網拍";
		System.out.println(url);
		String content = get_content(url);
		return content;
	}
}






