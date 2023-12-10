package com.expresspay.sdk.views.expresscardpay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import com.expresspay.sdk.databinding.ActivityExpressCardPayBinding
import com.expresspay.sdk.model.request.card.ExpresspayCard


class ExpressCardDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExpressCardPayBinding
    companion object{
        var amount:String = ""
        var currency:String = ""
        var onSubmitCardDetails:((ExpresspayCard) -> Unit)? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpressCardPayBinding.inflate(
            layoutInflater)
        setContentView(binding.root)

        loadFragment()
    }

    override fun onResume() {
        super.onResume()
        ExpressCardPay.shared()?._onPresent?.let { it(this) }
    }

    private fun loadFragment(){
        val fragment = ExpressCardDetailFragment(
            onSubmit = onSubmitCardDetails,
            amount = amount,
            currency = currency
        )
        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, fragment, fragment.javaClass.name)
            .commit()
    }
}