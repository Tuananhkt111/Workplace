/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author popem
 */
public class AccountDTO implements Serializable, Comparable<AccountDTO>{
    private String username, password, rank, role, characterClass, characterName;
    private int points;

    public AccountDTO(String username, String password, String rank, String role, String characterClass, int points) {
        this.username = username;
        this.password = password;
        this.rank = rank;
        this.role = role;
        this.characterClass = characterClass;
        this.points = points;
    }

    public AccountDTO(String username, String rank, String characterClass, String characterName, int points, String role) {
        this.username = username;
        this.rank = rank;
        this.characterClass = characterClass;
        this.characterName = characterName;
        this.points = points;
        this.role = role;
    }
    
    

    public AccountDTO(String characterName, String rank, String characterClass, String username) {
        this.username = username;
        this.rank = rank;        
        this.characterName = characterName;
        this.characterClass = characterClass;
    }    

    public AccountDTO(String username, String password, String rank, String role, String characterClass, String characterName, int points) {
        this.username = username;
        this.password = password;
        this.rank = rank;
        this.role = role;
        this.characterClass = characterClass;
        this.characterName = characterName;
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
        if (this.points > 1200) setRank("Veteran");
        else setRank("Rookie");
        if (this.points > 3000) setRank("Champion");
    }
    
    

    public Vector toVector(){
        Vector v = new Vector();
        v.add(characterName);
        v.add(rank);
        v.add(characterClass);
        v.add(username);
        return v;
    }
    
    public Vector toVectorLeaderboard(){
        Vector v = new Vector();
        v.add(1);
        v.add(characterName);
        v.add(rank);
        v.add(characterClass);
        v.add(points);
        v.add(username);
        return v;
    }

    @Override
    public int compareTo(AccountDTO t) {
        return this.getPoints() < t.getPoints() ? -1 : 1;
    }
    

}