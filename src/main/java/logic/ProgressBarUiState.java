package logic;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import icons.Backgrounds;
import icons.Icon;
import org.jetbrains.annotations.NotNull;

@State(
        name = "org.intellij.sdk.logic.YoProgressBarUiState",
        storages = {@Storage("YoProgressBarUiState.xml")}
)
public class ProgressBarUiState implements PersistentStateComponent<ProgressBarUiState> {
    private String currentIconPath = Icon.getMarioPath();
    private String currentBackgroundPath = Backgrounds.getWallBackgroundPath();

    public String getCurrentIconPath() {
        return currentIconPath;
    }

    public String getCurrentBackgroundPath() {
        return currentBackgroundPath;
    }

    @Override
    public ProgressBarUiState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ProgressBarUiState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public static ProgressBarUiState getInstance() {
        return ServiceManager.getService(ProgressBarUiState.class);
    }
}
