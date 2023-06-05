package pers.nefedov.demoshop.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import pers.nefedov.demoshop.validators.NotebookSize;

@Data
public class NotebookDto {
    private long id;
    @NotebookSize
    private int size;
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
