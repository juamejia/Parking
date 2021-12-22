package data

import utils.Constants
import utils.Constants.MINUTES_IN_MILLISECONDS
import java.util.*
import kotlin.math.roundToInt

data class ParkingSpace(var vehicle: Vehicle) {

    private val checkInTime = Calendar.getInstance()
    private val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS
    var count = 0
    val discountCard: String? = null
    var vehiclesList: MutableSet<Vehicle> = mutableSetOf()
    private var totalEarnings: Pair<Int, Int> = Pair(0, 0)

    fun getVehiclesList(vehicles: MutableSet<Vehicle>) {
        vehiclesList = vehicles
    }

    var backFee = 0
    fun checkOutVehicle(plate: String) {
        if (vehiclesList.elementAt(1).plate?.contains(plate) == true) {
            count++
            val fee = calculateFee(parkedTime, vehiclesList.elementAt(3), true)
            val totalEarnings = onSuccess(fee, vehiclesList.elementAt(3), backFee, count)
        } else {
            onError()
        }
    }

    private fun calculateFee(time: Long, vehicle: Vehicle, hasDiscountCard: Boolean): Int {
        var totalFee: Int = 0
        val parkedTime = 12600000 // 3 horas
        val vehicleType = Vehicle.VehicleType.CAR.fee
        var surplusTime: Int = 0
        var surplusMinutes: Int = 0
        if (parkedTime <= Constants.TWO_HOURS_IN_MILLISECONDS) {
            totalFee = Vehicle.VehicleType.CAR.fee
        } else {
            while (parkedTime > Constants.TWO_HOURS_IN_MILLISECONDS) {
                surplusTime = parkedTime - Constants.TWO_HOURS_IN_MILLISECONDS
                break
            }
            for (i in 0..surplusTime step Constants.FIFTEEN_IN_MILLISECONDS) {
                surplusMinutes++
            }
            totalFee = Vehicle.VehicleType.CAR.fee + (surplusMinutes * 5)
        }

        if (hasDiscountCard) {
            val discount = (totalFee * 0.15).roundToInt()
            totalFee -= discount
        }
        return totalFee
    }

    private fun onSuccess(fee: Int, vehicle: Vehicle, backFee: Int, countVehicles: Int) : Pair<Int, Int> {
        println("Your fee is $fee. Come back soon.")
        vehiclesList.remove(vehicle)
        totalEarnings = totalEarnings.copy(countVehicles, fee + backFee)
        this.backFee = fee
        return totalEarnings
    }

    fun onError() {
        println("Sorry, the check-out failed")
    }
}
