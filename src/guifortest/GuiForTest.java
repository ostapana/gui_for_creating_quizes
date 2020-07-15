
package guifortest;

import frames.openFrame;

/**
 *
 * @author clear_atom
 */
public class GuiForTest {
    
    public void run(){
        
        //start the main frame with all logic
        openFrame oFrame = new openFrame();
        oFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiForTest().run();
        
    }
    
}
