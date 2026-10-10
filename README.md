# LEADEN2 APK V1 FUNCIONAL

Proyecto Android nativo experimental para probar una sesión multimedia Media3 en un Redmi 12C con Android 14.

## Qué incluye

- `MainActivity.java`: botones para activar LEADEN2 y ejecutar la acción local.
- `PlaybackService.java`: `MediaSessionService` con ExoPlayer y una capa `ForwardingPlayer` que conecta los comandos de reproducción/pausa de la sesión con la acción de prueba.
- Dos MP3 originales en `app/src/main/assets/`.
- Workflow de GitHub Actions que compila y publica el APK debug.

## Compilación mediante GitHub Actions

1. Crea un repositorio nuevo en GitHub, por ejemplo `LEADEN2_APK_V1_FUNCIONAL`.
2. Sube el contenido de esta carpeta al directorio raíz del repositorio. La carpeta `.github/workflows/build.yml` debe conservar esa ruta.
3. Abre la pestaña **Actions**.
4. Selecciona **Build LEADEN2 APK V1 FUNCIONAL**.
5. Pulsa **Run workflow** y confirma.
6. Cuando termine, abre la ejecución y descarga el artifact `LEADEN2-APK-V1-FUNCIONAL`.
7. Descomprime el artifact; dentro estará `app-debug.apk`.

## Instalar en el Redmi 12C

1. Transfiere `app-debug.apk` al teléfono.
2. Abre el archivo desde el administrador de archivos.
3. Si Android lo solicita, permite temporalmente instalar aplicaciones desde esa fuente.
4. Instala y abre **LEADEN2**.
5. Pulsa **PRUEBA LOCAL: EJECUTAR ACCIÓN** y comprueba que suene `importando.mp3`.
6. Pulsa **ACTIVAR LEADEN2** y confirma que suene `comienza_el_ensamblaje.mp3`.
7. Con el servicio activo, bloquea la pantalla y pulsa una vez el botón central de las gafas.

## Interpretación de la prueba

La prueba local valida los assets y la reproducción. La prueba con las gafas comprueba si Android enruta el comando multimedia a la sesión LEADEN2. Android puede entregar el comando a otra sesión activa; por eso no se garantiza que el botón active LEADEN2 en todos los teléfonos o configuraciones.

Si el botón no activa la acción, anota si la música u otra aplicación reacciona y si `importando.mp3` llega a sonar. Ese resultado real determinará el siguiente ajuste.

## Configuración

- Paquete: `com.leaden2.app`
- `versionCode`: 1
- `versionName`: 1.0
- `compileSdk`: 35
- `targetSdk`: 35
- `minSdk`: 23
- AGP: 8.6.1
- Gradle: 8.7
- JDK: 17
- Media3: 1.5.1

## Limitaciones y estado de validación

Este ZIP es el proyecto fuente, no un APK ya compilado ni una prueba ejecutada en el Redmi 12C. La compilación se debe confirmar en GitHub Actions. La entrega del comando multimedia a LEADEN2, la reproducción con pantalla bloqueada y el comportamiento específico de HyperOS deben probarse en el teléfono real.

No requiere modificar la PWA, el VPS, Nginx ni las licencias de LEADEN1/LEADEN2.
