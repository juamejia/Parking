import data.Parking
import data.ParkingSpace
import data.Vehicle
import java.util.*

class Main {

    companion object {
        val parking = Parking(mutableSetOf())

        @JvmStatic
        fun main(args: Array<String>) {
            showMenu()
        }

        private fun showMenu() {
            println("Welcome to AlkeParking \n select an option \n 1. Enter vehicle \n 2. Remove a vehicle \n 3. View plate list \n 4. See earnings")
            val option = readLine()?.toInt()
            println(option)

            when (option) {
                1 -> {
                    println("Add vehicle type: \n 1. CAR \n 2. BIKE \n 3. BUS \n 4. MINIBUS ")
                    val vehicleType = readLine()?.toInt()
                    println("Please enter your plate:")
                    val vehiclePlate = readLine()
                    println("If you have discount card, enter the code, otherwise press enter")
                    val discountCard = readLine()
                    addVehicle(vehicleType, vehiclePlate, discountCard)
                }
                2 -> {
                    println("If you want remove a vehicle enter your plate:")
                    val vehiclePlate = readLine()
                    removeVehicle(vehiclePlate)
                }
                3 -> parking.listVehicles(parking.vehicles)
                4 -> {
                    println("Your earnings are:")
                }
            }
        }

        private fun removeVehicle(vehiclePlate: String?) {
            val carToRemove = parking.vehicles.elementAt(1)
            val parkingSpace = ParkingSpace(carToRemove)
            parkingSpace.getVehiclesList(parking.vehicles)
            parking.listVehicles(parking.vehicles)
            carToRemove.plate?.let { parkingSpace.checkOutVehicle(it) }
        }

        private fun addVehicle(vehicleType: Int?, vehiclePlate: String?, discountCard: String?) {
            var vehicleTypeEnum: Vehicle.VehicleType = Vehicle.VehicleType.CAR
            when (vehicleType) {
                1 -> vehicleTypeEnum = Vehicle.VehicleType.CAR
                2 -> vehicleTypeEnum = Vehicle.VehicleType.BIKE
                3 -> vehicleTypeEnum = Vehicle.VehicleType.BUS
                4 -> vehicleTypeEnum = Vehicle.VehicleType.MINIBUS
            }
            val car = Vehicle(vehiclePlate, vehicleTypeEnum, Calendar.getInstance(), discountCard)
            when {
                parking.addVehicle(car) -> {
                    println("Welcome to AlkeParking!")
                }
                else -> {
                    println("Sorry, the check-in failed")
                }
            }
            println(parking.vehicles)
        }

    }


}