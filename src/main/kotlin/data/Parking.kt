package data

data class Parking(val vehicles: MutableSet<Vehicle>){
    private var parkingSize: Int = 20
    fun addVehicle( vehicle: Vehicle): Boolean{

        return vehicles.size >= parkingSize
    }
}