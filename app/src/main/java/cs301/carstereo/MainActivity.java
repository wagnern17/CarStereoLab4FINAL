package cs301.carstereo;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, View.OnLongClickListener  {

    private ToggleButton powerButton;
    private Button presetBut1;
    private Button presetBut2;
    private Button presetBut3;
    private Button presetBut4;
    private Button presetBut5;
    private Button presetBut6;
    private Button volButUp;
    private Button volButDown;
    private Button seekUp;
    private Button seekDown;
    private TextView radioTxt;
    private TextView volPosTxt;
    private TextView volNegTxt;
    private Switch amFmSwitch;
    private boolean isFM;
    private int AM;
    private int FM;
    private double dFM;
    private int[] presetFM;
    private int[] presetAM;
    private TextView reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        powerButton = (ToggleButton) findViewById(R.id.powerButton);
        presetBut1 = (Button) findViewById(R.id.preset1);
        presetBut2 = (Button) findViewById(R.id.preset2);
        presetBut3 = (Button) findViewById(R.id.preset3);
        presetBut4 = (Button) findViewById(R.id.preset4);
        presetBut5 = (Button) findViewById(R.id.preset5);
        presetBut6 = (Button) findViewById(R.id.preset6);
        volButUp = (Button) findViewById(R.id.volUpButton);
        volButDown = (Button) findViewById(R.id.volDownButton);
        radioTxt = (TextView) findViewById(R.id.radioText);
        volPosTxt = (TextView) findViewById(R.id.volPos);
        volNegTxt = (TextView) findViewById(R.id.volNeg);
        seekUp = (Button) findViewById(R.id.seekUp);
        seekDown = (Button) findViewById(R.id.seekDown);
        amFmSwitch = (Switch) findViewById(R.id.amFmSwitch);
        reset = (TextView) findViewById(R.id.reset);

        powerButton.setOnClickListener(this);
        amFmSwitch.setOnClickListener(this);
        seekUp.setOnClickListener(this);
        seekDown.setOnClickListener(this);
        presetBut1.setOnClickListener(this);
        presetBut2.setOnClickListener(this);
        presetBut3.setOnClickListener(this);
        presetBut4.setOnClickListener(this);
        presetBut5.setOnClickListener(this);
        presetBut6.setOnClickListener(this);
        presetBut1.setOnLongClickListener(this);
        presetBut2.setOnLongClickListener(this);
        presetBut3.setOnLongClickListener(this);
        presetBut4.setOnLongClickListener(this);
        presetBut5.setOnLongClickListener(this);
        presetBut6.setOnLongClickListener(this);


        AM = 530;
        FM = 881;
        dFM = 88.1;
        presetFM = new int[] {909, 929, 949, 969, 989, 1009};
        presetAM = new int[] {550, 600, 650, 700, 750, 800};
        radioTxt.setText(Integer.toString(AM) + "kHz");
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

    @Override
    public void onClick(View v) {
        if(v==powerButton) {
            if(powerButton.isChecked()){
                presetBut1.setBackgroundColor(Color.WHITE);
                presetBut2.setBackgroundColor(Color.WHITE);
                presetBut3.setBackgroundColor(Color.WHITE);
                presetBut4.setBackgroundColor(Color.WHITE);
                presetBut5.setBackgroundColor(Color.WHITE);
                presetBut6.setBackgroundColor(Color.WHITE);
                volButUp.setBackgroundColor(Color.WHITE);
                volButDown.setBackgroundColor(Color.WHITE);
                radioTxt.setBackgroundColor(Color.WHITE);
                volPosTxt.setBackgroundColor(Color.WHITE);
                volNegTxt.setBackgroundColor(Color.WHITE);
                seekDown.setBackgroundColor(Color.WHITE);
                seekUp.setBackgroundColor(Color.WHITE);
            }
            else {
                presetBut1.setBackgroundColor(Color.BLACK);
                presetBut2.setBackgroundColor(Color.BLACK);
                presetBut3.setBackgroundColor(Color.BLACK);
                presetBut4.setBackgroundColor(Color.BLACK);
                presetBut5.setBackgroundColor(Color.BLACK);
                presetBut6.setBackgroundColor(Color.BLACK);
                volButUp.setBackgroundColor(Color.BLACK);
                volButDown.setBackgroundColor(Color.BLACK);
                radioTxt.setBackgroundColor(Color.BLACK);
                volPosTxt.setBackgroundColor(Color.BLACK);
                volNegTxt.setBackgroundColor(Color.BLACK);
                seekDown.setBackgroundColor(Color.BLACK);
                seekUp.setBackgroundColor(Color.BLACK);
                reset.setBackgroundColor(Color.BLACK);
            }
        }
        if (powerButton.isChecked()) {
            if (v == amFmSwitch) {
                if (amFmSwitch.isChecked()) {
                    isFM = true;
                    radioTxt.setText(Double.toString(dFM) + " MHz");
                } else {
                    isFM = false;
                    radioTxt.setText(Integer.toString(AM) + " kHz");
                }
            }
            if (v == seekUp) {
                if (isFM) {
                    if (FM == 1079) {
                        FM = 881;
                    } else {
                        FM = FM + 2;
                    }
                    dFM = ((double) FM) / 10.0;
                    radioTxt.setText(Double.toString(dFM) + " MHz");
                } else {
                    if (AM == 1700) {
                        AM = 530;
                    } else {
                        AM = AM + 10;
                    }
                    radioTxt.setText(Integer.toString(AM) + " kHz");
                }
            }
            if (v == seekDown) {
                if (isFM) {
                    if (FM == 881) {
                        FM = 1079;
                    } else {
                        FM = FM - 2;
                    }
                    dFM = ((double) FM) / 10.0;
                    radioTxt.setText(Double.toString(dFM) + " MHz");
                } else {
                    if (AM == 530) {
                        AM = 1700;
                    } else {
                        AM = AM - 10;
                    }
                    radioTxt.setText(Integer.toString(AM) + " kHz");
                }
            }
            if (v == presetBut1) {
                if(isFM) {
                    FM = presetFM[0];
                    dFM = ((double) presetFM[0])/10.0;
                    radioTxt.setText(Double.toString(dFM) + " MHz");
                } else {
                    AM = presetAM[0];
                    radioTxt.setText(Integer.toString(AM) + " kHz");
                }
            }
            if (v == presetBut2) {
                if(isFM) {
                    FM = presetFM[1];
                    dFM = ((double) presetFM[1])/10.0;
                    radioTxt.setText(Double.toString(dFM) + " MHz");
                } else {
                    AM = presetAM[1];
                    radioTxt.setText(Integer.toString(AM) + " kHz");
                }
            }
            if (v == presetBut3) {
                if(isFM) {
                    FM = presetFM[2];
                    dFM = ((double) presetFM[2])/10.0;
                    radioTxt.setText(Double.toString(dFM) + " MHz");
                } else {
                    AM = presetAM[2];
                    radioTxt.setText(Integer.toString(AM) + " kHz");
                }
            }
            if (v == presetBut4) {
                if(isFM) {
                    FM = presetFM[3];
                    dFM = ((double) presetFM[3])/10.0;
                    radioTxt.setText(Double.toString(dFM) + " MHz");
                } else {
                    AM = presetAM[3];
                    radioTxt.setText(Integer.toString(AM) + " kHz");
                }
            }
            if (v == presetBut5) {
                if(isFM) {
                    FM = presetFM[4];
                    dFM = ((double) presetFM[4])/10.0;
                    radioTxt.setText(Double.toString(dFM) + " MHz");
                } else {
                    AM = presetAM[4];
                    radioTxt.setText(Integer.toString(AM) + " kHz");
                }
            }
            if (v == presetBut6) {
                if(isFM) {
                    FM = presetFM[5];
                    dFM = ((double) presetFM[5])/10.0;
                    radioTxt.setText(Double.toString(dFM) + " MHz");
                } else {
                    AM = presetAM[5];
                    radioTxt.setText(Integer.toString(AM) + " kHz");
                }
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v==presetBut1) {
            if(isFM){
                presetFM[0] = FM;
            }
            else {
                presetAM[0] = AM;
            }
            reset.setBackgroundColor(Color.RED);
        }
        if (v==presetBut2) {
            if(isFM){
                presetFM[1] = FM;
            }
            else {
                presetAM[1] = AM;
            }
            reset.setBackgroundColor(Color.RED);
        }
        if (v==presetBut3) {
            if(isFM){
                presetFM[2] = FM;
            }
            else {
                presetAM[2] = AM;
            }
            reset.setBackgroundColor(Color.RED);
        }
        if (v==presetBut4) {
            if(isFM){
                presetFM[3] = FM;
            }
            else {
                presetAM[3] = AM;
            }
            reset.setBackgroundColor(Color.RED);
        }
        if (v==presetBut5) {
            if(isFM){
                presetFM[4] = FM;
            }
            else {
                presetAM[4] = AM;
            }
            reset.setBackgroundColor(Color.RED);
        }
        if (v==presetBut6) {
            if(isFM){
                presetFM[5] = FM;
            }
            else {
                presetAM[5] = AM;
            }
            reset.setBackgroundColor(Color.RED);
        }
        return false;
    }
}