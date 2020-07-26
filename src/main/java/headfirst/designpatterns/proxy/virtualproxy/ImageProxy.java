package headfirst.designpatterns.proxy.virtualproxy;

import java.net.*;
import java.awt.*;
import javax.swing.*;

public class ImageProxy implements Icon {
    final URL imageURL;
    volatile ImageIcon imageIcon;
    ImageState state;
    ImageState imageNotLoaded;
    ImageState imageLoaded;

    public ImageProxy(URL url) {
        imageURL = url;
        imageNotLoaded = new ImageNotLoaded(this);
        imageLoaded = new ImageLoaded(this);
        state = imageNotLoaded;
    }

    void setState(ImageState state) {
        this.state = state;
    }

    public ImageState getImageNotLoadedState() {
        return imageNotLoaded;
    }
    public ImageState getImageLoadedState() {
        return imageLoaded;
    }
    public ImageState getState() {
        return state;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        getState().paintIcon(c, g, x, y);
    }

    synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    @Override
    public int getIconWidth() {
        return getState().getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return getState().getIconHeight();
    }
}
