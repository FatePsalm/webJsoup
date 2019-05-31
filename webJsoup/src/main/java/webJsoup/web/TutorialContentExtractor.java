package webJsoup.web;


import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;

/**
 * 本教程演示了从WebCollector 2.10起添加的新闻网页正文自动提取功能
 *
 * @author hu
 */
public class TutorialContentExtractor {
	 public static void main(String[] args) throws Exception {

	        News news = ContentExtractor.getNewsByUrl("http://www.zhcw.com/ssq/szjq/4534170.shtml");
	        System.out.println(news.getUrl());
	        System.out.println(news.getTitle());
	        System.out.println(news.getTime());
	        System.out.println(news.getContent());
	        //System.out.println(news.getContentElement());

	        //System.out.println(news);
	    }
   
}