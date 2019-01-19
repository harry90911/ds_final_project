package ds_demo;

public class Url_tuple implements Comparable<Url_tuple>{
	public String url_name;
	public String url;
	public String is_mall;
	public int searchResultCount;
	
    Url_tuple(String url_name,String url, String is_mall, int searchResultCount) {  
        this.url_name=url_name;    
        this.url=url;
        this.is_mall = is_mall;
        this.searchResultCount = searchResultCount;
    }
	public void show() {
		System.out.println("["+this.url_name+", "+this.is_mall+", "+this.searchResultCount+", "+this.url+"]");   
	}
	
	@Override
	public int compareTo(Url_tuple other) {
		return other.searchResultCount-this.searchResultCount;
	}
}