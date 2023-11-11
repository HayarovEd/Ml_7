package com.kredit.onlain.merca.domain.model

import com.kredit.onlain.merca.domain.model.ElementOffer
import com.kredit.onlain.merca.domain.model.basedto.BaseState

sealed class StatusApplication {
    object Loading: StatusApplication()
    object Mock : StatusApplication()
    class Connect (val baseState: BaseState): StatusApplication()

    class Offer (
        val currentBaseState: BaseState,
        val elementOffer: ElementOffer
        ): StatusApplication()

    class Info (
        val currentBaseState: BaseState,
        val content: String
        ): StatusApplication()

    class Web (
        val url: String,
        val offerName: String
    ): StatusApplication()

    object NoConnect: StatusApplication()
}
