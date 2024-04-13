package ru.kudukhov.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TransportCars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "category_id")
    private Long category;

    @Column(name = "registration_Number")
    private String registrationNumber;

    @Column(name = "vehicle_Type")
    private String vehicleType;

    @Column(name = "year_Of_Manufacture")
    private int yearOfManufacture;

    @Column(name = "has_Trailer")
    private boolean hasTrailer;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", hasTrailer=" + hasTrailer +
                '}';
    }
}