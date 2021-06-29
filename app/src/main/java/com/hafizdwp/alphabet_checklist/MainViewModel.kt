package com.hafizdwp.alphabet_checklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hafizdwp.alphabet_checklist.base.BaseViewModel
import com.hafizdwp.alphabet_checklist.data.Repository
import com.hafizdwp.alphabet_checklist.data.local.table.Hero
import kotlinx.coroutines.launch
import java.util.*

/**
 * @author hafizdwp
 * 29/06/2021
 **/
class MainViewModel(private val repository: Repository) : BaseViewModel() {

    companion object {
        val CHAR_INDEX: List<String> =
                "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",")
    }

    val sortedItems: LiveData<List<Item>>
        get() = _sortedItems

    private var _sortedItems = MutableLiveData<List<Item>>()


    fun addHero(name: String) = viewModelScope.launch {
        withDefault { repository.addHero(Hero(name)) }
        getHeroes()
    }

    fun getHeroes() = viewModelScope.launch {
        val heroes = withDefault { repository.getHeroes() }

        log("heroes: ${heroes.toJson()}")
        _sortedItems.value = withDefault { convertToSortedItems(heroes) }
        log("sortedHeroes: ${_sortedItems.value.toJson()}")
    }

    private fun convertToSortedItems(heroes: List<Hero>): List<Item> {
        val items = arrayListOf<Item>()

        heroes.forEach {
            val firstChar = it.name.substring(0, 1)
            val item = Item(
                    alphabet = firstChar.toUpperCase(Locale.ROOT),
                    text = it.name
            )

            items.add(item)
        }

        val sortedItems = items.sortedBy { it.text }

        for (index in CHAR_INDEX.indices) {
            log("CHAR: ${CHAR_INDEX[index]}")

            var found = false
            for (item in sortedItems) {
                if (item.alphabet == CHAR_INDEX[index]) {
                    log("item in LOOP CHAR [${CHAR_INDEX[index]}] : ${item.toJson()}")

                    if (found) item.alphabet = ""
                    else found = true
                }
            }
        }

        return sortedItems
    }
}