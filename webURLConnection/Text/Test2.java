package webURLConnection.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Test2 {
	/**
     * 方法说明：用于下载HTML页面
     *@param SrcPath  下载目标页面的URL
     *@param filePath 下载得到的HTML页面存放本地目录
     *@param fileName  下载页面的名字
     */
    public static void downloadHtmlByNet(String SrcPath,String filePath,String fileName){
        try{
            URL url = new URL(SrcPath);
            URLConnection conn = url.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(3*1000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //输出流
            InputStream str = conn.getInputStream();

            //控制流的大小为1k
            byte[] bs = new byte[1024];

            //读取到的长度
            int len = 0;

            //是否需要创建文件夹
            File saveDir = new File(filePath);  
            if(!saveDir.exists()){  
                saveDir.mkdir();  
            }  
            File file = new File(saveDir+File.separator+fileName);   

            //实例输出一个对象
            FileOutputStream out = new FileOutputStream(file);
            //循环判断，如果读取的个数b为空了，则is.read()方法返回-1，具体请参考InputStream的read();
            while ((len = str.read(bs)) != -1) {
                //将对象写入到对应的文件中
                out.write(bs, 0, len);   
            }
            //刷新流
            out.flush();
            //关闭流
            out.close();
            str.close();        
            System.out.println("下载成功");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //测试
    public static void main(String[] args) {
         //下载网页
    	//url是要下载的指定网页，filepath存放文件的目录如d:/resource/html/ ,filename指文件名如"下载的网页.html"


         downloadHtmlByNet(" http://www.jc258.cn/news/show/392118","d:/web","textweb1.txt");
    }
}
