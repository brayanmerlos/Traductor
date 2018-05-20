package pkg_cls;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @Edick Valdez
 */

public class Idioma extends Properties{
    
    private static final long serialVersionUID = 1L;
	        
    public Idioma(String idioma){
    	
           	switch(idioma){
	    	case "Español":
                    getProperties("espanol.properties");
                    break;
	    	case "Ingles":
                    getProperties("ingles.properties");
                    break;
               	default:
                    getProperties("ingles.properties");
	   	}

    }

    private void getProperties(String idioma) {
        try {
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {
        
        }
   }
}
