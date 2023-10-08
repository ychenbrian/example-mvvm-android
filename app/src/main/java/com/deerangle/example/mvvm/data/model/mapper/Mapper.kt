package com.deerangle.example.mvvm.data.model.mapper

interface Mapper<in A, out B> {
    fun map(input: A): B
}
