package com.softcat.vktest.presentation.pokemonList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softcat.vktest.domain.useCases.GetPokemonFlowUseCase
import com.softcat.vktest.domain.useCases.LoadPokemonsUseCase
import com.softcat.vktest.presentation.extensions.mergeWith
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonsViewModel @Inject constructor(
    private val loadPokemonsUseCase: LoadPokemonsUseCase,
    getPokemonFlowUseCase: GetPokemonFlowUseCase
): ViewModel() {

    private val stateUpdate = MutableSharedFlow<PokemonsScreenState>()

    val state = getPokemonFlowUseCase()
        .map { PokemonsScreenState.Content(it) as PokemonsScreenState }
        .onStart { emit(PokemonsScreenState.Initial) }
        .mergeWith(stateUpdate)

    fun loadPokemonsPage() {
        viewModelScope.launch {
            loadPokemonsUseCase()
        }
    }
}