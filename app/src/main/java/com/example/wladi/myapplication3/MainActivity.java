package com.example.wladi.myapplication3;

import android.content.ContextWrapper;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int number = 0;

    static final String KEY_NUBMER = "number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Закомментирован обработчик события OnClick для кнопки
        // у меня он реализован прямым указанием обработчика в xml

//        Button btn = (Button)findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Hello world", Toast.LENGTH_SHORT).show();
//                //OnButtonClick(v);
//                TextView view = (TextView)findViewById(R.id.textView);
//                view.setText("dsad");
//
//            }
//
//
//        });

        EditText etext = (EditText)findViewById(R.id.editText);

        // Слушатель "при изменении текста" для поля ввода
        // аналогичного события поля ввода не нашел
        etext.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
                // Прописываем то, что надо выполнить после изменения текста
                ReCalc();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        if (savedInstanceState != null){
            number = savedInstanceState.getInt(KEY_NUBMER);
            ShowText();
            //Toast.makeText()
        }

        Log.i("d2", "onCreate");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putInt(KEY_NUBMER, number);
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        Log.i("d2", "onStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        Log.i("d2", "onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i("d2", "onPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i("d2", "onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i("d2", "onDestroy");
    }

    public void OnButtonClick_Plus(View v) {
        number++;

        ShowText();
        ReCalc();
    }

    public void OnButtonClick_Minus(View v) {
        number--;
        if (number < 0)
        {
            number = 0;
        }

        ShowText();
        ReCalc();
    }

    public void OnButtonClick_Calc(View v) {
        ReCalc();
    }

    public void ShowText()
    {
        Toast.makeText(getApplicationContext(), " " + number, Toast.LENGTH_SHORT).show();
        TextView view = (TextView)findViewById(R.id.textView2);
        view.setText(" " + number);
    }

    public void ReCalc()
    {
        TextView view = (TextView)findViewById(R.id.textView);
        EditText etext = (EditText)findViewById(R.id.editText);

        String s_numb2 = etext.getText().toString();

        try {
            int num2 = Integer.parseInt(s_numb2);
            view.setText(" " + (number * num2));
        }
        catch (NumberFormatException e) {
            view.setText("error");
        }
    }
}
