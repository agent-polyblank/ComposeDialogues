package com.example.composedialogues.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SimpleAlertDialogWithReturnCallback(
    show: Boolean,
    onDismiss: () -> Unit,
    onSubmit: (String) -> Unit
) {
    // can be changed to reflect desired behavior
    var textFieldValue by remember { mutableStateOf("reee") }

    if (show) {
        AlertDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(onClick = { onSubmit(textFieldValue) })
                { Text(text = "OK") }
            },
            dismissButton = {
                TextButton(onClick = onDismiss)
                { Text(text = "Cancel") }
            },
            title = { Text(text = "Confirm?") },
            text = { Text(text = "Continue with some action?") }
        )
    }
}