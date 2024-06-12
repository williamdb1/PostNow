package com.postnow.state

data class NewPostState(
    val title: String = "",
    val description: String = "",
    val isLoading: Boolean = false,
    val showDialogError: Boolean = false,
    val messageSuccess: String = "",
)