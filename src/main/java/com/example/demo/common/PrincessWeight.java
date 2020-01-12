package com.example.demo.common;

/**
 * *权重实体
 * 
 * @author sullivan
 *
 */
public class PrincessWeight {

    private String princess;
    private Integer weight;
    private Integer dynamicWeight;

    public String getPrincess() {
        return princess;
    }

    public void setPrincess(String princess) {
        this.princess = princess;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getDynamicWeight() {
        return dynamicWeight;
    }

    public void setDynamicWeight(Integer dynamicWeight) {
        this.dynamicWeight = dynamicWeight;
    }

    public PrincessWeight(String princess, Integer weight, Integer dynamicWeight) {
        super();
        this.princess = princess;
        this.weight = weight;
        this.dynamicWeight = dynamicWeight;
    }

}
