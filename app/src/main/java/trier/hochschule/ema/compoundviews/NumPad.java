package trier.hochschule.ema.compoundviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NumPad extends LinearLayout implements View.OnClickListener {

    // The interface we have to implement
    public interface OnNumClickListener {
        public void onNumClick(View v, char num);
    }

    /// The buttons the NumPad owns
    List<Button> buttons = new ArrayList<>();
    ///
    OnNumClickListener onNumClickListener;
    /// The screen that the NumPad will write to
    TextView screen;

    public NumPad(Context context) {
        super(context);
    }

    public NumPad(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            screen.setText(((Button) v).getText());
        }
    }

    public void setButtons(Button... buttons) {
        this.buttons.clear();

        for (int i = 0; i < buttons.length; i++) {
            this.buttons.add(buttons[i]);
        }

        for (Button b : this.buttons) {
            // THIS NumPad class's OnClick() will be used for all buttons
            b.setOnClickListener(this);
        }
    }

    public void setScreen(TextView tv) {
        screen = tv;
    }
}
