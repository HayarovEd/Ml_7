package com.kredit.onlain.merca.presentation

import com.kredit.onlain.merca.domain.model.StatusApplication
import com.kredit.onlain.merca.domain.model.basedto.BaseDto


data class MainState(
    val instanceIdMyTracker: String? = null,
    val fireBaseToken: String? = null,
    val gaid: String? = null,
    val message: String = "",
    val affsub1Unswer: String = "",
    val affsub2Unswer: String = "",
    val affsub2UnswerAF: String = "",
    val affsub2UnswerMT: String = "",
    val affsub2UnswerEmpty: String = "",
    val affsub3Unswer: String = "",
    val affsub5Unswer: String = "",
    val dbData: BaseDto? = null,
    val statusApplication: StatusApplication = StatusApplication.Splash/*Web(url = "https://ya.ru/", offerName = "Offer")*/,
)
