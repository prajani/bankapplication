package com.example.mlrit.bankapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
    Button b1,b2,b3,b4,b5;
    TextView tv1;
long Balance=100000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        tv1=(TextView)findViewById(R.id.tv1);

        et2.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
        b5.setVisibility(View.INVISIBLE);

        tv1.setVisibility(View.INVISIBLE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Pin=et1.getText().toString();
                et1.setText("");
                if(Pin.isEmpty()) {
                    et1.setError("Empty");
                }
                else
                {
                    int pin=Integer.parseInt(Pin);
                    if(pin==1234)
                    {
                        et2.setVisibility(View.VISIBLE);
                        b2.setVisibility(View.VISIBLE);
                        b3.setVisibility(View.VISIBLE);
                        b4.setVisibility(View.VISIBLE);
                        b5.setVisibility(View.VISIBLE);

                        tv1.setVisibility(View.VISIBLE);


                        b1.setVisibility(View.INVISIBLE);
                        et1.setVisibility(View.INVISIBLE);

                    }
                    else
                    {
                        et1.setError("Invalid Password");
                    }
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=et2.getText().toString();
                long amount=Long.parseLong(s1);
                if(amount>Balance)
                {
                    tv1.setText("No funds Available");
                } else if (amount % 100 == 0)
                {
                 Balance=Balance-amount;
                    tv1.setText(""+Balance);
                    //SmsManager sms=SmsManager.getDefault();
                    //sms.sendTextMessage("9440615699",null,"you have withdrawn:"+amount+"\n"+"Current balance is:"+Balance,null,null);
                }
                else
                {
                    tv1.setText("Invalid entry");
                }

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et2.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);
                b3.setVisibility(View.INVISIBLE);
                b4.setVisibility(View.INVISIBLE);
                b5.setVisibility(View.INVISIBLE);


                b1.setVisibility(View.VISIBLE);
                et1.setVisibility(View.VISIBLE);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2=et2.getText().toString();
                if(s2.isEmpty())
                {
                    et2.setError("Empty");
                }
               else
                {
                    long amount=Long.parseLong(s2);
                    Balance=Balance+amount;
                    tv1.setText(""+Balance);
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(""+Balance);
            }
        });






    }


}
