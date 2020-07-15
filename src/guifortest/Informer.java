
package guifortest;

import frames.openFrame;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author clear_atom
 */

//this class is used for checking if all the necessary fields were filled with user inputs
//it also creates all these fields in empty file
public class Informer {
    String selectedFile;
    String simpleKeys [];
    String simpleValues [];
    String typesOfSimpleValues [];
    String doubleKeys [][];
    Object obj;

    public Informer(String selectedFile) {
        this.obj = null;
        this.selectedFile = selectedFile;
    }
    
    public void checkAll()throws Exception{
        this.obj = createJsonObj(); 
        if (obj == null){
            createBaseForJson();
            obj = createJsonObj();
        }
        
        checkSimpleArrKeys();
        checkSimpleValues();
        checkDoubleKeys();
    }
    
    //puts empty json object to a new file, otherwise there is a mistake "unexpected end of file"
    private void createBaseForJson(){
        JSONObject jo = new JSONObject();
            PrintWriter pw; 
            try {
                pw = new PrintWriter(selectedFile);
                pw.write(jo.toJSONString()); 

            pw.flush(); 
            pw.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(openFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private Object createJsonObj(){
        try {
            obj = new JSONParser().parse(new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), Charset.forName("UTF8"))));
        } catch (IOException | ParseException ex) {  
        }
        return obj;
    }
    
    private void writeToFile(JSONObject jo) throws Exception{
        PrintWriter pw = new PrintWriter(selectedFile); 
        pw.write(jo.toJSONString()); 
        pw.flush(); 
        pw.close();
    }
    
    private void checkSimpleArrKeys() throws Exception{
        
        JSONObject jo = (JSONObject) obj; 
        
        JSONArray ja;
        
        for (String sKey : simpleKeys){
            ja = (JSONArray) jo.get(sKey);
            if (ja == null){
                ja = new JSONArray ();
                jo.put(sKey, ja);
            }
        }
        
        writeToFile(jo);
    }
    
    private void checkSimpleValues() throws Exception{
        JSONObject jo = (JSONObject) obj; 
        
        for (int i = 0; i < simpleValues.length; i++){ 
            if (! jo.containsKey(simpleValues[i])){
                if ("bool".equals(typesOfSimpleValues[i]))
                    jo.put(simpleValues[i], "False");
                else
                    jo.put(simpleValues[i], 0);
            }
        }
        
        writeToFile(jo);
    }
    
    private void checkDoubleKeys() throws Exception{
        JSONObject jo = (JSONObject) obj; 
        JSONObject jo2;
        JSONArray ja;
        
        for (String[] doubleKey : doubleKeys) {
            jo2 = (JSONObject) jo.get(doubleKey[0]);
            if (jo2 == null){
                jo2 = new JSONObject ();
            }
            for (int j = 1; j < doubleKey.length; j++) {
                ja = (JSONArray) jo2.get(doubleKey[j]);
                if (ja == null) {
                    ja = new JSONArray();
                    jo2.put(doubleKey[j], ja);
                }
            }
            jo.put(doubleKey[0], jo2);  
        }
        
        writeToFile(jo);
    }

    public void setSimpleKeys(String[] simpleKeys) {
        this.simpleKeys = simpleKeys;
    }

    public void setSimpleValues(String[] simpleValues) {
        this.simpleValues = simpleValues;
    }

    public void setTypesOfSimpleValues(String[] typesOfSimpleValues) {
        this.typesOfSimpleValues = typesOfSimpleValues;
    }

    public void setDoubleKeys(String[][] doubleKeys) {
        this.doubleKeys = doubleKeys;
    }
    
    public boolean checkIfNoEmptyFields(){
        obj = createJsonObj();
        JSONObject jo = (JSONObject) obj; 
        
        JSONArray ja;
        
        for (String sKey : simpleKeys){
            ja = (JSONArray) jo.get(sKey);
            if (ja.isEmpty()){
                int answ = JOptionPane.showConfirmDialog(null, "Field " + sKey + " is Empty. Test is incomplete. \n Do you want to exit?");
                return answ == 0;
            }
        }
        
        JSONObject jo2;
        
        for (String[] doubleKey : doubleKeys) {
            jo2 = (JSONObject) jo.get(doubleKey[0]);
            for (int j = 1; j < doubleKey.length; j++) {
                ja = (JSONArray) jo2.get(doubleKey[j]);
                if (ja.isEmpty()) {
                    int answ = JOptionPane.showConfirmDialog(null, "Field " + doubleKey[0] + " " + doubleKey[j] + " is Empty. Test is incomplete. \n Do you want to exit?");
                    return answ == 0;
                }
            }
        }
        
        return true;
    }
}
