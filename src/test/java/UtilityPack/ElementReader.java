package UtilityPack;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ElementReader {
	Properties proElement ;
	 public ElementReader() {
		 try {
			File src=new File("./Configuration/Element.property");
			   FileInputStream fis = new FileInputStream(src);
			   proElement = new Properties();
			   proElement.load(fis);
		} 
		 catch (Exception e) {
		System.out.println("Exception is =="+ e.getMessage());
		}
	 }
	 public String googleSearchBoxElement() {
		 return proElement.getProperty("GoogleSearchBox");   
	 }	 
	 public String amazonWebsiteLink() {
		 return proElement.getProperty("AmazonShopingWebsiteLink");
	 }	 
	 public String amazonSearchBox() {
		 return proElement.getProperty("AmazonSearchBox");
	 }	
	 public String amazonSearchBoxButton() {
		 return proElement.getProperty("AmazonSearchBoxButton");
	 }
	 public String firstBookResult() {
		 return proElement.getProperty("AmazonFirstBookResult");
	 }
	 public String searchBookList() {
		 return proElement.getProperty("TotalBooksResult");
	 }
	 public String englishLanguageSearch() {
		 return proElement.getProperty("BookLanguageChangeSearch");
	 }
	 public String nextSwitchOption() {
		 return proElement.getProperty("NextButtonSwitch"); 
	 }
}
