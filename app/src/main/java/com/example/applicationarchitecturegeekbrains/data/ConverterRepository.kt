package com.example.applicationarchitecturegeekbrains.data

import android.net.Uri
import io.reactivex.rxjava3.core.Single

interface ConverterRepository {
    fun convert(uri: Uri?): Single<String>
}
