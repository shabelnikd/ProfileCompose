package com.shabelnikd.profile.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties

@Composable
fun AlertDialogWithTextField(
    showDialog: MutableState<Boolean>,
    onConfirm: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val textState = remember { mutableStateOf("") }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Введите имя") },
            text = {
                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    label = { Text("Имя пользователя") }
                )
            },
            confirmButton = {
                StyledButton(
                    modifier = Modifier,
                    onClick = {
                        onConfirm(textState.value)
                        showDialog.value = false
                        textState.value = ""
                    }
                ) {
                    Text("Подтвердить")
                }
            },
            dismissButton = {
                StyledButton(
                    modifier = Modifier,
                    onClick = {
                        showDialog.value = false
                        onDismiss()
                    }
                ) {
                    Text("Отмена")
                }
            },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
        )
    }
}