package br.com.cielo.librarycielolinkpagamentos

interface CieloPaymentsLinkCallbacks {
    fun onGetLink(link: String)
    fun onError(error: String)
}