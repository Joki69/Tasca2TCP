import java.io.Serializable;
import java.util.List;

public class Llista implements Serializable {
    private static final long serialVersionUID = 2L;
    private String nombre;
    private List<Integer> listaNumeros;

    public Llista(String nombre, List<Integer> listaNumeros) {
        this.nombre = nombre;
        this.listaNumeros = listaNumeros;
    }

    public String getNoombre() {
        return nombre;
    }

    public void setNoombre(String noombre) {
        this.nombre = nombre;
    }

    public List<Integer> getListaNumeros() {
        return listaNumeros;
    }

    public void setListaNumeros(List<Integer> listaNumeros) {
        this.listaNumeros = listaNumeros;
    }
}