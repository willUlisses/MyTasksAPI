package will.MyTasks.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record TaskCreateDTO(
        @NotBlank(message = "Title can't be null")
        String title,
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate deadline) {}
