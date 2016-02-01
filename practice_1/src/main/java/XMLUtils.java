import model.Shop;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Oleg on 01.02.2016.
 */
public class XMLUtils {

    public void marshallJaxB(Shop shop) {
        try {
            File file = new File("testXml.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(shop, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Shop unMarshallJaxB(String fileName) {

        Shop shop = null;
        File file = new File(fileName);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            shop = (Shop) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return shop;
    }

    public void parseXmlWithDom(String fileName){
        try {

            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("staff");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Staff id : " + eElement.getAttribute("id"));
                    System.out.println("First Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Last Name : " + eElement.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println("Nick Name : " + eElement.getElementsByTagName("category").item(0).getTextContent());
                    System.out.println("Salary : " + eElement.getElementsByTagName("description").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}