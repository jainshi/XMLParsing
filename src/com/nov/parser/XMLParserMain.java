package com.nov.parser;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLParserMain {

	public static void main(String[] args) throws Exception{
		/*//File folder = new File("C:\\Users\\sunesarah\\Desktop\\XMLS");
		File folder = new File("\\\\srvhouplmalc04.nov.com\\LCTemp$\\DH-ECR\\ECRFiles");
		File[] listOfFiles = folder.listFiles();
		for(int i = 0; i < listOfFiles.length; i++){
		String filename = listOfFiles[i].getName();
		//if(filename.startsWith("")){
			System.out.println(filename);
		//}
		//else{
			//System.out.println("File not found");
		//}
		   
		}*/
		
		System.out.println("Enter the path to search");          

        Scanner scanner = new Scanner(System.in);
        String folderPath = scanner.next();
        File [] files1 = null;
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
                File[] listOfFiles = folder.listFiles();
                for (File file : listOfFiles) {
                	String filename = file.getName();
                	System.out.println(filename);
                       if(file.isDirectory() && !filename.startsWith("Done")) {
                    	   files1 = file.listFiles();  
                    	   for(File file2 : files1)
                    	   	{
                    		   String xmlFile = file2.getName();
                    		   if(xmlFile.endsWith(".xml")){
                    			   System.out.println(xmlFile);
                    			   DocumentBuilderFactory domFactory = DocumentBuilderFactory
                    		                .newInstance();
                    		        domFactory.setNamespaceAware(true);
                    		        DocumentBuilder builder = domFactory.newDocumentBuilder();
                    		        Document doc = builder.parse(file2);
                    		        
                    		        XPathFactory factory = XPathFactory.newInstance();
                    		        XPath xpath = factory.newXPath();
                    		        String expression = "/ECR/approvalGroup";
                    		        XPathExpression expr = xpath.compile(expression);
                    		 
                    		        Object result = expr.evaluate(doc, XPathConstants.NODESET);
                    		        NodeList nodes = (NodeList) result;
                    		        for (int i = 0; i < nodes.getLength(); i++) {
                    		            System.out.println(nodes.item(i).getNodeValue());
                    		        }
                    		   Scanner file3 = new Scanner (file2);
                    		   while (file3.hasNext()){ 
                    			   System.out.print(file3.next() + "\t");
                    			   
                    		   }   
                    		   System.out.print("\n");
                    	   	}
                    	   	}
                       }
                }
        }
    
	}
	       
}


