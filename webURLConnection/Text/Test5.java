package webURLConnection.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Test5 {
	static String str="asdas@sadasaf123";
	static String str1="sdf<img src=\"get Me\">src=\"sagf\"<img >aaa<dfs>df<fs<dsf>";
	@Test
	public void test1(){
		String reg="\"([^>]*)\">";
		Pattern p1=Pattern.compile(reg);
		Matcher matcher1=p1.matcher(str1);
		while(matcher1.find()){
			System.out.println(matcher1.group(1));
		}
	}
	
	
	
	
	@Test
	public void testReg(){
		String reg1="s";
		String reg2="s(a)";
		Pattern p1=Pattern.compile(reg1);
		Matcher matcher1=p1.matcher(str);
		int j=1;
		while(matcher1.find()){
			System.out.println("NULLA"+j+"  "+matcher1.group());
			System.out.println("0A"+j+"   "+matcher1.group(0));
			j++;
		}
		Pattern p2=Pattern.compile(reg2);
		Matcher matcher2=p2.matcher(str);
		int i=1;
		while(matcher2.find()){
			System.out.println("1B"+i+"  "+matcher2.group(1));
			System.out.println("0B"+i+"  "+matcher2.group(0));
			System.out.println("nullB"+i+"  "+matcher2.group());
			i++;
		}
	}
}
