package com.postnow.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.postnow.R
import com.postnow.model.PostEntity
import com.postnow.ui.components.PnButton
import com.postnow.ui.components.PnDialog
import com.postnow.ui.components.PnScreen
import com.postnow.ui.components.PnSpacerVertical
import com.postnow.ui.components.PnTextField
import com.postnow.ui.typography.AppTypography
import com.postnow.ui.viewmodel.NewPostViewModel
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

@Composable
fun NewPostScreen(
    navController: NavHostController,
    viewModel: NewPostViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsState()


    PnDialog(
        showDialog = state.showDialogError,
        onDismissRequest = {
            viewModel.post(
                PostEntity(
                    title = state.title,
                    date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                    description = state.description,
                )
            )
            viewModel.updateShowErrorDialog(false)
        }
    )

    PnDialog(
        showDialog = state.messageSuccess.isNotEmpty(),
        title = stringResource(id = R.string.dialog_success_title),
        subtitle = stringResource(id = R.string.dialog_success_subtitle),
        buttonText = stringResource(id = R.string.dialog_success_button),
        onDismissRequest = {
            viewModel.updateMessageSuccess("")
            navController.navigate("home")
        }
    )

    PnScreen(
        title = stringResource(id = R.string.new_post),
        canNavigateBack = true,
        navigateUp = {
            navController.popBackStack()
        },
    ) {

        PnSpacerVertical(size = 40)

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .border(BorderStroke(1.dp, Color.Black), shape = RectangleShape),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.add_post),
                        style = AppTypography.displayMedium
                    )

                    PnSpacerVertical(size = 16)

                    PnTextField(
                        value = state.title,
                        onValueChange = { viewModel.updateTitle(it) },
                        placeholder = stringResource(id = R.string.add_title),
                        maxLine = 1,
                    )

                    PnSpacerVertical(size = 16)

                    PnTextField(
                        value = state.description,
                        onValueChange = { viewModel.updateDescription(it) },
                        placeholder = stringResource(id = R.string.add_description),
                        maxLine = 5,
                    )
                }
            }

            PnButton(
                text = stringResource(id = R.string.new_post),
                onClick = {
                    viewModel.post(
                        item = PostEntity(
                            title = state.title,
                            date = LocalDate.now()
                                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                            description = state.description,
                        )
                    )
                },
                enabled = (state.title.isNotBlank() && state.description.isNotBlank() && !state.isLoading),
                loading = state.isLoading,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}