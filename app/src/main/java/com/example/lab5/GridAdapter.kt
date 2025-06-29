import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5.GridItem
import com.example.lab5.R

class GridAdapter(
    private val items: List<GridItem>,
    private val onClick: (GridItem) -> Unit
) : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {

    class GridViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val circle: View = view.findViewById(R.id.circle_view)
        val text: TextView = view.findViewById(R.id.number_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid, parent, false)
        return GridViewHolder(v)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val item = items[position]
        holder.text.text = item.value.toString()
        val drawable = GradientDrawable()
        drawable.shape = GradientDrawable.OVAL
        drawable.setColor(item.color)
        holder.circle.background = drawable

        holder.view.setOnClickListener { onClick(item) }
    }
}
