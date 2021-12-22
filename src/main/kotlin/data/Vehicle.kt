package data

import java.util.*

data class Vehicle(val plate: String?, val type: VehicleType?, val calendar: Calendar, val discountCard: String? ){
    enum class VehicleType(val fee: Long){
        CAR(20),
        BIKE(15),
        MINIBUS(25),
        BUS(30)
    }

    override fun equals(other: Any?): Boolean {
        if(other is Vehicle){
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return this.plate.hashCode()
    }
}
