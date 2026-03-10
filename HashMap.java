// aqhe tamaño = tamano porque la ñ me estaba dando unos problemas ahi
public class HashMap<T> {
     private String[] claves;
    private T[] valores;
    private int tamano;

    public HashMap(int tamano) {
        this.tamano = tamano;
        claves = new String[tamano];
        valores = (T[]) new Object[tamano];
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % tamano; //math.abs es para convertir los numeros en valor absuluto
    }

    public void put(String clave, T valor) {

        int indice = hash(clave);

        claves[indice] = clave;
        valores[indice] = valor;
    }

    public T get(String clave) {

        int indice = hash(clave);

        if (claves[indice] != null && claves[indice].equals(clave)) { // && esto sirve para verificar 2 cosas 
            return valores[indice];
        }

        return null;
    }

    public boolean remove(String clave) {

        int indice = hash(clave);

        if (claves[indice] != null && claves[indice].equals(clave)) {

            claves[indice] = null;
            valores[indice] = null;

            return true;
        }

        return false;
    }

    public void mostrar() {

        for (int i = 0; i < tamano; i++) {

            if (claves[i] != null) {

                System.out.println(valores[i]);

            }
        }

    }
}
    
    

        

