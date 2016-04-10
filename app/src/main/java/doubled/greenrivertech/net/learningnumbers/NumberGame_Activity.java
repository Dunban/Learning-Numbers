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

import org.w3c.dom.Text;

import java.util.Random;

public class NumberGame_Activity extends AppCompatActivity
{
    NumberModal modal = new NumberModal();
    private TextView score;
    private Button left;
    private Button right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        score = (TextView) findViewById(R.id.score);
        left = (Button) findViewById(R.id.leftbutton);
        right = (Button) findViewById(R.id.rightbutton);
        score.setText(modal.getScore() + "");
        left.setText(modal.getLeftnum() + "");
        right.setText(modal.getRightnum() + "");

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
        if (view.getId() == left.getId())
        {
            if (modal.play(0))
            {
                Toast.makeText(NumberGame_Activity.this, "You got it right!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(NumberGame_Activity.this, "Sorry, you got it wrong.", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            if (modal.play(1))
            {
                Toast.makeText(NumberGame_Activity.this, "You got it right!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(NumberGame_Activity.this, "Sorry, you got it wrong.", Toast.LENGTH_SHORT).show();
            }
        }
        modal.generate();
        score.setText(modal.getScore() + "");
        left.setText(modal.getLeftnum() + "");
        right.setText(modal.getRightnum() + "");
    }
}
