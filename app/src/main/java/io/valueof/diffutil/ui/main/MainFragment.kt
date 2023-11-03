package io.valueof.diffutil.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import io.valueof.diffutil.R
import io.valueof.diffutil.databinding.MainFragmentBinding
import io.valueof.diffutil.ui.main.compose.MainScreen
import io.valueof.diffutil.ui.main.compose.theme.AppTheme

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val binding by viewBinding(MainFragmentBinding::bind)

    private lateinit var viewModel: MainViewModel

    private val itemAdapter = ItemAdapter(this::toggleFavoriteStatus)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        return ComposeView(requireContext()).apply {

            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AppTheme {
                    MainScreen()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
            lifecycleScope.launchWhenResumed {
              viewModel.itemList.collect { itemList ->
                Timber.d("current item list $itemList")
                itemAdapter.submitList(itemList)
              }
            }

         */
    }

    private fun toggleFavoriteStatus(id: String, isFavorite: Boolean) {
        viewModel.toggleFavoriteStatus(id, isFavorite)
    }
}