package br.edu.cesarschool.cc.poo.ac.passagem;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class BilheteVipDAO {

    private CadastroObjetos cadastro;

    public BilheteVipDAO() {

    }


    private String obterIdUnico(BilheteVip bilheteVip){
        return bilheteVip.gerarNumero();
    }

    public BilheteVip buscar(String numeroBilheteVip){
        return (BilheteVip) cadastro.buscar(numeroBilheteVip);
    }

    public boolean incluir(BilheteVip bilheteVip){
        String numeroBilheteVip = obterIdUnico(bilheteVip);
        BilheteVip bv1 = buscar(numeroBilheteVip);
        if (bv1 == null) {
            cadastro.incluir(bv1, numeroBilheteVip);
            return true;
        }
        return false;
    }

    public boolean alterar(BilheteVip bilheteVip){
        String idUnico = obterIdUnico(bilheteVip);
        BilheteVip bv1 = buscar(idUnico);
        if (bv1 != null) {
            cadastro.alterar(bv1, idUnico);
            return true;
        }
        return false;
    }

    public boolean excluir(String numeroBilhete){
        BilheteVip bv1 = buscar(numeroBilhete);
        if (bv1 != null) {
            cadastro.excluir(numeroBilhete);
            return true;
        }
        return false;
    }
}

