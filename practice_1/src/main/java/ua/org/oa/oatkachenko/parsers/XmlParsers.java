package ua.org.oa.oatkachenko.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.org.oa.oatkachenko.model.Category;
import ua.org.oa.oatkachenko.model.Goods;
import ua.org.oa.oatkachenko.model.Shop;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 01.02.2016.
 */
public class XmlParsers {

    public static void writeWithJaxB(Shop shop, String fileName) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(shop, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Shop parseWithJaxB(String fileName) {

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

    public static Shop parseWithDom(String fileName) {
        Shop shop = new Shop();

        try {
            List<Goods> goodsList = new ArrayList<>();
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("goods");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Goods goods = new Goods();
                    goods.setId(Integer.parseInt(eElement.getAttribute("id")));
                    goods.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    goods.setPrice(Float.parseFloat(eElement.getElementsByTagName("price").item(0).getTextContent()));
                    String category = eElement.getElementsByTagName("category").item(0).getTextContent();
                    goods.setCategory(resolveCategory(category));
                    goods.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());
                    goodsList.add(goods);
                }
                shop.setGoodsList(goodsList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shop;
    }

    public static void writeWithDom(Shop shop, String fileName) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("shop");
            doc.appendChild(rootElement);

            shop.getGoodsList().forEach(item -> {

                Element goods = doc.createElement("goods");
                goods.setAttribute("id", String.valueOf(item.getId()));

                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(item.getName()));
                goods.appendChild(name);

                Element price = doc.createElement("price");
                price.appendChild(doc.createTextNode(String.valueOf(item.getPrice())));
                goods.appendChild(price);

                Element category = doc.createElement("category");
                category.appendChild(doc.createTextNode(item.getCategory().name()));
                goods.appendChild(category);

                Element description = doc.createElement("description");
                description.appendChild(doc.createTextNode(String.valueOf(item.getDescription())));
                goods.appendChild(description);

                rootElement.appendChild(goods);
            });

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }

    public static Shop parseWithSax(String fileName) {

        try {
            SAXParserFactory parserFactor = SAXParserFactory.newInstance();
            SAXParser parser = parserFactor.newSAXParser();
            DefaultHandler handler = new SaxHandler();

            parser.parse(fileName, handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return SaxHandler.getShop();
    }

    public static Category resolveCategory(String cat) {
        Category category = null;
        switch (cat) {
            case "PC":
                category = Category.PC;
                break;
            case "LAPTOP":
                category = Category.LAPTOP;
                break;
        }
        return category;
    }
}