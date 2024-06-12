package com.postnow.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.postnow.R
import com.postnow.ui.theme.Orange
import com.postnow.ui.typography.AppTypography

@Composable
fun PnDialog(
    iconResId: ImageVector = Icons.Filled.Info,
    title: String = stringResource(id = R.string.dialog_error_title),
    subtitle: String = stringResource(id = R.string.dialog_error_title),
    onDismissRequest: () -> Unit = {},
    buttonText: String = stringResource(id = R.string.dialog_error_button),
    showDialog: Boolean = false,
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = iconResId,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = Orange
                    )
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        style = AppTypography.displaySmall
                    )
                }
            },
            text = {
                Text(
                    text = subtitle,
                    style = AppTypography.headlineMedium
                )
            },
            confirmButton = {
                TextButton(
                    onClick = onDismissRequest,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = Orange
                    )
                ) {
                    Text(buttonText)
                }
            }
        )
    }
}