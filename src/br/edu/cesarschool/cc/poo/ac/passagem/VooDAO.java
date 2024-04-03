package br.edu.cesarschool.cc.poo.ac.passagem;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class VooDAO {
    CadastroObjetos cadastro;

    public VooDAO(){

    }

    private String obterIdUnico(Voo voo){

        return voo.getCompanhiaAerea() + voo.getNumeroVoo();
    }

    public Voo buscar(String idVoo){
        return (Voo)cadastro.buscar(idVoo);
    }

    public boolean incluir(Voo voo) {
        String idUnico = obterIdUnico(voo);
        Voo v1 = buscar(idUnico);
        if (v1 == null) {
            cadastro.incluir(v1, idUnico);
            return true;
        }
        return false;
    }

    public boolean alterar(Voo voo) {
        String idUnico = obterIdUnico(voo);
        Voo v1 = buscar(idUnico);
        if (v1 != null) {
            cadastro.alterar(v1, idUnico);
            return true;
        }
        return false;
    }

    public boolean excluir(String idVoo) {
        Voo v1 = buscar(idVoo);
        if (v1 != null) {
            cadastro.excluir(idVoo);
            return true;
        }
        return false;
    }
}

