package eu.tutorials.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private val recipeService: ApiService = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    private val _categorieState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categorieState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            _categorieState.value = _categorieState.value.copy(loading = true, error = null)
            try {
                val response = recipeService.getCategories() // This should work now
                _categorieState.value = _categorieState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = "Error fetching Categories: ${e.localizedMessage ?: e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}
