package mx.tecnm.tepic.ladm_u2_practica1_diademuertos

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.media.MediaPlayer
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import java.util.*
import kotlin.random.Random

class lienzo(p:MainActivity): View(p) {

    val prin = p
    val mp = MediaPlayer.create(p, R.raw.skeleton)
    var arena = BitmapFactory.decodeResource(prin.resources,R.drawable.arena)
    var tumbas = BitmapFactory.decodeResource(prin.resources,R.drawable.tumbas1)
    var estrellas = BitmapFactory.decodeResource(prin.resources,R.drawable.stars)
    var tumba1 = BitmapFactory.decodeResource(prin.resources,R.drawable.tumba1)
    var tumba2 = BitmapFactory.decodeResource(prin.resources,R.drawable.tumba21)
    var tumba3 = BitmapFactory.decodeResource(prin.resources,R.drawable.tumba31)
    var esqX = 20f
    var esqY = 1050f
    var ince = 0
    var may = true
    var esq = Imagen(this,20f,1050f,R.drawable.skeletons)
    //var tumba5 = BitmapFactory.decodeResource(prin.resources,R.drawable.tumba5)


    //Timer
    val timer= object: CountDownTimer(60000,1){
        override fun onTick(p0: Long) {
            if(may){
                esqY=esqY-3
                ince++}else{
                esqY=esqY+3
                ince--}

            if(ince==70){
                may=false}
            if(ince==0){
                if (Random.nextBoolean()) {
                    if (Random.nextBoolean()) {
                        esqX = 0f
                    } else {
                        esqX = 20f
                    }
                    esqY = 1050f
                    ince = 0
                }
                if (Random.nextBoolean()) {
                    if (Random.nextBoolean()) {
                        esqX = 0f
                    } else {
                        esqX = 400f
                    }
                    esqY = 1050f
                    ince = 0
                }
                if (Random.nextBoolean()) {
                    if (Random.nextBoolean()) {
                        esqX = 600f
                    } else {
                        esqX = 790f
                    }
                    esqY = 1050f
                    ince = 0
                }
                may=true
            }
            esq.mover(esqX,esqY)
            invalidate()
        }

        override fun onFinish() {
            start()
        }

    }

    init {
        mp.start()
        timer.start()
    }

    //Canvas
    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        var p = Paint()

        //Fondo
        c.drawColor(Color.rgb(37,40,80))
        c.drawBitmap(estrellas,0f,0f,p)
        c.drawBitmap(arena,0f,1100f,p)
        c.drawBitmap(tumbas,0f,880f,p)

        c.drawBitmap(tumba1,20f,1050f,p)
        c.drawBitmap(tumba3,400f,1050f,p)
        c.drawBitmap(tumba2,790f,1050f,p)
        esq.pintar(c)

    }

}