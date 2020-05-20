package com.example.tarea1fernando.Beans

class MenuCarta {
    var detallePedido : String=""
    var costo : Double=0.0
    var catidad : Int=0
    var Total : Double=0.0
    var Descuento : Double=0.0
    var TotalPagar : Double=0.0

    constructor(detallePedido: String, costo: Double,catidad:Int,delivery:Boolean) {
        this.detallePedido = detallePedido
        this.costo = costo
        this.catidad = catidad
        this.Total = costo*catidad
        this.Descuento = descuento(Total)
        this.TotalPagar = totalPagar(delivery)
    }

    fun calcularTotal(costo:String,cantidad:String):Boolean
    {
        if(costo.isEmpty() || costo.equals("0")){
            return false;
        }
        if(cantidad.isEmpty() || cantidad.equals("0")){
            return false;
        }
        return true;
    }
    fun descuento(total:Double):Double{
        if(total>=200 && total<500)
            return total*0.05
        else if(total>=500 && total<1000)
            return total*0.1
        else
        return total*0.12
    }
    fun totalPagar(delivery:Boolean):Double{
        var precioDelivery:Double=0.0
        if(delivery){
            precioDelivery=20.0
        }
        return Total-Descuento+precioDelivery
    }
}