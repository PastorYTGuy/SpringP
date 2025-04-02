package org.example;

class RentalRepository extends JsonRepository<Rental> {
    public RentalRepository() { super("rentals.json"); }
}
