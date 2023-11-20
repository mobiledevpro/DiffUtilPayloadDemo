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
##

### Jetpack Compose version is available through the branch [jetpack-compose-list](https://github.com/mobiledevpro/DiffUtilPayloadDemo/tree/jetpack-compose-list)

[![Alt text](https://img.youtube.com/vi/_kznxaFi2Zo/0.jpg)](https://youtube.com/shorts/_kznxaFi2Zo)

##

Code:
```kotlin
      LazyColumn {
                items(
                    items = list,
                    key = { item -> item.id }
                ) { item ->
                    ListItem(item = item, onFavoriteClicked = {
                        onFavouriteClicked(item)
                    })
                }
            }
```

## Follow:

<a href="https://www.instagram.com/mobiledevpro/" target="_blank">
  <img src="https://s.gravatar.com/avatar/72c649d298a8f0f088fd0850e19b9147?s=400" width="70" align="left">
</a>

**Dmitri Chernysh**

[![Youtube](https://img.shields.io/badge/-youtube-red?logo=youtube&message=Youtube&style=for-the-badge)](https://www.youtube.com/@mobiledevpro?sub_confirmation=1)
[![Instagram](https://img.shields.io/badge/-instagram-E4405F?logo=instagram&message=Behind+the+scenes+in+Storiesn&style=for-the-badge&logoColor=white)](https://www.instagram.com/mobiledevpro/)
[![Twitter](https://img.shields.io/badge/-twitter-1DA1F2?logo=twitter&style=for-the-badge&logoColor=white)](https://twitter.com/mobiledev_pro)
[![Linkedin](https://img.shields.io/badge/-linkedin-0A66C2?logo=linkedin&style=for-the-badge&logoColor=white)](https://www.linkedin.com/in/dmitriychernysh/)

