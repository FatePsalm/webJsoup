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
	 * ���չ涨��ʽ����ı���ָ���ص�
	 * 
	 * */
	
	public FileWrite(String path){
		this.path=path;
	}
	/**
	 * д���ļ�
	 * */
	public boolean doWrite(String title,String url,String date,String txt){
		//�Ƿ���Ҫ�����ļ���
        File saveDir = new File(path);  
        if(!saveDir.exists()){
            saveDir.mkdir();
        }  
        File file = new File(path,title+".txt");   

        //ʵ�����һ������
        //ѭ���жϣ������ȡ�ĸ���bΪ���ˣ���is.read()��������-1��������ο�InputStream��read();
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
        //ˢ����
        //�ر���
		return true;
	}
}
