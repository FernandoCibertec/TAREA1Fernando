package com.example.tarea1fernando.Beans

public class ProveedorBean {
    var Codigo:Int=0
    var Ruc:String=""
    var RazonSocial:String =""
    var Direccion:String =""
    constructor(pCodigo:Int, pRuc:String,pRazonSocial:String, pDireccion:String)
    {
        this.Codigo = pCodigo
        this.Ruc= pRuc
        this.RazonSocial = pRazonSocial
        this.Direccion = pDireccion
    }

}
