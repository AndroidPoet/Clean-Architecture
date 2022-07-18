package com.androidpoet.cleanarchitecture.commonui.material

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.androidpoet.cleanarchitecture.presentation.model.UiLayerNowPlaying
import com.androidpoet.cleanarchitecture.ui.theme.SlackCloneTypography
import com.androidpoet.cleanarchitecture.utils.Constants


@Composable
fun MovieItem(
    uiLayerNowPlaying: UiLayerNowPlaying.NowPlaying,
    onItemClick: (UiLayerNowPlaying.NowPlaying) -> Unit
) {

    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Row(
            Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxSize()
        ) {

            Card(elevation = 5.dp) {
                Image(
                    modifier = Modifier
                        .size(100.dp),
                    painter = rememberAsyncImagePainter(
                        model = Constants.IMAGE_BASE_URL + uiLayerNowPlaying.posterPath
                    ),
                    contentScale = ContentScale.Crop,
                    contentDescription = ""
                )
            }

            Column(
                verticalArrangement = Top,
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 12.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    text = uiLayerNowPlaying.title,
                    style = SlackCloneTypography.body1.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = uiLayerNowPlaying.overview,
                    modifier = Modifier.padding(vertical = 8.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = SlackCloneTypography.body1.copy(
                        color = Color.Black
                    )

                )
            }
        }
    }
}