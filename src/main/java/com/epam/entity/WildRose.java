package com.epam.entity;

import com.epam.entity.enums.Color;
import com.epam.entity.enums.Multiplying;
import com.epam.entity.enums.Soil;
import com.epam.entity.enums.WildRoseSort;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wild_rose", namespace = "http://www.epam.com/flowers")
@XmlType(name = "Wild_rose", propOrder = {
        "fruitForm"
})
public class WildRose extends Rose {

    @XmlElement(name = "fruit_Form", required = true)
    private String fruitForm;
    @XmlAttribute(name = "wild_rose_sort")
    private WildRoseSort wildRoseSort;

    public WildRose(String id, WildRoseSort wildRoseSort, String name, Soil soil, Color color, String growingTips, Multiplying multiplying,
                    String blossomTime, int petalQuantity, String budType, String fruitForm ) {
        super(id, name, soil, color, growingTips, multiplying, blossomTime, petalQuantity, budType);
        this.fruitForm = fruitForm;
        this.wildRoseSort = wildRoseSort;
    }

    public WildRose() {
    }

    public WildRoseSort getWildRoseSort() {

        if(wildRoseSort == null){
            return WildRoseSort.RUGOSA;
        }else {
            return wildRoseSort;
        }
    }

    public void setWildRoseSort(WildRoseSort wildRoseSort) {
        if (wildRoseSort == null) {
            this.wildRoseSort = WildRoseSort.RUGOSA;
        } else {
            this.wildRoseSort = wildRoseSort;
        }
    }

    public String getFruitForm() {
        return fruitForm;
    }

    public void setFruitForm(String fruitForm) {
        this.fruitForm = fruitForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WildRose)) {
            return false;
        }
        if(!super.equals(o)){
            return false;
        }
        WildRose wildRose = (WildRose) o;
        if (wildRose.fruitForm == null || wildRose.wildRoseSort == null) {
            return false;
        }
        return getWildRoseSort() == wildRose.getWildRoseSort() &&
                getFruitForm().equals(wildRose.getFruitForm());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + fruitForm.hashCode();
        result = prime * result + wildRoseSort.hashCode();

        return result;
    }
}
