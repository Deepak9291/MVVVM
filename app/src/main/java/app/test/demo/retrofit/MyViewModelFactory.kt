package app.test.demo.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.test.demo.repository.MainRepository
import app.test.demo.viewmodel.MainViewModel

class MyViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}