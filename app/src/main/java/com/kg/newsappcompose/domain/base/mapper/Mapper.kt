package com.kg.newsappcompose.domain.base.mapper

import com.kg.newsappcompose.model.NewsModel

interface Mapper<in LeftObject, out RightObject> {

    fun mapLeftToRight(obj: NewsModel): RightObject

}