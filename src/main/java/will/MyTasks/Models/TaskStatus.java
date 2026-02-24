package will.MyTasks.Models;

import lombok.Getter;

@Getter
public enum TaskStatus {
    INCOMPLETE("Incompleto"),
    COMPLETE("Completo");

    private final String value;
    TaskStatus(String value) {
        this.value = value;
    }
}
