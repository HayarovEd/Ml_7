package com.kredit.onlain.merca.presentation

import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.kredit.onlain.merca.domain.model.StatusApplication.Connect
import com.kredit.onlain.merca.domain.model.StatusApplication.Info
import com.kredit.onlain.merca.domain.model.StatusApplication.Loading
import com.kredit.onlain.merca.domain.model.StatusApplication.Mock
import com.kredit.onlain.merca.domain.model.StatusApplication.NoConnect
import com.kredit.onlain.merca.domain.model.StatusApplication.Offer
import com.kredit.onlain.merca.domain.model.StatusApplication.Splash
import com.kredit.onlain.merca.domain.model.StatusApplication.Web
import com.kredit.onlain.merca.domain.model.basedto.BaseState
import com.kredit.onlain.merca.domain.model.basedto.BaseState.Loans
import org.zaim.na.kartu.polus.presentation.ConnectScreen
import org.zaim.na.kartu.polus.presentation.MainEvent.OnChangeBaseState
import org.zaim.na.kartu.polus.presentation.MainEvent.OnChangeStatusApplication
import org.zaim.na.kartu.polus.presentation.OfferScreen
import org.zaim.na.kartu.polus.presentation.WebViewScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Sample(
    viewModel: MainViewModel = hiltViewModel(),
) {

    val state = viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent
    val context = LocalContext.current

    val launcherMultiplePermissions = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissionsMap ->
        val areGranted = permissionsMap.values.reduce { acc, next -> acc && next }
        if (areGranted) {
           Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
        } else {
            //Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }
    val loanLazyState = rememberLazyListState()
    val creditLazyState = rememberLazyListState()
    val creditCardloanLazyState = rememberLazyListState()
    val debitCardLazyState = rememberLazyListState()
    val instalmentCardLazyState = rememberLazyListState()
    when (val currentState = state.value.statusApplication) {
        is Connect -> {
            ConnectScreen(
                baseState = currentState.baseState,
                db = state.value.dbData!!,
                onClickCards = { onEvent(
                    OnChangeBaseState(
                        Loans
                    )
                ) },
                onClickCredits = { onEvent(OnChangeBaseState(BaseState.Credits)) },
                onClickLoans = { onEvent(OnChangeBaseState(Loans)) },
                onClickRules = {
                    onEvent(
                        OnChangeStatusApplication(
                            Info(
                                currentBaseState = currentState.baseState,
                                content = state.value.dbData!!.appConfig.privacyPolicyHtml
                            )
                        )
                    )
                },
                loanLazyState = loanLazyState,
                creditLazyState = creditLazyState,
                creditCardloanLazyState = creditCardloanLazyState,
                debitCardLazyState = debitCardLazyState,
                instalmentCardLazyState = instalmentCardLazyState,
                creditCards = state.value.creditCards,
                debitCards = state.value.debitCards,
                installmentCards = state.value.installmentCards,
                onEvent = viewModel::onEvent
            )
        }

        Loading -> {
            LoadingScreen()
        }

        is Mock -> {
            NoInternetScreen(onEvent = viewModel::onEvent)
        }

        is Info -> {
        }

        is Offer -> {
            OfferScreen(
                elementOffer = (state.value.statusApplication as Offer).elementOffer,
                baseState = (state.value.statusApplication as Offer).currentBaseState,
                onEvent = viewModel::onEvent,
            )
        }

        is Web -> {
            WebViewScreen(
                url = currentState.url,
                offerName = currentState.offerName,
                onEvent = viewModel::onEvent,
            )
        }

        NoConnect -> {
            NoInternetScreen(onEvent = viewModel::onEvent)
        }

        Splash -> TODO()
    }

}