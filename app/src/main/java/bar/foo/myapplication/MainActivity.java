package bar.foo.myapplication;

import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;


public class MainActivity extends ActionBarActivity {

    private static final int STATUS_BAR_VISIBLE = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
    private static final int STATUS_BAR_HIDDEN = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            getWindow().getDecorView().setSystemUiVisibility(STATUS_BAR_VISIBLE);

            ((CompoundButton) findViewById(R.id.button)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        getWindow().getDecorView().setSystemUiVisibility(STATUS_BAR_HIDDEN);
                    } else {
                        getWindow().getDecorView().setSystemUiVisibility(STATUS_BAR_VISIBLE);
                    }
                }
            });
        }
    }
}
