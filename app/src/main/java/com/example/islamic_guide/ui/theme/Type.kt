package com.example.islamic_guide.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// In your theme/Type.kt file:
val Typography = Typography(
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,  // Increase title size
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,  // Increase body text size
        lineHeight = 24.sp,
        letterSpacing = 0.25.sp
    ),
    // Add other styles as needed
)


// // Set of Material typography styles to start with
// val Typography = Typography(
//     bodyLarge = TextStyle(
//         fontFamily = FontFamily.Default,
//         fontWeight = FontWeight.Normal,
//         fontSize = 16.sp,
//         lineHeight = 24.sp,
//         letterSpacing = 0.5.sp
//     )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
