import data.Parking
import data.Vehicle
import java.util.*

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            /*
            val car = Vehicle("ABC-001", Vehicle.VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001" )
            val moto = Vehicle("ABC-002", Vehicle.VehicleType.BIKE, Calendar.getInstance(), null )
            val minibus = Vehicle("ABC-003", Vehicle.VehicleType.MINIBUS, Calendar.getInstance(), null )
            val bus = Vehicle ( "ABC-004", Vehicle.VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002" )
            val car2 = Vehicle( "ABC-001", Vehicle.VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_003")
            val parking = Parking(mutableSetOf(car, moto, minibus, bus))
            val isCar2Inserted = parking.vehicles.add(car2)
            println(isCar2Inserted)
            println(parking.vehicles.contains(car))
            println(parking.vehicles.contains(moto))
            println(parking.vehicles.contains(minibus))
            println(parking.vehicles.contains(bus))
            */
            val parking = Parking(mutableSetOf())
            for (i in 1..21){
                val car = Vehicle("ABC-00${i}", Vehicle.VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001" )
                parking.vehicles.add(car)
                when {
                    parking.addVehicle(car) -> {
                        println("Sorry, the check-in failed")
                    }
                    else -> {
                        println("Welcome to AlkeParking!")
                    }
                }

            }

        }
    }

}