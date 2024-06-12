package com.postnow.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PnSpacerHorizontal(size: Int){
    Spacer(modifier = Modifier.width(size.dp))
}