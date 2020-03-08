package com.blogspot.soloinformaticayalgomas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.Random;

/**
 *
 * @author Daniel Alvarez
 */
public class Sprite {

    private int x;          // posicion en el eje X
    private int y;          // posicion en el eje Y
    private int ancho;      // ancho del sprite
    private int alto;       // alto del sprite
    private int fila;       // fila en el Sprite
    private int columna;    // columna en el Sprite
    private int velocidadX;
    private int velocidadY;
    private JuegoView vista;
    private Bitmap imagen;

    public Sprite(JuegoView vista, Bitmap imagen) {
        this.vista = vista;
        this.imagen = imagen;
        this.ancho = imagen.getWidth() / 3;
        this.alto = imagen.getHeight() / 4;
        this.fila = 0;
        this.columna = 0;
        this.x = 0;
        this.y = 0;
        Random R = new Random();
        velocidadX = R.nextInt(10) - 5;
        velocidadY = R.nextInt(10) - 5;
    }

    public void onDraw(Canvas canvas) {



        if (x > vista.getWidth() - ancho - velocidadX || x + velocidadX < 0) {
            velocidadX = -velocidadX;
        }
        if (y > vista.getHeight() - alto - velocidadY || y + velocidadY < 0) {
            velocidadY = -velocidadY;
        }
        x = x + velocidadX;
        y = y + velocidadY;

        columna++;
        columna = columna % 3;


        int srcX = columna * ancho;
        int srcY = getFilaAdecuada() * alto;
        Rect src = new Rect(srcX, srcY, srcX + ancho, srcY + alto); // recortamos el rectangulo
        Rect dst = new Rect(x, y, x + ancho, y + alto);             // escalacion del rectangulo, en donde se dibujara
        canvas.drawBitmap(imagen, src, dst, null);
    }

    public int getFilaAdecuada() {
        if (velocidadX == 0 && velocidadY > 0) {
            return 0; // adelante
        }
        if (velocidadX == 0 && velocidadY < 0) {
            return 3; // atras
        }
        if (velocidadY == 0 && velocidadX > 0) {
            return 2; // 
        }
        if (velocidadY == 0 && velocidadX < 0) {
            return 1; // 
        }
        if (velocidadX > 0 && velocidadY > 0) {
            return 2; // derecha
        }
        if (velocidadX > 0 && velocidadY < 0) {
            return 2; // derecha
        }
        if (velocidadX < 0 && velocidadY > 0) {
            return 1; // izquierda
        }
        if (velocidadX < 0 && velocidadY < 0) {
            return 1; // izquierda
        }
        return 0;
    }

    public boolean esColision(float x2, float y2) {
        return x2 > x && x2 < x + ancho && y2 > y && y2 < y + alto;
    }
}
