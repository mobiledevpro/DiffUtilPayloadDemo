# RecyclerView DiffUtil Payload demo

##
Forked from [https://github.com/jshvarts/DiffUtilPayloadDemo](https://github.com/jshvarts/DiffUtilPayloadDemo)

The original blog post with an explanation is here [RecyclerView DiffUtil with Change Payload](https://www.valueof.io/blog/recyclerview-diffutil-change-payloads)
##

How it works (tap to watch):

[![Alt text](https://img.youtube.com/vi/K-YKBO_fbO4/0.jpg)](https://youtube.com/shorts/K-YKBO_fbO4)

##

Code:
```kotlin
class ItemAdapter(
  private val favoriteListener: (String, Boolean) -> Unit
) : ListAdapter<Item, ItemViewHolder>(ItemDiffCallback()) {

...
...

  override fun onBindViewHolder(holder: ItemViewHolder,
                                position: Int,
                                payloads: MutableList<Any>) {
    if (payloads.isEmpty()) {
      super.onBindViewHolder(holder, position, payloads)
    } else {
      if (payloads[0] == true) {
        // change 'favorite' icon state via holder
        holder.bindFavoriteState(getItem(position).isFavorite)
      }
    }
  }

}
```

```kotlin
class ItemDiffCallback : DiffUtil.ItemCallback<Item>() {

  ...
  ...

  override fun getChangePayload(oldItem: Item, newItem: Item): Any? {
    return if (oldItem.isFavorite != newItem.isFavorite) true else null
  }
}

```
