
package login;

import login.igu.Principal;

/**
 *
 * @author angel
 */
public class Login 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Principal princ = new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        
    }
    
    private int id;
    private String nombreUsuario;
    private String contraseña;

    public Login() {
    }

    public Login(int id, String nombreUsuario, String contraseña) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
