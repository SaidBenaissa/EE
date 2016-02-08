package ua.org.oa.oatkachenko.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Oleg on 01.02.2016.
 */
@XmlRootElement
public class Shop {
    private List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    @XmlElement(name = "goods")
    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "goodsList=" + goodsList +
                '}';
    }
}
