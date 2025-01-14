package icons;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.net.URL;

public class Icon {
    private static final String MARIO_PATH = "/Gifs/avatar.png";

    private Icon() {throw new IllegalStateException("Utility class"); }


    public static String getMarioPath() {
        return MARIO_PATH;
    }

    @NotNull
    @Contract("_ -> new")
    public static ImageIcon loadIcon(URL url) {
        return new ImageIcon(url);
    }
}
