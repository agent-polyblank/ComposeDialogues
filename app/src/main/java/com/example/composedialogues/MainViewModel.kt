package com.example.composedialogues

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel:ViewModel() {
    // Initial value is false so the dialog is hidden
    private val _showDialog = MutableStateFlow(false)
    val showDialog: StateFlow<Boolean> = _showDialog.asStateFlow()

    private val value: MutableState<String> = mutableStateOf("")

    fun onOpenDialogClicked() {
        _showDialog.value = true
    }

    fun onDialogueSubmit(value:String) {
        _showDialog.value = false
        this.value.value = value
    }

    fun onDialogDismiss() {
        _showDialog.value = false
    }

}