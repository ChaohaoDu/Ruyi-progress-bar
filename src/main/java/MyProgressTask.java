import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;

public class MyProgressTask {
    public static void runTask(Project project) {
        ProgressManager.getInstance().run(new Task.Backgroundable(project, "My Progress Task", false) {
            @Override
            public void run(ProgressIndicator indicator) {
                // Indeterminate progress phase for 5 seconds
                indicator.setIndeterminate(true);
                indicator.setText("Preparing the task...");

                try {
                    Thread.sleep(5000); // Simulate the 5 seconds indeterminate progress
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return; // Exit if interrupted
                }

                // Determinate progress phase
                indicator.setIndeterminate(false); // Switch to determinate mode

                for (int i = 0; i < 100; i++) {
                    if (indicator.isCanceled()) {
                        break;
                    }

                    // Simulate work and update progress
                    indicator.setFraction(i / 100.0);
                    indicator.setText("Processing item " + i);

                    try {
                        Thread.sleep(100); // Simulate time-consuming task
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }

                indicator.setText("Task complete!");
            }
        });
    }
}
