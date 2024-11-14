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

    /**
     * Inicializa el reloj. Establece la hora actual y configura un temporizador
     * para actualizar la hora cada segundo.
     */
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

    /**
     * Actualiza la hora en los ImageView correspondientes a cada dígito del reloj.
     * Obtiene la hora, minutos y segundos actuales y actualiza las imágenes
     * de los dígitos correspondientes.
     */
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

    /**
     * Establece la imagen correspondiente al dígito en el ImageView proporcionado.
     *
     * @param imageView El ImageView al que se asignará la imagen.
     * @param digit El dígito que se representará.
     */
    private void setDigitImage(ImageView imageView, int digit) {
        // Define los nombres de los archivos de imagen para cada dígito
        String[] digitNames = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

        // Construye el nombre de archivo según el valor del dígito
        String imageFileName = imagePath + digitNames[digit] + ".png";

        // Carga la imagen y la asigna al ImageView
        Image image = new Image(getClass().getResourceAsStream(imageFileName));

        // Maneja el caso si la imagen no se carga correctamente
        if (image.isError()) {
            System.out.println("Error loading image for digit: " + digitNames[digit]);
        }
        imageView.setImage(image);
    }
}
