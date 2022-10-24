package src.repository;
import src.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public static List<Usuario> findUsuariosSistema() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setLogin("admin");
        usuario.setSenha("admin");

        Usuario usuario1 = new Usuario();
        usuario1.setSenha("normal");
        usuario1.setLogin("normal");

        usuarios.add(usuario);
        usuarios.add(usuario1);

        return usuarios;
    }

    public static Object[] findUsuariosSistemaInArray() {
        List<Usuario> usuarios = findUsuariosSistema();
        List<String> usuariosLogins = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuariosLogins.add(usuario.getLogin());
        }

        return usuariosLogins.toArray();
    }

    public static Usuario findUsuarioByLogin(String login) {
        List<Usuario> usuariosSistema = findUsuariosSistema();

        for (Usuario usuario : usuariosSistema) {
            if (login.equals(login)) {
                return usuario;
            }
        }
        return null;
    }
}
