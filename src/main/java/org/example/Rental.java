package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Rental {
    private String userId;
    private String vehicleId;
    private Date rentalDate;
}
