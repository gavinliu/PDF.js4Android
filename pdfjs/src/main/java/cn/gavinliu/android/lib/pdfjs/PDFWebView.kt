package cn.gavinliu.android.lib.pdfjs

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.webkit.WebChromeClient
import android.webkit.WebView


class PDFWebView : WebView {

    private val PDFJS_ASSETS_PATH = "file:///android_asset/pdfjs-1.9.426-dist/web/viewer.html"

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun init() {
        val settings = settings
        settings.allowFileAccess = true
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.allowFileAccessFromFileURLs = true
        settings.allowUniversalAccessFromFileURLs = true
        webChromeClient = WebChromeClient()
    }

    fun loadFromFile(pdfFilePath: String) {
        loadUrl(PDFJS_ASSETS_PATH + "?file=file://" + Uri.encode(pdfFilePath, "UTF-8"))
    }

    fun loadFromAssets(pdfAssetsPath: String) {
        loadUrl(PDFJS_ASSETS_PATH + "?file=file:///android_asset/" + Uri.encode(pdfAssetsPath, "UTF-8"))
    }
}