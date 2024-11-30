package com.kg.newsappcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(navController: NavHostController) {
    LazyColumn {
        item {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                text = "Home",
                style = MaterialTheme.typography.titleMedium
            )
            PostCardTop(
                post = Post(),
                modifier = Modifier.clickable(onClick = {
                }
                )
            )
            PostListDivider()
        }

        item {
            PostListPopularSection(
                listOf(Post(), Post(), Post())
            )
        }
        item { PostListHistorySection(listOf(Post(), Post(), Post())) }

    }
}

@Composable
private fun PostListDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 14.dp),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f)
    )
}

@Composable
private fun PostListPopularSection(
    posts: List<Post>,
) {
    Column {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Title",
            style = MaterialTheme.typography.titleLarge
        )
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .height(IntrinsicSize.Max)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (post in posts) {
                PostCardPopular(
                    post
                )
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}


@Composable
private fun PostListHistorySection(
    posts: List<Post>,
) {
    Column {
        posts.forEach { post ->
            PostCardHistory(post)
            PostListDivider()
        }
    }
}


data class Post(
    val imageId: Int = R.drawable.ic_launcher_foreground,
    val title: String = "Text title",
    val name: String = "Text name"
)


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController)
}