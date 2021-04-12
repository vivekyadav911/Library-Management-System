package images;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Utility {
	public static ImageIcon resizeImg(ImageIcon icon ,int width,int height) {
		
		Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(image);
	}

}