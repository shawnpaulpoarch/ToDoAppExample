package com.example.todoappexample;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
/*
Compile time -> handled while the code is building
Runtime -> handled while the code is running

 OOP -> Object Orientated Programming
 Polymorphism ->
            taking many forms
            overloading ->
                compile time
                two or more methods of the same name, but different parameters
            overriding ->
                runtime
                pulling methods from the parent class/interface
 Abstraction -> only showing the needed functionality
 Inheritance -> one class derives from another class
 Encapsulation ->
            hiding the data
            variable are private
            methods are public
            getters and setters

 Visibility Modifiers
 - public -> everything can see
 - private -> only visible within the class
 - protected -> only visible to its children
 */
public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    // Global Variables
    EditText etInput;
    Button btnSubmit;
    ListView lvTodos;
    ImageButton ibtnPlus;
    TextView tvMiddleText;
    // adapter -> layout
    ArrayAdapter<String> lvAdapter;
    String displayText;
    final String KEY = "keykeykey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_layout);

        etInput = findViewById(R.id.et_input);
        btnSubmit = findViewById(R.id.btn_submit);
        lvTodos = findViewById(R.id.lv_todos);
        ibtnPlus = findViewById(R.id.ibtn_plus);
        tvMiddleText = findViewById(R.id.tv_middle_text);

        if (savedInstanceState != null) {
            displayText = savedInstanceState.getString(KEY);
            tvMiddleText.setText(displayText);
        }

        // Context and the ID of the layout
        // Context -> current state of our application
        lvAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvTodos.setAdapter(lvAdapter);
        btnSubmit.setOnClickListener(this);

        ibtnPlus.setOnClickListener(view -> {
            tvMiddleText.setText(etInput.getText().toString());
            etInput.getText().clear();
        });
    }

    @Override
    public void onClick(View view) {
        String newInput = etInput.getText().toString();
//        String value = "value";
//        addNewTodo(value);
        //== vs ===
        // == -> check the value
        // === -> check the references
        if (newInput.equals("")) {
            Toast.makeText(this, "Input cannot be empty!!", Toast.LENGTH_LONG).show();
        } else {
            addNewTodo(newInput);
        }
    }

    private void addNewTodo(String input) {
        lvAdapter.add(input);
        etInput.getText().clear();
    }

    @Override // overriding
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // not lifecycle aware
        outState.putString(KEY, tvMiddleText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        displayText = savedInstanceState.getString(KEY);
    }
}