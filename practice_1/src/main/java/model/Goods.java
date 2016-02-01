package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleg on 01.02.2016.
 */
@XmlRootElement
public class Goods {
    @XmlElement
    private int id;

    @XmlElement
    private String name;

    @XmlElement
    private float price;

    @XmlElement
    private Category category;

    @XmlElement
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}
