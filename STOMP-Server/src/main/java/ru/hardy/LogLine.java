package ru.hardy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class LogLine {


    double x;
    double y;
    LocalDateTime registeredAt;
    int webDriverId;

}
