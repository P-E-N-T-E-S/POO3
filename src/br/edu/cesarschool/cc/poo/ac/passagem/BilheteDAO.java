package br.edu.cesarschool.cc.poo.ac.passagem;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class BilheteDAO {

    private CadastroObjetos cadastro;

    public BilheteDAO(){

    }

    private String obterIdUnico(Bilhete bilhete){
        return bilhete.gerarNumero();
    }

    public Bilhete buscar(String numeroBilhete){
        return (Bilhete)cadastro.buscar(numeroBilhete);
    }

    public boolean incluir(Bilhete bilhete){
        String numeroBilhete = obterIdUnico(bilhete);
        Bilhete b1 = buscar(numeroBilhete);
        if (b1 == null) {
            cadastro.incluir(b1, numeroBilhete);
            return true;
        }
        return false;
    }

    public boolean alterar(Bilhete bilhete) {
        String idUnico = obterIdUnico(bilhete);
        Bilhete b1 = buscar(idUnico);
        if (b1 != null) {
            cadastro.alterar(b1, idUnico);
            return true;
        }
        return false;
    }

    public boolean excluir(String numeroBilhete) {
        Bilhete b1 = buscar(numeroBilhete);
        if (b1 != null) {
            cadastro.excluir(numeroBilhete);
            return true;
        }
        return false;
    }
}
