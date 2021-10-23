package mx.tecnm.tepic.ladm_u2_practica1_diademuertos

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Imagen(l:lienzo, posX: Float, posY: Float, img: Int) {

    var x = posX
    var y = posY
    var imaged = BitmapFactory.decodeResource(l.resources, img)
    var imagen= Bitmap.createScaledBitmap(imaged,200,200,true)

    fun pintar(c: Canvas) {
        c.drawBitmap(imagen, x, y, Paint())
    }
    fun mover(toqueX: Float, toqueY: Float){
        x=toqueX
        y=toqueY
    }

}