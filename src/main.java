import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
 
public class main {
 
	public static void main(String argv[]) {
 
	  try {
 
		  /*
		  URL fXmlFile = new URL("http://xml.betclick.com/odds_en.xml");
		  InputStream xml = fXmlFile.openStream();
		  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		  Document doc = dBuilder.parse(xml);
		  xml.close();
		   																		*/
		// /*  
		File fXmlFile = new File("xml/odds_en.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
																				// */
 
		System.out.println("primo nodo: " + doc.getDocumentElement().getNodeName());
		
		System.out.println("secondo nodo: " + doc.getDocumentElement().getFirstChild().getNodeName());
		
		System.out.println("terzo nodo: " + doc.getDocumentElement().getFirstChild().getFirstChild().getNodeName());
		
		System.out.println("quarto nodo: " + doc.getDocumentElement().getFirstChild().getFirstChild().getFirstChild().getNodeName());
		
		System.out.println("quinto nodo: " + doc.getDocumentElement().getFirstChild().getFirstChild().getFirstChild().getFirstChild().getNodeName());
		
		System.out.println("sesto nodo: " + doc.getDocumentElement().getFirstChild().getFirstChild().getFirstChild().getFirstChild().getFirstChild().getNodeName());
		
		System.out.println("settimo nodo: " + doc.getDocumentElement().getFirstChild().getFirstChild().getFirstChild().getFirstChild().getFirstChild().getFirstChild().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("sports");
		System.out.println("-----------------------");
 
		for (int temp = 0; temp < nList.getLength(); temp++) {
 
		   Node nNode = nList.item(temp);
		   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
		      Element eElement = (Element) nNode;
 
		     
		      System.out.println("valore settimo nodo: " +  doc.getDocumentElement().getFirstChild().getFirstChild().getFirstChild().getFirstChild().getFirstChild().getFirstChild().getNodeValue());
		   /*   System.out.println("Last Name : " + getTagValue("lastname", eElement));
	              System.out.println("Nick Name : " + getTagValue("nickname", eElement));
		      System.out.println("Salary : " + getTagValue("salary", eElement)); */
 
		   }
		}
	  } catch (Exception e) {
		e.printStackTrace();
	  }
  }
 
  private static String getTagValue(String sTag, Element eElement) {
	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
 
        Node nValue = (Node) nlList.item(0);
 
	return nValue.getNodeValue();
  }
 
}