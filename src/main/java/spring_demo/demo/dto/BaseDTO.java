package spring_demo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {

    private LocalDateTime createDataTime;

    private LocalDateTime updatedTime;

}
