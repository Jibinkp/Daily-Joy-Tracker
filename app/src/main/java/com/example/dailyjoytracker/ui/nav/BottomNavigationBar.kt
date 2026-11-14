package com.example.dailyjoytracker.ui.nav

import androidx.compose.foundation.clickable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Today
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class BottomTab {
    Today, Routines, Stats
}

@Preview
@Composable
fun PreviewBottomNavigationBar() {
    BottomNavigationBar(
        selectedTab = BottomTab.Today,
        onTabSelected = { }
    )
}

@Composable
fun BottomNavigationBar(
    selectedTab: BottomTab,
    onTabSelected: (BottomTab) -> Unit
) {
    val tabs = listOf(
        Triple(BottomTab.Today, "Today", Icons.Outlined.Today),
        Triple(BottomTab.Routines, "Routines", Icons.Outlined.List),
        Triple(BottomTab.Stats, "Stats", Icons.Outlined.BarChart)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF2EEFF))
            .navigationBarsPadding()
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(Color.White)
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEach { (tab, title, icon) ->

                val isSelected = selectedTab == tab

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(32.dp))
                        .background(
                            if (isSelected) Color(0xFFE6F4FC)
                            else Color.Transparent
                        )
                        .clickable { onTabSelected(tab) }
                        .padding(vertical = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        tint = if (isSelected) Color(0xFF0099D6)
                        else Color(0xFF69758D),
                        modifier = Modifier.size(28.dp)
                    )

                    Text(
                        text = title,
                        fontSize = 18.sp,
                        fontWeight = if (isSelected) FontWeight.SemiBold
                        else FontWeight.Medium,
                        color = if (isSelected) Color(0xFF0099D6)
                        else Color(0xFF69758D)
                    )
                }
            }
        }
    }
}