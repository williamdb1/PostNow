package com.postnow.navigation


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.postnow.ui.screens.HomeScreen
import com.postnow.ui.screens.NewPostScreen
import com.postnow.ui.screens.PostDetailScreen
import com.postnow.ui.theme.Orange
import com.postnow.ui.theme.White
import com.postnow.ui.typography.AppTypography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostNowAppBar(
    title: String = "",
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                style = AppTypography.labelLarge,
                textAlign = TextAlign.Start,
                color = White,
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Orange
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = White,
                    )
                }
            }
        }
    )
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("new_post") {
            NewPostScreen(navController = navController)
        }
        composable("detail/{title}/{date}/{description}") { entry ->
            val title = entry.arguments?.getString("title")
            val date = entry.arguments?.getString("date")
            val description = entry.arguments?.getString("description")
            if (title != null && date != null && description != null)
                PostDetailScreen(
                    navController = navController,
                    title = title,
                    date = date,
                    description = description
                )
        }
    }
}
