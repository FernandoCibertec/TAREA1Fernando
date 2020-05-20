package com.example.tarea1fernando

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea1fernando.Actividad.NuevoProveedor
import com.example.tarea1fernando.Adaptador.AdaptadorProveedor
import com.example.tarea1fernando.Beans.ProveedorBean
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nuevo_proveedor.*

class MainActivity : AppCompatActivity() {

    lateinit var oListaproveedor:ArrayList<ProveedorBean>
    lateinit var oAdaptadorProveedor: AdaptadorProveedor
    lateinit var oNuevoProveedor: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        oListaproveedor = ArrayList<ProveedorBean>()
        oListaproveedor.add(ProveedorBean(1, "1041009882", "Cibertec SAC", "Av Izaguirre"))
        oListaproveedor.add(ProveedorBean(2, "3453453454", "Metro SAC", "Av Izaguirre"))

        oAdaptadorProveedor = AdaptadorProveedor(oListaproveedor.toList(), this)
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        lvListaProveedor.setLayoutManager(llm)
        lvListaProveedor.setHasFixedSize(true)
        lvListaProveedor.setAdapter(oAdaptadorProveedor)


    }

    public fun btnCargarDialogo_onClick(v: View){

        oNuevoProveedor = Dialog(this)
        oNuevoProveedor.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoProveedor.setCancelable(false)
        oNuevoProveedor.setContentView(R.layout.activity_nuevo_proveedor)
        val obtnagregarNuevoprov = oNuevoProveedor.findViewById(R.id.btnagregarNuevoprov) as Button
        val obtnCancelNuevoprov = oNuevoProveedor.findViewById(R.id.btnCancelarNuevoprov) as Button
        obtnagregarNuevoprov.setOnClickListener{
            GrabarRegistro()
            oNuevoProveedor.dismiss()
        }
        obtnCancelNuevoprov.setOnClickListener {
            oNuevoProveedor.dismiss()
        }
        oNuevoProveedor.show()
    }

    private fun GrabarRegistro(){
        var oedtrucnuevo : EditText = (oNuevoProveedor.findViewById(R.id.edtrucnuevo)) as EditText
        var oedtdireccionnuevo: EditText = (oNuevoProveedor.findViewById(R.id.edtdireccionnuevo)) as EditText
        var oedtrazonsocialnuevo: EditText = (oNuevoProveedor.findViewById(R.id.edtrazonsocialnuevo)) as EditText

        oListaproveedor.add(
            ProveedorBean(oListaproveedor.size,
                oedtrucnuevo.text.toString(),
                oedtrazonsocialnuevo.text.toString(),
                oedtdireccionnuevo.text.toString() ))

        oAdaptadorProveedor = AdaptadorProveedor(oListaproveedor.toList(), this)
        lvListaProveedor.setAdapter(oAdaptadorProveedor)
    }
}
