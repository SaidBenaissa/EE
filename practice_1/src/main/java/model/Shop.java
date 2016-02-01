package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Oleg on 01.02.2016.
 */
@XmlRootElement
public class Shop {
    @XmlElement(name = "goods")
    private List<Goods> goodsList;

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "goodsList=" + goodsList +
                '}';
    }
}
