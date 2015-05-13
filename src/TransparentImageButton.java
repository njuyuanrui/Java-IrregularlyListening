import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TransparentImageButton extends JButton implements MouseListener,MouseMotionListener  {

    public BufferedImage image = null;
    private File imageFile;
    private ArrayList<ActionListener> listeners;

    public TransparentImageButton(/*File imageFile*/) throws IOException {
       // this.imageFile = imageFile;
       // this.image = ImageIO.read(imageFile);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.listeners = new ArrayList<ActionListener>();
       
    }

    public void addActionListener(ActionListener listener) {
        listeners.add(listener);
    }

  //  @Override
  /*  protected void paintComponent(Graphics g) { 
        super.paintComponent(g);
        Rectangle r = getImageBounds();
        g.drawImage(image, r.x, r.y, r.width, r.height, this);
    }*/


    private Rectangle getImageBounds() {
        // TODO Add in proper handling if component size < image size.
        return new Rectangle((int)((getBounds().width-image.getWidth())/2), (int)((getBounds().height-image.getHeight())/2), image.getWidth(), image.getHeight());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Add more action events?
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Rectangle bounds = getImageBounds();
        if(bounds.contains(e.getPoint())) {
            int ix = e.getX()-bounds.x;
            int iy = e.getY()-bounds.y;
            int [] arr = image.getData().getPixel(ix, iy, new int[4]);
            // get the alpha for the current pixel
            if(arr[3] != 0) {
                // not transparent
                ActionEvent newActionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, imageFile.getName(), e.getWhen(), e.getModifiers());
                for(ActionListener listener : listeners) {
                    listener.actionPerformed(newActionEvent);
                }
            }
        } else {
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Add more action events?
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    	
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Add more action events?
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(686, 678);
        frame.setLocationByPlatform(true);
        BufferedImage buImg = null;
        BufferedImage buImg1 = null;
        buImg = ImageIO.read(new File("C:\\Users\\NJUYuanRui\\Desktop\\q1.png"));
        buImg1 = ImageIO.read(new File("C:\\Users\\NJUYuanRui\\Desktop\\q2.png"));
        ImageIcon imMIcon = new ImageIcon(buImg);
        ImageIcon imMIcon1 = new ImageIcon(buImg1);
        
        TransparentImageButton btn = new TransparentImageButton();
        btn.setIcon(imMIcon);
        btn.image = buImg;
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicky!!");
            }
        });
        TransparentImageButton btn1 = new TransparentImageButton();
        btn1.setIcon(imMIcon1);
        btn1.image = buImg1;
        btn1.setContentAreaFilled(false);
        btn.setBorderPainted(false);
       
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("2");
            }
        });
        frame.getContentPane().setBackground(Color.black);
        
      
        frame.getContentPane().add(btn);
        frame.getContentPane().add(btn1);
       
        frame.setVisible(true);
    }

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Rectangle bounds = getImageBounds();
        if(bounds.contains(e.getPoint())) {
            int ix = e.getX()-bounds.x;
            int iy = e.getY()-bounds.y;
            int [] arr = image.getData().getPixel(ix, iy, new int[4]);
            // get the alpha for the current pixel
            if(arr[3] != 0) {
                // not transparent
                ActionEvent newActionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, imageFile.getName(), e.getWhen(), e.getModifiers());
                for(ActionListener listener : listeners) {
                    listener.actionPerformed(newActionEvent);
                }
            }
        } else {
        }
		
	}
    
    
    
} 
