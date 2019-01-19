package ds_demo;

import java.text.MessageFormat;

import org.json.JSONObject;
import ds_demo.Connect;


public class Fetch_content {
	public static int getSearchResult_count(String name, String key_word) throws Exception {

		int indexOfstart = 0;
		int indexOfend = 0;
		int search_result = 0;
		String url;
		String content;
		key_word = java.net.URLEncoder.encode(key_word, "utf-8");
		
		if (name == "momomall"){
			url = MessageFormat.format("https://www.momomall.com.tw/mall/{0}.html", key_word);
			content = Connect.get_content(url);
			indexOfstart = content.indexOf("共計<b>");
			indexOfend = content.substring(indexOfstart+5).indexOf("<")+indexOfstart+5;
			search_result = Integer.parseInt(content.substring(indexOfstart+5,indexOfend)); 
		}
		else if (name == "pchome"){
			url = MessageFormat.format("https://ecshweb.pchome.com.tw/search/v3.3/all/results?q={0}&page=1&sort=sale/dc", key_word);
			content = Connect.get_content(url);
			JSONObject obj = new JSONObject(content);
			search_result = obj.getInt("totalRows");
		}
		else if (name == "shopee"){
			url = MessageFormat.format("https://shopee.tw/api/v2/search_items/?by=relevancy&keyword={0}&limit=50&newest=0&order=desc&page_type=search", key_word);
			content = Connect.get_content(url);
			JSONObject obj = new JSONObject(content);
			search_result = obj.getInt("total_count");
		}
		else if (name == "momoshop"){
			url = MessageFormat.format("https://www.momoshop.com.tw/search/searchShop.jsp?keyword={0}&searchType=1&curPage=1&_isFuzzy=0&showType=chessboardType", key_word);
			content = Connect.get_content(url);
			search_result = -1; 
		}
		else if(name == "mall.yahoo"){
			url = MessageFormat.format("https://tw.search.mall.yahoo.com/search/mall/product?p={0}", key_word);
			content = Connect.get_content(url);
			indexOfstart = content.indexOf("筆結果</span>");
			indexOfend = content.substring(0,indexOfstart).lastIndexOf(">");
			search_result = Integer.parseInt(content.substring(indexOfend+1,indexOfstart).replace(" ","")); 
		}
		else if(name == "bid.yahoo"){
			url = MessageFormat.format("https://tw.bid.yahoo.com/search/auction/product?p={0}", key_word);
			content = Connect.get_content(url);
			indexOfstart = content.indexOf(">全部<span>(");
			indexOfend = content.substring(indexOfstart).indexOf(")</span>")+indexOfstart;
			search_result = Integer.parseInt(content.substring(indexOfstart+10,indexOfend)); 
		}
		else if(name == "buy.yahoo"){
			url = MessageFormat.format("https://tw.search.buy.yahoo.com/search/shopping/product?p={0}", key_word);
			content = Connect.get_content(url);
			indexOfstart = content.indexOf("筆結果</span>");
			indexOfend = content.substring(0,indexOfstart).lastIndexOf(">");
			search_result = Integer.parseInt(content.substring(indexOfend+1,indexOfstart).replace(" ","")); 
		}
		else if(name == "rakuten"){
			url = MessageFormat.format("https://find.ruten.com.tw/s/?q={0}", key_word);
			content = Connect.get_content(url);
			indexOfstart = content.indexOf("顯示第 1 筆 - 第 20 筆，共 ");
			indexOfend = content.substring(indexOfstart).indexOf(" 筆結果")+indexOfstart;
			search_result = Integer.parseInt(content.substring(indexOfstart+19,indexOfend)); 
		}
		else if(name == "books"){
			url = MessageFormat.format("https://search.books.com.tw/search/query/key/{0}/cat/all", key_word);
			content = Connect.get_content(url);
			indexOfstart = content.indexOf("搜尋結果共 <span>");
			indexOfend = content.substring(indexOfstart+12).indexOf("<")+indexOfstart+12;
			search_result = Integer.parseInt(content.substring(indexOfstart+12,indexOfend)); 
		}
		else if(name == "friday"){
			url = MessageFormat.format("https://shopping.friday.tw/ec2/search?sid=&hotNum=0&search={0}", key_word);
						content = Connect.get_content(url);
			indexOfstart = content.indexOf("friDay購物</a>									<span class=\"count\">(")+42;
			indexOfend = content.substring(indexOfstart).indexOf(")")+indexOfstart;
			search_result = Integer.parseInt(content.substring(indexOfstart,indexOfend)); 
		}
		else if(name == "tree"){
			url = MessageFormat.format("https://www.treemall.com.tw/quidditch/treemall?suggestword=0&carrierType=&productNum=&keywords={0}", key_word);
			content = Connect.get_content(url);
			String tag = "符合的商品共 &quot; <span id=\"displayedsize\" class=\"style3\">";
			int tagLength = tag.length();	
			indexOfstart = content.indexOf(tag)+tagLength;
			indexOfend = content.substring(indexOfstart).indexOf("<")+indexOfstart;
			
			search_result = Integer.parseInt(content.substring(indexOfstart,indexOfend)); 
		}
		else if(name=="myfone"){
			url = MessageFormat.format("https://search.myfone.com.tw/searchResult.php?sort_id=&keyword={0}", key_word);
			content = Connect.get_content(url);
			String tag = "找到共 <span class=\"count\">";
			int tagLength = tag.length();	
			indexOfstart = content.indexOf(tag)+tagLength;
			indexOfend = content.substring(indexOfstart).indexOf("<")+indexOfstart;
			
			search_result = Integer.parseInt(content.substring(indexOfstart,indexOfend)); 
		}
		else {
			search_result = -1;
		}
		return search_result;
	}
}
