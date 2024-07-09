package ru.hardy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogLine {
    double x;
    double y;
    LocalDateTime registeredAt;
    int webDriverId;
}
