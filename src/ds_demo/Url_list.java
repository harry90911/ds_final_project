package ds_demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

@SuppressWarnings("serial")
public class Url_list extends ArrayList<Url_tuple>{
	
	public void printAll() {
        Iterator<Url_tuple> itr=this.iterator();  
        while(itr.hasNext()){  
        	Url_tuple url_tuple=(Url_tuple)itr.next();
        	url_tuple.show();
        }
        System.out.println("");
	}
	public void sort(){
		Collections.sort(this);
	}
}
