import java.awt.event.KeyEvent;
import java.lang.reflect.Field;                                                               
import java.lang.reflect.Modifier;   

public class KeyEventList {
    public static void main(String[] args) {
        Field[] fields = java.awt.event.KeyEvent.class.getDeclaredFields();
        for (Field f : fields) {
            if (Modifier.isStatic(f.getModifiers())) {
                System.out.println(f.getName());
            } 
        }
    }
}

