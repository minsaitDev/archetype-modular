# Arquitectura Hexagonal

## ¿Qué es la arquitectura de software?
Conjunto de patrones que proporcionan un marco de referencia necesario para guiar la construcción de un software, permitiendo a los programadores, analistas y todo el conjunto de desarrolladores del software compartir una misma línea de trabajo y cubrir todos los objetivos y restricciones de la aplicación. Es considerada el nivel más alto en el diseño de la arquitectura de un sistema puesto que establecen la estructura, funcionamiento e interacción entre las partes del software.

Ejemplos de arquitectura son MVC, la programación por capas, peer-to-peer, orientada a servicios (SOA), cliente-servidor, etc…

## Entonces, ¿Qué es la arquitectura Hexagonal?
La arquitectura hexagonal, a la que también se le conoce como arquitectura de puertos y adaptadores, es una arquitectura de software que se basa en la idea de aislar la lógica comercial central de las preocupaciones externas, por medio de la separación de la aplicación en componentes débilmente acoplados.

## Problemas comunes en el desarrollo de software al no implementar una arquitectura.
Una de las grandes pesadillas en las aplicaciones de software ha sido la infiltración de la lógica del negocio en el código de la interfaz de usuario. Esto trae múltiples problemas:
- Dificulta la automatización de pruebas.
- Impide el cambio de uso de la aplicación.
- Dificulta o impide el uso por otro programa.

Otro gran problema es el acoplamiento con detalles de infraestructura como la base de datos.

## Cuando utilizarla
Arquitectura Hexagonal es ideal cuando la modularidad y el mantenimiento son críticos. Úsala en aplicaciones complejas donde la lógica de negocio debe separarse de los detalles de implementación.

## Objetivo de la Arquitectura Hexagonal
Permitir que una aplicación sea usada de la misma forma por usuarios, programas, pruebas automatizadas o scripts, y sea desarrollada y probada de forma aislada(isolated) de sus eventuales dispositivos y bases de datos en tiempo de ejecución.

Separar nuestra aplicación en distintas capas o regiones con su propia responsabilidad. De esta manera consigue desacoplar capas de nuestra aplicación permitiendo que evolucionen de manera aislada. Además, tener el sistema separado por responsabilidades nos facilitará la reutilización.

Gracias a este desacoplamiento obtenemos también la ventaja de poder testear estas capas sin que intervengan otras externas, falseando el comportamiento con dobles de pruebas, por ejemplo.

## Estructura de la Arquitectura Hexagonal
Esta arquitectura se suele representar con forma de hexágono, pero el número de lados no es lo que importa, sino lo que estos representan. Cada lado representa un puerto hacia dentro o fuera de la aplicación. Por ejemplo, un puerto puede ser el HTTP, y hacer peticiones a nuestra aplicación, otro puerto puede ser el SOAP y también hace peticiones a la aplicación. Otro puede ser un servidor de base de datos en donde persistir los datos de nuestro dominio.
<p align="center">
  <a href="https://medium.com/@edusalguero/arquitectura-hexagonal-59834bb44b7f" target="blank"><img src="https://miro.medium.com/v2/resize:fit:4800/format:webp/1*yR4C1B-YfMh5zqpbHzTyag.png" width="600" alt="Logo" /></a>
</p>

<b>A continuación, exploraremos detalladamente las capas clave que componen la Arquitectura Hexagonal y analizaremos cómo se complementan para lograr un diseño coherente y eficiente.</b>
- <p align="justify"><b>Capa de Dominio:</b> La capa de dominio constituye el núcleo central del hexágono y alberga las reglas de negocio esenciales. Aquí encontramos modelos de datos y sus restricciones, definiendo la esencia misma de la aplicación.</p>
- <p align="justify"><b>Capa de Aplicación:</b> Justo por encima de la capa de dominio, se sitúa la capa de aplicación, donde se definen los distintos casos de uso de la aplicación. Aquí, la lógica de negocio del dominio se implementa en términos de casos de uso específicos.</p>
- <p align="justify"><b>Capa de Infraestructura:</b> La capa de infraestructura se encarga de facilitar la entrada y salida de datos, abordando aspectos técnicos esenciales para la ejecución de la aplicación. Este nivel no contiene lógica de negocio, sino que se centra en cuestiones de infraestructura técnica.</p>
- <p align="justify"><b>Comunicación entre Capas:</b> El código en cada capa describe cómo comunicarse con las demás utilizando interfaces (puertos) e implementaciones (adaptadores). Esta interacción cuidadosamente diseñada garantiza la coherencia y la eficiencia en la transmisión de información entre las capas.</p>

## Pros de la Arquitectura Hexagonal

- <p align="justify"><b>Mejora en la Testabilidad:</b> La estructura clara de la Arquitectura Hexagonal facilita la escritura y ejecución de pruebas unitarias, asegurando la robustez del código y reduciendo los errores.</p>
- <p align="justify"><b>Promoción de la Modularidad:</b> La separación de responsabilidades entre el núcleo y los adaptadores fomenta la creación de módulos independientes, facilitando la escalabilidad y el mantenimiento del sistema.</p>
- <p align="justify"><b>Adaptabilidad a Cambios:</b> La flexibilidad inherente permite adaptarse rápidamente a cambios en los requisitos o en el entorno externo, manteniendo la agilidad del desarrollo.</p>


## Contras de la Arquitectura Hexagonal
- <p align="justify"><b>Complejidad Inicial:</b> Implementar la Arquitectura Hexagonal puede requerir una planificación cuidadosa y un entendimiento profundo de los principios, lo que puede aumentar la complejidad inicial del desarrollo.</p>
- <p align="justify"><b>Curva de Aprendizaje:</b> Para los desarrolladores nuevos en esta metodología, puede haber una curva de aprendizaje significativa al comprender la estructura y los patrones de diseño específicos de la Arquitectura Hexagonal.</p></p>


## Bibliografía
- [Arquitectura Hexagonal](https://medium.com/@edusalguero/arquitectura-hexagonal-59834bb44b7f)
- [Explorando la Arquitectura Hexagonal](https://es.linkedin.com/pulse/explorando-la-arquitectura-hexagonal-un-enfoque-en-su-mu%C3%B1oz-garro-nhyee)
- [Hexagonal Architecture, there are always two sides to every story](https://medium.com/ssense-tech/hexagonal-architecture-there-are-always-two-sides-to-every-story-bc0780ed7d9c)
- [Aprende Arquitectura Hexagonal](https://www.youtube.com/watch?v=eNFAJbWCSww&ab_channel=CodelyTV-Redescubrelaprogramaci%C3%B3n)