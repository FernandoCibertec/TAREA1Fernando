package com.example.tarea1fernando.Adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tarea1fernando.R
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea1fernando.Beans.ProveedorBean
import kotlinx.android.synthetic.main.registroproveedor.view.*

class AdaptadorProveedor(val listainterna:List<ProveedorBean>, Contexto:Context): RecyclerView.Adapter<AdaptadorProveedor.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(oProveedor:ProveedorBean){
            val tvCodigoProv=itemView.findViewById(R.id.tvITEMCODIGOPROVEEDOR) as TextView
            val tvRuc=itemView.findViewById(R.id.TVRUC_ITEM) as TextView
            val tvRazonSocial=itemView.findViewById(R.id.TVRAZONSOCIAL_ITEM) as TextView

            tvCodigoProv.text =oProveedor.Codigo.toString()
            tvRuc.text =oProveedor.Ruc.toString()
            tvRazonSocial.text =oProveedor.RazonSocial.toString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val v: View=LayoutInflater.from(parent?.context).inflate(R.layout.registroproveedor,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listainterna.size
    }

    override fun onBindViewHolder(holder: AdaptadorProveedor.ViewHolder, position: Int) {
        holder?.itemView.tvITEMCODIGOPROVEEDOR?.text =listainterna.get(position).Codigo.toString()
        holder?.itemView.TVRUC_ITEM?.text =listainterna.get(position).Ruc.toString()
        holder?.itemView.TVRAZONSOCIAL_ITEM?.text =listainterna.get(position).RazonSocial.toString()


    }

}