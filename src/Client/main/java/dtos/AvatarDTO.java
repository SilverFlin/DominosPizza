package dtos;

import java.util.Objects;

/**
 *
 */
public class AvatarDTO implements Comparable<AvatarDTO> {

    private String nombre;
    private String image;

    public AvatarDTO() {
    }

    public AvatarDTO(final String nombre, final String image) {
        this.nombre = nombre;
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    @Override
    public int compareTo(final AvatarDTO o) {
        return this.getNombre().compareTo(o.getNombre());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AvatarDTO other = (AvatarDTO) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.image, other.image);
    }

    @Override
    public String toString() {
        return "AvatarDTO{" + "nombre=" + nombre + '}';
    }

}
