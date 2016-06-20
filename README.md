---
# aydoo-2016-e4
Trabajo práctico Nº1 de Análisis y Diseño Orientado a Objetos 2016
---
## Consideraciones de diseño
---
Se eligió para este proyecto crear una serie de clases encargadas de manejar la entrada del archivo Markdown y la salida HTML, además de verificar y validar los parámetros. En principio, esas clases no tienen relación alguna entre sí, estando desacopladas. La relación entre ellas se verifica exclusivamente en la clase Traductor, la cual es la que define el algoritmo que se ejecutará, dependiendo de los parámetros ingresados.
---
Se decidio utilizar en el proyecto dos patrones de diseño: visitor y factory method (abandonado en la versión 2).
---
## Patron Visitor
### Propósito
El uso de este patrón nos resulto ser una buena practica, ya que por un lado queda muy prolijo y por otro no estamos atados a los condicionales. Al ser un patrón de comportamiento, nos permitio definir una operación sobre los objetos Etiqueta de una jerarquía de clases sin modificar las clases sobre las que opera. 
---
### Como lo aplicamos
El patron Visitor lo utilizamos en la clase CreadorDeSalida para construir el codigo HTML mediante la iteracion de una lista de Etiqueta, las cuales realizan la operacion "Accept", en la cual se toma el visitor del argumento y realiza otra operacion llamada "visit" que, de acuerdo al tipo de objeto, acumula en la lista correspondiente determinado objeto.
---
### Como lo usamos
* Visitor: Declara una operación de visita para cada Etiqueta concreta en la estructura de objetos, que incluye el propio objeto visitado.
* VisitorDeEtiquetas : Implementa las operaciones del visitor y acumula resultados como estado local en una lista.
* Etiqueta (Elemento): Define una operación “Accept” que toma un visitor como argumento.
* Elemento Concreto: en nuestro caso son los objetos que hereden de Etiqueta los que implementa la operación “Accept”;	
---
## Patrón Factory Method
### Propósito
Se usó el Factory Method para reemplazar la implementación original de la creación de Etiquetas que era por medio de un diccionario que estaba asociado a un new "tipo de Etiqueta" según el encabezado. Este cambio fue debido a que el diccionario traía problemas al crear 2 o más Etiquetas del mismo tipo (por ej. 2 Titulos), ya que tanto el primero como el segundo recibían el mismo objeto, por lo que si se le cambiaba el texto a la segunda etiqueta repercutía también en la primera.
---
El Factory Method ayuda a desligarse de la responsabilidad de saber que objeto crear, ya que solo se le pide a un Factory que cree algo según el parámetro que se le da, y el se encarga de crearlo.
---
### Cómo lo usamos
* EtiquetaHTMLFactoryMethod: declara la interfaz con el método crearEtiqueta(String encabezado);.
* EtiquetaHTMLFactory : implementa la interfaz. Según el encabezado recibido crea un tipo de Etiqueta.
---
El Factory Method es utilizado por la clase CreadorDeEtiquetas. A EtiquetaHTMLFactory se le da un encabezado, y a partir de ese encabezado crea un objeto. El método crearListaDeEtiquetas agrega este objeto a una lista. Se repite este proceso hasta que este último método recorra toda su lista de String. Finalmente devuelve una lista de Etiquetas, que es la lista donde fue agregando a los objetos. 
---
### Por qué lo descartamos
* Estaba mal aplicado: el patrón no incluye ninguna cadena de if, usa herencia.
* Violaba el principio Open/Close: no estaba abierto a extensión y cerrado a modificación.
---
## Lista de responsabilidades
El reemplazo de EtiquetasHTMLFactory consiste en aprovechar el principio de que cada Etiqueta conozca si debe incluirse en la lista HTML de salida, a partir del conocimiento de su encabezado Markdown. La clase CreadorDeEtiquetas contiene una lista de Etiquetas que puede traducir por defecto. Al recibirse una lista con las lineas del archivo Markdown, se crea una nueva Etiqueta por cada una de las lineas. Para ellos se recorre toda la lista de Etiquetas, pidiéndole a cada Etiqueta que se devuelva a sí misma. Si le corresponde lo hace, de otra forma continúa con la siguiente de la lista. Este comportamiento permite delegar la incumbencia de la creación en cada Etiqueta, además de que facilita la inclusión de nuevas etiquetas en la lista, por lo cual está abierto a extensión. Este mismo principio se aplicó además en las clases ValidadorDeArgumentos y Traductor. La primera contiene una lista de excepciones que puede lanzar, de forma que cada excepción sabe en qué situaciones debe ser lanzada. Lo mismo aplica al traductor, el cual contiene una lista de Modos de Salida disponibles. 
---
## Modos de salida
Un concepto innovador es el de Modos de Salida. ModoDeSalida es una clase que engloba el algoritmo que define de qué manera se devolverá la salida HTML. En principio, existen dos modos: Default y No Output. Default crea una carpeta de salida, clona en ella el contenido de la carpeta "plantilla" y escribe en el archivo "index.html" que incluye la salida HTML. En cambio, el modo No Output solamente imprime en linea de comando la salida HTML. Todos los Modos de Salida tienen en común el parseo del archivo markdown de entrada, y pueden agregarse nuevos Modos de Salida para devolverle al usuario el resultado de la traducción de diferentes maneras. Se aclara que el modo Default responde tanto a los argumentos "--mode=default" como "--output=...", y el modo No Output responde al argumento "--mode=no-output".
---
## Aclaraciones importantes
---
* Para poder crear la carpeta de salida, y copiar en ella el contenido de la carpeta "plantilla", se utiliza la clase FileUtils de Apache Commons IO en su versión 2.5 Es FUNDAMENTAL colocar el archivo "commons-io-2.5.jar" dentro de la carpeta "target", es decir al lado de "slider.jar". Para ello, se modificó el POM incluyendo un comando que lo descarga automáticamente y lo ubica en la carpeta correspondiente, el cual fue probado en 3 equipos Linux distintos.
* Se asume que la carpeta a clonar se llamara obligatoriamente "plantilla" y se ubica dentro de la carpeta "target", al lado de "slider.jar". También se asume que dentro de esta carpeta se ubicará el archivo Markdown de entrada de datos. 
* Se asume que la salida del programa, en caso de escribir a archivo, lo hará en el archivo "index.html" dentro de la carpeta de salida creada por el mismo programa. El programa puede ser modificado para hacer de estas condiciones configurables, pero se considera que la consigna inicial del trabajo no contempla esto.
* En la clase CreadorDeEtiquetasTest hay Tests con varios Assert, ya que como el CreadorDeEtiquetas le encarga al Factory que cree los objetos, no hay forma de que yo pueda crear una lista con los mismos objetos y compararlas. En la clase OrganizadorDeEtiquetasTest pasa lo mismo, porque como la Seccion y la ListaSinOrden contienen Etiquetas dentro, no nos es posible verificar que contengan dichas Etiquetas de otra manera.
* Los tests de las clases OrganizadorDeItems y OrganizadorDeSecciones se hicieron posteriormente a su creación debido a que anteriormente su lógica estaba combinada en una misma clase, la cual sufrió una refactorización. 
* Existen algunas porciones del código que contienen posibles "smells": el método setNombreDeCarpetaDeSalida de la clase ValidadorDeArgumentos tiene un if anidado, que no fue retirado del código por suponer que no va a cambiar sin importar el número de argumentos adicionales que se agreguen al programa. Además, el método organizar dentro de la clase OrganizadorDeSecciones tiene un if dentro de otro. Se intentó retirarlo infructuosamente, por algún motivo que no conocemos varias pruebas fallan si se unen ambas condiciones en una misma condición.
* Puede notarse cierto acoplamiento en la clase ModoDeSalida respecto de otras clases. Esto se debe a que se priorizó que las clases de creación de carpetas, análisis y validación de argumentos, lectura del archivo markdown, etc., sean totalmente independientes entre ellas. De esta forma, la clase ModoDeSalida funciona como un "director de orquesta" que define la interacción entre ellas.
* La cobertura entre la versión 1 y la versión 2 cayó 2% (del 98% al 96%). No nos parece un retroceso notable ni preocupante, y se debe principalmente a la aparición de un try-catch sin cobertura en la clase CreadorDeEtiquetas.
* La clase CreadorDeEtiquetas almacena una lista de Class que extienden de la clase Etiqueta. Esto no pudo ser replicado ni en la clase ValidadorDeArgumentos ni en la clase Traductor, ya que las excepciones y los modos de salida reciben por constructor una serie de argumentos, y estos deben ser incluidos al momento de agregarlos a las listas.
* Se han actualizado debidamente los diagramas de clase y secuencia incluidos en el trabajo.
---
# Integración continua
## Utilizamos dos sistemas de integracion continua: Jenkins provisto por el profesor y Travis para uso personal
* https://nicopaez.ci.cloudbees.com/job/g4/
* http://travis-ci.org/gonzalocozzi
