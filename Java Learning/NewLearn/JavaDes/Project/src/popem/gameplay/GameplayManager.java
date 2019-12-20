/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popem.gameplay;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import popem.daos.AccountDAO;
import popem.daos.CompletedMissionDAO;
import popem.daos.InventoryDAO;
import popem.daos.ItemDAO;
import popem.dtos.AccountDTO;
import popem.dtos.ClassDTO;
import popem.dtos.CompletedMissionDTO;
import popem.dtos.InventoryDTO;
import popem.dtos.ItemDTO;
import popem.dtos.MissionDTO;

/**
 *
 * @author popem
 */
public class GameplayManager  {
    private JTabbedPane tabbedPane;
    private JLabel lblHint;
    private ClassDTO classDTO;
    private MissionDTO missionDTO;
    private ItemDTO itemDTO;
    private JTextArea txtMissionQuestion;
    private JRadioButton choice1,choice2,choice3;
    private JTextField txtAnswer;
    private JProgressBar pbTemp,pbOverall;
    private JPanel playingPanel;
    private int baseTime = 12;
    private Timer tempTimer, overallTimer;
    private int points = 0;
    private String rewardItem = "", username;
    private boolean won = false;
    private float baseDropRate = 1.0f;

    public GameplayManager(JTabbedPane tabbedPane,JLabel lblHint ,String username, ClassDTO classDTO, MissionDTO missionDTO, ItemDTO itemDTO, JTextArea missionQuestion, JRadioButton choice1, JRadioButton choice2, JRadioButton choice3, JTextField Answer, JProgressBar pbTemp, JProgressBar pbOverall, JPanel playingPanel) {
        this.classDTO = classDTO;
        this.lblHint = lblHint;
        this.tabbedPane = tabbedPane;
        this.username = username;
        this.missionDTO = missionDTO;
        this.itemDTO = itemDTO;
        this.txtMissionQuestion = missionQuestion;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.txtAnswer = Answer;
        this.pbTemp = pbTemp;
        this.pbOverall = pbOverall;
        this.playingPanel = playingPanel;
        baseTime = (int) (baseTime*classDTO.getTimeModifier()
                *itemDTO.getTimeModifier());
        points = this.missionDTO.getPoints();
        

    }
    
    public void startMission() throws Exception {
        // IF completed rewards are low
        CompletedMissionDAO cmDAO = new CompletedMissionDAO();
        CompletedMissionDTO cmDTO = cmDAO.findByPrimaryKey(username, missionDTO.getId());
        if ((cmDTO = cmDAO.findByPrimaryKey(username, missionDTO.getId())) != null){
            baseTime *= 0.5f;
            points *= 0.1f;
            baseDropRate *= 0.4f; 
        }
        lblHint.setText(" ");
        tempTimer = TempTimer();
        overallTimer = OverallTimer();
        txtMissionQuestion.setText(missionDTO.getQuestion());
        if (missionDTO.getType().equals("Written")){
            choice1.setVisible(false);
            choice2.setVisible(false);
            choice3.setVisible(false);
            txtAnswer.setVisible(true);
        } else {
            choice1.setVisible(true);
            choice2.setVisible(true);
            choice3.setVisible(true);
            choice1.setText(missionDTO.getChoice1());
            choice2.setText(missionDTO.getChoice2());
            choice3.setText(missionDTO.getChoice3());
            txtAnswer.setVisible(false);
        }
        if (itemDTO.isQuestionModifier()) {
            if (missionDTO.getType().equals("Written")){
                lblHint.setText("Low Sercurity: The answer starts with "+missionDTO.getAnswer().charAt(0));
            } else {
                int choice;
                do {
                    choice = new Random().nextInt(3);
                } while (choice ==0 || missionDTO.getAnswer().equals(choice+""));
                lblHint.setText("Low Sercurity: choice "+choice+" is wrong!");
            }
        }
        tempTimer.start();
        overallTimer.start();
    }
    
    public void stopMission() throws Exception{
        tempTimer.stop();
        overallTimer.stop();
        ItemDTO reward = new ItemDAO().findByPrimaryKey(missionDTO.getItem());
        String answer = missionDTO.getAnswer();
        if (missionDTO.getType().equals("Written")){// if WRITTEN mission
            if (txtAnswer.getText().equals(answer)) {
                points = (int) ((float)pbOverall.getValue()/100*points*classDTO.getPointsModifier()*itemDTO.getPointModifier());
                JOptionPane.showMessageDialog(playingPanel, "Congrats! You won.\nFinal score: "+points);
                won = true;
                if (new Random().nextFloat() < baseDropRate*reward.getDropRate()){ // if rewards drop
                    rewardItem += reward.getId()+"-"+reward.getName();
                    JOptionPane.showMessageDialog(playingPanel, "Congrats! You get the following rewards:\n"+rewardItem);
                }
            } else JOptionPane.showMessageDialog(playingPanel, "You Lost! Better Luck next Time!");            
        } else { // if CHOICE mission
            if ((answer.equals("1")&& choice1.isSelected())||(answer.equals("2")&& choice2.isSelected())||(answer.equals("3")&& choice3.isSelected())){// if right
                points = (int) ((float)pbOverall.getValue()/100*points*classDTO.getPointsModifier()*itemDTO.getPointModifier());
                JOptionPane.showMessageDialog(playingPanel, "Congrats! You won.\nFinal score: "+points);
                won = true;
                if (new Random().nextFloat() < baseDropRate*reward.getDropRate()){ // if reward drops
                    rewardItem += missionDTO.getItem();
                    rewardItem += "-"+new ItemDAO().findByPrimaryKey(rewardItem).getName();
                    JOptionPane.showMessageDialog(playingPanel, "Congrats! You get the following rewards:\n"+rewardItem);
                }
            } else JOptionPane.showMessageDialog(playingPanel, "You Lost! Better Luck next Time!");
        }
        // update account info
        if (points!=0) { // update points and rank
            AccountDAO accountDAO = new AccountDAO();
            AccountDTO accountDTO = accountDAO.findByPrimaryKey(username);
            accountDTO.setPoints(accountDTO.getPoints()+points);
            accountDAO.updateAfterMission(accountDTO.getPoints()+points, username, accountDTO.getRank());
        }
        // update inventory
        if (!rewardItem.equals("")){ //update reward
            String itemID = rewardItem.split("-")[0];
            InventoryDAO inventoryDAO = new InventoryDAO();
            InventoryDTO inventoryDTO;
            if ((inventoryDTO=inventoryDAO.findByPrimaryKey(username, itemID))!=null){
                inventoryDTO.setQuantity(inventoryDTO.getQuantity()+1);
                inventoryDAO.update(inventoryDTO);
            } else {
                inventoryDTO = new InventoryDTO(username, itemID, 1);
                inventoryDAO.create(inventoryDTO);
            }
        }
        if (itemDTO.getId()!=null){// update used item
            String itemID = itemDTO.getId();
            InventoryDAO inventoryDAO = new InventoryDAO();
            InventoryDTO inventoryDTO;
            if ((inventoryDTO=inventoryDAO.findByPrimaryKey(username, itemID)).getQuantity() != 1){
                inventoryDTO.setQuantity(inventoryDTO.getQuantity()-1);
                inventoryDAO.update(inventoryDTO);
            } else {
                inventoryDAO.delete(username, itemID);
            }
        }
        if (won){ // update completed mission
            CompletedMissionDAO cmDAO = new CompletedMissionDAO();
            CompletedMissionDTO cmDTO = cmDAO.findByPrimaryKey(username, missionDTO.getId());
            if ((cmDTO = cmDAO.findByPrimaryKey(username, missionDTO.getId())) == null)
                cmDAO.create(username, missionDTO.getId(), points);
            else {
                if (cmDTO.getHighestScore() < points) 
                    cmDAO.update(username, missionDTO.getId(), points);
                
            }
        }
        tabbedPane.setEnabledAt(0, true);
        tabbedPane.setEnabledAt(1, false);
        tabbedPane.setSelectedIndex(0);
        tabbedPane.setEnabledAt(2, true);
        tabbedPane.setEnabledAt(3, true);
    }


    
    public Timer TempTimer(){
        return new Timer(50 , new ActionListener() {
            float temp = 100;
            @Override
            public void actionPerformed(ActionEvent ae) {
                temp = (float) (temp - 100.0/(baseTime/4*20));
                pbTemp.setValue((int)(temp));
                if ((int)temp==0) temp = 100;
            }
        });
    }
    
    public Timer OverallTimer() throws Exception{
        return new Timer(50 , new ActionListener() {
            float temp = 100;
            @Override
            public void actionPerformed(ActionEvent ae) {
                temp = (float) (temp - 100.0/(baseTime*20));
                pbOverall.setString((int)(temp/100*baseTime)+1+"s");
                pbOverall.setValue((int)(temp));
                if ((int)temp==99) pbOverall.setForeground(new Color(0, 120, 215));
                else if ((int)temp==75) pbOverall.setForeground(Color.green);
                else if ((int)temp==50) pbOverall.setForeground(Color.orange);
                else if ((int)temp==25) pbOverall.setForeground(Color.red);
                else if ((int)temp==0) 
                try {
                    stopMission();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(playingPanel, "Error stopping mission!");
                }
            }
        });
    }
    
}
