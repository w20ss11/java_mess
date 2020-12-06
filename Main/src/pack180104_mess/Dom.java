package pack180104_mess;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class Dom {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException{
		//1.获取dom解析工厂
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//2.获得dom解析器
		DocumentBuilder db = dbf.newDocumentBuilder();
		//3.解析一个xml文档，获得Document对象
		Document document = db.parse(new File("book.xml"));
		
		//根据标签名访问节点
		NodeList list = document.getElementsByTagName("书");
		System.out.println("list length: " + list.getLength());
		for(int i=0;i<list.getLength();++i){
			
		}
	}
}
