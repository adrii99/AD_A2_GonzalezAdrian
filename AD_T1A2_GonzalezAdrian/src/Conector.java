import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conector {

    //Atributos
    private String servidor;
    private String usuario;
    private String clave;
    Connection conexion;

    //Constructor
    public Conector(String ser, String usu, String cv) throws ClassCastException {

        this.servidor = ser;
        this.usuario = usu;
        this.clave =cv;

        try
        {
            //carga el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Se conecta a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/"+ser+"?serverTimezone=UTC",usu,cv);

            //Comprobar si se ha podido conectar
            if (conexion != null)
                System.out.println("Conexion establecida correctamente");
            else
                System.out.println("Error al establecer la conexion");
        }catch (ClassCastException cn){cn.printStackTrace();}
        catch (SQLException e){e.printStackTrace();} catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConector()
    {
        return conexion;
    }
}
