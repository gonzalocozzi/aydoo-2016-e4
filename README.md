---
# aydoo-2016-e4
Trabajo práctico nº1 de Análisis y Diseño Orientado a Objetos 2016
---
##Consideraciones de diseño
---
Se eligió para este proyecto crear una serie de clases encargadas de manejar la entrada del archivo Markdown y la salida HTML, además de verificar y validar los parámetros. En principio, esas clases no tienen relación alguna entre sí, estando desacopladas. La relación entre ellas se verifica exclusivamente en la clase SelectorDeModo, la cual es la que define el algoritmo que se ejecutará, dependiendo de los parámetros ingresados.
---
Se modeló la clase EtiquetaHTML, la cual define una serie de elementos HTML (título, subtítulo, items, etc.). El programa se encarga de leer el archivo Markdown de entrada linea a linea, creando una EtiquetaHTML por cada uno de ellos, siendo estos elementos los que luego son escritos en el archivo "index.html" o mostrados por consola.
---
Se decidio utilizar en el proyecto dos patrones de diseño: visitor y factory method.
---
#Patron Visitor:
##Propósito
El uso de este patrón nos resulto ser una buena practica, ya que por un lado queda muy prolijo y por otro no estamos atados a los condicionales. Al ser un patrón de comportamiento, nos permitio definir una operación sobre los objetos EtiquetaHTML de una jerarquía de clases sin modificar las clases sobre las que opera. 
---
## Como lo aplicamos
El patron Visitor lo utilizamos en la clase CreadorDeSalida para construir el codigo html mediante la iteracion de una lista de EtiquetaHTML, las cuales realizan la operacion "Accept", en la cual se toma el visitor del argumento y realiza otra operacion llamada "visit" que, de acuerdo al tipo de objeto, acumula en la lista correspondiente determinado objeto.
---
## Como lo usamos
*Visitor: Declara una operación de visita para cada EtiquetaHTML concreto en la estructura de objetos, que incluye el propio objeto visitado.
*VisitorDeEtiquetas : Implementa las operaciones del visitor y acumula resultados como estado local en una lista.
*EtiquetaHTML (Elemento): Define una operación “Accept” que toma un visitor como argumento.
*Elemento Concreto : en nuestro caso son los objetos que hereden de EtiquetaHTML los que implementa la operación “Accept”;	
---
##Aclaraciones importantes
---
Para poder crear la carpeta de salida, y copiar en ella el contenido de la carpeta "plantilla", se utiliza la clase FileUtils de Apache Commons IO en su versión 2.5 Es FUNDAMENTAL colocar el archivo "commons-io-2.5.jar" dentro de la carpeta "target", es decir al lado de "slider.jar". El archivo "commons-io-2.5.jar" puede ser descargado desde el siguiente vínculo: http://mirrors.nxnethosting.com/apache//commons/io/binaries/commons-io-2.5-bin.tar.gz
---
Se asume que la carpeta a clonar se llamara obligatoriamente "plantilla" y se ubica dentro de la carpeta "target", al lado de "slider.jar". También se asume que dentro de esta carpeta se ubicará el archivo Markdown de entrada de datos. Finalmente, se asume que la salida del programa, en caso de escribir a archivo, lo hará en el archivo "index.html" dentro de la carpeta de salida creada por el mismo programa. El programa puede ser modificado para hacer de estas condiciones configurables, pero  se considera que la consigna inicial del trabajo no contempla esto.
---
#Links de interes
##Utilizamos dos sistemas de integracion continua: Jenkins provisto por el profesor y Travis para uso personal
*https://nicopaez.ci.cloudbees.com/job/g4/
*http://travis-ci.org/gonzalocozzi