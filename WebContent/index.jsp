<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="ds_demo.*, org.json.*" %>
<!doctype html>
<html>
  <head>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  </head>
    <style>
      /* BASIC STYLES */
      body {
        margin: 0;
        padding: 0;
        font-family: 'Roboto', sans-serif;
      }
      /* GOOGLE AREA */
      .google #google_logo {
        text-align: center;
        display: block;
        margin: 0 auto;
        clear: both;
        padding-top: 112px;
        padding-bottom: 20px;
      }

      .form {
        text-align: center;
      }

      #form-search { 
        width: 450px;
        line-height: 32px;
        padding: 20px 10px;
      }

      .form #form-search {
        padding: 0 8px;
      }

      .buttons {
        text-align: center;
        padding-top: 30px;
        margin-bottom: 300px;
      }
    </style>
  <body>
    <!-- GOOGLE IMG -->  
    <div class="google">
      <a href="#" id="google_logo"><img src="https://i325.photobucket.com/albums/k388/pricecompare650/index_zps2ad4152c.jpg" alt="price_compare.jpg"/></a>
    </div>
      
    <div class="form">
      <% if (request.getParameter("form-search") == null){ %>
      <form action='${requestUri}'>
      	<input type="text" name="form-search" placeholder="Type in keyword">
    	<div class= "buttons">
    		<input type="submit" value="Search Best Price" id="google_search">
    	</div>
      </form>
 		<%} else {
			String key_word = request.getParameter("form-search").replaceAll("\\s+", "+");
			key_word = java.net.URLEncoder.encode(key_word, "ISO-8859-1");
			key_word = java.net.URLDecoder.decode(key_word, "UTF-8");
			
			Output output = new Output(key_word);
			Url_list url_list = output.get_url_list();
 		%>
			<font size="7" align="center">排序前</font>
			<table align="center">
				<tr>
					<th width="20%">Title</th>
					<th width="15%">EC Name</th>
					<th width="20%">Search results</th>
					<th width="15%" align="left">Url</th>
				</tr>	
			<% for(int i = 0; i<url_list.size(); i++) {%>
				<tr>	
					<td width="20%"><%out.print(url_list.get(i).url_name);%></td>
					<td><%out.print(url_list.get(i).is_mall);%></td>
					<td><%out.print(url_list.get(i).searchResultCount);%></td>
					<td width="15%" align="left"><%out.print(url_list.get(i).url);};%></td>
				</tr>
			</table>
			
			<font size="7" align="center">排序後</font>
			<table align="center">
				<tr>
					<th width="20%">Title</th>
					<th width="15%">EC Name</th>
					<th width="20%">Search results</th>
					<th width="15%" align="left">Url</th>
				</tr>		
			<% 
			Url_list url_list_sorted = output.sort_url_list(url_list);
			for(int i = 0; i<url_list_sorted.size(); i++) {%>
				<tr>	
					<td width="20%"><%out.print(url_list_sorted.get(i).url_name);%></td>
					<td><%out.print(url_list_sorted.get(i).is_mall);%></td>
					<td><%out.print(url_list_sorted.get(i).searchResultCount);%></td>
					<td width="15%" align="left"><%out.print(url_list_sorted.get(i).url);};%></td>
				</tr>
			</table>
			<%};%>
    </div>
  </body>
</html>
