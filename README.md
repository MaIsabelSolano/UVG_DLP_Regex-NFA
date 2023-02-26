# UVG_DLP_Regex-NFA

![image](https://user-images.githubusercontent.com/60373842/221439305-0e3391c1-9e72-4a1c-921d-1bbbe91b4f29.png) <br>
Facultad de Ingeniería <br>
Departamento de Ciencias de la Computación <br>
CC3071 - Diseño de Lenguajes de Programación <br>
Ma. Isabel Solano 20504 <br>

## Índice
* [Sobre el Laboratorio](https://github.com/MaIsabelSolano/UVG_DLP_Regex-NFA/edit/main/README.md#sobre-el-laboratorio)
* [Objetivos](https://github.com/MaIsabelSolano/UVG_DLP_Regex-NFA/edit/main/README.md#objetivos)
* [Dependencias](https://github.com/MaIsabelSolano/UVG_DLP_Regex-NFA/edit/main/README.md#dependencias)
* [Funciones](https://github.com/MaIsabelSolano/UVG_DLP_Regex-NFA/edit/main/README.md#funciones)
* [Modo de uso](https://github.com/MaIsabelSolano/UVG_DLP_Regex-NFA/edit/main/README.md#modo-de-uso)
* [Tecnologías](https://github.com/MaIsabelSolano/UVG_DLP_Regex-NFA/blob/main/README.md#tecnologías)

## Sobre el Laboratorio
Se buscba desarrollar una implementación de algoritmos para la construcción de autómatas finitos no deterministas a partir de una expresión regular dada. Para ello se utiliza la construcción de Thompson. 

## Objetivos
* Generales
  * Implementación de algoritmos básicos de autómatas finitos no deterministas y expresiones regulares.
  * Desarrollar una sección para la base de la implementación del generador de analizadores léxicos.
* Específicos
  * Conversión de una expresión regular en notación infix a notación postfix. Puede utilizar el algoritmo Shunting Yard.
  * Implementación del algoritmo de Construcción de Thompson.
  * Generación visual de los AF.

## Dependencias
Para el correcto uso del programa, es necesario que se tenga instalado [GraphViz](https://github.com/nidi3/graphviz-java) ([Descarga](https://graphviz.org/download/) graphviz-7.1.0 (64-bit) EXE installer) y que dot sea una variable del sistema. 

## Funciones
* Identificación de ingreso de input incorrecto
* Conversión de una expresión infix a postfix
* Determinación del alfabeto del lenguaje a partir de la expresión ingresada
* Construcción de árbol sintáctico a partir de expresión postfix
* Construcción de AFN por Thompson y por subconjuntos basados en el árbol sintáctico
* Graficación del AFN con ayuda de GraphViz

## Modo de uso 
<b>Input</b>: <br>
Expresión regular con los operadores '|', '.', '+', '-', '?'

<b>Correr</b>:
* `javac src/Controller.java`
* `java src/Controller`

<b>Output<b>: 
![AFN](https://user-images.githubusercontent.com/60373842/221440248-8d5f2b1b-344f-41e8-bf41-05f61cb351c6.jpg)
<i>(ab)|(a?b+a*)</i>

## Tecnologías
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
