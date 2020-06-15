package ru.int24.cripto
// Идентификатор приложения: ca-app-pub-5883364410511588~9149079861
// banner ca-app-pub-5883364410511588/2200528137
// InnerNout  ca-app-pub-5883364410511588/4040223419


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import ru.int24.cripto.activities.AboutActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) {}
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        for (n in 0..10){
            Log.d("Mylog", "N is $n")
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.action_about -> {

                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showAd(){
        if (mInterstitialAd.isLoaded)
            mInterstitialAd.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        showAd()
        //Toast.makeText(getApplicationContext(), "Nout", Toast.LENGTH_SHORT).show()
    }
}