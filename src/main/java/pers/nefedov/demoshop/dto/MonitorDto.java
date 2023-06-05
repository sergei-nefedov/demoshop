package pers.nefedov.demoshop.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import pers.nefedov.demoshop.validators.NotebookSize;

@Data
public class MonitorDto {
    private long id;
    @Min(4)
    @Max(100)
    private int diagonalSize;
    @Positive
    private long serialNumber;
    @NotBlank
    @Size(min = 1, max = 255)
    private String manufacturer;
    @Positive
    private double price;
    @Min(1)
    private int quantity;
}
