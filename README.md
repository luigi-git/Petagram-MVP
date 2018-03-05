# Petagram. Generando persistencia en aplicación 

### En esta aplicación se utiliza el patrón MVP

Mascotas favoritas
* Son las 5 mascotas que cambian conforme el usuario da rating a una o varias mascotas. 
* El POJO para la entidad mascota genera un identificador el cuál deberá ser único y permita diferenciar una mascota de otra.

Modelo de base de datos mascotas:
* Tabla mascota almacena las mascotas idéntica al POJO de mascota.
* Tabla mascota_rating, almacena el rating de una foto.

### Modelo ER
![Petagram DiagramaER](https://github.com/luigi-git/Petagram-MVP/blob/master/DiagramaER.png)


### Vistas de la aplicación


**Petagram Home**
![Petagram Home](https://github.com/luigi-git/Petagram-MVP/blob/master/Petagrama_Fragmet_Home.png)

**Petagram Mascota Perfil**

![Petagram Mascota Perfil](https://github.com/luigi-git/Petagram-MVP/blob/master/Petagram_Fragment_MascotaPerfil.png)

**Petagram Mascotas Favoritas**

![Petagram Mascotas Favoritas](https://github.com/luigi-git/Petagram-MVP/blob/master/Petagram_MascotasFavoritas.png)

**Petagram Contacto**

![Petagram Contacto](https://github.com/luigi-git/Petagram-MVP/blob/master/Petagram_Contacto.png)

**Petagram Acerca De**

![Petagram Acerca De](https://github.com/luigi-git/Petagram-MVP/blob/master/Petagram_AcercaDe.png)


## Importante

**Para que la aplicación envíe el correo electrónico se debe editar el archivo *ConfigurarMail.java* con los datos de la cuenta de correo a utilizar.**
**La configuración para el envío del mensaje se basa en una cuenta de correo de Gmail.**




