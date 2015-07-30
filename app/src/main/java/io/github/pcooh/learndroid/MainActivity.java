package io.github.pcooh.learndroid;

//import android.support.v7.app.ActionBarActivity;
// ↑deprecated なので↓recommended を使用
import android.support.v7.app.AppCompatActivity;//
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;//
import android.util.Log;//
import android.content.Intent;// ファイル ピッカー用
import android.net.Uri;// ファイル ピッカーの戻り実装で使用


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

    private static final int OPEN_DOCUMENT_REQUEST = 1; //メニュー用
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
        // File ... メニューを選択したとき
        else if (id == R.id.action_file) {
            // ファイル ピッカーを表示
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.setType("*/*");
            startActivityForResult(intent, OPEN_DOCUMENT_REQUEST);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(resultCode != RESULT_OK)
            return;
        else{
            switch (requestCode){
                case OPEN_DOCUMENT_REQUEST:
                    Uri url = data.getData();
                    TextView textView = (TextView) findViewById(R.id.textView);
                    Log.d(null, url.getPath());
                    textView.setText(url.getPath());
                    break;

                default :
                    break;
            }
        }
    }
}
