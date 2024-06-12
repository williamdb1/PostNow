package com.postnow.state

import com.postnow.model.PostEntity
import kotlinx.coroutines.flow.SharedFlow

data class HomeState(
    val posts: List<PostEntity> = emptyList(),
    val isLoading: Boolean = true,
    val showDialogError: Boolean = false,
    val refreshPosts: SharedFlow<Unit>,
)