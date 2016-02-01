import model.Category;
import model.Goods;
import model.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 01.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        List<Goods> goodsList = new ArrayList<Goods>();

        Goods pc1 = new Goods();
        pc1.setId(1);
        pc1.setName("PC-1");
        pc1.setCategory(Category.PC);
        pc1.setPrice(199.99f);
        pc1.setDescription("The slowest PC ever");

        Goods pc2 = new Goods();
        pc2.setId(2);
        pc2.setName("PC-2");
        pc2.setCategory(Category.PC);
        pc2.setPrice(299.99f);
        pc2.setDescription("Almost the slowest PC ever");

        Goods laptop1 = new Goods();
        laptop1.setId(3);
        laptop1.setName("LAPTOP-1");
        laptop1.setCategory(Category.LAPTOP);
        laptop1.setPrice(388.99f);
        laptop1.setDescription("Laptop with extended graphics adepter");

        Goods laptop2 = new Goods();
        laptop2.setId(4);
        laptop2.setName("LAPTOP-2");
        laptop2.setCategory(Category.LAPTOP);
        laptop2.setPrice(498.99f);
        laptop2.setDescription("Laptop with Retina display");

        goodsList.add(pc1);
        goodsList.add(pc2);
        goodsList.add(laptop1);
        goodsList.add(laptop2);
        shop.setGoodsList(goodsList);

        XMLUtils utils = new XMLUtils();
//        utils.marshallJaxB(shop);
//        Shop shop1 = utils.unMarshallJaxB("testXml.xml");
//        System.out.println(shop1);
        utils.parseXmlWithDom("testXml.xml");

    }

}
