package com.kredit.onlain.merca.data

import android.util.Log
import org.zaim.na.kartu.polus.domain.RepositoryServer
import javax.inject.Inject
import com.kredit.onlain.merca.domain.model.basedto.BaseDto
import com.kredit.onlain.merca.data.Resource.Error
import com.kredit.onlain.merca.data.Resource.Success

class RepositoryServerImpl @Inject constructor(
    private val apiServer: ApiServer
) : RepositoryServer {
    override suspend fun getDataDb(): Resource<BaseDto> {
        return try {
            val folder = apiServer.getDataDb()
            Log.d("DATADB", "dATA DB:${folder.loans.first().id}")
            Success(
                data = folder
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Error(e.message ?: "An unknown error")
        }
    }
}