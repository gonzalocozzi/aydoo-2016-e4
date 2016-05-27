# aydoo-2016-e4
Trabajo práctico nº1 de Análisis y Diseño Orientado a Objetos 2016
---
##Consideraciones de diseño
--
Se eligió para este proyecto crear una serie de clases encargadas de manejar la entrada del archivo Markdown y la salida HTML, además de verificar y validar los parámetros. En principio, esas clases no tienen relación alguna entre sí, estando desacopladas. La relación entre ellas se verifica exclusivamente en la clase SelectorDeModo, la cual es la que define el algoritmo que se ejecutará, dependiendo de los parámetros ingresados.
---
Se modeló la clase EtiquetaHTML, la cual define una serie de elementos HTML (título, subtítulo, items, etc.). El programa se encarga de leer el archivo Markdown de entrada linea a linea, creando una EtiquetaHTML por cada uno de ellos, siendo estos elementos los que luego son escritos en el archivo "index.html" o mostrados por consola.
---
Se decidio utilizar en el proyecto dos patrones de diseño: visitor y factory method.
---
##Aclaraciones importantes
---
Para poder crear la carpeta de salida, y copiar en ella el contenido de la carpeta "plantilla", se utiliza la clase FileUtils de Apache Commons IO en su versión 2.5 Es FUNDAMENTAL colocar el archivo "commons-io-2.5.jar" dentro de la carpeta "target", es decir al lado de "slider.jar". El archivo "commons-io-2.5.jar" puede ser descargado desde el siguiente vínculo: http://mirrors.nxnethosting.com/apache//commons/io/binaries/commons-io-2.5-bin.tar.gz
---
Se asume que la carpeta a clonar se llamara obligatoriamente "plantilla" y se ubica dentro de la carpeta "target", al lado de "slider.jar". También se asume que dentro de esta carpeta se ubicará el archivo Markdown de entrada de datos. Finalmente, se asume que la salida del programa, en caso de escribir a archivo, lo hará en el archivo "index.html" dentro de la carpeta de salida creada por el mismo programa. El programa puede ser modificado para hacer de estas condiciones configurables, pero  se considera que la consigna inicial del trabajo no contempla esto.
---
