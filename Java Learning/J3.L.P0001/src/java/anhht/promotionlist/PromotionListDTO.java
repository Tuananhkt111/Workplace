/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.promotionlist;

import anhht.prolistdetails.ProListDetailsDTO;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author tuana
 */
public class PromotionListDTO implements Serializable {

    private final HashMap<String, ProListDetailsDTO> list;

    public HashMap<String, ProListDetailsDTO> getList() {
        return list;
    }

    public PromotionListDTO() {
        this.list = new HashMap<>();
    }

    public boolean addProList(ProListDetailsDTO dto) {
        boolean check = false;
        if (!this.list.containsKey(dto.getUserID())) {
            this.list.put(dto.getUserID(), dto);
            check = true;
        }
        return check;
    }

    public void removeProList(String userID) {
        if (this.list.containsKey(userID)) {
            this.list.remove(userID);
        }
    }

    public boolean updateProList(String userID, float mark) {
        boolean check = false;
        if (this.list.containsKey(userID)) {
            this.list.get(userID).setRank(mark);
        }
        return check;
    }
}
