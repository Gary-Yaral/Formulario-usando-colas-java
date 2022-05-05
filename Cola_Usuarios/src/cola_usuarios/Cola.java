
package cola_usuarios;

public interface Cola {
    public void agregar(String nombre);
    public String atender();
    public Boolean colaLlena();
    public Boolean colaVacia();
    public String mostrarCola();
    public String mostrarPrimerUsuario();
}
