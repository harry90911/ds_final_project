package ds_demo;

public class Output {
	
	String key_word;
	public Output(String key_word) {
		this.key_word = key_word;
	}
	
	public Url_list get_url_list() throws Exception {
		
		Url_list output_list = new Url_list();
		int indexOfstart = 0;
		int indexOfend = 0;
		int indexOfstart_name = 0;
		int indexOfend_name = 0;
		int item_count = 1;
		String urlContent;
		String nameContent;
		
		String content = Connect.get_google_content(this.key_word);
		
		while (item_count <= 10) {
			indexOfstart = content.indexOf("<a href=\"/url?q=");
			indexOfend = content.substring(indexOfstart).indexOf("&")+indexOfstart;
			String url_preprocess = content.substring(indexOfstart+16,indexOfend);
			urlContent = java.net.URLDecoder.decode(url_preprocess, "UTF-8");
			
			indexOfstart_name = content.substring(indexOfend).indexOf(">")+indexOfend;
			indexOfend_name = content.substring(indexOfstart_name).indexOf("</a>")+indexOfstart_name;
			nameContent = content.substring(indexOfstart_name+1,indexOfend_name)
								 .replace("<b>", "")
								 .replace("</b>", "");
			
			String ismall = null;
			for (String ismall_name:Connect.ismall_array){
				if (urlContent.contains(ismall_name)){
					ismall = ismall_name;
				}
			}

			int SearchResult_count = Fetch_content.getSearchResult_count(ismall,this.key_word);
			
			Url_tuple Url_tuple = new Url_tuple(nameContent, urlContent, ismall, SearchResult_count);
			output_list.add(Url_tuple);
			content = content.substring(indexOfend+1);
			item_count +=1;
		}
		output_list.printAll();
		return output_list;
	}
	
	public Url_list sort_url_list(Url_list output_list) throws Exception {
		Url_list output_list2 = output_list;
		output_list2.sort();
		output_list2.printAll();
		return output_list2;
	}
}
