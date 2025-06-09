package trier.hochschule.ema.compoundviews;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import trier.hochschule.ema.compoundviews.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // // // // // // // // // // // // // // // //

        binding.numPad.setScreen(binding.screen);

        binding.numPad.setButtons(
                binding.num0,
                binding.numPeriod,
                binding.num1,
                binding.num2,
                binding.num3,
                binding.num4,
                binding.num5,
                binding.num6,
                binding.num7,
                binding.num8,
                binding.num9
        );
    }
}