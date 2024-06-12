package com.postnow.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.postnow.navigation.PostNowAppBar

@Composable
fun PnScreen(
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
    ) {

        Scaffold(
            topBar = {
                PostNowAppBar(
                    title = title,
                    canNavigateBack = canNavigateBack,
                    navigateUp = navigateUp,
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                content()
            }
        }
    }
}