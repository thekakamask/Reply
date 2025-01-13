package com.dcac.reply.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dcac.reply.data.Email
import com.dcac.reply.data.MailboxType
import com.dcac.reply.ui.utils.ReplyNavigationType

@Composable
fun ReplyApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val viewModel: ReplyViewModel = viewModel()
    val replyUiState = viewModel.uiState.collectAsState().value

    val navigationType: ReplyNavigationType = when {
        windowSize == WindowWidthSizeClass.Compact -> {
            ReplyNavigationType.BOTTOM_NAVIGATION
        }
        windowSize == WindowWidthSizeClass.Medium -> {
            ReplyNavigationType.NAVIGATION_RAIL
        }
        windowSize == WindowWidthSizeClass.Expanded -> {
            val isLandscapeSmartphone = isLandscapeSmartphone()
            if (isLandscapeSmartphone) {
                ReplyNavigationType.NAVIGATION_RAIL // Display rail on smartphone landscape
            } else {
                ReplyNavigationType.PERMANENT_NAVIGATION_DRAWER // Drawer for tablet
            }
        }
        else -> {
            ReplyNavigationType.BOTTOM_NAVIGATION
        }
    }

    ReplyHomeScreen(
        navigationType = navigationType,
        replyUiState = replyUiState,
        onTabPressed = { mailboxType: MailboxType ->
            viewModel.updateCurrentMailbox(mailboxType = mailboxType)
            viewModel.resetHomeScreenStates()
        },
        onEmailCardPressed = { email: Email ->
            viewModel.updateDetailsScreenStates(
                email = email
            )
        },
        onDetailScreenBackPressed = {
            viewModel.resetHomeScreenStates()
        },
        modifier = modifier
    )
}

@Composable
fun isLandscapeSmartphone(): Boolean {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp
    val screenRatio = screenWidthDp.toFloat() / screenHeightDp.toFloat()

    // Consider smartphone if ratio is large but screen stay compact
    return screenWidthDp > 600 && screenRatio > 1.5 && screenHeightDp < 600
}