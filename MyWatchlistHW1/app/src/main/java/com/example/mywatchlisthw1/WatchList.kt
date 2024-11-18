package com.example.mywatchlisthw1

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WatchList(
    list: List<WatchListElement>,
    onCloseShow: (WatchListElement) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        items(
            items = list,
            key = { show -> show.id }
        ) { show ->
            WatchListItem(showName = show.name, onClose = { onCloseShow(show) })
        }
    }
}
