package com.eiman.ejk;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class RelojController {
    @FXML
    private ImageView hora1, hora2, min1, min2, seg1, seg2;

    private Timer timer;
    private final String imagePath = "/com/eiman/ejk/imagenes/"; // Ajusta esta ruta según la estructura de tu proyecto

    public void initialize() {
        // Llamar a updateClock() inmediatamente para establecer la hora actual al inicio
        updateClock();

        // Configura el temporizador para actualizar la hora cada segundo
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateClock();
            }
        }, 1000, 1000); // Espera 1 segundo antes de la primera ejecución, luego actualiza cada segundo
    }

    private void updateClock() {
        // Obtiene la hora actual
        LocalDateTime now = LocalDateTime.now();
        int hours = now.getHour();
        int minutes = now.getMinute();
        int seconds = now.getSecond();

        // Actualiza cada dígito con la imagen correspondiente
        setDigitImage(hora1, hours / 10);    // Decenas de horas
        setDigitImage(hora2, hours % 10);    // Unidades de horas
        setDigitImage(min1, minutes / 10);   // Decenas de minutos
        setDigitImage(min2, minutes % 10);   // Unidades de minutos
        setDigitImage(seg1, seconds / 10);   // Decenas de segundos
        setDigitImage(seg2, seconds % 10);   // Unidades de segundos
    }
}
