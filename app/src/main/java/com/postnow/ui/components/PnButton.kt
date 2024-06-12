package com.postnow.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.postnow.ui.theme.DarkSurface
import com.postnow.ui.theme.LightOrange
import com.postnow.ui.theme.Orange
import com.postnow.ui.theme.White

@Composable
fun PnButton(
    text: String,
    modifier: Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    onClick: () -> Unit,
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Orange,
            contentColor = White,
            disabledContainerColor = LightOrange,
            disabledContentColor = White
        ),
        modifier = modifier,
        shape = RoundedCornerShape(4.dp)
    ) {
        Row() {
            Text(text = text)
            if (loading) {
                PnSpacerVertical(12)
                CircularProgressIndicator(
                    color = White,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    PnButton(
        text = "teste",
        onClick = {},
        enabled = false,
        loading = true,
        modifier = Modifier.fillMaxWidth()
    )
}