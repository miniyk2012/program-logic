package headfirst.designpatterns.proxy.virtualproxy;

import javax.swing.*;
import java.awt.*;

public class ImageNotLoaded implements ImageState {
    private ImageProxy imageProxy;
    Thread retrievalThread;
    boolean retrieving = false;

    public ImageNotLoaded(ImageProxy imageProxy) {
        this.imageProxy = imageProxy;
    }

    @Override
    public int getIconWidth() {
        return 800;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.drawString("Loading CD cover, please wait...", x + 300, y + 190);
        if (!retrieving) {
            retrieving = true;
            retrievalThread = new Thread(() -> {
                try {
                    imageProxy.setImageIcon(new ImageIcon(imageProxy.imageURL, "CD Cover"));
                    imageProxy.setState(imageProxy.getImageLoadedState());
                    c.repaint();  // 内部会调用ImageComponent.paintComponent方法, 它再调用Icon.paintIcon方法
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            retrievalThread.start();
        }
    }

    @Override
    public int getIconHeight() {
        return 600;
    }
}
