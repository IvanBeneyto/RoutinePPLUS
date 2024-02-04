package com.pmdm.routinepplus.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun Exercises(navController: NavController) {
    Scaffold(
        content = { innerPadding ->
            MyMenuExercises(innerPadding)
        },
        bottomBar = { MyBottomNavigation(navController) }
    )
}


@Composable
fun MyMenuExercises(innerPadding: PaddingValues) {

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp),
        columns = GridCells.Fixed(2)
    ) {

        itemsIndexed(MainActivity.items) { index, item ->
            GridItem(item = item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun GridItem(item: Item) {

    Column(
        modifier = Modifier
            .height(250.dp)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(30.dp)),
            painter = painterResource(id = item.image),
            contentDescription = item.tittle,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = item.tittle, fontWeight = FontWeight.SemiBold)
    }
}







