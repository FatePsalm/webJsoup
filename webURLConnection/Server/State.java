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
 * @author �ܸ�
 * ���÷���ʵ��ץȥ����
 * */
public class State {
	private int i=0;
	private String url="http://www.jc258.cn/news/list/7";//����ҳ��ַ
	//�����Ѿ���¼�����ŵ�ID
	private static Set<String> set=new HashSet<String>();
	private HtmlFilter htmlFilter=new HtmlFilter();
	private SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private List<String> listUrl;
	private static int timeRun=180;//�����ٴ�ץȡʱ����
	public static void main(String[] args) {
		ExecutorService threadPool	= Executors.newFixedThreadPool(2);
		Runnable runn = new Runnable(){
			public void run(){
				while(true){
					Thread t = Thread.currentThread();
					State state=new State();
					try {
						state.writeFileBo(state.url);
						System.out.println(state.sim.format(new Date())+"�����ռ�"+set.size()+"������,�ȴ�3����..");
						t.sleep(1000*timeRun);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//������ָ�ɸ��̳߳�
		threadPool.execute(runn);
	}
	/**
	 * �ж��Ƿ�����ظ�������
	 * */
	public  void writeFileBo(String url){
		listUrl=htmlFilter.getUrl(url);
		for(String e:listUrl){
			if(!set.add(e.substring(e.lastIndexOf("/")+1).trim())){
				System.out.println(e.substring(e.lastIndexOf("/")+1).trim()+"�ظ���������...");
			}else{
				System.out.println("׼��д���ļ���Ӳ��..");
				runServer(e,url);
			}
		}
	}
	/**
	 * д�����ŵ�Ӳ��
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
				System.out.println("��ȡ�ļ�����ʧ��!");
			}
			fileWrite.doWrite(list.get(i).replaceAll("\"", ""), str, sim.format(date), text);
			i++;
		//htmlFilter.Text("http://www.jc258.cn/news/show/39211");
//		System.out.println(list);
		System.out.println("ʱ��"+sim.format(date)+"�������,����д��"+i+"����¼");
	}

}
