package com.example.mywatchlisthw1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyListScreen(
    modifier: Modifier = Modifier,
    viewModel: WatchlistViewModel = viewModel()
) {
    val list = viewModel.watchlist
    val isDialogOpen = viewModel.isDialogOpen
    val movieName = viewModel.movieName
    val topAppBarColor = Color(0xFFB0AFFF)
    val listItemBackgroundColor = Color(0xFFF0F0F0)
    val buttonColor = Color(0xFFB0AFFF)
    val buttonTextColor = Color(0xFFFFFFFF)

    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.openDialog() },
                containerColor = topAppBarColor,
                modifier = Modifier.padding(end = 28.dp)
            ) {
                Text(text = "Add Movie Or Show", color = buttonTextColor, modifier = Modifier.padding(horizontal = 12.dp))
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            WatchList(
                list = list,
                onCloseShow = { show -> viewModel.removeMovie(show) }
            )

            if (isDialogOpen) {
                AlertDialog(
                    onDismissRequest = { viewModel.closeDialog() },
                    title = { Text(text = "Add New Movie") },
                    text = {
                        TextField(
                            value = movieName,
                            onValueChange = { viewModel.updateMovieName(it) },
                            label = { Text(text = "Movie Name") },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = listItemBackgroundColor
                            )
                        )
                    },
                    confirmButton = {
                        Button(
                            onClick = { viewModel.addMovie() },
                            colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
                        ) {
                            Text("Add", color = buttonTextColor)
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { viewModel.closeDialog() },
                            colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
                        ) {
                            Text("Cancel", color = buttonTextColor)
                        }
                    }
                )
            }
        }
    }
}
