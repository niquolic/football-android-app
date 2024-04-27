package com.nextu.nextu_android_advanced.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nextu.nextu_android_advanced.data.store.TeamsRepository
import com.nextu.nextu_android_advanced.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TeamDetailViewModel(private val teamsRepository: TeamsRepository) : ViewModel() {

    private val _state = MutableStateFlow<ProductPageState>(ProductPageState())
    val state: StateFlow<ProductPageState> = _state.asStateFlow()

    data class ProductPageState(
        val team: List<Team>? = null,
        val isLoading: Boolean = false,
    )

    fun loadTeam (id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { state ->
                state.copy(
                    isLoading = true
                )
            }
            fetchTeam(id)
            _state.update { state ->
                state.copy(
                    isLoading = false
                )
            }
        }
    }

    private suspend fun fetchTeam(id: String) {
        val teamRequest = teamsRepository.getTeamById(id)
        _state.update { state ->
            state.copy(
                team = teamRequest,
            )
        }
    }

}