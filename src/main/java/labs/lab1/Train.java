package labs.lab1;

import labs.lab4.TrainBuilder;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

/**
 * Клас, що представляє поїзд залізничного транспорту.
 */
public class Train {
    private String trainNumber;
    private int yearOfManufacture;
    private String lastRepairDate;
    private String driverFullName;

    public Train(TrainBuilder builder) {
        this.trainNumber = builder.trainNumber;
        this.yearOfManufacture = builder.yearOfManufacture;
        this.lastRepairDate = builder.lastRepairDate;
        this.driverFullName = builder.driverFullName;
    }


    public String getTrainNumber() {
        return trainNumber;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getLastRepairDate() {
        return lastRepairDate;
    }

    public String getDriverFullName() {
        return driverFullName;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber='" + trainNumber + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", lastRepairDate=" + lastRepairDate +
                ", driverFullName='" + driverFullName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;
        Train train = (Train) o;
        return yearOfManufacture == train.yearOfManufacture &&
                trainNumber.equals(train.trainNumber) &&
                lastRepairDate.equals(train.lastRepairDate) &&
                driverFullName.equals(train.driverFullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainNumber, yearOfManufacture, lastRepairDate, driverFullName);
    }

    public static Comparator<Train> YearOfManufactureComparator = new Comparator<Train>() {
        @Override
        public int compare(Train t1, Train t2) {
            return Integer.compare(t1.yearOfManufacture, t2.yearOfManufacture);
        }
    };
}