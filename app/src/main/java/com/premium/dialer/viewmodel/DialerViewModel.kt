package com.premium.dialer.viewmodel

import androidx.lifecycle.ViewModel
import com.premium.dialer.data.FakeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class DialerUiState(val query: String = "")

class DialerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DialerUiState())
    val uiState: StateFlow<DialerUiState> = _uiState.asStateFlow()

    val contacts = FakeData.contacts
    val recents = FakeData.recents
    val history = FakeData.history

    fun onQueryChange(value: String) { _uiState.value = _uiState.value.copy(query = value) }
}
