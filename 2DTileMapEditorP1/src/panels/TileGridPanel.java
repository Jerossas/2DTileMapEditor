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
public class TileGridPanel extends JPanel {
    
    private static final int MAX_COL_NUM = 12;
    private static final int MAX_ROW_NUM = 5;
    private EditionPanel editionPanel;
    
    public TileGridPanel(EditionPanel editionPanel){
        this.editionPanel = editionPanel;
        
        setLayout(new GridLayout(MAX_ROW_NUM, MAX_COL_NUM));
        setPreferredSize(new Dimension(MAX_COL_NUM*editionPanel.getTileSize(), MAX_ROW_NUM*editionPanel.getTileSize()));
        loadDefaultTile();
    }
    
    private void loadDefaultTile(){
        for (int i = 0; i < MAX_COL_NUM; i++) {
            for (int j = 0; j < MAX_ROW_NUM; j++) {                
                try {
                    
                    JLabel tile = new JLabel(new ImageIcon(ImageIO.read(new File("./src/tiles/default_tile.png")).getScaledInstance(editionPanel.getTileSize(), editionPanel.getTileSize(), Image.SCALE_DEFAULT)));
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
                            tile.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                        }
                    });
                    add(tile);
                } catch (IOException ex) {
                    System.out.println("No cargó la imagen. XD");
                }
            }
        }
    }

    public EditionPanel getEditionPanel() {
        return editionPanel;
    }

    public void setEditionPanel(EditionPanel editionPanel) {
        this.editionPanel = editionPanel;
    }
}
