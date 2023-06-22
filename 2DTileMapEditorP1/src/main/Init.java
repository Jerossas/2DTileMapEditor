package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JFrame;
import panels.EditionPanel;
import panels.TileGridPanel;

/**
 *
 * @author Jeros
 */
public class Init extends JFrame {
    
    private EditionPanel editionPanel;
    private TileGridPanel tileGridPanel;
    private Dimension displaySize;
    
    public Init(){        
        configureGUI();
        loadPanels();
    }
    
    private void configureGUI(){
        
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        getDisplaySize();
        
        setLayout(null);
        setSize(displaySize);   
        setResizable(false);
        getContentPane().setBackground(Color.black);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void getDisplaySize(){
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        //displaySize = Toolkit.getDefaultToolkit().getScreenSize();
        displaySize = winSize.getSize();
    }
    
    private void loadPanels(){
        
        editionPanel = new EditionPanel(displaySize);
        editionPanel.setBounds((int)(5.5*displaySize.getWidth()/32), (int)(displaySize.getHeight()/16), editionPanel.getEditionPanelWidth(), editionPanel.getEditionPanelHeight());
        
        getContentPane().add(editionPanel);
        
        tileGridPanel = new TileGridPanel(editionPanel);
        int tgpw = (int)tileGridPanel.getPreferredSize().getWidth();
        int tgph = (int)tileGridPanel.getPreferredSize().getHeight();
        tileGridPanel.setBounds((int)(5.5*displaySize.getWidth()/32), editionPanel.getHeight()+(int)(displaySize.getHeight()/16) + 20, tgpw, tgph);
        
        getContentPane().add(tileGridPanel);
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new Init().setVisible(true);
        });
    }
}
