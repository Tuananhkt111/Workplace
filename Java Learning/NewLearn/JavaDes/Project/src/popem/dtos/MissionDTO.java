/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.dtos;

import java.io.Serializable;
import java.util.Vector;
import popem.daos.ItemDAO;

/**
 *
 * @author popem
 */
public class MissionDTO implements Serializable{
    String id,question, choice1, choice2, choice3, type,item,answer,name,rank;
    int points;

    public MissionDTO(String id, String question, String choice1, String choice2, String choice3, String Type, String Item, String Answer, int points) {
        this.id = id;
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.type = Type;
        this.item = Item;
        this.answer = Answer;
        this.points = points;
    }

    public MissionDTO(String id, String name, String rank, String item) {
        this.id = id;
        this.item = item;
        this.name = name;
        this.rank = rank;
    }
    
    public MissionDTO(String id, String question) {
        this.id = id;
        this.question = question;
    }

    public MissionDTO(String id, String question, String Type, String Item, String Answer, int points) {
        this.id = id;
        this.question = question;
        this.choice1 = "";
        this.choice2 = "";
        this.choice3 = "";
        this.type = "Written";
        this.item = Item;
        this.answer = Answer;
        this.points = points;
    }

    public MissionDTO(String id, String question, String choice1, String choice2, String choice3, String type, String item, String answer, String name, String rank, int points) {
        this.id = id;
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.type = type;
        this.item = item;
        this.answer = answer;
        this.name = name;
        this.rank = rank;
        this.points = points;
    }
    
    
    
    public MissionDTO() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    
    
    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getType() {
        return type;
    }

    public void setType(String Type) {
        this.type = Type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String Item) {
        this.item = Item;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String Answer) {
        this.answer = Answer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public Vector toVector() throws Exception {
        Vector v = new Vector();
        v.add(id);
        v.add(name);
        v.add(rank);
        ItemDTO dto = new ItemDAO().findByPrimaryKey(item);
        v.add(dto.getName());
        return v;
    }
    
}
