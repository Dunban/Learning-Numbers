package doubled.greenrivertech.net.learningnumbers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class NumberGame_Activity extends AppCompatActivity {

    Random rand = new Random();
    private Button leftbutton = (Button) findViewById(R.id.leftbutton);
    private Button rightbutton = (Button) findViewById(R.id.rightbutton);
    private Integer leftnum;
    private Integer rightnum;
    private Integer score = 0;
    private TextView scoreview = (TextView) findViewById(R.id.score);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        generate();
        scoreview.setText(score.toString());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_number_game, menu);
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

    public void checkanswer(View view)
    {
        if (view.getId() == leftbutton.getId())
        {
            if (leftnum > rightnum)
            {
                Toast.makeText(NumberGame_Activity.this, "You Got it right!",
                        Toast.LENGTH_SHORT).show();
                scoreview.setText(score);
            }
            else
            {
                Toast.makeText(NumberGame_Activity.this, "Sorry, you got it wrong.",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            if (rightnum > leftnum)
            {
                Toast.makeText(NumberGame_Activity.this, "You Got it right!",
                        Toast.LENGTH_SHORT).show();
                score++;
            }
            else
            {
                Toast.makeText(NumberGame_Activity.this, "Sorry, you got it wrong.",
                        Toast.LENGTH_SHORT).show();
            }
        }
        generate();
    }

    public void generate()
    {
        leftnum = rand.nextInt(10) + 1;
        rightnum = 0;
        while (rightnum == leftnum && rightnum == 0)
        {
            rightnum = rand.nextInt(10) + 1;
        }
        leftbutton.setText(leftnum.toString());
        rightbutton.setText(rightnum.toString());
    }
}
