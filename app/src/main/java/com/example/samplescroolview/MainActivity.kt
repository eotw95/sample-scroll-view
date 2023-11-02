package com.example.samplescroolview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplescroolview.ui.theme.SampleScroolViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleScroolViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScrollView()
                }
            }
        }
    }
}

@Composable
fun ScrollView() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        val list1 = listOf("a", "b", "c", "d", "e")
        val list2 = listOf("1", "2", "3", "4", "5")
        val list3 = listOf("aa", "bb", "cc", "dd", "ee")
        val list4 = listOf("a1", "b2", "c3", "d4", "e5")
        val list5 = listOf("11", "22", "33", "44", "55")
        val listInList = listOf<List<String>>(list1, list2, list3, list4, list5)
        ArticleList(listInList)
    }
}

@Composable
fun ArticleList(contents: List<List<Any>>) {
    contents.forEach {
        Column {
            Text("Channel")
            Spacer(modifier = Modifier.padding(10.dp))
            it.forEach {
                Text(text = "ArticleList: $it")
                Spacer(modifier = Modifier.padding(10.dp))
                Divider()
            }
        }
        Spacer(modifier = Modifier.padding(30.dp))
    }
}