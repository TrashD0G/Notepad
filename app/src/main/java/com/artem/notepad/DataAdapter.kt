package com.artem.notepad

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


public class DataAdapter(private val dataSet:List<Note>):RecyclerView.Adapter<DataAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {                            //Создает новый объект ViewHolder
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)//когда RecyclerView нуждается в этом
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = dataSet.size //Возвращает размер коллекции


    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //Устанавливает необходимые
        val note: Note = dataSet[position]                             //данные у созданых ViewHolder-ов
        holder.bind(note)

    }


    public class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var listTitleView:TextView? = null
        var listDescriptionView:TextView? = null
        var context:Context = itemView.context
        private val intent = Intent(context,OpenNoteActivity::class.java)

        init {
            listTitleView = itemView.findViewById(R.id.list_title)  //Ссылки на элементы
            listDescriptionView = itemView.findViewById(R.id.list_description)


            itemView.setOnClickListener{
                val position:Int = adapterPosition
                intent.putExtra("itemPosition",position)
                context.startActivity(intent)
            }

        }

        fun bind(note:Note){
            listTitleView?.text = note.param_head
            listDescriptionView?.text = note.param_description
        }

    }


}


