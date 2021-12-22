package data

import utils.Constants
import utils.Singleton
import java.util.*
import kotlin.math.roundToInt

data class ParkingSpace(var vehicle: Vehicle?) {

    private val checkInTime = Calendar.getInstance()
    private val parkedTime: Long = 0
    private var count: Long = Singleton.count
    var vehiclesList: MutableSet<Vehicle> = mutableSetOf()
    private var totalEarnings: Pair<Long, Long> = Singleton.totalEarnings

    fun getVehiclesList(vehicles: MutableSet<Vehicle>) {
        vehiclesList = vehicles
    }

    private var backFee: Long = Singleton.backFee
    fun checkOutVehicle(plate: String, indexVehicle: Int, vehicleType: Vehicle.VehicleType?) {
        if (vehiclesList.elementAt(indexVehicle).plate?.contains(plate) == true) {
            Singleton.count = Singleton.count + 1
            val fee = calculateFee(vehiclesList.elementAt(indexVehicle), vehicleType)
            val totalEarnings = onSuccess(fee, vehiclesList.elementAt(indexVehicle), Singleton.backFee, Singleton.count)
            Singleton.totalEarnings = totalEarnings
        } else {
            onError()
        }
    }

    private fun calculateFee(vehicle: Vehicle, vehicleType: Vehicle.VehicleType?): Long {
        val parkedTime: Long = (Calendar.getInstance().timeInMillis - vehicle.calendar.timeInMillis)
        var totalFee: Long = 0
        var surplusTime: Long = 0
        var surplusMinutes: Long = 0

        val hasDiscountCard: Boolean = vehicle.discountCard?.isNotEmpty() == true


        if (parkedTime <= Constants.TWO_HOURS_IN_MILLISECONDS) {
            totalFee = vehicleType?.fee ?: 0
        } else {
            while (parkedTime > Constants.TWO_HOURS_IN_MILLISECONDS) {
                surplusTime = parkedTime - Constants.TWO_HOURS_IN_MILLISECONDS
                break
            }
            for (i in 0..surplusTime step Constants.FIFTEEN_IN_MILLISECONDS) {
                surplusMinutes++
            }
            totalFee = vehicleType?.fee ?: 0 + (surplusMinutes * 5)
        }

        if (hasDiscountCard) {
            val discount = (totalFee * 0.15).roundToInt()
            totalFee -= discount
        }
        return totalFee
    }

    private fun onSuccess(fee: Long, vehicle: Vehicle, backFee: Long, countVehicles: Long) : Pair<Long, Long> {
        println("Your fee is $fee. Come back soon.")
        vehiclesList.remove(vehicle)
        totalEarnings = Pair(countVehicles, fee + Singleton.backFee)
        println(totalEarnings)
        Singleton.backFee += fee
        return totalEarnings
    }

    fun onError() {
        println("Sorry, the check-out failed")
    }
}
