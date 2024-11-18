package com.example.mywatchlisthw1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(viewModel: WatchlistViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFB0AFFF),
                    titleContentColor = Color.White
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.logo),
                            contentDescription = "Watchlist Icon",
                            modifier = Modifier
                                .width(36.dp)
                                .height(36.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "My Watchlist",
                            color = Color.White,
                            fontSize = 20.sp
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        MyListScreen(modifier = Modifier.padding(innerPadding), viewModel = viewModel)
    }
}
