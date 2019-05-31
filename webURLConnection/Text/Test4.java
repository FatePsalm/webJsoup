package webURLConnection.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test4 {
	 public static void main(String[] args) throws IOException {
		  	 testCase();
    }

	public static void testCase() throws IOException {
		List<String> result = new ArrayList<String>();
		 String url_news = "http://www.jc258.cn/news/list/7"; 
		 Document doc = Jsoup.connect(url_news).timeout(1000).get();
		 Elements e1 = doc.select("div.list_ti");
		 Elements e2 = e1.select("div.list_ti");
		 String str="/\\w*\"";
		 //a = new String(a.getBytes(),"GBK").replace('?', ' ').replace('¡¡', ' ');
		// System.out.println((e1.select("a[title]")));
		 String out=e1.select("a[title]").toString();
		 System.out.println(out);
		 String str2="title=([^>]*)>(.*?)";
		 String str3="href=\"([^>]*)target";
		 Matcher m = Pattern.compile(str3).matcher(out);
		// System.out.println(m);
		 while (m.find()) {  
		        String r = m.group(1);  
		        result.add(r);  
		    }
		 for(String l:result){
			 System.out.println(l);
		 }
//   System.out.print(e2);
//			 for (Element el2 : e2) {
//				 if (el2.text().length() > 20) {
//					 StringBuffer sb = new StringBuffer();
//					 sb.append(el2.text());
//					 String time = sb.substring(0, 9);
//					 String title = sb.substring(12);
//					 System.out.print("time:"+time+"\n");
//					 System.out.print("title:"+title+"\n");
//					 System.out.print("link:"+"http://i.guet.edu.cn/"+el2.attr("href")+"\n");
//				 }   
//			 }
	}
}
