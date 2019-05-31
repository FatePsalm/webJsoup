package webURLConnection.Text;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
	 public static void main(String[] args) throws IOException {
			 String url_news = "http://www.jc258.cn/news/show/391734"; 
			 Document doc = Jsoup.connect(url_news).timeout(1000).get();
			 Elements e1 = doc.select("div.news_content");
			 Elements a = e1.select("#cke_pastebin");
			 Elements e4 = doc.select("h2");
			 System.out.println(e4.get(2).text());
			// System.out.println(a);
			 String a1=a.toString();
			String emailRegEx="<[b-h,j-z][^>]*>";
			String b=a1.replaceAll(emailRegEx, "");
			 System.out.println(b);
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
