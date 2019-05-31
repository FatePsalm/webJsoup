package webURLConnection.Server;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class FileWrite {
	String path;
	/**
	 * 
	 * 按照规定格式输出文本到指定地点
	 * 
	 * */
	
	public FileWrite(String path){
		this.path=path;
	}
	/**
	 * 写入文件
	 * */
	public boolean doWrite(String title,String url,String date,String txt){
		//是否需要创建文件夹
        File saveDir = new File(path);  
        if(!saveDir.exists()){
            saveDir.mkdir();
        }  
        File file = new File(path,title+".txt");   

        //实例输出一个对象
        //循环判断，如果读取的个数b为空了，则is.read()方法返回-1，具体请参考InputStream的read();
        BufferedWriter bw = null;
        try {
        	FileOutputStream out = new FileOutputStream(file);
        	OutputStreamWriter write=new OutputStreamWriter(out);
            bw=new BufferedWriter(write);
			bw.write("title:"+title);
			bw.newLine();
			bw.write("url:"+url);
			bw.newLine();
			bw.write("date:"+date);
			bw.newLine();
			bw.write("content:"+txt);
			bw.newLine();
			write.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(bw!=null){
					bw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        //刷新流
        //关闭流
		return true;
	}
}
