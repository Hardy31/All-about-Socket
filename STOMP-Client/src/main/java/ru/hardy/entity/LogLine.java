package ru.hardy.entity;


//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//
//@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "log_line")
public class LogLine {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    double x;
    double y;
    LocalDateTime registeredAt;
    int webDriverId;



}
