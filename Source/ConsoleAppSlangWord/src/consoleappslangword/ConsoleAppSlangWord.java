/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleappslangword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ASUS
 */
public class ConsoleAppSlangWord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
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
            System.out.println("9. Do vui, tim definition của slang word cho truoc");
            System.out.println("10. Do vui, tim slang word tu definition cho truoc");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("-------------------\n Nhap so lua chon: ");
            try {
                keyMenu = Integer.parseInt(br.readLine());
            } catch (Exception e){
                System.out.println("WARN: Chuc nang la 1 so tu 0-10!");
            }
            switch(keyMenu) {
                case 1:
                  System.out.println("Chuc nang 1");
                  break;
                case 2:
                  System.out.println("Chuc nang 2");
                  break;
                case 3:
                  System.out.println("Chuc nang 3");
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
                  System.out.println("Lua chon khong phu hop, vui long nhap lai");
              }
        } while(keyMenu != 0); 
    }
    
}
