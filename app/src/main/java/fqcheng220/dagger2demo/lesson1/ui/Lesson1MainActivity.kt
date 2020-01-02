package fqcheng220.dagger2demo.lesson1.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import fqcheng220.dagger2demo.R.layout
import fqcheng220.dagger2demo.lesson1.di.test.Friend
import fqcheng220.dagger2demo.lesson1.di.test.Man
import fqcheng220.dagger2demo.lesson1.di.test.Son
import fqcheng220.dagger2demo.utils.Logger

class Lesson1MainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_lesson1_main)

        testDagger2()
    }

    fun testDagger2(){
        Logger.d(TAG,"testDagger2 start")
        val man = Man()
        val manComponent = man.getmManComponet()
        val friend = Friend(manComponent)
        val son = Son(manComponent)
        val another = Son(manComponent, true)
        Logger.d(TAG,"testDagger2 end")
    }
}
