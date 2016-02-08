package ua.org.oa.oatkachenko;

import ua.org.oa.oatkachenko.model.Shop;
import ua.org.oa.oatkachenko.parsers.XmlParsers;

/**
 * Created by Oleg on 01.02.2016.
 */
public class Main {
    private static final String PATH = "src/main/resources/";

    public static void main(String[] args) {


        Shop jaxbShop = XmlParsers.parseWithJaxB(PATH + "shop.xml");
        XmlParsers.writeWithJaxB(jaxbShop, PATH + "jaxBShop.xml");

        Shop domShop = XmlParsers.parseWithDom(PATH + "shop.xml");
        XmlParsers.writeWithDom(domShop, PATH + "domShop.xml");

        Shop saxShop = XmlParsers.parseWithSax(PATH + "shop.xml");

    }

}
