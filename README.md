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
#Patrón Factory Method:
##Propósito
Se usó el Factory Method para reemplazar la implementación original de la creación de EtiquetasHTML que era por medio de un diccionario que estaba asociado a un new "tipo de EtiquetaHTML" según el encabezado. Este cambio fue debido a que el diccionario traía problemas al crear 2 o más EtiquetasHTML del mismo tipo (por ej. 2 Titulo), ya que tanto el primero como el segundo recibían el mismo objeto, por lo que si se le cambiaba el texto a la segunda etiqueta repercutía también en la primera.
---
El Factory Method ayuda a desligarse de la responsabilidad de saber que objeto crear, ya que solo se le pide a un Factory que cree algo según el parámetro que se le da, y el se encarga de crearlo.
---
## Como lo usamos
*EtiquetaHTMLFactoryMethod: Declara la interfaz con el método public EtiquetaHTML crearEtiqueta(String encabezado);.
*EtiquetaHTMLFactory : Implementa la interfaz. Según el encabezado recibido crea un tipo de EtiquetaHTML.
---
El patron Factory Method lo utilizamos en la clase CreadorDeEtiquetas en el método privado crearEtiqueta que es llamado desde el método público crearListaDeEtiquetas. Al EtiquetaHTMLFactory se le da un encabezado, y a partir de ese encabezado crea un objeto que es devuelto por el método privado nombrado al método público crearListaDeEtiquetas, y este último lo agrega a la lista que va a devolver al finalizar el proceso de recorrer la lista que recibió. 
---
##Aclaraciones importantes
---
Para poder crear la carpeta de salida, y copiar en ella el contenido de la carpeta "plantilla", se utiliza la clase FileUtils de Apache Commons IO en su versión 2.5 Es FUNDAMENTAL colocar el archivo "commons-io-2.5.jar" dentro de la carpeta "target", es decir al lado de "slider.jar". El archivo "commons-io-2.5.jar" puede ser descargado desde el siguiente vínculo: http://mirrors.nxnethosting.com/apache//commons/io/binaries/commons-io-2.5-bin.tar.gz
---
Se asume que la carpeta a clonar se llamara obligatoriamente "plantilla" y se ubica dentro de la carpeta "target", al lado de "slider.jar". También se asume que dentro de esta carpeta se ubicará el archivo Markdown de entrada de datos. Finalmente, se asume que la salida del programa, en caso de escribir a archivo, lo hará en el archivo "index.html" dentro de la carpeta de salida creada por el mismo programa. El programa puede ser modificado para hacer de estas condiciones configurables, pero  se considera que la consigna inicial del trabajo no contempla esto.
---
*En el CreadorDeEtiquetasTest hay Tests con varios Assert, ya que como el CreadorDeEtiquetas le encarga al Factory que cree los objetos, no hay forma de que yo pueda crear una lista con los mismos objetos y compararlas.
*En el OrganizadorDeEtiquetasTest pasa lo mismo, porque como la Seccion y la ListaSinOrden contienen EtiquetasHTML dentro, no nos es posible verificar que contengan dichas EtiquetasHTML de otra manera.
*Los tests de las clases OrganizadorDeItems y OrganizadorDeSecciones se hicieron posteriormente a su creación debido a que anteriormente su lógica estaba combinada en una misma clase, la cual sufrió una refactorización. 
---
#Links de interes
##Utilizamos dos sistemas de integracion continua: Jenkins provisto por el profesor y Travis para uso personal
*https://nicopaez.ci.cloudbees.com/job/g4/
*http://travis-ci.org/gonzalocozzi
