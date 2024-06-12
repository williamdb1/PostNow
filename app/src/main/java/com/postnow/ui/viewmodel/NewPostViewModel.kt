package com.postnow.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.postnow.api.RetrofitClient
import com.postnow.model.PostEntity
import com.postnow.state.NewPostState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewPostViewModel : ViewModel() {

    private val _state = MutableStateFlow(NewPostState())
    val state: StateFlow<NewPostState> = _state

    fun updateTitle(title: String) {
        _state.value = _state.value.copy(title = title)
    }

    fun updateDescription(description: String) {
        _state.value = _state.value.copy(description = description)
    }

    fun updateShowErrorDialog(show: Boolean) {
        _state.value = _state.value.copy(showDialogError = show)
    }

    fun updateMessageSuccess(message: String) {
        _state.value = _state.value.copy(messageSuccess = message)
    }

    fun post(item: PostEntity) {
        _state.value = _state.value.copy(isLoading = true)

        RetrofitClient.apiService.postPosts(item).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val message = response.body()?.string()
                    _state.value = _state.value.copy(isLoading = false, messageSuccess = message ?: "")
                } else {
                    _state.value = _state.value.copy(isLoading = false, showDialogError = true)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                _state.value = _state.value.copy(isLoading = false, showDialogError = true)
            }
        })
    }
}