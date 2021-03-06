package info.xudshen.android.playground.thirdpartylib.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer
import info.xudshen.android.playground.R
import info.xudshen.android.playground.SampleDataSource
import kotlinx.android.synthetic.main.fragment_uil_sample.*
import kotlinx.android.synthetic.main.include_toolbar.*
import kotlinx.android.synthetic.main.layout_uil_sample_item.view.*

/**
 * Created by xudong on 2017/1/13.
 */

class UILSampleFragment : Fragment() {
    val options: DisplayImageOptions by lazy {
        DisplayImageOptions.Builder().displayer(FadeInBitmapDisplayer(3000)).build()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_uil_sample, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)?.setSupportActionBar(toolbar)
        (activity as AppCompatActivity?)?.title = "UIL Sample"

        uil_list.layoutManager = GridLayoutManager(context, 2)
        uil_list.adapter = UILSampleItemAdapter()
    }

    inner class UILSampleItemAdapter : RecyclerView.Adapter<UILSampleItemAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
                ViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.itemView.uil_iv.loadImage { _, _ ->
                ImageLoader.getInstance().displayImage(SampleDataSource.IMAGE_DATA.elementAtOrNull(position),
                        holder.itemView.uil_iv, options)
            }
        }

        override fun getItemCount(): Int = SampleDataSource.IMAGE_DATA.size

        override fun getItemViewType(position: Int): Int = R.layout.layout_uil_sample_item

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    }
}
