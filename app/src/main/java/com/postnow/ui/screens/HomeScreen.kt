package com.postnow.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.postnow.R
import com.postnow.model.PostEntity
import com.postnow.ui.components.PnButton
import com.postnow.ui.components.PnDialog
import com.postnow.ui.components.PnScreen
import com.postnow.ui.components.PnSpacerVertical
import com.postnow.ui.theme.Orange
import com.postnow.ui.typography.AppTypography
import com.postnow.ui.viewmodel.HomeViewModel
import org.threeten.bp.format.DateTimeFormatter


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    navController: NavHostController,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getPosts()
    }

    PnDialog(
        showDialog = state.showDialogError,
        onDismissRequest = {
            viewModel.getPosts()
            viewModel.updateShowErrorDialog(false)
        }
    )

    PnScreen(
        title = "",
        canNavigateBack = false,
        navigateUp = {},
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PnSpacerVertical(size = 40)

            Text(
                text = stringResource(id = R.string.app_name),
                style = AppTypography.displayLarge,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )

            PnSpacerVertical(size = 30)

            ListPost(
                title = stringResource(id = R.string.posts_list),
                posts = state.posts,
                onClick = { post ->
                    navController.navigate("detail/" + "${post.title}/${post.date}/${post.description}")
                },
                isLoading = state.isLoading
            )

            Spacer(modifier = Modifier.weight(1f))

            PnButton(
                text = stringResource(id = R.string.new_post),
                onClick = {
                    navController.navigate("new_post")
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }
    }

}

@Composable
fun ListPost(
    title: String,
    posts: List<PostEntity>,
    onClick: (PostEntity) -> Unit,
    isLoading: Boolean,
) {
    Box(modifier = Modifier.border(
        border = BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(4.dp)
    ), content = {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = title,
                style = AppTypography.displayMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                textAlign = TextAlign.Center,
            )

            if (isLoading && posts.isEmpty()) {
                LinearProgressIndicator(
                    color = Orange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                )
                PnSpacerVertical(size = 4)

            } else {
                LazyColumn(
                    modifier = Modifier
                        .heightIn(max = 400.dp)
                ) {
                    items(posts) { post ->
                        Box(modifier = Modifier
                            .border(
                                border = BorderStroke(1.dp, Color.Black),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(start = 4.dp)
                            .clickable { onClick(post) }, content = {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = post.title, style = AppTypography.bodyMedium
                                )
                                Text(
                                    text = "Data: ${
                                        post.date.format(
                                            DateTimeFormatter.ofPattern(
                                                "dd/MM/yyyy"
                                            )
                                        )
                                    }", style = AppTypography.bodyMedium
                                )
                            }
                        })

                        PnSpacerVertical(size = 8)
                    }
                }
            }
        }
    })
}