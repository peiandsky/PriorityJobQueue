package com.saianfu.hxaf.priorityjobqueue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saianfu.hxaf.priorityjobqueue.base.BaseJob
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGo.setOnClickListener {

            val list = mutableListOf<BaseJob>()
            for (i in 1..100) {
                val job = TestJob(i)
                list.add(job)
                App.getInstance().jobManager.addJobInBackground(job)
            }

        }
    }
}
