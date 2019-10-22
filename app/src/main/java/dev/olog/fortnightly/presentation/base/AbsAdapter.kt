package dev.olog.fortnightly.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.olog.fortnightly.presentation.model.PresentationModel
import dev.olog.fortnightly.utils.CustomScope
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.distinctUntilChanged

abstract class AbsAdapter<T : PresentationModel>(
    private val itemCallback: DiffUtil.ItemCallback<T>
) : RecyclerView.Adapter<DataBoundViewHolder>(),
    CoroutineScope by CustomScope(Dispatchers.Default),
    DefaultLifecycleObserver {

    protected val dataSet = mutableListOf<T>()
    private val channel = Channel<List<T>>(Channel.CONFLATED)

    init {
        launch {
            channel.consumeAsFlow()
                .distinctUntilChanged()
                .collect { list ->
                    val diffCallback = AdapterDiffUtil(dataSet.toList(), list, itemCallback)
                    val diff = DiffUtil.calculateDiff(diffCallback, true)
                    withContext(Dispatchers.Main) {
                        updateDataSetInternal(list)
                        diff.dispatchUpdatesTo(this@AbsAdapter)
                    }
                }
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        cancel()
    }

    @CallSuper
    override fun onViewAttachedToWindow(holder: DataBoundViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.onAppear()
    }

    @CallSuper
    override fun onViewDetachedFromWindow(holder: DataBoundViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.onDisappear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(viewType, parent, false)
        val viewHolder = DataBoundViewHolder(view)
        initViewHolderListeners(viewHolder, viewType)
        return viewHolder
    }

    protected open fun initViewHolderListeners(viewHolder: DataBoundViewHolder, viewType: Int) {}

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: DataBoundViewHolder, position: Int) {
        val item = dataSet[position]
        bind(holder, item, position)
    }

    override fun getItemViewType(position: Int) = dataSet[position].viewType

    protected abstract fun bind(holder: DataBoundViewHolder, item: T, position: Int)

    fun updateDataSet(data: List<T>) {
        channel.offer(data)
    }

    private fun updateDataSetInternal(data: List<T>) {
        this.dataSet.clear()
        this.dataSet.addAll(data)
    }

}