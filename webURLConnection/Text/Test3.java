package webURLConnection.Text;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test3 {
	 public static void main(String[] args) throws IOException {
			 String url_news = "http://www.sporttery.cn/football/jczj/2017/0728/254142.html"; 
			 String doc = Jsoup.connect(url_news).timeout(1000).get().toString();
			 //String e1 = doc.select("div.news_content").text();
			 //String a = e1.select("#cke_pastebin").text();
			// e1 = new String(e1.getBytes(),"GBK").replace('?', ' ').replace('¡¡', ' ');
			 System.out.println(doc);
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
