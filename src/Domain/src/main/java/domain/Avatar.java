package domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa un avatar con un nombre y una imagen.
 *
 * Esta clase implementa la interfaz Serializable para permitir la serialización
 * de objetos Avatar.
 */
public class Avatar implements Serializable {

    private String name; // Nombre del avatar
    private String image; // Ruta de la imagen del avatar

    /**
     * Constructor de la clase Avatar.
     *
     * @param name Nombre del avatar.
     * @param image Ruta de la imagen del avatar.
     */
    public Avatar(final String name, final String image) {
        this.name = name;
        this.image = image;
    }

    /**
     * Obtiene el nombre del avatar.
     *
     * @return Nombre del avatar.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del avatar.
     *
     * @param name Nuevo nombre del avatar.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Obtiene la ruta de la imagen del avatar.
     *
     * @return Ruta de la imagen del avatar.
     */
    public String getImage() {
        return image;
    }

    /**
     * Establece la ruta de la imagen del avatar.
     *
     * @param image Nueva ruta de la imagen del avatar.
     */
    public void setImage(final String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avatar other = (Avatar) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.image, other.image);
    }

}
