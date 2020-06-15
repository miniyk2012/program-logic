package headfirst.designpatterns.proxy.virtualproxy;

import java.awt.*;

public interface ImageState {
    int getIconWidth();
    void paintIcon(Component c, Graphics g, int x, int y);
    int getIconHeight();
}
