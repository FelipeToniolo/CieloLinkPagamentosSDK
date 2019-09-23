package br.com.cielo.librarycielolinkpagamentos.models

interface CieloPaymentsLinkCallbacks {
    fun onGetLink(link: String)
    fun onError(error: String)
}