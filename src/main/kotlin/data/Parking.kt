package data

data class Parking(val vehicles: MutableSet<Vehicle>){

    private var parkingSize: Int = 20
    fun addVehicle( vehicle: Vehicle): Boolean{
        return if (vehicles.size <= parkingSize) {
            vehicles.add(vehicle)
            true
        }else false
    }
}