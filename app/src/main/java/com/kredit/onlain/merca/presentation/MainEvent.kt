package org.zaim.na.kartu.polus.presentation

import com.kredit.onlain.merca.domain.model.StatusApplication
import com.kredit.onlain.merca.domain.model.basedto.BaseState


sealed class MainEvent {
    object Reconnect: MainEvent()

    class OnChangeStatusApplication(val statusApplication: StatusApplication): MainEvent()
    class OnChangeBaseState(val baseState: BaseState): MainEvent()

    class OnGoToWeb(
        val urlOffer: String,
        val nameOffer: String
        ): MainEvent()
}
