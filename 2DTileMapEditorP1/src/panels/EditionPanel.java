package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jeros
 */
public class EditionPanel extends JPanel {
    
    private static final int MAX_COL_NUM = 16;
    private static final int MAX_ROW_NUM = 9;
    private int tileSize;
    
    private boolean grid = true;
    private int editionPanelWidth;
    private int editionPanelHeight;
    
    private final Dimension displayDimension;
    
    public EditionPanel(Dimension displayDimension){
        this.displayDimension = displayDimension;
        configureEditionPanel();
    }
    
    private void configureEditionPanel(){
        
        // 1/16
        editionPanelWidth = (int)displayDimension.getWidth()/2;
        tileSize = (int)editionPanelWidth/MAX_COL_NUM;
        editionPanelHeight = MAX_ROW_NUM*tileSize;
        
        setLayout(new GridLayout(MAX_ROW_NUM, MAX_COL_NUM, 0, 0));
        setPreferredSize(new Dimension(editionPanelWidth, editionPanelHeight));
        setBackground(Color.red);
        
        loadDefaultTile();
    }
    
    private void loadDefaultTile(){
        for (int i = 0; i < MAX_COL_NUM; i++) {
            for (int j = 0; j < MAX_ROW_NUM; j++) {                
                try {
                    
                    JLabel tile = new JLabel(new ImageIcon(ImageIO.read(new File("./src/tiles/default_tile.png")).getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
                    if(isGridded())
                        tile.setBorder(BorderFactory.createLineBorder(Color.gray));
                    tile.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            super.mouseEntered(e);
                            tile.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            super.mouseExited(e);
                            if(isGridded())
                                tile.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                            else
                                tile.setBorder(null);
                        }
                    });
                    add(tile);
                } catch (IOException ex) {
                    System.out.println("No cargó la imagen. XD");
                }
            }
        }
    }    

    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public int getEditionPanelWidth() {
        return editionPanelWidth;
    }

    public void setEditionPanelWidth(int editionPanelWidth) {
        this.editionPanelWidth = editionPanelWidth;
    }

    public int getEditionPanelHeight() {
        return editionPanelHeight;
    }

    public void setEditionPanelHeight(int editionPanelHeight) {
        this.editionPanelHeight = editionPanelHeight;
    }

    public boolean isGridded() {
        return grid;
    }

    public void setGrid(boolean grid) {
        this.grid = grid;
    }
}
