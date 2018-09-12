import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class wcHomework {
    private static int cCount = 0;
    private static int wCount = 0;
    private static int lCount = 0;
    private static int codeLineCount = 0;
    private static int nullLineCount = 0;
    private static int noteLineCount = 0;
    private static String command = "";
    private static String[] string;
    private static String string1;
    private static String File;

    //统计字符数
    public static int cCount() throws IOException {
    	 cCount = 0;
    	 File file = new File(File);
    	 FileInputStream fis = new FileInputStream(file);
         InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
         BufferedReader br = new BufferedReader(isr);
         String line = "";
         while ((line = br.readLine()) != null) {
        	 cCount  += line.length();
         }
         return cCount;
    }

    //统计词数
    public static int wCount() throws IOException {
    	 wCount = 0;
    	File file = new File(File);
   	    FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
        	sb.append(line);
        	line = line.trim(); //删除起始和结尾的空格
            wCount = sb.toString().split("\\s+").length;
        }
        return wCount;
    }

   //统计总行数
    public static int lCount() throws IOException {
        lCount = 0;
    	File file = new File(File);
   	    FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = br.readLine())!= null) {
        	lCount = lCount +1;
        }
        return lCount;
    }

    //统计代码行数、空白行数、注释行数
    public static void moreLineCount() throws IOException {
        codeLineCount = 0;
        nullLineCount = 0;
        noteLineCount = 0;
    	File file = new File(File);
   	    FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
             if (line == "" || line.length() <= 1) {
                 nullLineCount =  nullLineCount + 1;
                 continue;
             }
             int a = line.indexOf("/");
             int b = line.substring(a + 1).indexOf("/");
             if (b == 0) {
                 noteLineCount++;
                 continue;
             }
             codeLineCount++;
        }
    }
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		System.out.print("wc.exe ");
        Scanner s = new Scanner(System.in);
        command = s.nextLine();
        string = command.split(" ");
        string1 = string[0];
        File = string[1];

        File file = new File(File);
        if(file.exists()) {
           switch(string1) {
              case "-c" :
        	     System.out.println("字符数目 ：" + cCount());
        	     break;
              case "-w" :
        	     System.out.println("词的数目 ：" + wCount());
        	     break;
              case "-l" :
        	     System.out.println("行数总数 ： " + lCount());
        	     break;
              case "-a" :
        	     moreLineCount();
        	     System.out.println("代码行数 ： " + codeLineCount);
        	     System.out.println("空白行数 ： " + nullLineCount);
        	     System.out.println("注释行数 ： " + noteLineCount);
        	     break;
          }
        }
        else {
            System.out.println("文件路径输入有误或者文件路径不存在");
        }
	}

}
