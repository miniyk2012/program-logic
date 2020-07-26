package headfirst.designpatterns.proxy.virtualproxy;

import java.awt.*;

public class ImageLoaded implements ImageState {
    private ImageProxy imageProxy;

    public ImageLoaded(ImageProxy imageProxy) {
        this.imageProxy = imageProxy;
    }

    @Override
    public int getIconWidth() {
        return imageProxy.imageIcon.getIconWidth();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        imageProxy.imageIcon.paintIcon(c, g, x, y);
    }

    @Override
    public int getIconHeight() {
        return imageProxy.imageIcon.getIconHeight();
    }
}
