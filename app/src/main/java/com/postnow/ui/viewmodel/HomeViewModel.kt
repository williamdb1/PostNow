package com.postnow.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.postnow.api.RetrofitClient.apiService
import com.postnow.model.PostEntity
import com.postnow.state.HomeState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val _refreshPosts = MutableSharedFlow<Unit>()
    val refreshPosts = _refreshPosts.asSharedFlow()

    private val _state = MutableStateFlow(HomeState(refreshPosts = refreshPosts))
    val state: StateFlow<HomeState> = _state

    fun updateShowErrorDialog(show: Boolean) {
        _state.value = _state.value.copy(showDialogError = show)
    }

    fun getPosts() {
        _state.value = _state.value.copy(isLoading = true)
        apiService.getPosts().enqueue(object : Callback<List<PostEntity>> {
            override fun onResponse(
                call: Call<List<PostEntity>>,
                response: Response<List<PostEntity>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _state.value = _state.value.copy(posts = it, isLoading = false)
                    }
                } else {
                    _state.value = _state.value.copy(isLoading = false, showDialogError = true)
                }
            }

            override fun onFailure(call: Call<List<PostEntity>>, t: Throwable) {
                _state.value = _state.value.copy(isLoading = false, showDialogError = true)
            }
        })
    }
}