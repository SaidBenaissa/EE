package ua.org.oa.oatkachenko.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.org.oa.oatkachenko.model.Goods;
import ua.org.oa.oatkachenko.model.Shop;

import java.util.ArrayList;

/**
 * Created by Oleg on 01.02.2016.
 */
public class SaxHandler extends DefaultHandler {

    private static Shop shop;
    private Goods goods;
    private String content;

    public static Shop getShop() {
        return shop;
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("SHOP")) {
            shop = new Shop();
            shop.setGoodsList(new ArrayList<>());
        }
        if (qName.equalsIgnoreCase("GOODS")) {
            goods = new Goods();
            goods.setId(Integer.parseInt(attributes.getValue(0)));
        }

    }

    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        if (qName.equalsIgnoreCase("GOODS")) {
            shop.getGoodsList().add(goods);
        }
        if (qName.equalsIgnoreCase("NAME")) {
            goods.setName(content);
        }
        if (qName.equalsIgnoreCase("PRICE")) {
            goods.setPrice(Float.parseFloat(content));
        }
        if (qName.equalsIgnoreCase("CATEGORY")) {
            goods.setCategory(XmlParsers.resolveCategory(content));
        }
        if (qName.equalsIgnoreCase("DESCRIPTION")) {
            goods.setDescription(content);
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length);
    }
}
