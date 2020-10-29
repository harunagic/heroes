package com.heroes.app.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.google.gson.Gson

/**
 * Helper function to parse model to string & string to Model
 */
inline fun <reified T : Any> T.json(): String = Gson().toJson(this, T::class.java)
inline fun <reified T : Any> String.fromJson(): T = Gson().fromJson(this, T::class.java)

/**
 * Helper function to parse [TextWatcher.onTextChanged] event of [TextWatcher] only.
 * @receiver EditText
 * @param event (input: String) -> Unit
 */
inline fun EditText.onTextChange(crossinline event: (input: String) -> Unit) {
  addTextChangedListener(object : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
      // Left empty on purpose
    }

    override fun beforeTextChanged(
      s: CharSequence?,
      start: Int,
      count: Int,
      after: Int
    ) {
      // Left empty on purpose
    }

    override fun onTextChanged(
      s: CharSequence?,
      start: Int,
      before: Int,
      count: Int
    ) {
      val response = s?.toString() ?: ""
      event(response)
    }
  })
}