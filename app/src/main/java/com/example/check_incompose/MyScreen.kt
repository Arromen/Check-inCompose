package com.example.check_incompose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.enums.enumEntries

@OptIn(ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class)
@Composable
fun MyScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Заезд", "Выезд")
    val pagerState = rememberPagerState(pageCount = { selectedTabIndex })

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /* Обработка нажатия на стрелку назад */ }) {
                        Icon(
                            painter = painterResource(id =
                                R.drawable.arrow_left),
                            contentDescription = "Назад",
                                modifier = Modifier.size(24.dp))
                    }
                },
                title = {
                    Row {
                        Spacer(
                            modifier = Modifier.width(32.dp)
                        )
                        Text("Заезд / выезд",
                            color = Color(0xFF0D0D0D),
                            fontFamily = FontFamily.Default,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 24.sp
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Обработка нажатия на поиск */ }) {
                        Icon(
                            painter = painterResource(id =
                                R.drawable.search),
                            contentDescription = "Поиск",
                                modifier = Modifier.size(24.dp))
                    }
                    IconButton(onClick = { /* Обработка нажатия на календарь */ }) {
                        Icon(
                            painter = painterResource(id =
                            R.drawable.calendar),
                            contentDescription = "Календарь",
                                modifier = Modifier.size(24.dp))
                    }
                    IconButton(onClick = { /* Обработка нажатия на фильтр */ }) {
                        Icon(
                            painter = painterResource(id =
                                R.drawable.filter),
                            contentDescription = "Фильтр",
                                modifier = Modifier.size(24.dp))
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
            ) {
                OceanButton(innerPadding)

                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    indicator = { tabPositions ->
                        if (tabPositions.isNotEmpty()) {
                            val currentTabPosition = tabPositions[selectedTabIndex]
                            Box(
                                Modifier
                                    .tabIndicatorOffset(currentTabPosition)
                                    .fillMaxWidth()
                                    .height(4.dp)
                                    .background(
                                        Color(0xFF4096FB),
                                        RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                                    )
                            )
                        }
                    }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = {
                                Text(
                                    text = title,
                                    color = Color(0xFF0D0D0D),
                                    textAlign = TextAlign.Center,
                                    fontFamily = FontFamily.Default,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    lineHeight = 24.sp
                                )
                            },
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }

                HorizontalPager(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    state = pagerState,
                    modifier = Modifier.weight(1f)
                ) { page ->

                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    MyScreen()
}