package com.dcac.reply

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dcac.reply.ui.ReplyApp
import com.dcac.reply.ui.theme.ReplyTheme

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ReplyTheme {
                val windowSize = calculateWindowSizeClass(this)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Surface(
                        modifier = Modifier
                            .padding(calculateLandscapeSafePadding())
                    ) {
                        ReplyApp(
                            windowSize = windowSize.widthSizeClass
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun calculateLandscapeSafePadding(): PaddingValues {
    val insets = WindowInsets.safeDrawing.asPaddingValues()
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        val startInset = insets.calculateStartPadding(LocalLayoutDirection.current)
        val endInset = insets.calculateEndPadding(LocalLayoutDirection.current)


        return if (endInset > startInset) {
            // Camera at left (start)
            PaddingValues(start = startInset, end = 0.dp)git 
        } else if(startInset > endInset) {
            // Camera at right (end)
            PaddingValues(start = 0.dp, end = startInset)
        } else {
            PaddingValues(0.dp)
        }
    }

    // Mode portrait : aucune marge spécifique nécessaire
    return PaddingValues(0.dp)
}

@Preview(showBackground = true)
@Composable
fun ReplyAppCompactPreview() {
    ReplyTheme {
        Surface {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Compact)
        }
    }
}