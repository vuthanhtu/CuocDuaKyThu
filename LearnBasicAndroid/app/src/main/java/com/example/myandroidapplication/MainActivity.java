package com.example.myandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CheckBox cbOne,cbTwo,cbThree;
    SeekBar sbOne,sbTwo,sbThree;
    TextView tvScore;
    Button btnStart;
    int score = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        tvScore.setText(Integer.toString(score));
        CountDownTimer countDownTimer = new CountDownTimer(60000,200) {
            @Override
            public void onTick(long l) {
                Random rand = new Random();
                int number1 = rand.nextInt(5);
                int number2 = rand.nextInt(5);
                int number3 = rand.nextInt(5);
                if(sbOne.getProgress()>=sbOne.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"ONE WIN",Toast.LENGTH_LONG).show();
                    if(cbOne.isChecked()){
                        score +=10;
                        Toast.makeText(MainActivity.this, "Bạn đoán đúng rồi", Toast.LENGTH_SHORT).show();
                        cbOne.setChecked(false);
                    }
                    else{
                        score-=5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    if(score>=0){
                        tvScore.setText(Integer.toString(score));
                    }
                    else{
                        tvScore.setText(Integer.toString(0));
                        Toast.makeText(MainActivity.this,"Bạn không được phép chơi nữa",Toast.LENGTH_SHORT).show();
                    }
                    //tvScore.setText(Integer.toString(score));
                    btnStart.setVisibility(View.VISIBLE);
                    Enable();
                    setFalseCheckedCheckBox();
                }
                if(sbTwo.getProgress()>=sbTwo.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"TWO WIN",Toast.LENGTH_LONG).show();
                    btnStart.setVisibility(View.VISIBLE);
                    if(cbTwo.isChecked()){
                        score +=10;
                        Toast.makeText(MainActivity.this, "Bạn đoán đúng rồi", Toast.LENGTH_SHORT).show();
                        cbTwo.setChecked(false);
                    }
                    else{
                        score-=5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    if(score>=0){
                        tvScore.setText(Integer.toString(score));
                    }
                    else{
                        tvScore.setText(Integer.toString(0));
                        Toast.makeText(MainActivity.this,"Bạn không được phép chơi nữa",Toast.LENGTH_SHORT).show();
                    }
                    Enable();
                    setFalseCheckedCheckBox();
                }
                if(sbThree.getProgress()>=sbThree.getMax()){

                    this.cancel();
                    Toast.makeText(MainActivity.this,"THREE WIN",Toast.LENGTH_LONG).show();
                    if(cbThree.isChecked()){
                        score +=10;
                        Toast.makeText(MainActivity.this, "Bạn đoán đúng rồi", Toast.LENGTH_SHORT).show();
                        cbThree.setChecked(false);
                    }
                    else{
                        score-=5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    if(score>=0){
                        tvScore.setText(Integer.toString(score));
                    }
                    else{
                        tvScore.setText(Integer.toString(0));
                        Toast.makeText(MainActivity.this,"Bạn không được phép chơi nữa",Toast.LENGTH_SHORT).show();
                    }
                    btnStart.setVisibility(View.VISIBLE);
                    Enable();
                    setFalseCheckedCheckBox();
                }
                sbOne.setProgress(sbOne.getProgress()+number1);
                sbTwo.setProgress(sbTwo.getProgress()+number2);
                sbThree.setProgress(sbThree.getProgress()+number3);
            }

            @Override
            public void onFinish() {

            }
        };
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score>=0){
                    if(cbOne.isChecked()||cbTwo.isChecked()||cbThree.isChecked()){
                        sbOne.setProgress(0);
                        sbTwo.setProgress(0);
                        sbThree.setProgress(0);

                        btnStart.setVisibility(View.INVISIBLE);
                        countDownTimer.start();
                        Disable();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Vui lòng đặt cược",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Bạn không được phép chơi nữa!!!",Toast.LENGTH_SHORT).show();
                    btnStart.setEnabled(false);
                    Disable();
                }
            }
        });
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });
    }
    private void AnhXa(){
        cbOne = (CheckBox) findViewById(R.id.checkBox1);
        cbTwo = (CheckBox) findViewById(R.id.checkBox2);
        cbThree = (CheckBox) findViewById(R.id.checkBox3);
        sbOne = (SeekBar) findViewById(R.id.seekBar1);
        sbTwo = (SeekBar) findViewById(R.id.seekBar2);
        sbThree = (SeekBar) findViewById(R.id.seekBar3);
        tvScore = (TextView) findViewById(R.id.idTVScore);
        btnStart = (Button) findViewById(R.id.btnStart);
    }
    private void Enable(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
        sbOne.setEnabled(true);
        sbTwo.setEnabled(true);
        sbThree.setEnabled(true);

    }
    private void Disable(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
        sbOne.setEnabled(false);
        sbTwo.setEnabled(false);
        sbThree.setEnabled(false);
    }
    private void setFalseCheckedCheckBox(){
        cbOne.setChecked(false);
        cbTwo.setChecked(false);
        cbThree.setChecked(false);
    }
}