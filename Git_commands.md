# Comandos de uso frecuente de Git
Git es una herramienta que nos permite manejar repositorios de Github desde nuestra computadora, para poder usarlo solo hace falta instalarlo en nuestra computadora y seleccionar tu editor de código favorito en el instalador para que se vincule correctamente desde un inicio. Para poder usar la consola que el programa trae, basada en bash, debemos de buscar Git Bash y abrirlo. 
Dentro de Visual Studio Code también es posible abrir esa terminal.

*NOTA*: Los comandos que aquí vaya mostrando se irán agregando conforme los vaya utilizando, lo que quiere decir que si aparece en esta lista ya lo he usado por lo menos una vez ;)

## Comandos de uso frecuente
Algunos de los comandos más usados para manejar un repositorio local son los siguientes: 
| comando | función | estructura | parametros opcionales utiles |
| :--- | :--- | :---: | :---: |
| help | Da una lista de los comandos disponibles | `git help` | nombre de un comando |
| init | Inicia un repositorio local en tu computadora, tienes que subirlo a github despues | `git init` | ... |
| commit | Prepara un commit de los cambios realizados a los archivos del repositorio | `git commit ` | `.`, `-a`|
| push | Sube a GitHub el código al que le hayas previamente hecho commit | `git push` | ... |
| branch | Crea una nueva rama de codigo, osea otro "guardado" para no perder el original | `git branch` | `<nombre nueva branch>` |
| checkout | Te permite cambiar entre una branch y otra | `git checkout` | `<nombre branch que quieres usar>` |
