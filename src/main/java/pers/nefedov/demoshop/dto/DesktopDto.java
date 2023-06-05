package pers.nefedov.demoshop.dto;

import lombok.Data;
import pers.nefedov.demoshop.entities.FormFactor;
@Data
public class DesktopDto {
    private long id;
    private String formFactor;
    private long serialNumber;
    private String manufacturer;
    private double price;
    private int quantity;
}
