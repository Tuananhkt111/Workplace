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
public class ClassDTO implements Serializable{
    private String name, description;
    private float pointsModifier, timeModifier;
    private boolean questionModifier;

    public ClassDTO() {
    }

    public ClassDTO(String name, String description, float pointsModifier, float timeModifier, boolean questionModifier) {
        this.name = name;
        this.description = description;
        this.pointsModifier = pointsModifier;
        this.timeModifier = timeModifier;
        this.questionModifier = questionModifier;
    }

    public ClassDTO(float pointsModifier, float timeModifier, boolean questionModifier) {
        this.pointsModifier = pointsModifier;
        this.timeModifier = timeModifier;
        this.questionModifier = questionModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPointsModifier() {
        return pointsModifier;
    }

    public void setPointsModifier(float pointsModifier) {
        this.pointsModifier = pointsModifier;
    }

    public float getTimeModifier() {
        return timeModifier;
    }

    public void setTimeModifier(float timeModifier) {
        this.timeModifier = timeModifier;
    }

    public boolean isQuestionModifier() {
        return questionModifier;
    }

    public void setQuestionModifier(boolean questionModifier) {
        this.questionModifier = questionModifier;
    }



}