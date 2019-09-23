package br.com.cielo.cielolinkpagamentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cielo.librarycielolinkpagamentos.CieloPaymentsLinkCallbacks
import br.com.cielo.librarycielolinkpagamentos.CieloPaymentsLinkClient
import br.com.cielo.librarycielolinkpagamentos.models.paymentlink.CieloPaymentsLinkParameters
import br.com.cielo.librarycielolinkpagamentos.models.paymentlink.SaleType
import br.com.cielo.librarycielolinkpagamentos.service.Environment
import com.cielo.cielopaymentlinkclient.models.paymentlink.recurrent.RecurrentInterval
import com.cielo.cielopaymentlinkclient.models.paymentlink.shipping.ShippingType
import kotlinx.android.synthetic.main.kotlin_activity_main.*

class KotlinMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_activity_main)

        val paymentsLink = CieloPaymentsLinkClient(
            environment= Environment.SANDBOX,
            clientID = "SEUCLIENTID",
            clientSecret = "SEUCLIENTSECRET"
        )
        val parameters = CieloPaymentsLinkParameters(
            "Pedido", "4000", SaleType.DIGITAL, ShippingType.WITHOUTSHIPPING,
            "teste", "1000000000", recurrentInterval = RecurrentInterval.MONTHLY
        )

        val parameters2 = CieloPaymentsLinkParameters(
            "Pedido", "10000", SaleType.DIGITAL, ShippingType.WITHOUTSHIPPING,
            "teste", "1000000000"
        )


        paymentsLink.generateLink(parameters, object :
            CieloPaymentsLinkCallbacks {
            override fun onGetLink(link: String) {
                txt1kotlin.text = link
            }

            override fun onError(error: String) {
                txt1kotlin.text = "Deu pau $error"
            }
        })

        paymentsLink.generateLink(parameters2, object :
            CieloPaymentsLinkCallbacks {
            override fun onGetLink(link: String) {
                txt2kotlin.text = link
            }

            override fun onError(error: String) {
                txt2kotlin.text = "Deu pau $error"
            }
        })

    }
}
