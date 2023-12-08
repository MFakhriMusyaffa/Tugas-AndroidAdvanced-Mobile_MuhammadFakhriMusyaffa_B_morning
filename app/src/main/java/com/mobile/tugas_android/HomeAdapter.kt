
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobile.tugas_android.HomeModel
import com.mobile.tugas_android.databinding.HomeItemBinding

class HomeAdapter(private val list: List<HomeModel>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(val binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.imageProduk.setImageResource(this.image)
                binding.judulProduk.text = this.judul
                binding.hargaProduk.text = this.harga
            }
        }
    }
}