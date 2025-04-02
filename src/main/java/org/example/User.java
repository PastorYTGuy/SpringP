package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    private String login;
    private String passwordHash;
    private String role;
    private String rentedVehicleId;
}
