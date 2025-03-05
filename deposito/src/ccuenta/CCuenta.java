package ccuenta;

/**
 * 
 * @author Eduardo PC
 * @Version 1.5
 * 
 * La clase CCuenta representa una cuenta bancaria con atributos básicos 
 * como el nombre del titular, número de cuenta, saldo y tipo de interés.
 * Proporciona métodos para consultar y modificar estos valores, así como 
 * para realizar operaciones de ingreso y retiro de dinero.
 * 
 */
public class CCuenta {

    private String nombre;      //Nombre del titular
    private String cuenta;      //Numero de cuenta
    private double saldo;       //Saldo de la cuenta
    private double tipoInterés; //Tipo de interes aplicado a la cuenta

    /**
     * Constructor vacio o por defecto de la clase
     */
    public CCuenta() {
    }

    /**
     * Constructor con parametros, inicializa la cuenta bancaria
     * 
     * @param nom   Nombre del titular
     * @param cue   Numero de cuenta
     * @param sal   Saldo inicial de la cuenta
     * @param tipo  Tipo de interes aplicado 
     */
    public CCuenta(String nom, String cue, double sal, double tipo) {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
        tipoInterés = tipo;
    }

    /**
     * Metodo setter que modifica el atributo nombre
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Medodo setter que modifica la cuenta
 * 
 * @param cuenta 
 */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
/**
 * Medodo setter que modifica el saldo
 * 
 * @param saldo 
 */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
/**
 * Medodo setter que modifica el tipo de interes
 * 
 * @param tipoInterés 
 */
    public void setTipoInteres(double tipoInterés) {
        this.tipoInterés = tipoInterés;
    }

/**
 * Medodo getter de acceso a al nombre
 * 
 * @return nombre del titutlar
 */
    public String getNombre() {
        return nombre;
    }
/**
 * Medodo getter de acceso a al numero de cuenta
 * 
 * @return el numero de cuenta
 */
    public String getCuenta() {
        return cuenta;
    }
/**
 * Medodo getter de acceso al saldo
 * 
 * @return el saldo de la cuenta
 */
    public double getSaldo() {
        return saldo;
    }
/**
 * Medodo getter de acceso al tipo de interes
 * 
 * @return el tipo de interes aplicado a la cuenta
 */
    public double getTipoInteres() {
        return tipoInterés;
    }
/**
 * Metodo ejecuta el programa con todos sus metodos.
 * Recibe por parametro los valores de los atributos
 * Luego se los pasa al contructor parametrizado y ejecuta el resto de metodos
 * 
 * @param nom       Nombre del titular
 * @param cue       Numero de cuenta      
 * @param sal       Saldo de la cuenta
 * @param tipo      Tipo de interes aplicado
 * @param cantidad  Cantidad a operar
 */
    public void operativa_cuenta(String nom, String cue, double sal, double tipo, float cantidad) {
        CCuenta cuenta1;
        double saldoActual;

        cuenta1 = new CCuenta(nom, cue, sal, tipo);
        saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es" + saldoActual);

        try {
            cuenta1.retirar(2300);
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
        }
        try {
            System.out.println("Ingreso en cuenta");
            cuenta1.ingresar(695);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }

    }
/**
 * Devuelve el saldo actual de la cuenta
 * 
 * @return 
 * @deprecated lo sustituye el metodo getSaldo
 */
    @Deprecated
    public double estado() {
        return getSaldo();
    }
/**
 * Metodo para ingresar dinero en la cuenta
 * 
 * @param cantidad  cantidad a ingresar
 * @throws Exception si la cantidad es negativa   
 */
    public void ingresar(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede ingresar una cantidad negativa");
        }
        double saldo;
        saldo = getSaldo();

        saldo += cantidad;
    }

    public void retirar(double cantidad) throws Exception {
        if (cantidad <= 0) {
            throw new Exception("No se puede retirar una cantidad negativa");
        }
        if (estado() < cantidad) {
            throw new Exception("No se hay suficiente saldo");
        }
        double saldo;
        saldo = getSaldo();

        saldo -= cantidad;
    }
}
