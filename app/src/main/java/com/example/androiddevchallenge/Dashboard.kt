package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class Item(val image: Int, val title: String)

val favourites = listOf(
    Item(R.drawable.fav2, "Stress and anxiety"),
    Item(R.drawable.fav3, "Overwhelmed"),
    Item(R.drawable.fav4, "Nature meditations"),
    Item(R.drawable.fav5, "Self-massage"),
    Item(R.drawable.fav6, "Nightly wind down"),
)

val bodies = listOf(
    Item(R.drawable.body1, "Inversions"),
    Item(R.drawable.body2, "Quick yoga"),
    Item(R.drawable.body3, "Stretching"),
    Item(R.drawable.body4, "Tabata"),
    Item(R.drawable.body5, "HllT"),
    Item(R.drawable.body6, "Pre-natal yoga"),
)

val minds = listOf(
    Item(R.drawable.body7, "Meditate"),
    Item(R.drawable.body8, "With kids"),
    Item(R.drawable.body9, "Aromatherapy"),
    Item(R.drawable.body10, "On the go"),
    Item(R.drawable.body11, "With pets"),
    Item(R.drawable.body12, "High stress"),
)

class Dashboard : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme(true) {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {},
                            backgroundColor = MaterialTheme.colors.primary
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.play_arrow),
                                contentDescription = null,
                                tint = MaterialTheme.colors.onPrimary,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    },
                    floatingActionButtonPosition = FabPosition.Center
                ) {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        DashboardContent()
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun DashboardContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MySootheInput(
            modifier = Modifier.padding(bottom = 24.dp),
            placeholder = "Search",
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search"
                )
            })
        Heading(heading = "FAVOURITE COLLECTIONS", modifier = Modifier.padding(bottom = 8.dp))
        Favourites()
        Heading(heading = "ALIGN YOUR BODY", modifier = Modifier.padding(bottom = 8.dp))
        ItemsRow(bodies)
        Heading(heading = "ALIGN YOUR MIND", modifier = Modifier.padding(bottom = 8.dp))
        ItemsRow(minds)
    }
}

@Composable
fun Heading(heading: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = heading,
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.onBackground
    )
}

@ExperimentalFoundationApi
@Composable
fun Favourites() {
    Column(
        modifier = Modifier
            .padding(bottom = 32.dp)
            .horizontalScroll(state = rememberScrollState()),
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 8.dp)

        ) {
            repeat(3) { index ->
                Favourite(favourite = favourites[index])
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 8.dp)
        ) {
            repeat(2) { index ->
                Favourite(favourite = favourites[index + 3])
            }
        }
    }
}

@Composable
fun Favourite(modifier: Modifier = Modifier, favourite: Item) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .height(60.dp)
            .width(220.dp)
            .padding(end = 8.dp)
            .background(color = MaterialTheme.colors.surface)
    ) {
        CoilImage(
            data = favourite.image,
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.4F),
            contentDescription = favourite.title,
            contentScale = ContentScale.Crop
        )
        Text(
            text = favourite.title,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .weight(0.75F)
                .padding(start = 16.dp, end = 8.dp)
        )
    }
}

@Composable
fun ItemsRow(items: List<Item>) {
    Row(
        Modifier
            .horizontalScroll(rememberScrollState())
            .padding(bottom = 32.dp)
    ) {
        repeat(items.size) {
            RoundedItem(item = items[it])
        }
    }
}

@Composable
fun RoundedItem(item: Item) {
    Column(
        modifier = Modifier
            .padding(end = 16.dp)
            .width(IntrinsicSize.Max),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(88.dp)
                .width(88.dp)
                .clip(CircleShape), data = item.image,
            contentDescription = item.title,
            contentScale = ContentScale.Crop
        )
        Text(
            text = item.title, style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSurface,
        )
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    MyTheme {
        DashboardContent()
    }
}