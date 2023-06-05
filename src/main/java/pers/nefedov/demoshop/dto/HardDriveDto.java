package pers.nefedov.demoshop.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class HardDriveDto {
    private long id;
    @Positive
    private int capacity;
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
