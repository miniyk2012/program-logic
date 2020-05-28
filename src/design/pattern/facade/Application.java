package design.pattern.facade;

import java.io.File;

public class Application {
    public static void main(String[] args) {
        VideoConverterFacade converter = new VideoConverterFacade();
        File mp4Video = converter.convert("youtubevideo.ogg", "mp4");
    }
}
