package me.bhauck.ttr_rechner
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager
import android.R.*
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.text.InputType
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.*
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.EditText
import android.text.InputFilter
import android.view.Gravity
import android.widget.TableLayout









class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageButton>(R.id.btn_clear_own_ttr).setOnClickListener(View.OnClickListener {
            findViewById<EditText>(R.id.edit_text_own_ttr).setText("")
            findViewById<EditText>(R.id.edit_text_own_ttr).requestFocus()

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        })

        findViewById<Button>(R.id.btn_add_op).setOnClickListener(View.OnClickListener {
            val scroll = findViewById<LinearLayout>(R.id.linearlayout_scroll) as LinearLayout
            scroll.addView(createRowOpponent())
        })



    }

    fun createRowOpponent(): LinearLayout {
        val row_linearlayout = LinearLayout(baseContext)

        var  param: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,dpToPx(40));
        row_linearlayout.layoutParams = param
        row_linearlayout.orientation = LinearLayout.HORIZONTAL

        val ttr = EditText(baseContext)
        ttr.inputType = InputType.TYPE_NUMBER_VARIATION_NORMAL
        ttr.setFilters(arrayOf<InputFilter>(InputFilter.LengthFilter(4)));
        ttr.setLayoutParams(LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 0.36f))
        ttr.setText("1496")
        ttr.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24.0f);
        ttr.setPadding(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8))
        ttr.gravity = Gravity.CENTER_VERTICAL

        row_linearlayout.addView(ttr)
        return row_linearlayout
    }

    fun dpToPx(dp: Int): Int {
        val px = (dp * Resources.getSystem().getDisplayMetrics().density) as Float
        return px.toInt()
    }
}
