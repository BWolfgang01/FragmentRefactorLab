package edu.temple.fragmentrefactor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val textViewKey = "displayTextView"
private const val editTextKey = "nameEditText"
private const val buttonKey = "changeButton"

class ActivityFragment : Fragment() {
    private lateinit var textViewParam: TextView
    private lateinit var editTextParam: EditText
    private lateinit var buttonParam: Button
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_activity, container, false)
        textViewParam = view.findViewById<TextView>(R.id.displayTextView)
        editTextParam = view.findViewById<EditText>(R.id.nameEditText)
        buttonParam = view.findViewById<Button>(R.id.changeButton)
        view.apply {
            buttonParam.setOnClickListener {
                val name = editTextParam.text

                textViewParam.text = if (name.isNotBlank()) {
                    "Hello, $name!"
                } else {
                    "Please enter your name"
                }
            }
        }
        return view
    }

}