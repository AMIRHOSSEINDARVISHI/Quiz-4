package code.with.cal.ui.items

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import code.with.cal.model.User
import code.with.cal.q_4.databinding.ItemRecyclerviewBinding


class ItemAdapter(val context: Context, val userList: MutableList<User>) :
    RecyclerView.Adapter<ItemAdapter.SearchViewHolder>() {

    lateinit var itemClick: ItemClick

    interface ItemClick{
        fun viewClick(position: Int,v:View?)
    }

    fun setItemUserClick(itemClick:ItemClick){
        this.itemClick = itemClick
    }


    inner class SearchViewHolder(private var itemRecyclerViewBinding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(itemRecyclerViewBinding.root), View.OnClickListener {
        fun bind(position: Int) {
            itemRecyclerViewBinding.textNationalCode.text = userList[position].nationalCode
            itemRecyclerViewBinding.textFirstName.text = userList[position].firstName
            itemRecyclerViewBinding.textLastName.text = userList[position].lastName
        }

        init {
            itemRecyclerViewBinding.root.setOnClickListener(this);
        }
        override fun onClick(p0: View?) {
            itemClick.viewClick(adapterPosition, p0)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val viewHolder =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SearchViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = userList.size

}