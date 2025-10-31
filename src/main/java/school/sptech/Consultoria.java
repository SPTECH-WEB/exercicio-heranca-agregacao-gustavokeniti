package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Consultoria() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if(desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        } else {
            System.out.println("Vagas indísponiveis!");
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack()) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double salarioTotal = 0.0;
        for (Desenvolvedor dev : desenvolvedores) {
            salarioTotal += dev.calcularSalario();
        } return salarioTotal;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer totalMobile = 0;
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorMobile) {
                totalMobile += 1;
            }
        } return totalMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> maiorIgual = new ArrayList<>();
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.calcularSalario() >= salario) {
                maiorIgual.add(dev);
            }
        } return maiorIgual;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }
        Desenvolvedor menorSalario = desenvolvedores.get(0);
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.calcularSalario() < menorSalario.calcularSalario()) {
                menorSalario = dev;
            }
        } return menorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> temTecnologia = new ArrayList<>();
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) dev).getSgbd().equals(tecnologia) || ((DesenvolvedorWeb) dev).getBackend().equals(tecnologia) || ((DesenvolvedorWeb) dev).getFrontend().equals(tecnologia)) {
                    temTecnologia.add(dev);
                }
            }
            if (dev instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) dev).getPlataforma().equals(tecnologia) || ((DesenvolvedorMobile) dev).getLinguagem().equals(tecnologia)) {
                    temTecnologia.add(dev);
                }
            }
        } return temTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double somaTemTecnologia = 0.0;
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) dev).getSgbd().equals(tecnologia) || ((DesenvolvedorWeb) dev).getBackend().equals(tecnologia) || ((DesenvolvedorWeb) dev).getFrontend().equals(tecnologia)) {
                    somaTemTecnologia += dev.calcularSalario();
                }
            }
            if (dev instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) dev).getPlataforma().equals(tecnologia) || ((DesenvolvedorMobile) dev).getLinguagem().equals(tecnologia)) {
                    somaTemTecnologia += dev.calcularSalario();
                }
            }
        } return somaTemTecnologia;
    }
}
