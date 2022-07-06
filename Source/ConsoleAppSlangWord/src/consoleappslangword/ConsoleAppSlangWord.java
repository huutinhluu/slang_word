/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleappslangword;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	public static List<String> listHistorySlang = new ArrayList<String>();
	public static BufferedReader br=new BufferedReader(new InputStreamReader( System.in));  
	public static String outputFile = "slang_output.txt";
	public static String rootFile = "slang.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
    	data_Root = DocFile(outputFile);
        System.out.println( data_Root );    
        
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
                  ChucNang4();
                  break;
                case 5:
                  ChucNang5();
                  break;
                case 6:
                  ChucNang6();
                  break;
                case 7:
                ChucNang7();
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
    	if(data_Root.get(key)!= null ) {
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
    
    public static void ChucNang4() throws IOException{
    	System.out.println("Nhap slang word moi: ");
    	String keyNew = br.readLine().toUpperCase();
    	List<String> listDefinition = new ArrayList<String>();
    	int index = 1;
    	String definition;
    	do {
    		System.out.println("Nhap phim 1 de them slang word moi");
    		System.out.print("Definition " + index + ": " );
    		definition = br.readLine();
    		if(!definition.equals("1")) {
    			listDefinition.add(definition);
    		}
    		index++;
    	} while (!definition.equals("1"));
    	data_Root.put(keyNew, listDefinition);
    	Map<String, List<String>> newData = new HashMap<String,List<String>>();
    	newData.put(keyNew, listDefinition);
    	GhiFile(newData,true);
    	System.out.println("Them moi thanh cong");
    }
    
    public static void ChucNang5() throws IOException{
    	System.out.println("Nhap slang can edit: ");
    	String keyEdit = br.readLine().toUpperCase();
    	if(!data_Root.containsKey(keyEdit)) {
    		System.out.println("Khong tim thay");
    		return;
    	}
    	List<String> listDefinition = new ArrayList<String>();
    	int index = 1;
    	String definition;
    	do {
    		System.out.println("Nhap phim 1 de thay doi definition");
    		System.out.print("Definition " + index + ": " );
    		definition = br.readLine();
    		if(!definition.equals("1")) {
    			listDefinition.add(definition);
    		}
    		index++;
    	} while (!definition.equals("1"));
    	data_Root.remove(keyEdit);
    	data_Root.put(keyEdit, listDefinition);
    	GhiFile(data_Root,false);
    	System.out.println("Thay doi thanh cong");
    }
    
    public static void ChucNang6() throws IOException{
    	System.out.println("Nhap slang can xoa: ");
    	String keyRemove = br.readLine().toUpperCase();
    	if(!data_Root.containsKey(keyRemove)) {
    		System.out.println("Khong tim thay");
    		return;
    	}
    	System.out.println("Nhap delete de xac nhan xoa: ");
    	String keyCheck = br.readLine().toUpperCase();
    	if(keyCheck.equals("DELETE")) {
    		data_Root.remove(keyRemove);
        	GhiFile(data_Root,false);
        	System.out.println("Xoa thanh cong");
    	}
    	else {
    		System.out.println("Xoa khong thanh cong");    		
    	}
    }
    
    public static void ChucNang7() throws FileNotFoundException, IOException {
    	data_Root.clear();
    	data_Root = DocFile(rootFile);
    	GhiFile(data_Root,false);
    	System.out.println("Reset danh sach thanh cong");
    }
    
    public static Map<String, List<String>> DocFile(String nameFile) throws FileNotFoundException, IOException{
      String stringFile =""; 
      Map<String, List<String>> data = new HashMap<String, List<String>>();
      String str;
                      BufferedReader br = new BufferedReader(new FileReader(nameFile));
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
    
    public static void GhiFile(Map<String, List<String>> data, boolean type) throws IOException {
    	FileWriter fw = new FileWriter("slang_output.txt",type);
    	for (Entry<String, List<String>> entry: data_Root.entrySet())
        {
            List<String> listDefinition = entry.getValue();
            String itemLast = listDefinition.get(listDefinition.size()-1);
            fw.write(entry.getKey().toUpperCase() + "`" );
            for (String item : listDefinition) {
            	if(item.equals(itemLast))
            	{
            		fw.write(item);
            	}
            	else {
            		fw.write(item + "|" );
            	}
            }
            fw.write("\n");
        }
        
        fw.close();
    }
    
    public static List<String> getKey(String string)
    {
    	List<String> listKey = new ArrayList<String>();
        for (Entry<String, List<String>> entry: data_Root.entrySet())
        {
            List<String> listDefinition = entry.getValue();
            for (String item : listDefinition) {
            	String temp = item.toUpperCase();
            	if(temp.contains(string))
            	{
            		listKey.add(entry.getKey());
            	}
            }
        }
        return listKey;
    }
    
}
