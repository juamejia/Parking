import data.Parking
import data.ParkingSpace
import data.Vehicle
import java.util.*

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val parking = Parking(mutableSetOf())
            for (i in 1..21) {
                val car = Vehicle("ABC-00${i}", Vehicle.VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")

                when {
                    parking.addVehicle(car) -> {
                        println("Welcome to AlkeParking!")
                    }
                    else -> {
                        println("Sorry, the check-in failed")
                    }
                }
            }
            println(parking.vehicles)
            val carToRemove = parking.vehicles.elementAt(1)
            val parkingSpace = ParkingSpace(carToRemove)
            parkingSpace.getVehiclesList(parking.vehicles)
            parking.listVehicles(parking.vehicles)
            parkingSpace.checkOutVehicle(carToRemove.plate)
        }
    }
}