# Práctica 1

## Descripción del problema

Se desea realizar un convertidor de números arábigos  a texto (es decir, si se le damos el número 734, entonces el programa debe regresar "setecientos treinta y cuatro".  El convertidor está limitado a convertir unidades, decenas, centenas y hasta millares. Esto implica que el número mínimo a convertir será el cero y el máximo será el 9999. Se pide que se diseñe este convertidor empleando los principios de diseño SOLID (i.e., SRP, OCP, LSP, ISP, DIP), cuando sea necesario.

## Descripción de la entrega

En el reporte, presentar el diagrama de clases del diseño (usando Star UML) y una explicación sobre las decisiones tomadas para aplicar los principios SOLID. Además, el código fuente debe ser entregado junto con el reporte, siendo totalmente ejecutable y correcto. El lenguaje de programación a emplear es Java.

Se deberá generar un reporte en formato PDF donde se muestren los detalles de la práctica en typesetting (es decir, formato nativamente digital, no escaneo). Además, el código fuente deberá ser totalmente ejecutable y escrito en **Java**. Subir el reporte a Canvas en el apartado adecuado.

## Instrucciones
Ya existe un archivo ejecutable, pero en caso de modificar el código, seguir las siguientes instrucciones para volver a generarlo.

Hay que posicionarse en la carpeta que contiene el código.

Para compilar y generar el archivo ejecutable, usar los siguienes comandos:

```
javac -d . Main.java
jar cfve numToTxt.jar Main *.class
```
Para correr el ejecutable, usar el siguiente comando:
```
java -jar numToTxt.jar
```

