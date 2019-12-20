/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.dtos;

import java.io.Serializable;

/**
 *
 * @author popem
 */
public class ItemDTO implements Serializable{
    private String id,description,name;
    private float dropRate, timeModifier, pointModifier;
    private boolean questionModifier;

    public ItemDTO(String name, String description, float dropRate) {
        this.name = name;
        this.description = description;
        this.dropRate = dropRate;
    }

    public ItemDTO(String id,String name, String description, float dropRate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dropRate = dropRate;
    }

    public ItemDTO() {
        this.dropRate = 0;
        this.timeModifier = 1;
        this.pointModifier = 1;
        this.questionModifier = false;
    }
    
    

    public ItemDTO(String id, float dropRate, float timeModifier, float PointsModifier, boolean questionModifier) {
        this.id = id;
        this.dropRate = dropRate;
        this.timeModifier = timeModifier;
        this.pointModifier = PointsModifier;
        this.questionModifier = questionModifier;
    }

    public float getTimeModifier() {
        return timeModifier;
    }

    public float getPointModifier() {
        return pointModifier;
    }

    public boolean isQuestionModifier() {
        return questionModifier;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDropRate() {
        return dropRate;
    }

    public void setDropRate(float dropRate) {
        this.dropRate = dropRate;
    }

    
    @Override
    public String toString() {
        return id+"-"+name;
    }
    public String toStringDes() {
        return this.description+"\nDroprate: "+dropRate*100+"%";
    }
    
}
