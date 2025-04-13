package com.shabelnikd.profile.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun StyledButton(
    modifier: Modifier,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonColors(
            contentColor = Color.White,
            disabledContentColor = Color.White,
            containerColor = Color(0xFF262626),
            disabledContainerColor = Color(0xFF262626),
        ),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp),
        shape = RoundedCornerShape(percent = 25),
        content = content
    )
}