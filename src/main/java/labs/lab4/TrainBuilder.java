package labs.lab4;

import labs.lab1.Train;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Статичний клас Builder для створення об'єктів типу Train з валідацією полів.
 */
public class TrainBuilder {
    public String trainNumber; // Поля повинні бути приватними
    public int yearOfManufacture;
    public String lastRepairDate;
    public String driverFullName;

    public TrainBuilder setTrainNumber(String trainNumber) {
        if (trainNumber == null || trainNumber.isEmpty()) {
            throw new IllegalArgumentException("Invalid train number: cannot be null or empty.");
        }
        if (!trainNumber.matches("^[A-Z]{1,2}\\d{1,4}$")) { // Формат "T123" або "AB1234"
            throw new IllegalArgumentException("Invalid train number: must match pattern [A-Z]{1,2}\\d{1,4}.");
        }
        this.trainNumber = trainNumber;
        return this;
    }

    public TrainBuilder setYearOfManufacture(int yearOfManufacture) {
        if (yearOfManufacture < 1900 || yearOfManufacture > 2025) {
            throw new IllegalArgumentException("Invalid year of manufacture: must be between 1900 and the current year.");
        }
        this.yearOfManufacture = yearOfManufacture;
        return this;
    }

    public TrainBuilder setLastRepairDate(String lastRepairDate) {
        if (lastRepairDate == null || lastRepairDate.isEmpty()) {
            throw new IllegalArgumentException("Invalid last repair date: cannot be null or in the future.");
        }
        this.lastRepairDate = lastRepairDate;
        return this;
    }

    public TrainBuilder setDriverFullName(String driverFullName) {
        if (driverFullName == null || driverFullName.isEmpty()) {
            throw new IllegalArgumentException("Invalid driver full name: cannot be null or empty.");
        }
        // Регулярний вираз для перевірки формату імені водія
        if (!driverFullName.matches("^[A-Z][a-z]+\\s[A-Z][a-z]+$")) { // Формат "John Doe"
            throw new IllegalArgumentException("Invalid driver full name: must match pattern 'First Last'.");
        }
        this.driverFullName = driverFullName;
        return this;
    }

    public Train build() {
        List<String> invalidFields = new ArrayList<>();

        if (trainNumber == null || trainNumber.isEmpty()) {
            invalidFields.add("train number");
        } else if (!trainNumber.matches("^[A-Z]{1,2}\\d{1,4}$")) {
            invalidFields.add("train number");
        }

        if (yearOfManufacture < 1900 || yearOfManufacture > 2025) {
            invalidFields.add("year of manufacture");
        }

        if (lastRepairDate == null || lastRepairDate.isEmpty()) {
            invalidFields.add("last repair date");
        }

        if (driverFullName == null || driverFullName.isEmpty()) {
            invalidFields.add("driver full name");
        } else if (!driverFullName.matches("^[A-Z][a-z]+\\s[A-Z][a-z]+$")) {
            invalidFields.add("driver full name");
        }

        if (!invalidFields.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + invalidFields);
        }

        return new Train(this); // Переконайтеся, що у класі Train є відповідний конструктор
    }
}