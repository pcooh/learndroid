package io.github.pcooh.learndroid;

//import android.support.v7.app.ActionBarActivity;
// ↑deprecated なので↓recommended を使用
import android.support.v7.app.AppCompatActivity;//
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;//
import android.util.Log;//



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //<!-- リソースから取得した String を TextView に設定
        try {
            String msg = getString(R.string.message);
            TextView textView = (TextView) findViewById(R.id.textView);

            Log.d(null, msg);
            textView.setText(msg);
        } catch (NullPointerException e) {
            Log.e(null, e.toString());
        }
        //-->
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
}
