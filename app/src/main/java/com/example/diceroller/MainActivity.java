package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int numberGuessed;
    private int diceNum;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //final TextView tx = (TextView) findViewById(R.id.textView2);
        final EditText userNum = (EditText) findViewById(R.id.userNum);
        Button buttonNum = (Button) findViewById(R.id.button3);
        buttonNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    numberguesser(Integer.valueOf(userNum.getText().toString()));
                }catch(Exception e) {
                    numberguesser(0);
                }

            }
        });

        final TextView tv = (TextView)findViewById(R.id.textView);
        Button diceButton = (Button) findViewById(R.id.button);
        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(String.valueOf(rollDice()));
            }
        });
        //int num = 0;
        //int userscore = checkVals(num);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void feeling_lucky_button(View view){
        TextView tv = this.findViewById(R.id.textView);
        int num = rollDice();
        if (num == 1){
            tv.setText("If you could go anywhere in the world, where would you go?");
        }
        else if (num == 2){
            tv.setText("If you were stranded on a desert island, what three things would you want to take with you?");
        }
        else if (num == 3){
            tv.setText("If you could eat only one food for the rest of your life, what would that be?");
        }
        else if (num == 4){
            tv.setText("If you won a million dollars, what is the first thing you would buy?");
        }
        else if (num == 5){
            tv.setText("If you could spend the day with one fictional character, who would it be?");
        }
        else if (num == 6){
            tv.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
        }
    }

    public int rollDice(){
        Random r = new Random();
        int number = (r.nextInt(6))+1;
        diceNum = number;
        checkVals();
        return number;
    }

    public void numberguesser(int numbGuessed) {
        numberGuessed = numbGuessed;
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText("The number you've chosen is " +numberGuessed+ ", GOOD LUCK!!!");
    }

    public void checkVals() {
        if(numberGuessed == diceNum) {
            score++;
        }
        TextView tv =  this.findViewById(R.id.textView3);
        tv.setText("Your score is:" + String.valueOf(score));
    }

}
