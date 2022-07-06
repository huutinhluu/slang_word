/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleappslangword;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 *
 * @author ASUS
 */
public class ConsoleAppSlangWord {
	
	public static  Map<String, List<String>> data_Root;
	public static  Map<String, List<String>> data_Process;
	public static List<String> listHistorySlang = new ArrayList<String>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
    	data_Root = DocFile();
    	data_Process = DocFile_XuLy();
        System.out.println( data_Process );

        
        
        BufferedReader br=new BufferedReader(new InputStreamReader( System.in));  
        int keyMenu = -1;
        do {  
            System.out.println("------------------\nMENU CHUC NANG");
            System.out.println("1. Tim kiem theo Slang word");
            System.out.println("2. Tim kiem theo definition");
            System.out.println("3. Hien thi history");
            System.out.println("4. Them 1 slang word moi");
            System.out.println("5. Chinh sua 1 slang word");
            System.out.println("6. Xoa 1 slang word");
            System.out.println("7. Reset ve danh sach slang word goc");
            System.out.println("8. Random 1 slang word");
            System.out.println("9. Do vui, tim definition cac slang word cho truoc");
            System.out.println("10. Do vui, tim slang word tu definition cho truoc");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("-------------------\n Nhap so lua chon: ");
            try {
                keyMenu = Integer.parseInt(br.readLine());
            } catch (Exception e){
                System.out.println("WARN: Chuc nang la 1 so tu 0-10!");
            }
            switch(keyMenu) {
                case 1:
                  System.out.print("Nhap slang word:");
                  String keySlang = br.readLine();
                  listHistorySlang.add(keySlang);
                  ChucNang1(keySlang);                  
                  break;
                case 2:
                	System.out.print("Nhap definition :");
                    String valueDefination = br.readLine();
                    ChucNang2(valueDefination);
                  break;
                case 3:
                	ChucNang3();
                  break;
                case 4:
                  System.out.println("Chuc nang 4");
                  break;
                case 5:
                  System.out.println("Chuc nang 5");
                  break;
                case 6:
                  System.out.println("Chuc nang 6");
                  break;
                case 7:
                  System.out.println("Chuc nang 7");
                  break;
                case 8:
                  System.out.println("Chuc nang 8");
                  break;
                case 9:
                  System.out.println("Chuc nang 9");
                  break;
                case 10:
                  System.out.println("Chuc nang 10");
                  break;
                default:
                	if(keyMenu != 0) {
                		System.out.println("Lua chon khong phu hop, vui long nhap lai");
                	}
              }
        } while(keyMenu != 0); 
    }
    
    public static void ChucNang1(String key){
    	key = key.toUpperCase();
    	if(data_Process.get(key)!= null ) {
    		System.out.println("Cac definition cua " + key + " la: ");
    		for(String item : data_Root.get(key))
            {
          	  System.out.println("+ " + item);
            }
    	}
    	else {
    		System.out.println("Khong tim thay definition");
    	}
    }
    
    public static void ChucNang2(String value){
    	List<String> listSlang = getKey(value.toUpperCase());
    	if(listSlang.size() > 0) {
    		System.out.println("Cac slang word cua " + value + " la: ");
    		for ( String item : listSlang) {
    			System.out.println("+ " + item);
    		}
    	}
    	else {
    		System.out.println("Khong tim thay slang word nao");
    	}
    	
    }
    
    public static void ChucNang3(){
    	if(listHistorySlang.size()> 0) {
    		System.out.println("Lich su tim kiem cac slang word: ");
    		for(String item : listHistorySlang) {
    			System.out.println ("+ " + item);
    		}
    	}
    	else {
    		System.out.println("Chua co lich su tim kiem nao");
    	}
    	
    }
    
    public static Map<String, List<String>> DocFile() throws FileNotFoundException, IOException{
      String stringFile =""; 
      Map<String, List<String>> data = new HashMap<String, List<String>>();
      String str;
                      BufferedReader br = new BufferedReader(new FileReader("slang.txt"));
		while (true)
		{
			str = br.readLine();
                        if (str==null)
				break;
                        List<String> listValue = new ArrayList<String>();                      
                        String valueItem = str.split("`")[1];
                        valueItem = valueItem.replaceAll(Pattern.quote("|"), "-");
                        listValue =  Arrays.asList(valueItem.split("-"));
                        data.put(str.split("`")[0],listValue);                
		}
        br.close();
        return data;
    }
    
    public static Map<String, List<String>> DocFile_XuLy() throws FileNotFoundException, IOException{
        String stringFile =""; 
        Map<String, List<String>> data = new HashMap<String, List<String>>();
        String str;
                        BufferedReader br = new BufferedReader(new FileReader("slang.txt"));
  		while (true)
  		{
  			str = br.readLine();
                          if (str==null)
  				break;
                          List<String> listValue = new ArrayList<String>();                      
                          String valueItem = str.split("`")[1].toUpperCase();
                          valueItem = valueItem.replaceAll(Pattern.quote("|"), "-");
                          listValue =  Arrays.asList(valueItem.split("-"));
                          data.put(str.split("`")[0].toUpperCase(),listValue);                
  		}
          br.close();
          return data;
      }
    
    public static List<String> getKey(String string)
    {
    	List<String> listKey = new ArrayList<String>();
        for (Entry<String, List<String>> entry: data_Process.entrySet())
        {
            List<String> listDefinition = entry.getValue();
            for (String item : listDefinition) {
            	if(item.contains(string))
            	{
            		listKey.add(entry.getKey());
            	}
            }
        }
        return listKey;
    }
    
}
