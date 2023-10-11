import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Conector conecta = new Conector("Tiendas","root","usuario");
        Connection conexion = conecta.getConector();

        Scanner scanner = new Scanner(System.in);
        Ejercicio2 ejercicio2 = new Ejercicio2();
        int opcion;

        do {
            System.out.println("Elige una opcion:");
            System.out.println("1. Insertar articulo");
            System.out.println("2. Insertar empresario.");
            System.out.println("3. Insertar fruteria");
            System.out.println("4. Insertar registros en la tabla stock");
            System.out.println("5. Mostrar las fruterias de un empleado.");
            System.out.println("6. Mostrar stock de una fruteria.");
            System.out.println("7. Salir.");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    //Insertar articulo
                    System.out.println("Codigo del articulo: ");
                    int codArt = scanner.nextInt();

                    System.out.println("Nombre del articulo: ");
                    scanner.nextLine();
                    String nombreArt = scanner.nextLine();

                    System.out.println("Categoria del articulo: ");
                    String categoriaArt = scanner.next();

                    System.out.println("Precio del articulo: ");
                    float precioArt = scanner.nextFloat();

                    insertarArticulo(codArt,nombreArt,categoriaArt,precioArt);

                    break;
                case 2:
                    // Insertar empresario
                    System.out.println("DNI del empresario: ");
                    String DNIemp = scanner.next();

                    System.out.println("Nombre del empresario: ");
                    scanner.nextLine();
                    String nombreEmp = scanner.nextLine();

                    System.out.println("Telefono del empresario: ");
                    String tlfnEmp = scanner.next();

                    insertarEmpresario(DNIemp,nombreEmp,tlfnEmp);

                    break;
                case 3:
                    // Insertar fruteria
                    System.out.println("Introduce codigo de fruteria: ");
                    int codFru = scanner.nextInt();

                    System.out.println("Introduce nombre de la fruteria: ");
                    scanner.nextLine();
                    String nomFru = scanner.nextLine();

                    System.out.println("Introduce direccion de la fruteria: ");
                    scanner.nextLine();
                    String dirFru = scanner.nextLine();

                    System.out.println("Introduce telefono: ");
                    String tlfnFru = scanner.next();

                    System.out.println("Introduce DNI empresario");
                    String DNIEmpFru = scanner.next();

                    insertarFruteria(codFru,nomFru,dirFru,tlfnFru,DNIEmpFru);

                    break;
                case 4:
                    // Insertar registros en la tabla stock
                    System.out.println("Introduce codigo del articulo");
                    int CodArtSto = scanner.nextInt();

                    System.out.println("Introduce codigo fruteria");
                    int CodFruSto = scanner.nextInt();

                    System.out.println("Introduce la cantidad");
                    float Cant = scanner.nextFloat();

                    insertarStock(CodArtSto,CodFruSto,Cant);

                    break;
                case 5:
                    // Mostrar las fruterias de un empleado
                    break;
                case 6:
                    // Mostrar stock de una fruteria
                    break;
                case 7:

                    //Salir
                    System.out.println("Adios...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 7);



        }

        //INSERTAR ARTICULO
    public static void insertarArticulo(int codigo,String nombre, String categoria, float precio) {

        String insertarArt = "INSERT INTO articulo(codigo,nombre,categoria,precio) VALUES(?, ?, ?,?)";

        try {
            Connection connection = DriverManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertarArt);

            preparedStatement.setFloat(1, codigo);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, categoria);
            preparedStatement.setFloat(4, precio);


            int filas = preparedStatement.executeUpdate();

            if (filas > 0)
            {
                System.out.println("Articulo insertado correctamente");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar el articulo " + e.getMessage());
        }
    }

    //INSERTAR EMPRESARIO
    public static void insertarEmpresario(String dni, String nombre, String tlfn) {
        String insertarEmp = "INSERT INTO empresario(dni, nombre, tlfn) VALUES(?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertarEmp);

            preparedStatement.setString(1, dni);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, tlfn);

            int filas = preparedStatement.executeUpdate();

            if (filas > 0)
            {
                System.out.println("Empresario insertado correctamente");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar empresario " + e.getMessage());
        }
    }

    //INSERTAR FRUTERIA
    public static  void insertarFruteria(int codfru, String nomfru, String dirfru, String tlfnfru, String DNI)
    {
        String insertarFru = "INSERT INTO fruteria VALUES (?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertarFru);

            preparedStatement.setInt(1, codfru);
            preparedStatement.setString(2, nomfru);
            preparedStatement.setString(3,dirfru);
            preparedStatement.setString(4,tlfnfru);
            preparedStatement.setString(5,DNI);

            int filas = preparedStatement.executeUpdate();

            if(filas > 0)
            {
                System.out.println("Fruteria insertada correctamente");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar fruteria " + e.getMessage());
        }
    }

    //INSERTAR REGIRSTROS TABLA STOCK
    public static void insertarStock(int CodArtSto, int CodFruSto, float Cant)
    {
        String insertarStock = "INSERT INTO stock VALUES (?,?,?)";

        try {
            Connection connection = DriverManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertarStock);

            preparedStatement.setInt(1, CodArtSto);
            preparedStatement.setInt(2, CodFruSto);
            preparedStatement.setFloat(3,Cant);


            int filas = preparedStatement.executeUpdate();

            if(filas > 0)
            {
                System.out.println("Stock insertado correctamente");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar stock " + e.getMessage());
        }
    }

}

