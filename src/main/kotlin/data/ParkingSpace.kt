package data
import utils.Constants.MINUTES_IN_MILISECONDS
import java.util.*

data class ParkingSpace(var vehicle: Vehicle) {

    private val checkInTime = Calendar.getInstance()
    val parkedTime : Long
    get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

    val discountCard: String? = null
    var vehiclesList: MutableSet<Vehicle> = mutableSetOf()

    fun getVehiclesList(vehicles: MutableSet<Vehicle>){
        vehiclesList = vehicles
    }

    fun checkOutVehicle(plate: String){
        if (vehiclesList.elementAt(3).plate.contains(plate)){
            onSuccess(20)
        }else{
            onError()
        }
    }

    private fun onSuccess(fee: Int){
        TODO("Make function onSuccess")
    }

    fun onError(){
       TODO("Make function OnError")
    }
}
