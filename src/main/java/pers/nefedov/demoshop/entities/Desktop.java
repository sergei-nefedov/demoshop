package pers.nefedov.demoshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
@Getter
@Setter
@Entity
public class Desktop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;
    private FormFactor formFactor;
    private long serialNumber;
    private String manufacturer;
    private double price;
    private int quantity;

    public Desktop() {
    }
}
