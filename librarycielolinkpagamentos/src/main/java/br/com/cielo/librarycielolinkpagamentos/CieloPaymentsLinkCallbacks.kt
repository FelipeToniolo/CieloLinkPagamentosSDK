package br.com.cielo.librarycielolinkpagamentos

import br.com.cielo.librarycielolinkpagamentos.models.paymentlink.Transaction

interface CieloPaymentsLinkCallbacks {
    fun onGetLink(link: Transaction)
    fun onError(error: String)
}