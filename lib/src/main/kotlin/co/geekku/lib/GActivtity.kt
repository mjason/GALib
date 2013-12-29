package co.geekku.lib

import android.app.Activity
import android.view.View
import android.os.AsyncTask

/**
 * Created by mj on 13-12-29.
 */

open class GActivity : Activity() {

    fun Int.view<T : View>(): T? {
        return findViewById(this) as T?
    }

    fun getSystemServiceAs<T>(name: String) = this.getSystemService(name) as T

}