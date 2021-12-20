package data
import utils.Constants.MINUTES_IN_MILISECONDS
import java.util.*

data class ParkingSpace(var vehicle: Vehicle){

    private val checkInTime = Calendar.getInstance()
    val parkedTime : Long
    get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

    val discountCard: String? = null
}
