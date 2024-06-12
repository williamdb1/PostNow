package com.postnow.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PnSpacerVertical(size: Int){
    Spacer(modifier = Modifier.height(size.dp))
}