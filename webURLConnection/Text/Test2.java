package webURLConnection.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Test2 {
	/**
     * ����˵������������HTMLҳ��
     *@param SrcPath  ����Ŀ��ҳ���URL
     *@param filePath ���صõ���HTMLҳ���ű���Ŀ¼
     *@param fileName  ����ҳ�������
     */
    public static void downloadHtmlByNet(String SrcPath,String filePath,String fileName){
        try{
            URL url = new URL(SrcPath);
            URLConnection conn = url.openConnection();
            //���ó�ʱ��Ϊ3��
            conn.setConnectTimeout(3*1000);
            //��ֹ���γ���ץȡ������403����
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //�����
            InputStream str = conn.getInputStream();

            //�������Ĵ�СΪ1k
            byte[] bs = new byte[1024];

            //��ȡ���ĳ���
            int len = 0;

            //�Ƿ���Ҫ�����ļ���
            File saveDir = new File(filePath);  
            if(!saveDir.exists()){  
                saveDir.mkdir();  
            }  
            File file = new File(saveDir+File.separator+fileName);   

            //ʵ�����һ������
            FileOutputStream out = new FileOutputStream(file);
            //ѭ���жϣ������ȡ�ĸ���bΪ���ˣ���is.read()��������-1��������ο�InputStream��read();
            while ((len = str.read(bs)) != -1) {
                //������д�뵽��Ӧ���ļ���
                out.write(bs, 0, len);   
            }
            //ˢ����
            out.flush();
            //�ر���
            out.close();
            str.close();        
            System.out.println("���سɹ�");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //����
    public static void main(String[] args) {
         //������ҳ
    	//url��Ҫ���ص�ָ����ҳ��filepath����ļ���Ŀ¼��d:/resource/html/ ,filenameָ�ļ�����"���ص���ҳ.html"


         downloadHtmlByNet(" http://www.jc258.cn/news/show/392118","d:/web","textweb1.txt");
    }
}
