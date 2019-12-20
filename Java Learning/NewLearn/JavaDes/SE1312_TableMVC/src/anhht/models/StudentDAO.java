/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.models;

import anhht.dtos.StudentDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author tuana
 */
public class StudentDAO implements Serializable{

    public StudentDAO() {
    }
    
    public List<StudentDTO> loadData(String fileName) {
        List<StudentDTO> result = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            File f =new File(fileName);
            fr = new FileReader(f);
            br = new BufferedReader(br);
            result = new ArrayList<>();
            String rowData;
            while((rowData = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(rowData, ";");
                String id = stk.nextToken();
                String name = stk.nextToken();
                String gender = stk.nextToken();
                float mark = Float.parseFloat(stk.nextToken());
                StudentDTO dto = new StudentDTO(id, name, gender, mark);
                result.add(dto);
            }
        } catch (Exception e) {
            
        } finally {
            try {
                if(br != null)
                    br.close();
                if(fr != null)
                    fr.close();
            } catch (Exception e) {
                
            }
        }
        return result;
    }
}
