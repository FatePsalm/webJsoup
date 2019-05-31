package webURLConnection.Server;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author 曹刚
 * 调用方法实现抓去新闻
 * */
public class State {
	private int i=0;
	private String url="http://www.jc258.cn/news/list/7";//主网页地址
	//保存已经记录过新闻的ID
	private static Set<String> set=new HashSet<String>();
	private HtmlFilter htmlFilter=new HtmlFilter();
	private SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private List<String> listUrl;
	private static int timeRun=180;//设置再次抓取时间秒
	public static void main(String[] args) {
		ExecutorService threadPool	= Executors.newFixedThreadPool(2);
		Runnable runn = new Runnable(){
			public void run(){
				while(true){
					Thread t = Thread.currentThread();
					State state=new State();
					try {
						state.writeFileBo(state.url);
						System.out.println(state.sim.format(new Date())+"共计收集"+set.size()+"条新闻,等待3分钟..");
						t.sleep(1000*timeRun);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//将任务指派给线程池
		threadPool.execute(runn);
	}
	/**
	 * 判断是否存在重复的新闻
	 * */
	public  void writeFileBo(String url){
		listUrl=htmlFilter.getUrl(url);
		for(String e:listUrl){
			if(!set.add(e.substring(e.lastIndexOf("/")+1).trim())){
				System.out.println(e.substring(e.lastIndexOf("/")+1).trim()+"重复新闻跳过...");
			}else{
				System.out.println("准备写入文件到硬盘..");
				runServer(e,url);
			}
		}
	}
	/**
	 * 写入新闻到硬盘
	 * */
	public  void runServer(String e,String url){
		List<String> list=htmlFilter.getTitle(url);
		String path="d:/web";
		FileWrite fileWrite=new FileWrite(path);
			Date date=new Date();
			//System.out.println("http://www.jc258.cn"+e);
			String str="http://www.jc258.cn"+e;
			System.out.println(str);
			String text = null;
			try {
				text = htmlFilter.Text(str);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("获取文件内容失败!");
			}
			fileWrite.doWrite(list.get(i).replaceAll("\"", ""), str, sim.format(date), text);
			i++;
		//htmlFilter.Text("http://www.jc258.cn/news/show/39211");
//		System.out.println(list);
		System.out.println("时间"+sim.format(date)+"运行完毕,本次写入"+i+"条记录");
	}

}
