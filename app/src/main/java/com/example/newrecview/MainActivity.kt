package com.example.newrecview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newrecview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter
    private var items = mutableListOf<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        init()

    }

    private fun init() {

        adapter = ItemAdapter(items, object : ItemLongClickListener {

            override fun itemLongClickListener(position: Int) {
                items.removeAt(position)
                adapter.notifyItemRemoved(position)
            }

            override fun itemClickListener(position: Int) {
                items[position] = ItemModel(
                    "Added to Cart",
                    "https://thumbs.dreamstime.com/b/add-to-cart-icon-adding-shopping-cart-well-organized-fully-editable-add-to-cart-icon-adding-shopping-cart-any-use-like-167547952.jpg"
                )
                adapter.notifyDataSetChanged()

                Toast.makeText(baseContext, "Added to cart", Toast.LENGTH_SHORT).show()


            }
        })

        binding.clearButton.setOnLongClickListener {
            items.clear()
            setData()
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Cart cleared", Toast.LENGTH_SHORT).show()
            true
        }

        binding.recycleView.layoutManager = GridLayoutManager(this, 2)
        binding.recycleView.adapter = adapter
    }

    private fun setData() {
        items.add(
            ItemModel(
                "Domino's Pizza",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/sp9inq8ksknquvv4lbtd"
            )
        )
        items.add(
            ItemModel(
                "Chicken McD",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/spsqbigvtg8yfk1yilmg"
            )
        )
        items.add(
            ItemModel(
                "Wendy's",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/xhhwxxrhel4d2iollfao"
            )
        )
        items.add(ItemModel("Pho"))
        items.add(
            ItemModel(
                "Dunkin'",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/cbookusq05v1ye3txzox"
            )
        )
        items.add(
            ItemModel(
                "Wendy's",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/tzs3hir4fwqewftyyese"
            )
        )
        items.add(ItemModel("McCafé"))
        items.add(
            ItemModel(
                "Subway",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/tzs3hir4fwqewftyyese"
            )
        )
        items.add(
            ItemModel(
                "Tokyo Sushi",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/s2mgiopebvrzojzuuzqx"
            )
        )
        items.add(ItemModel("Burger King"))
        items.add(
            ItemModel(
                "MARGE",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/om0jyg1y9rjhwwyutxv7"
            )
        )
        items.add(
            ItemModel(
                "Sushi24",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/ltpnpmczr8tkksgzizws"
            )
        )
        items.add(ItemModel("Shemoikhede Genatsvale"))
        items.add(
            ItemModel(
                "Gochit's Burger",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/rupi5mqrk1cjhvlk73fd"
            )
        )
        items.add(
            ItemModel(
                "Fifki",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/vvvoef2wwjwtp5cldjq6"
            )
        )
        items.add(
            ItemModel(
                "LRG",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/eq3q8f71gpy7l5vmcm5v"
            )
        )
        items.add(
            ItemModel(
                "SMASH by PIPES",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/bynfqm1fooucbkfedfvj"
            )
        )
        items.add(
            ItemModel(
                "Sweets Corner",
                "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/lgzb2nlvkzbuz0k8rwdg"
            )
        )
        items.add(ItemModel("Area 51"))
        items.add(ItemModel("Receptor"))


    }

}