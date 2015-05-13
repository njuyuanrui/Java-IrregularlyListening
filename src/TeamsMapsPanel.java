import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TeamsMapsPanel extends JPanel implements MouseMotionListener {


	int width;
	int height;
	
	ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>(); // 原图片组件
	ArrayList<BufferedImage> imageList_highlight = new ArrayList<BufferedImage>(); // 高亮图片组件
	ArrayList<BufferedImage> imageToDraw = new ArrayList<BufferedImage>(); // 待绘图片组件

	int currentHighLight;    				//当前高亮的组件1~14，如果为0则表示没有高亮
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		for (BufferedImage each : imageToDraw) {
			g.drawImage(each, 0, 0, this);

		}
	}

	public TeamsMapsPanel(int width, int height) {

		this.setLayout(null);
		this.addMouseMotionListener(this);
		this.setBackground(Color.black);
		// 读取图片

		try {
			for (int i = 1; i <= 29; i++) {
				// 读取原始图片，并且存入待绘组件列表
				String path = "image" + File.separator + "z" + i + ".png";
				BufferedImage temp = ImageIO.read(new File(path));
				imageList.add(temp);
				imageToDraw.add(temp);

				// 读取高亮图片
				path = "image" + File.separator + "x" + i + ".png";
				imageList_highlight.add(ImageIO.read(new File(path)));
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO 自动生成的方法存根
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		int ix = e.getX();
		int iy = e.getY();
		int index = 0; // 储存匹配到的图片序号
		for (BufferedImage each : imageList) {
			index++;
			int[] arr = each.getData().getPixel(ix, iy, new int[4]);
			if (arr[3] != 0) {
				//首先恢复之前高亮的部分
				if(currentHighLight!=0){
					imageToDraw.set(currentHighLight-1, imageList.get(currentHighLight-1));
				}
				//修改当前高亮部分序号
				currentHighLight = index;
				imageToDraw.set(index - 1, imageList_highlight.get(index - 1));
				repaint();
				break;
			}
		}
		

	}
}