package com.example.check_incompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OceanButton(onClick: PaddingValues) {
    Button(
        onClick = {
//            сделать позже логику
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF5F5F5)
        )
    ) {
        Row(
            horizontalArrangement = Arrangement
                .SpaceBetween,
            verticalAlignment = Alignment
                .CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Text("Океан",
                color = Color(0xFF0D0D0D),
                modifier = Modifier
                    .weight(1f),
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                lineHeight = 24.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id =
                    R.drawable.arrows_right
                ),
                contentDescription = "Иконка",
                tint = Color.Black
            )
        }
    }
}