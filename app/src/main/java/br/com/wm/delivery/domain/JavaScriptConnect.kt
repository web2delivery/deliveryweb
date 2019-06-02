package br.com.wm.delivery.domain

import android.webkit.JavascriptInterface
import br.com.wm.delivery.MainActivity
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import java.lang.ref.WeakReference


class JavaScriptConnect(val weakActivity : WeakReference<MainActivity>) {

    companion object{
        @JvmField val INTERFACE_NAME = "AndroidInstance"
    }

    @JavascriptInterface
    fun reloadPage(){
        async(UI){
            weakActivity.get()?.loadPage()
        }
    }
}