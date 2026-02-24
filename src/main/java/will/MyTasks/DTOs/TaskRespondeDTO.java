package will.MyTasks.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import will.MyTasks.Models.TaskStatus;
import will.MyTasks.Models.Tasks;

import java.time.LocalDate;

public record TaskRespondeDTO(
        Long id,
        String title,
        String description,
        TaskStatus status,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate deadline
) {

    public TaskRespondeDTO(Tasks task) {
        this(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDeadline());
    }
}
