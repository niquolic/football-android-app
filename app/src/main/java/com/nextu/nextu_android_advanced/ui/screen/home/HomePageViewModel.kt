package com.nextu.nextu_android_advanced.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nextu.nextu_android_advanced.model.Category
import com.nextu.nextu_android_advanced.model.Product
import com.nextu.nextu_android_advanced.data.store.TeamsRepository
import com.nextu.nextu_android_advanced.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomePageViewModel(private val storeRepository: TeamsRepository) : ViewModel() {

    companion object {
        const val CATEGORY_ALL = "All"
    }

    private val _state = MutableStateFlow<HomePageState>(HomePageState())
    val state: StateFlow<HomePageState> = _state.asStateFlow()

    data class HomePageState(
        val teams: List<Team> = listOf(),
        val isLoading: Boolean = false,
    )

    fun loadTeams() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { state ->
                state.copy(
                    isLoading = true
                )
            }
            fetchAllTeams()
            _state.update { state ->
                state.copy(
                    isLoading = false
                )
            }
        }
    }


    private suspend fun fetchAllTeams() {
        val teamsRequest = storeRepository.getAllTeams()
        _state.update { state ->
            state.copy(
                teams = teamsRequest,
            )
        }
    }

}
