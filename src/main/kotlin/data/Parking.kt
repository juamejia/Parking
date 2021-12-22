package data

data class Parking(val vehicles: MutableSet<Vehicle>) {

    val totalEarnings : Pair<Int, Int> get() = Pair(0, 0)

    private var parkingSize: Int = 20
    fun addVehicle(vehicle: Vehicle): Boolean {
        return if (vehicles.size <= parkingSize) {
            vehicles.add(vehicle)
            true
        } else false
    }

    fun listVehicles(vehicles: MutableSet<Vehicle>){
        println("This is the complete vehicle list on AlkeParking")
        for(i in vehicles.indices){
            println(vehicles.elementAt(i).plate)
        }
    }
}