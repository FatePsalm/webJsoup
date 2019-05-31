package webURLConnection.Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlFilter {
	/**获取页面新闻连接返回*/
	
	private int time=3000;
	private String title="div.list_ti";
	private String titleText="div.news_content";
	private String titleRex="title=([^>]*)>(.*?)";
	private String hrefRex="href=\"([^>]*)target";
	/**
	 * 抓取子链接文本内容
	 * */
	public String Text(String Url) throws IOException{
		List<String> result = new ArrayList<String>();
		Document doc = Jsoup.connect(Url).timeout(time).get();
		 String str = doc.select(titleText).text();
		 str = new String(str.getBytes(),"GBK").replace('?', ' ').replace('　', ' ');//去问号
		 String strs=str.substring(0, str.length()-82);//82减去官方微信广告
		// System.out.println(strs);
		return strs;
	}
	/**
	 * 抓取URL子链接返回为List<String>
	 * */
	public List<String> getUrl(String Url){
		return result(Url, hrefRex);
	}
	/**
	 * 抓取新闻标签返回为List<String>
	 * */
	public List<String> getTitle(String Url){
		return result(Url, titleRex);
	}
	/**
	 * 提供get网页方法
	 * */
	public List<String> result(String Url,String rex){
		 List<String> result = new ArrayList<String>();
		 try {
			String doc = Jsoup.connect(Url).timeout(time).get().select(title).toString();
			Matcher matcher = Pattern.compile(rex).matcher(doc);
			// System.out.println(m);
			 while (matcher.find()) {  
		            String r = matcher.group(1);  
		            result.add(r.replaceAll("\"", ""));  
		        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
