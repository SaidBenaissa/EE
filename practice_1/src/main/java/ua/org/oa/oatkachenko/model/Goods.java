package ua.org.oa.oatkachenko.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleg on 01.02.2016.
 */
@XmlRootElement
public class Goods {
    private int id;

    private String name;

    private float price;

    private Category category;

    private String description;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    @XmlElement
    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
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
