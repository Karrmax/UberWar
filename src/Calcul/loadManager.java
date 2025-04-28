package Calcul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.Image;


public class loadManager {
    Map<String, BufferedImage> images = new HashMap<String, BufferedImage>();
    int size;
    public loadManager(int size) throws IOException {
        this.size = size;
        this.loadImages(size);
    }

    public void loadImages(int size) throws IOException {
        String[] imagesPaths = {
            "src\\Resources\\route.png",
            "src\\Resources\\cycliste.png",
            "src\\Resources\\herbe.png",
            "src\\Resources\\batiment.png",
            "src\\Resources\\depot.png"
        };
        
        String[] imagesNames = {"Route", "livreur", "Herbe", "Batiment", "depot"};
    
        // System.out.println(new File(imagesPaths[0]));
    
        for (int i = 0; i < imagesPaths.length; i++) {
            BufferedImage originalImage = ImageIO.read(new File(imagesPaths[i]));
    
            // Resize the image
            Image tmp = originalImage.getScaledInstance(size, size, Image.SCALE_SMOOTH);
            BufferedImage resized = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
    
            Graphics2D g2d = resized.createGraphics();
            g2d.drawImage(tmp, 0, 0, null);
            g2d.dispose();
    
            images.put(imagesNames[i], resized);
            System.out.println(imagesNames[i] + " chargé");
        }
    }
}


