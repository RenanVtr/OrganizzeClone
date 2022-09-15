package Config;

import com.google.firebase.auth.FirebaseAuth;

public class ConfiguracaoFirebase {
    private static FirebaseAuth autentificacao;


    //Retorna a instancia do FirebaseAuth
    public static FirebaseAuth getFirebaseAutentificacao(){
        if (autentificacao==null){
            autentificacao = FirebaseAuth.getInstance();
        } return autentificacao;

    }
}
