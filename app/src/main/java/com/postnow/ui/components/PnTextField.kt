package com.postnow.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.postnow.ui.theme.DarkSurface
import com.postnow.ui.theme.LightOrange
import com.postnow.ui.theme.Orange
import com.postnow.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PnTextField(
    value: String,
    onValueChange: (String) -> Unit = {},
    placeholder: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    placeholderColor: Color = Color.Gray,
    borderColor: Color = Orange,
    maxLine: Int = 1,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        maxLines = maxLine,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        textStyle = TextStyle(color = textColor),
        placeholder = { Text(text = placeholder, color = placeholderColor) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Color.Black,
            focusedBorderColor = borderColor,
            unfocusedBorderColor = borderColor,
            disabledBorderColor = borderColor,
        )
    )
}
