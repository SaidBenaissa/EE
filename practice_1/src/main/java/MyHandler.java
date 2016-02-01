import model.Goods;
import model.Shop;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by Oleg on 01.02.2016.
 */
public class MyHandler extends DefaultHandler {

    private Shop shop;
    private Goods goods;
    private String content;


    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

//        if (qName.equalsIgnoreCase("SHOP")) {
//            Shop shop = new Shop();
//            shop.setGoodsList(new ArrayList<>());
//        }
//        if (qName.equalsIgnoreCase("GOODS")) {
//            System.out.println("id : " + attributes.getValue("id"));
//        }
//        if (qName.equalsIgnoreCase("NAME")) {
//            eName = true;
//        }
//        if (qName.equalsIgnoreCase("PRICE")) {
//            ePrice = true;
//        }
//        if (qName.equalsIgnoreCase("CATEGORY")) {
//            eCategory = true;
//        }
//        if (qName.equalsIgnoreCase("DESCRIPTION")) {
//            eDescription = true;
//        }
    }

    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        if (qName.equalsIgnoreCase("SHOP")) {

        }
        if (qName.equalsIgnoreCase("GOODS")) {
            shop.getGoodsList().add(goods);
        }
        if (qName.equalsIgnoreCase("NAME")) {
            goods.setName(content);
        }
        if (qName.equalsIgnoreCase("PRICE")) {
            goods.setPrice(Float.parseFloat(content));
        }
//        if (qName.equalsIgnoreCase("CATEGORY")) {
//            eCategory = true;
//        }
//        if (qName.equalsIgnoreCase("DESCRIPTION")) {
//            eDescription = true;
//        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length);
    }

}
