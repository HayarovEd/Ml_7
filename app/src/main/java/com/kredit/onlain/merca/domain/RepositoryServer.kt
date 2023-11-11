package org.zaim.na.kartu.polus.domain

import com.kredit.onlain.merca.data.Resource
import com.kredit.onlain.merca.domain.model.basedto.BaseDto

interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseDto>
}