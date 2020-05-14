import java.util.ArrayList; //interface
import java.util.List; // Implementação da Interface

class Ponto {
    protected int posicaoX;
    protected int posicaoY;
    protected int posicaoZ;

    Ponto(int posicaoX,  int posicaoY, int posicaoZ) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.posicaoZ = posicaoZ;
    }
}

abstract class FormaGeometrica {
    protected Ponto pontoCentral;

    FormaGeometrica(int posicaoX,  int posicaoY, int posicaoZ) {
        this.pontoCentral = new Ponto( posicaoX, posicaoY, posicaoZ);
    }

     public String toString() {
        return " ponto central: (" + this.pontoCentral.posicaoX + "," + this.pontoCentral.posicaoY + "," + this.pontoCentral.posicaoZ + ")";
    }
}

class Quadrado extends FormaGeometrica {
    protected int largura;
    protected int comprimento;


    Quadrado(int largura, int comprimento, int posicaoX,  int posicaoY, int posicaoZ) {
        super(posicaoX, posicaoY, posicaoZ);
        this.largura = largura;
        this.comprimento = comprimento;
    }

     public String toString() {
        return "largura: " + this.largura + " comprimento: " + this.comprimento + super.toString();
    }
}

class Circulo extends FormaGeometrica {
    protected int raio;

    Circulo(int raio, int posicaoX,  int posicaoY, int posicaoZ) {
        super(posicaoX, posicaoY, posicaoZ);
        this.raio = raio;
        
    }

    public String toString() {
        return "raio: " + this.raio + super.toString();
    }
}

// class Poligono extends FormaGeometrica {
//     protected Ponto[] pontos;
// }

public class OrientacaoAObjeto {

    public static void main(String[] args) {

        Circulo c1 = new Circulo(10, 0, 0, 0);
        Quadrado q1 = new Quadrado(10, 10, 15, 15, 15);

        System.out.println("Exibindo forma geométrica c1: " + c1);
        System.out.println("Exibindo forma geométrica q1: " + q1);

        List<Quadrado> formasQuadrado = new ArrayList();
        formasQuadrado.add(q1);

        for(Quadrado q: formasQuadrado) {
            System.out.println("Lista: " + q);
        }

    }
}
