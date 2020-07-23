
package guifortest;

import frames.greetingFrame;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author clear_atom
 */
public class JSONWorker {
    
    String selectedFile;

    public JSONWorker(String selectedFile) {
        this.selectedFile = selectedFile;
    }
    
    //reads json file and fills swing list in one of the frames with values from the file
    public void fillList(String keyWord, String keyWord2, DefaultListModel<String> model) throws Exception {

        Object obj = new JSONParser().parse(new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), Charset.forName("UTF8")))); 
        
        JSONObject jo = (JSONObject) obj; 
        
        //if keyWord2 not empty than json object has another json array inside it
        JSONArray ja;
        if (!"".equals(keyWord2)){
           jo = (JSONObject) jo.get(keyWord);
           ja = (JSONArray) jo.get(keyWord2);
        }
        else
            ja = (JSONArray) jo.get(keyWord);
        
        //iterates json array and adds values to swing list 
        for (Iterator it = ja.iterator(); it.hasNext();) {
            String rawString = it.next().toString();
            model.addElement(rawString);
        }
    }
    
    //adds user input from one of the frames to json file and also to swing list
    public void addText(DefaultListModel<String> model,javax.swing.JTextField textField, 
            String keyWord, String keyWord2){
        String newText = textField.getText();
        Object obj = null;
        try {
            obj =
            new JSONParser().parse(new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), "UTF8")));
        }
        catch (ParseException | IOException ex) {
            Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (obj != null){
            JSONObject jo = (JSONObject) obj;
            JSONObject jo2 = null;
            JSONArray ja;
            if (!keyWord2.equals("")){
                jo2 = (JSONObject) jo.get(keyWord);
                ja = (JSONArray) jo2.get(keyWord2);
            }
            else
                ja =(JSONArray) jo.get(keyWord);
            byte[] bytes = newText.getBytes(StandardCharsets.UTF_8);
            String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
            ja.add(utf8EncodedString);
            model.addElement(utf8EncodedString);

            try {
                try (PrintWriter pw = new PrintWriter(selectedFile, "UTF8")) {
                    if (jo2 == null)
                        pw.write(jo.toJSONString());
                    else{
                        jo.put(keyWord, jo2);
                        pw.write(jo.toJSONString());
                    }

                    pw.flush();
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "The file couldn't be opened");
        }
        textField.setText("");
    }
    
    //deletes the element chosen by user from json file and from swing list
    public void deleteFromList(DefaultListModel<String> model, javax.swing.JList<String> list,
            String keyWord, String keyWord2) throws Exception{
        String value = list.getSelectedValue();
        if (value == null){
            JOptionPane.showMessageDialog(list, "Choose element to delete");
            return;
        }
        //we need to confirm that user really wants to delete the value
        int answ = JOptionPane.showConfirmDialog(list, "Are you sure you want to delete " + value);
        if (answ == 1 || answ == 2 || answ == -1)
            return;
        int index = model.indexOf(value);
        model.removeElement(value);
        Object obj = new JSONParser().parse(new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), Charset.forName("UTF8")))); 
        
        if (obj != null){
            JSONObject jo = (JSONObject) obj;
            JSONObject jo2 = null;
            JSONArray ja;
            if (!keyWord2.equals("")){
                jo2 = (JSONObject) jo.get(keyWord);
                ja = (JSONArray) jo2.get(keyWord2);
            }
            else
                ja =(JSONArray) jo.get(keyWord);
            
            ja.remove(index);

            try {
                try (PrintWriter pw = new PrintWriter(selectedFile, "UTF8")) {
                    if (jo2 == null)
                        pw.write(jo.toJSONString());
                    else{
                        jo.put(keyWord, jo2);
                        pw.write(jo.toJSONString());
                    }

                    pw.flush();
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //the same as fillList but for tables
    public void fillTable(javax.swing.table.DefaultTableModel model,
            String keyWord, String [] keyWords) throws Exception{
        Object[] row = new Object[keyWords.length]; //columns in one row in table
        
        Object obj = new JSONParser().parse(new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), Charset.forName("UTF8")))); 
        
        JSONObject jo = (JSONObject) obj; 
        
        JSONArray ja = (JSONArray) jo.get(keyWord);
        
        for (Iterator it = ja.iterator(); it.hasNext();) {
            JSONObject locJo = (JSONObject) it.next();
            int i = 0;
            for (String key:keyWords){
                String rawString = locJo.get(key).toString();
                row[i++] = rawString;
            }
            model.addRow(row);
        }
    }
    
    //the same as addText but for tables
    public void addObjectToTable(javax.swing.table.DefaultTableModel model,
            String keyWord, String [] keyWords, java.awt.TextField [] textFields){
        Object[] row = new Object[keyWords.length];
            
        for (int i = 0; i < keyWords.length; i++){
            row[i] = textFields[i].getText();
        }
            
        model.addRow(row);
                        
        Object obj = null;
        try {
            obj =
            new JSONParser().parse(new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), "UTF8")));
        }
        catch (ParseException | IOException ex) {
            Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (obj != null){
            JSONObject jo = (JSONObject) obj;
            JSONArray ja = (JSONArray) jo.get(keyWord);
            JSONObject locJo = new JSONObject();
            try {
                try (PrintWriter pw = new PrintWriter(selectedFile, "UTF8")) {
                    for (int i = 0; i<keyWords.length; i++){   
                        String key = keyWords[i];
                        if (key.equals("media") && !textFields[i].getText().equals("[]")){
                            String answers = textFields[i].getText(); 
                            String[] values = answers.split(",");
                            JSONArray locAr = new JSONArray();
                            for (String value : values){
                                locAr.add(value);
                            }
                            locJo.put(key, locAr);
                        }
                        else if (key.equals("answers")){
                            String answers = textFields[i].getText(); 
                            String[] values = answers.split(",");
                            Map m = new LinkedHashMap();
                            for (String value: values){
                                String keyVal[] = value.split(":");
                                if (keyVal.length == 1)
                                    m.put(keyVal[0], 0);
                                else
                                    m.put(keyVal[0], Integer.parseInt(keyVal[1]));
                            }
                            locJo.put(key, m); 
                        }
                        else
                            locJo.put(key, textFields[i].getText());
                    }
                    ja.add(locJo);
                    jo.put(keyWord, ja);
                    pw.write(jo.toJSONString());
                    pw.flush();
                    pw.close();
            } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "The file couldn't be opened");
        }
        for (java.awt.TextField field : textFields){
            field.setText("");
        }
    }
    
    public void deleteFromTable(javax.swing.table.DefaultTableModel model, javax.swing.JTable table,
            String keyWord, String keyWord2) throws Exception{
        int rowNum = table.getSelectedRow();
        
        if (rowNum == -1){
            JOptionPane.showMessageDialog(table, "Choose element to delete");
            return;
        }
        
        String value = (String) table.getValueAt(rowNum, 0);
        
        int answ = JOptionPane.showConfirmDialog(table, "Are you sure you want to delete " + model.getColumnName(0) + " " + value);
        if (answ == 1 || answ == 2 || answ == -1)
            return;

        model.removeRow(rowNum);
        Object obj = new JSONParser().parse(new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), Charset.forName("UTF8")))); 
        
        if (obj != null){
            JSONObject jo = (JSONObject) obj;
            JSONArray ja = (JSONArray) jo.get(keyWord);
            ja.remove(rowNum);

            try {
                try (PrintWriter pw = new PrintWriter(selectedFile, "UTF8")) {
                    pw.write(jo.toJSONString());
                    pw.flush();
                    pw.close();
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
