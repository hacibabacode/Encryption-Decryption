package Sifre;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;


class Ogrenci  {
	public void OgrenciSifre() {
		Scanner scan = new Scanner(System.in);
		 System.out.println("Adýnýzý girin: ");	        
	      String isim = scan.nextLine();
	      
	      double number=0;
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      System.out.println("Lütfen Öðrenci Numarasýný Girin");
	      try {
	      number = Double.parseDouble(br.readLine());
	      } catch (NumberFormatException e) {
	       
	      System.out.println("Numara GÝRÝÞ HATASI");
	      } catch (IOException e) {
	       
	      System.out.println("KLAVYE OKUMA HATASI");
	      }
	       
	      if(number<0)
	      {
	      System.out.println("HATALI GÝRÝÞ");
	      }
	      else if(number==10234)
	      {
	      System.out.println("Giriþ Baþarýlý.");
	      }else if(number>10235) 
	      {
	      System.out.println("Lütfen Öðrenci Numarasýný Girin");
	      try {
		      number = Double.parseDouble(br.readLine());
		      } catch (NumberFormatException e) {
		       
		      System.out.println("Numara GÝRÝÞ HATASI");
		      } catch (IOException e) {
		       
		      System.out.println("KLAVYE OKUMA HATASI");
		      }
	      if(number<0)
	      {
	      System.out.println("HATALI GÝRÝÞ");
	      }
	      else if(number==10234)
	      {
	      System.out.println("Giriþ Baþarýlý.");
	      }else    	  
	      System.out.println("Giriþ baþarýsýz.Numaranýzý Kontrol Edin !!");
	      }
	    
	  }

	public String OgrenciSifre(String message, int key) {
		// TODO Auto-generated method stub
		return null;
	}
}

class Encryption extends Ogrenci  {
	public void OgrenciSifre() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Lütfen Mesajý Girin ");
	      String message = scan.next();
	      int length = message.length();
	      System.out.print("Lütfen Anahtarý Girin. ");
	      int key = scan.nextInt();
	      String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowercase = "abcdefghijklmnopqrstuvwxyz";
	      String special = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
	      String numbers = "0123456789";
	      System.out.print("Encrypted Cümlesidir. ");
	      for(int i = 0 ;i < length ;i++)
	      {
	          for(int j = 0; j < 26 ;j++)
	          {
	              if(j < special.length() && message.charAt(i) == special.charAt(j))
	               {
	                   System.out.print(special.charAt(j)); //print special charecters as it is
	               }
	              else if(j < numbers.length() && message.charAt(i) == numbers.charAt(j))
	              {
	                  System.out.print(numbers.charAt(j)); //print numbers as it is
	              }
	              else if(message.charAt(i) == lowercase.charAt(j))
	              {
	                  System.out.print(lowercase.charAt((j + key) % 26));
	              }
	              else if(message.charAt(i) == uppercase.charAt(j))
	              {
	                  System.out.print(uppercase.charAt((j + key) % 26));
	              }          
	          }
	      }
	      System.out.println();
	  }
}

class Decryption extends Ogrenci  {
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	  public String OgrenciSifre(String cipherText, int shiftKey) {
	    cipherText = cipherText.toLowerCase();
	    String message = "";
	    for (int ii = 0; ii < cipherText.length(); ii++) {
	      int charPosition = ALPHABET.indexOf(cipherText.charAt(ii));
	      int keyVal = (charPosition - shiftKey) % 26;
	      if (keyVal < 0) {
	        keyVal = ALPHABET.length() + keyVal;
	      }
	      char replaceVal = ALPHABET.charAt(keyVal);
	      message += replaceVal;
	    }
	    return message;
	    
	  }
	  }
	
class Main {

public static void main(String[] args) {

	
	
      Ogrenci myOgrenci = new Ogrenci();
      Ogrenci myEncryption = new Encryption();
      Ogrenci myDecryption = new Decryption();
          
      myOgrenci.OgrenciSifre();
      myEncryption.OgrenciSifre();
      myDecryption.OgrenciSifre();
      
      Scanner sc = new Scanner(System.in);
      String message = new String();
      int key = 10234;
      System.out.print("Lütfen Encryption Cümlesini Girin:");
      message = sc.next();

      System.out.println("Lütfen Anahtarý girin.");
      key = sc.nextInt();
      
      System.out.println("Decrypted Message:" + myDecryption.OgrenciSifre(message, key));
      

}
}
