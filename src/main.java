import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
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
		  URL fXmlFile = new URL("http://feeds.titanbet.com/feed.xml");
		  InputStream xml = fXmlFile.openStream();
		  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		  Document doc = dBuilder.parse(xml);
		  xml.close();
		   																		*/
	//	 /*  
		File fXmlFile = new File("xml/feed.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
																				// */

		NodeList nList = doc.getElementsByTagName("bookmaker");
	
		System.out.println("-----------------------");
 
		for (int temp = 0; temp < nList.getLength(); temp++) {
 
		   Node nNode = nList.item(temp);
		   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
		      Element eElement = (Element) nNode;
		      
		      
		      
		      
		      System.out.println("bookmaker: " + (nList).item(0).getAttributes().getNamedItem("name").getNodeValue());
		      System.out.println("sport: " + ((NodeList) nNode).item(3).getAttributes().getNamedItem("name").getNodeValue());
		      System.out.println("categoria: " + ((NodeList) ((NodeList) nNode).item(3)).item(79).getAttributes().getNamedItem("name").getNodeValue());
		      System.out.println("-----------------------");
		      
		      System.out.println("partita: " + ((NodeList) ((NodeList) nNode).item(3)).item(79).getFirstChild().getAttributes().getNamedItem("name").getNodeValue() + "\n");
		      System.out.println("data: " + ((NodeList) ((NodeList) nNode).item(3)).item(79).getFirstChild().getAttributes().getNamedItem("date").getNodeValue() + "\n");
		      
		      //System.out.println("quotazioni: " + ((Node) ((NodeList) ((NodeList) ((NodeList) nNode).item(3)).item(79)).item(0).getChildNodes().item(3).getAttributes().getNamedItem("name")));
		      
		      
		      System.out.println("1: " + ((Node) ((NodeList) ((NodeList) ((NodeList) ((NodeList) nNode).item(3)).item(79)).item(0).getChildNodes().item(3)).item(0).getAttributes().getNamedItem("odds")));
		     String uno = ((Node) (NodeList) ((NodeList) ((NodeList) ((NodeList) nNode).item(3)).item(79)).item(0).getChildNodes().item(3)).item(0).getAttributes().getNamedItem("odds");
		      System.out.println("x: " + ((Node) ((NodeList) ((NodeList) ((NodeList) ((NodeList) nNode).item(3)).item(79)).item(0).getChildNodes().item(3)).item(1).getAttributes().getNamedItem("odds")));
		      System.out.println("2: " + ((Node) ((NodeList) ((NodeList) ((NodeList) ((NodeList) nNode).item(3)).item(79)).item(0).getChildNodes().item(3)).item(2).getAttributes().getNamedItem("odds")));
		      
		    

		     
		       
		   /*  System.out.println("Last Name : " + getTagValue("event", eElement));
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