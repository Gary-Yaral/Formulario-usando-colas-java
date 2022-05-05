
package cola_usuarios;


public class ColaUsuarios implements Cola{
    
    private String[] cola;
    private int limite;
    int inicio;
    int fin;
    
    public ColaUsuarios(int _limite){
        inicio = -1;
        fin = -1;
        limite = _limite;
        cola = new String[limite];      
    }

    @Override
    public void agregar(String nombre) {
            // Si la cola aún tiene espacio
            if(!colaLlena()) {
                fin++;
                cola[fin] = nombre;
                
                if(fin == 0) {
                    inicio = 0;
                }
            } else {
                System.out.println("La cola está llena, espere a que se libere un espacio");
            }
    }

    @Override
    public String atender() {
       
        // Verificamos que haya usuarios en la cola
        if(!colaVacia()) {
            String usuario;
            //Si solo hay un usuario
            if(fin == 0) {
                usuario = cola[inicio];
                inicio = inicio -1;
                fin = fin - 1;
                cola[0] = null;
                return usuario;
                
            } else {
                // Guardamos el usuario que estamos atendiendo
                usuario = cola[inicio];
                
                // El inicio comenzará a partir a de la siguiente posición.
                for(int i = 0; i < limite - 1 ; i++ ) {
                    cola[i] = cola[i + 1];
                }
                // Dsiminuimos el final en 1
                fin = fin - 1;              
                return usuario;
            }
        }       
       return null;
       
    }
    
    @Override
    public Boolean colaLlena() {
        return fin == limite - 1;
    }
           

    @Override
    public Boolean colaVacia() {
       return fin == - 1;
    }
    
    @Override
    public String mostrarCola() {
        String usuarios = "";
        for(int i = 0; i < limite - 1 ; i++ ) {
            if(i <= fin) {
                usuarios += cola[i]+"\n";
            }
        }   
        return usuarios;
    }
    
    @Override
    public String mostrarPrimerUsuario() {
        if(!colaVacia()) {
            String primerUsuario = cola[0];            
            return primerUsuario;
        }
        
        return null;       
    }
    
}
