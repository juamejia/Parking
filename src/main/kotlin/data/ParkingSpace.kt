package data
import utils.Constants
import utils.Constants.MINUTES_IN_MILLISECONDS
import java.util.*

data class ParkingSpace(var vehicle: Vehicle) {

    private val checkInTime = Calendar.getInstance()
    val parkedTime : Long
    get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS

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

    fun calculateFee(): Int{
        var totalFee : Int = 0
        val parkedTime = 180000000
        val vehicleType = Vehicle.VehicleType.CAR.fee
        if(parkedTime <= Constants.TWO_HOURS_IN_MILLISECONDS){
            totalFee = Vehicle.VehicleType.CAR.fee
        }else {

        }

        return totalFee
    }

    private fun onSuccess(fee: Int){
        TODO("Make function onSuccess")
    }

    fun onError(){
       TODO("Make function OnError")
    }
}
