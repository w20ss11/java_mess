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
		//1.��ȡdom��������
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//2.���dom������
		DocumentBuilder db = dbf.newDocumentBuilder();
		//3.����һ��xml�ĵ������Document����
		Document document = db.parse(new File("book.xml"));
		
		//���ݱ�ǩ�����ʽڵ�
		NodeList list = document.getElementsByTagName("��");
		System.out.println("list length: " + list.getLength());
		for(int i=0;i<list.getLength();++i){
			
		}
	}
}
