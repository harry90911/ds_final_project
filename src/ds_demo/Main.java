package ds_demo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input a key_word:");
		String key_word = sc.nextLine();
		key_word = key_word.replaceAll("\\s+", "+");
		
		Output output = new Output(key_word);
		Url_list url_list = output.get_url_list();
		Url_list url_list_sorted = output.sort_url_list(url_list);
		
		sc.close();
	}
}
