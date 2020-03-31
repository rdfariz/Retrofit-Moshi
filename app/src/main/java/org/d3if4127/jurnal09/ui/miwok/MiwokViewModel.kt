package org.d3if4127.jurnal09.ui.miwok

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.d3if4127.jurnal09.network.MiwokApi
import org.d3if4127.jurnal09.network.MiwokData

class MiwokViewModel : ViewModel() {

    private val _items = MutableLiveData<List<MiwokData>>()
    val items : LiveData<List<MiwokData>> get() = _items

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> get() = _loading

    private val _response = MutableLiveData<String>()
    val response : LiveData<String> get() = _response

    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
        _response.value = ""
        initData()
    }

    private fun initData() {
        _loading.value = true
        crScope.launch{
            try{
                val result = MiwokApi.retrofitService.showList()
                if(result.size > 0) {
                    _items.value = result
                }else {
                    _response.value = "Data kosong"
                }
            }catch (t: Throwable){
                _response.value = "Tidak ada koneksi"
            }finally {
                _loading.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }

}