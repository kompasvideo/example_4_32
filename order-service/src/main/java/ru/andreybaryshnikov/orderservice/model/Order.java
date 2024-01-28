package ru.andreybaryshnikov.orderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import jakarta.persistence.*;

import java.util.UUID;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;
    private String xRequestId;
    private long userId;
    private String productId;
    private int count;
    private double price;
    private PaymentMethod paymentMethod; // метод оплаты
    private String dateTime; // время доставки

    private String locality; // город
    private String street;   // улица
    private String houseNumber; // номер дома
    private String structure; // корпус/строение
    private short flat;     // квартира
    private byte entrance; // подъезд
    private byte floor;    // этаж
    private String comment;  // комментарий

    public double calculatePayMoney() {
        return count * price;
    }
}
