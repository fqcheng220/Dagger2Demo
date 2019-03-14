package fqcheng220.dagger2demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import fqcheng220.dagger2demo.di.test.Friend
import fqcheng220.dagger2demo.di.test.Man
import fqcheng220.dagger2demo.di.test.Son
import fqcheng220.dagger2demo.utils.Logger

class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
