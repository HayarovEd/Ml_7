package com.kredit.onlain.merca.data

import com.kredit.onlain.merca.domain.model.basedto.BaseDto
import retrofit2.http.GET

interface ApiServer {
    @GET ("524/db.json")
    suspend fun getDataDb () : BaseDto
}