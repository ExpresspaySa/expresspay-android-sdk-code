/*
 * Property of Expresspay (https://expresspay.sa).
 */

package com.expresspay.sample.app

import android.app.Application
import android.content.pm.ApplicationInfo
import android.webkit.WebView
import com.expresspay.sdk.core.ExpresspaySdk
import io.kimo.lib.faker.Faker


class ExpresspayApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Faker.with(this)
        ExpresspaySdk.init(
            this,
            MERCHANT_KEY,
            MERCHANT_PASSWORD,
            EXPRESSPAY_PAYMENT_URL
        )

        if (0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
    }
}
