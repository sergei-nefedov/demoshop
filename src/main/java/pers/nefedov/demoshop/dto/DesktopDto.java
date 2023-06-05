package pers.nefedov.demoshop.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class DesktopDto {
    private long id;
    private String formFactor;
    @Min(0)
    private long serialNumber;
    @NotBlank
    @Size(min = 1, max = 255)
    private String manufacturer;
    @Min(1)
    private double price;
    @Min(1)
    private int quantity;
}
