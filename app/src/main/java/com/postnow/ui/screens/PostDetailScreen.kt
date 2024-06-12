package com.postnow.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.postnow.R
import com.postnow.ui.components.PnScreen
import com.postnow.ui.components.PnSpacerVertical
import com.postnow.ui.typography.AppTypography

@Composable
fun PostDetailScreen(
    navController: NavHostController,
    title: String,
    date: String,
    description: String
) {
    PnScreen(
        title = stringResource(id = R.string.post_details),
        canNavigateBack = true,
        navigateUp = {
            navController.popBackStack()
        },
    ) {
        PnSpacerVertical(size = 40)

        Column(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.post_details),
                        style = AppTypography.displayMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        textAlign = TextAlign.Center,
                    )

                    Text(
                        text = "Título: $title",
                        style = AppTypography.bodyMedium
                    )
                    PnSpacerVertical(size = 4)

                    Text(
                        text = "Data: $date",
                        style = AppTypography.bodyMedium
                    )

                    PnSpacerVertical(size = 4)

                    Text(
                        text = "Descrição: $description",
                        style = AppTypography.bodyMedium
                    )

                    PnSpacerVertical(size = 4)
                }
            }
            PnSpacerVertical(size = 8)
        }
    }
}